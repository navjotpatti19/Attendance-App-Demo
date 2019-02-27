package com.sapple.attendanceapp.helper_classes

import android.content.Context
import android.location.Location
import android.preference.PreferenceManager
import kotlin.coroutines.experimental.coroutineContext

class SharedPreferenceResult(private val context: Context) {

    fun setLocationText(location: Location): String {
        return location.latitude.toString() + " " + location.longitude.toString()
    }

    fun saveLocation(latLong: String) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString("LOCATION_UPDATE", latLong)
                .apply()
    }

    fun saveFlagForMorningNotification(notificationFlag: Boolean) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit().putBoolean("MORNING_NOTI_FLAG",notificationFlag)
                .apply()
    }

    fun saveFlagForEveningNotification(notificationFlag: Boolean) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit().putBoolean("EVENING_NOTI_FLAG",notificationFlag)
                .apply()
    }

    fun getMorningNotificationFlag(context: Context): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean("MORNING_NOTI_FLAG", false)
    }

    fun getEveningNotificationFlag(context: Context): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean("EVENING_NOTI_FLAG", false)
    }

    companion object {
        fun getLocation(context: Context): String {
            return PreferenceManager.getDefaultSharedPreferences(context)
                    .getString("LOCATION_UPDATE", "")
        }
    }
}