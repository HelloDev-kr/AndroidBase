package kr.hellodev.support.base.utils

import android.app.ActivityManager
import android.content.Context

/**
 * @date 2018.06.20
 * @author Cura
 */
object ServiceUtils {

    fun isRunning(context: Context, tClass: Class<*>): Boolean {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val services = activityManager.getRunningServices(Integer.MAX_VALUE)
        for (runningServiceInfo in services) {
            if (runningServiceInfo.service.className == tClass.name) {
                return true
            }
        }
        return false
    }
}