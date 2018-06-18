package kr.hellodev.support.base.preferences

import android.content.Context
import android.content.SharedPreferences
import kr.hellodev.support.base.preferences.objects.*

/**
 * @date 2018.05.08
 * @author Cura
 */
class PreferencesManager private constructor() {

    companion object {
        @Volatile
        private var INSTANCE: PreferencesManager? = null

        private lateinit var prefs: SharedPreferences

        fun initialize(context: Context) {
            prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        }

        fun initialize(context: Context, prefsName: String) {
            if (prefsName == "") {
                throw IllegalArgumentException("Preference name can not be empty.")
            }
            prefs = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        }

        fun getInstance(): PreferencesManager =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: PreferencesManager()
                }
    }

    fun put(key: String, value: Any) {
        val baseObject = when (value) {
            is String -> {
                StringObject(prefs)
            }
            is Boolean -> {
                BooleanObject(prefs)
            }
            is Int -> {
                IntObject(prefs)
            }
            is Long -> {
                LongObject(prefs)
            }
            is Float -> {
                FloatObject(prefs)
            }
            is Set<*> -> {
                StringSetObject(prefs)
            }
            else -> {
                throw ClassCastException(value.javaClass.name + " is not allowed type of object.")
            }
        }

        baseObject.put(key, value)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> get(key: String, defaultValue: Any): T? {
        val baseObject = when (defaultValue) {
            is String -> {
                StringObject(prefs)
            }
            is Boolean -> {
                BooleanObject(prefs)
            }
            is Int -> {
                IntObject(prefs)
            }
            is Long -> {
                LongObject(prefs)
            }
            is Float -> {
                FloatObject(prefs)
            }
            is Set<*> -> {
                StringSetObject(prefs)
            }
            else -> {
                throw ClassCastException(defaultValue.javaClass.name + " is not allowed type of object.")
            }
        }
        return baseObject.get(key, defaultValue) as T?
    }

    fun getAll(): MutableMap<String, *>? {
        return prefs.all
    }

    fun contains(key: String): Boolean {
        return prefs.contains(key)
    }

    fun clear() {
        prefs.edit().clear().apply()
    }

    fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }
}