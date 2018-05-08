package kr.hellodev.support.base.preferences.objects

import android.content.SharedPreferences

/**
 * @date 2018.05.08
 * @author Cura
 */
class FloatObject(private val prefs: SharedPreferences) : PrefsBaseObject {

    override fun put(key: String, value: Any?) {
        prefs.edit().putFloat(key, value as Float).apply()
    }

    override fun get(key: String, defaultValue: Any?): Any? {
        return prefs.getFloat(key, defaultValue as Float)
    }
}