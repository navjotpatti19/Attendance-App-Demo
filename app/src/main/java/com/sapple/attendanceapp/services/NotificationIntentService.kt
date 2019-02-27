package com.sapple.attendanceapp.services

import android.app.IntentService
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationManagerCompat
import com.sapple.attendanceapp.R
import com.sapple.attendanceapp.activities.LoginActivity
import com.sapple.attendanceapp.activities.SampleActivity
import java.util.*

class NotificationIntentService: IntentService("") {

    override fun onHandleIntent(intent: Intent?) {
        val notificationManager = applicationContext!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val nb = Notification.Builder(this)
        nb.setContentTitle("Punch Missing")
        if(intent!!.action == "ACTION_ONE") {
            nb.setContentText("You have missed the morning punch")
        } else if(intent.action == "ACTION_TWO"){
            nb.setContentText("You have missed the evening punch")
        }

        nb.setSmallIcon(R.drawable.password_icon)

        val notifyIntent = Intent(this, SampleActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,2, notifyIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT)
        nb.setContentIntent(pendingIntent)
        val notificationCompat = nb.build()
        val notificationManagercompat = NotificationManagerCompat.from(this)
        notificationManagercompat.notify((Date().time / 1000L % Integer.MAX_VALUE).toInt(), notificationCompat)
        notificationManager.notify((Date().time / 1000L % Integer.MAX_VALUE).toInt(), notificationCompat)
    }
}