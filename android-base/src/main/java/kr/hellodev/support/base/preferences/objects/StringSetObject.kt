package kr.hellodev.support.base.preferences.objects

import android.content.SharedPreferences

/**
 * @date 2018.05.08
 * @author Cura
 */
class StringSetObject(private val prefs: SharedPreferences) : PrefsBaseObject {

    @Suppress("UNCHECKED_CAST")
    override fun put(key: String, value: Any?) {
        prefs.edit().putStringSet(key, value as Set<String>).apply()
    }

    @Suppress("UNCHECKED_CAST")
    override fun get(key: String, defaultValue: Any?): Any? {
        return prefs.getStringSet(key, defaultValue as Set<String>)
    }
}