package dsanti.digital.googlecertification.userInterface.codeLabsWorkManager

import android.content.Context
import android.util.Log
import androidx.core.net.toUri
import androidx.work.*
import dsanti.digital.googlecertification.R
import dsanti.digital.googlecertification.core.FileApi
import dsanti.digital.googlecertification.userInterface.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlin.random.Random


class DownloadWorker(private val ctx: Context, private val params: WorkerParameters) : CoroutineWorker(ctx, params) {

    private val notificationId: Int
        get() = Notifications.DOWNLOAD_ID

    private val appCtx : Context
        get() = applicationContext

    private var notificationBuilder = appCtx.notificationBuilder(Notifications.CANAL_DOWNLOAD)

    override suspend fun doWork(): Result {

        startForegroundProgress()

        val response = FileApi.instance.downloadImage()

        response.body()?.let { body ->
            return withContext(Dispatchers.IO) {
                val file = File(ctx.cacheDir, "image.jpg")
                val outputStream = FileOutputStream(file)
                outputStream.use { stream ->
                    try {
                        stream.write(body.bytes())
                    } catch (e: IOException){
                        return@withContext Result.failure(
                            workDataOf(WorkersKeys.error_msg to e.localizedMessage)
                        )
                    }
                }

                Result.success(
                    workDataOf(WorkersKeys.file_uri to file.toUri().toString())
                )
            }
        }

        if (!response.isSuccessful){
            if (response.code().toString().startsWith("5")){
                return Result.retry()
            }

            return Result.failure(
                workDataOf(WorkersKeys.error_msg to "Networking error")
            )
        }

        return Result.failure(workDataOf(WorkersKeys.error_msg to "Unknown error"))

    }

    private suspend fun startForegroundProgress(){
        setForeground(
            ForegroundInfo(
                notificationId,
                with(notificationBuilder){
                    setSmallIcon(R.drawable.ic_launcher_foreground)
                    setContentTitle("Downloading...")
                    setContentText("Download in progress")
                    build()
                }
            )
        )
    }

    companion object {
        const val TAG = "EstadosWorker"
    }
}