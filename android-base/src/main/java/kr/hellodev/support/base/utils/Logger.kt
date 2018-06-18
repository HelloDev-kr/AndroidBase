package kr.hellodev.support.base.utils

import android.util.Log

/**
 * @date 2018.05.09
 * @author Cura
 */
class Logger protected constructor(tag: String, logLevel: LogLevel) {

    private val mTag: String
    val mLogLevel: LogLevel

    init {
        mTag = tag
        mLogLevel = logLevel
    }

    companion object {
        private val DEFAULT_TAG = "Logger"
        var DEBUG = false

        fun newInstance(level: LogLevel): Logger {
            return Logger(DEFAULT_TAG, level)
        }

        fun newInstance(tag: String, logLevel: LogLevel): Logger {
            return Logger(tag, logLevel)
        }
    }

    fun d(format: String, vararg args: Any) {
        if (shouldLog(LogLevel.DEBUG)) {
            Log.d(mTag, String.format(format, *args))
        }
    }

    fun e(error: Throwable) {
        e(error, "")
    }

    fun e(format: String, vararg args: Any) {
        e(null, format, *args)
    }

    fun e(error: Throwable?, format: String, vararg args: Any) {
        if (shouldLog(LogLevel.ERROR)) {
            Log.e(mTag, String.format(format, *args), error)
        }
    }

    fun i(format: String, vararg args: Any) {
        if (shouldLog(LogLevel.INFO)) {
            Log.i(mTag, String.format(format, *args))
        }
    }

    fun v(format: String, vararg args: Any) {
        if (shouldLog(LogLevel.VERBOSE)) {
            Log.v(mTag, String.format(format, *args))
        }
    }

    fun w(format: String, vararg args: Any) {
        if (shouldLog(LogLevel.WARN)) {
            Log.w(mTag, String.format(format, *args))
        }
    }

    private fun shouldLog(level: LogLevel): Boolean {
        return mLogLevel.toInt() >= level.toInt()
    }

    enum class LogLevel private constructor(level: Int) {
        NONE(0),
        ERROR(1),
        WARN(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);

        private var mLevel: Int = 0

        init {
            mLevel = level
        }

        companion object {
            fun valueOf(value: Int): LogLevel {
                if (value == ERROR.toInt()) {
                    return ERROR
                } else if (value == WARN.toInt()) {
                    return WARN
                } else if (value == INFO.toInt()) {
                    return INFO
                } else if (value == DEBUG.toInt()) {
                    return DEBUG
                } else if (value == VERBOSE.toInt()) {
                    return VERBOSE
                } else {
                    return NONE
                }
            }
        }

        fun toInt(): Int {
            return mLevel
        }
    }
}