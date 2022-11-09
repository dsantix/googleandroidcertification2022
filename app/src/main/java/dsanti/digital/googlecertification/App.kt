package dsanti.digital.googlecertification

import android.app.Application
import dsanti.digital.googlecertification.userInterface.Notifications

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Notifications.createChannels(this)
    }
}

