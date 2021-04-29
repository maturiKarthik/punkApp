package com.example.punkapp.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class SharedPrefHelper {

    companion object {

        private var instance: SharedPrefHelper? = null
        private var pref: SharedPreferences? = null
        private const val INTERVAL_TIME = "time"
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: build(
                    context
                ).also {
                instance = it
            }
        }

        private fun build(context: Context): SharedPrefHelper {
            pref = PreferenceManager.getDefaultSharedPreferences(context)
            return SharedPrefHelper()
        }
    }

    fun setTime(time: Long) {
        pref?.edit(commit = true) {
            putLong(INTERVAL_TIME, time)
        }
    }

    fun getTime(): Long? {
        return pref?.getLong(
            INTERVAL_TIME, 0L)
    }
}