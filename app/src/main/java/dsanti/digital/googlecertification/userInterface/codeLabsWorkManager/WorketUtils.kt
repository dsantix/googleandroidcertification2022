package dsanti.digital.googlecertification.userInterface.codeLabsWorkManager

import android.util.Log

private const val TAG = "WorkerUtils"


/**
 * Method for sleeping for a fixed amount of time to emulate slower work
 */
fun sleep() {
    try {
        Thread.sleep(Constants.DELAY_TIME_MILLIS, 0)
    } catch (e: InterruptedException) {
        Log.e(TAG, e.message.toString())
    }

}


object Constants {

    const val DELAY_TIME_MILLIS: Long = 3000

}