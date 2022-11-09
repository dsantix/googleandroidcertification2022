package dsanti.digital.googlecertification

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.BigPictureStyle
import androidx.core.app.NotificationCompat.Builder
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import dsanti.digital.googlecertification.databinding.ActivityMainBinding
import dsanti.digital.googlecertification.userInterface.*
import dsanti.digital.googlecertification.userInterface.openMainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    private val notificationID: Int
        get() = Notifications.COMUM_ID

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if (it) {
                showNotification(this, binding, notificationID)
            } else {
                binding.root.snack(R.string.message_snack)
            }
        }

        binding.enviarNtf.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this, POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED) {
                showNotification(this, binding, notificationID)
            } else {
                requestPermissionLauncher.launch(POST_NOTIFICATIONS)
            }
        }
    }
}

private fun showNotification(ctx: Context, binding:ActivityMainBinding, notificationId: Int) {
    val notificationBuilder = ctx.notificationBuilder(Notifications.CANAL_COMUM) {
        setSmallIcon(R.drawable.ic_android_black_24dp)
        setContentTitle(binding.txtCidade.text)
        setContentText(binding.txtCidadeDescricao.text)
        setStyle(BigPictureStyle().bigPicture(binding.imgCidade.drawable.toBitmap()))
        priority = NotificationCompat.PRIORITY_DEFAULT
        setAutoCancel(true)

        setContentIntent(
            openMainActivity(ctx)
        )
    }

    ctx.notificationManager.notify(notificationId, notificationBuilder.build())
}

