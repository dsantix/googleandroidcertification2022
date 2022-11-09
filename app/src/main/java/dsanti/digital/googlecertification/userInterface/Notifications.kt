package dsanti.digital.googlecertification.userInterface

import android.content.Context
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.NotificationManagerCompat.IMPORTANCE_DEFAULT
import dsanti.digital.googlecertification.R

object Notifications {

    const val CANAL_COMUM = "canal_comum"
    const val GRUPO_COMUM = "grupo_comum"

    const val COMUM_ID = 101


    fun createChannels(ctx: Context){
        val notificationService = NotificationManagerCompat.from(ctx)

        notificationService.createNotificationChannelsCompat(
            listOf(
                buildNotificationChannel(CANAL_COMUM, IMPORTANCE_DEFAULT) {
                    setName(ctx.getString(R.string.canal_comum))
                }
            )
        )
    }
}