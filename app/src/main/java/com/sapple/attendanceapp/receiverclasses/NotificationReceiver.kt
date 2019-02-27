package com.sapple.attendanceapp.receiverclasses

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationManagerCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.sapple.attendanceapp.R
import com.sapple.attendanceapp.activities.SampleActivity
import com.sapple.attendanceapp.helper_classes.ConstantStrings
import com.sapple.attendanceapp.helper_classes.SharedPreferenceResult
import java.util.*

class NotificationReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val currentMinute = Calendar.getInstance().get(Calendar.MINUTE)

        val notificationManager = context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val nb = Notification.Builder(context)
        val sharedPreferences = SharedPreferenceResult(context)

        if(intent!!.action == "ACTION_ONE" && currentHour == ConstantStrings.morningHour &&
                currentMinute == ConstantStrings.morningMinute) {
            if(!sharedPreferences.getMorningNotificationFlag(context)) {
                nb.setContentTitle("Punch Missing")
                nb.setContentText("You have missed the morning punch")

                createNotification(nb, context, notificationManager)
            }
        } else if(intent.action == "ACTION_TWO"  && currentHour == ConstantStrings.eveningHour &&
                currentMinute == ConstantStrings.eveningMinute) {
            if(!sharedPreferences.getEveningNotificationFlag(context)) {
                nb.setContentTitle("Punch Missing")
                nb.setContentText("You have missed the evening punch")
            }
        }
    }

    private fun createNotification(nb: Notification.Builder, context: Context, notificationManager: NotificationManager) {
        nb.setSmallIcon(R.drawable.sapple_logo)

        val notifyIntent = Intent(context, SampleActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context,2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        nb.setContentIntent(pendingIntent)
        val notificationCompat = nb.build()
        val notificationManagerCompat = NotificationManagerCompat.from(context)
        notificationManagerCompat.notify((Date().time / 1000L % Integer.MAX_VALUE).toInt(), notificationCompat)
        notificationManager.notify((Date().time / 1000L % Integer.MAX_VALUE).toInt(), notificationCompat)
    }
}