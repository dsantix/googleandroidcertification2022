package dsanti.digital.googlecertification.userInterface

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.content.getSystemService
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationChannelGroupCompat
import androidx.core.app.NotificationCompat
import com.google.android.material.snackbar.Snackbar
import dsanti.digital.googlecertification.MainActivity
import dsanti.digital.googlecertification.R

fun View.snack(@StringRes message: Int) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun Context.toast(@StringRes message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.notificationBuilder(channelId: String, block: (NotificationCompat.Builder.() -> Unit)? = null): NotificationCompat.Builder {
    val builder = NotificationCompat.Builder(this, channelId)
    if (block != null) {
        builder.block()
    }
    return builder
}

fun Context.notification(channelId: String, block: (NotificationCompat.Builder.() -> Unit)?): Notification {
    val builder = notificationBuilder(channelId, block)
    return builder.build()
}

val Context.notificationManager: NotificationManager
    get() = getSystemService()!!

fun buildNotificationChannelGroup(
    channelId: String,
    block: (NotificationChannelGroupCompat.Builder.() -> Unit),
): NotificationChannelGroupCompat {
    val builder = NotificationChannelGroupCompat.Builder(channelId)
    builder.block()
    return builder.build()
}


fun buildNotificationChannel(
    channelId: String,
    channelImportance: Int,
    block: (NotificationChannelCompat.Builder.() -> Unit),
): NotificationChannelCompat {
    val builder = NotificationChannelCompat.Builder(channelId, channelImportance)
    builder.block()
    return builder.build()
}

internal fun openMainActivity(context: Context): PendingIntent {
    val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
    }
    return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
}