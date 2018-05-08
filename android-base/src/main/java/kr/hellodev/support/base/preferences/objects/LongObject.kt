package kr.hellodev.support.base.preferences.objects

import android.content.SharedPreferences

/**
 * @date 2018.05.08
 * @author Cura
 */
class LongObject(private val prefs: SharedPreferences) : PrefsBaseObject {

    override fun put(key: String, value: Any?) {
        prefs.edit().putLong(key, value as Long).apply()
    }

    override fun get(key: String, defaultValue: Any?): Any? {
        return prefs.getLong(key, defaultValue as Long)
    }
}