package kr.hellodev.support.base.preferences.objects

import android.content.SharedPreferences

/**
 * @date 2018.05.08
 * @author Cura
 */
class BooleanObjectn(private val prefs: SharedPreferences) : PrefsBaseObject {

    override fun put(key: String, value: Any?) {
        prefs.edit().putBoolean(key, value as Boolean).apply()
    }

    override fun get(key: String, defaultValue: Any?): Any? {
        return prefs.getBoolean(key, defaultValue as Boolean)
    }
}