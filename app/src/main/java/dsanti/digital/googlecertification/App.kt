package dsanti.digital.googlecertification

import android.app.Application
import android.util.Log
import dsanti.digital.googlecertification.userInterface.Notifications

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupNotificationChannels()
    }

    private fun setupNotificationChannels() {
        try {
            Notifications.createChannels(this)
        } catch (e: Exception) {
            e.message?.let { Log.e("Failed to modify notification channels", it) }
        }
    }
}

