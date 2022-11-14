package dsanti.digital.googlecertification

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.graphics.drawable.toBitmap
import coil.load
import coil.request.CachePolicy
import dsanti.digital.googlecertification.databinding.ActivityMainBinding
import dsanti.digital.googlecertification.userInterface.*


class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityVM by viewModels { MainViewModelFactory(app = application) }
    private val ramdomState by lazy { Brasil().regioes.random().estados.random() }
    private val notificationBuilder = this.notificationBuilder(Notifications.CANAL_COMUM)
    private val notificationId: Int
        get() = Notifications.COMUM_ID
    lateinit var binding: ActivityMainBinding
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showState()

        requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if (it) {
                showNotification(this)
            } else {
                binding.root.snack(R.string.message_snack)
            }
        }

        binding.enviarNtf.setOnClickListener {
            viewModel.downloadImage()
        }

    }

    private fun showState(){
        binding.imgCidade.load(ramdomState.image_url) {
            crossfade(true)
            memoryCachePolicy(CachePolicy.ENABLED)
        }
        binding.txtCidade.text= ramdomState.nome
        binding.txtCidadeDescricao.text = ramdomState.descricao
    }

    private fun showNotification(ctx: Context) {

        with(notificationBuilder){
            setSmallIcon(R.drawable.ic_android_black_24dp)
            setContentTitle(binding.txtCidade.text)
            setContentText(binding.txtCidadeDescricao.text)
            setStyle(NotificationCompat.BigPictureStyle().bigPicture(binding.imgCidade.drawable.toBitmap()))
            priority = NotificationCompat.PRIORITY_DEFAULT
            setAutoCancel(true)

            setContentIntent(
                openMainActivity(ctx)
            )
        }


        ctx.notificationManager.notify(notificationId, notificationBuilder.build())
    }


}



