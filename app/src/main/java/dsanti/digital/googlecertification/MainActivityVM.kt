package dsanti.digital.googlecertification

import android.app.Application
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import dsanti.digital.googlecertification.userInterface.codeLabsWorkManager.DownloadWorker
import dsanti.digital.googlecertification.userInterface.codeLabsWorkManager.WorkersKeys

class MainActivityVM(app: Application) : ViewModel() {

    private val workManager = WorkManager.getInstance(app)
    private val downloadRequest = OneTimeWorkRequestBuilder<DownloadWorker>()
        .setConstraints(
            Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
        )
        .build()


    fun downloadImage(){
        workManager.beginUniqueWork("downloadImage", ExistingWorkPolicy.KEEP, downloadRequest).enqueue()
    }
}



class MainViewModelFactory(private val app: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainActivityVM::class.java)){
            MainActivityVM(app) as T
        } else {
            throw  IllegalArgumentException("Unknown ViewModel class")
        }
    }
}