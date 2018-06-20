package kr.hellodev.support.base.utils

import android.app.Activity
import android.content.Intent

/**
 * @date 2018.06.20
 * @author Cura
 */
object NavigationUtils {

    fun startActivityAndFinishWithNoAnimation(activity: Activity, intent: Intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        activity.startActivity(intent)
        activity.overridePendingTransition(0, 0)
    }
}