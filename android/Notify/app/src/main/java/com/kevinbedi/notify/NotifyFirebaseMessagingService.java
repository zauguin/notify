package com.kevinbedi.notify;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class NotifyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(
                remoteMessage.getMessageId(),
                1,
                new NotificationCompat.Builder(this)
                        .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                        .setSmallIcon(R.drawable.ic_paperplane)
                        .setContentTitle(remoteMessage.getNotification().getTitle())
                        .setContentText(remoteMessage.getNotification().getBody())
                        .setVibrate(new long[] { 150, 300, 150, 600})
                        .setAutoCancel(true)
                        .build());
        super.onMessageReceived(remoteMessage);
    }
}
