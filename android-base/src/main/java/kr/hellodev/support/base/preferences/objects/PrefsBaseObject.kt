package kr.hellodev.support.base.preferences.objects

/**
 * @date 2018.05.08
 * @author Cura
 */
interface PrefsBaseObject {
    fun put(key: String, value: Any?)
    fun get(key: String, defaultValue: Any?): Any?
}