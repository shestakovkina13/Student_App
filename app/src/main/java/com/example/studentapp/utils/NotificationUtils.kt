package com.example.studentapp.utils

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import com.example.studentapp.R


const val NOTIFICATION_CHANNEL_ID = "NOTIFICATION_CHANNEL_ID"
const val RETAKE_NOTIFICATION_ID = 1
const val CHECK_NOTIFICATION_ID = 2
const val SCHEDULE_BEHIND_NOTIFICATION_ID = 3

fun Context.checkNotificationPermission(callback: (String) -> Unit) {
    if (SDK_INT >= TIRAMISU) {
        val permission = POST_NOTIFICATIONS
        if (checkSelfPermission(this, permission) != PERMISSION_GRANTED) callback.invoke(permission)
    }
}

fun showRetakeNotification(context: Context) {
    val channel = createNotificationChannel(context)

    val notification = NotificationCompat.Builder(context, channel)
        .setContentTitle(context.getString(R.string.notification_retake_title))
        .setContentText(context.getString(R.string.notification_retake))
        .setSmallIcon(R.drawable.ic_notifications)
        .build()
        .apply { flags = Notification.FLAG_AUTO_CANCEL }

    getNotificationManager(context).notify(RETAKE_NOTIFICATION_ID, notification)
}

fun showCheckNotification(context: Context) {
    val channel = createNotificationChannel(context)

    val notification = NotificationCompat.Builder(context, channel)
        .setContentTitle(context.getString(R.string.notification_check_title))
        .setContentText(context.getString(R.string.notification_check))
        .setSmallIcon(R.drawable.ic_notifications)
        .build()
        .apply { flags = Notification.FLAG_AUTO_CANCEL }

    getNotificationManager(context).notify(CHECK_NOTIFICATION_ID, notification)
}

fun showScheduleBehindNotification(context: Context) {
    val channel = createNotificationChannel(context)

    val notification = NotificationCompat.Builder(context, channel)
        .setContentTitle(context.getString(R.string.notification_schedule_behind_title))
        .setContentText(context.getString(R.string.notification_schedule_behind))
        .setSmallIcon(R.drawable.ic_notifications)
        .build()
        .apply { flags = Notification.FLAG_AUTO_CANCEL }

    getNotificationManager(context).notify(SCHEDULE_BEHIND_NOTIFICATION_ID, notification)
}

private fun createNotificationChannel(context: Context) =
    if (SDK_INT >= Build.VERSION_CODES.O) {
        val notificationManager = getNotificationManager(context)
        var channel = notificationManager.getNotificationChannel(NOTIFICATION_CHANNEL_ID)
        if (channel == null) {
            val name = context.getString(R.string.app_name)
            channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, name, IMPORTANCE_LOW)
            notificationManager.createNotificationChannel(channel)
        }
        channel.id
    } else {
        NOTIFICATION_CHANNEL_ID
    }

fun getNotificationManager(context: Context): NotificationManager =
    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager