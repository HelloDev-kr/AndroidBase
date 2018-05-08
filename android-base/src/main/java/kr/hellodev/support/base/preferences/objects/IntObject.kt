package kr.hellodev.support.base.preferences.objects

import android.content.SharedPreferences

/**
 * @date 2018.05.08
 * @author Cura
 */
class IntObject(private val prefs: SharedPreferences) : PrefsBaseObject {

    override fun put(key: String, value: Any?) {
        prefs.edit().putInt(key, value as Int).apply()
    }

    override fun get(key: String, defaultValue: Any?): Any? {
        return prefs.getInt(key, defaultValue as Int)
    }
}