package kr.hellodev.support.base.utils

import android.app.Activity
import android.app.Fragment
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity

/**
 * @date 2018.05.03
 * @author Cura
 */
fun AppCompatActivity.replaceFragment(@IdRes frameId: Int, fragment: android.support.v4.app.Fragment) {
    supportFragmentManager.beginTransaction().replace(frameId, fragment)?.commit()
}

fun Activity.replaceFragment(@IdRes frameId: Int, fragment: Fragment) {
    fragmentManager.beginTransaction().replace(frameId, fragment).commit()
}

fun AppCompatActivity.getFragment(@IdRes frameId: Int) = supportFragmentManager.findFragmentById(frameId)

fun <T> Context?.startServiceClass(clazz: Class<T>?) {
    this?.let {
        val intent = Intent(it, clazz)
        it.startService(intent)
    }
}

fun <T> Context?.stopServiceClass(clazz: Class<T>?) {
    this?.let {
        val intent = Intent(it, clazz)
        it.stopService(intent)
    }
}

fun Context?.registerReceiverAction(broadcastReceiver: BroadcastReceiver, actionList: List<String>? = null) {
    this?.let {
        val intentFilter = IntentFilter()
        actionList?.filterNotNull()?.forEach { intentFilter.addAction(it) }
        it.registerReceiver(broadcastReceiver, intentFilter)
    }
}