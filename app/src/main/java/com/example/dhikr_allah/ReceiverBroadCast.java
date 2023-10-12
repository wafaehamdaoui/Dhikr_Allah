package com.example.dhikr_allah;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReceiverBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // istighfar notif
        String istighfarTitle = intent.getStringExtra("istighfarTitle");
        String istighfarText = intent.getStringExtra("istighfarText");
        Intent rpeatin_intent = new Intent(context, IsighfarActivity.class);
        rpeatin_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, rpeatin_intent, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = createNotif(pendingIntent, context,istighfarTitle,istighfarText);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManagerCompat.notify(200, builder.build());

        // tasbih notif
        String tasbihTitle = intent.getStringExtra("tasbihTitle");
        String tasbihText = intent.getStringExtra("tasbihText");
        Intent rpeatin_intent1 = new Intent(context, TasbihActivity.class);
        rpeatin_intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(context, 1, rpeatin_intent1, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder1 = createNotif(pendingIntent1, context,tasbihTitle,tasbihText);
        NotificationManagerCompat notificationManagerCompat1 = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManagerCompat1.notify(201, builder1.build());

        // salat on prophet notif
        String salatTitle = intent.getStringExtra("salatTitle");
        String salatText = intent.getStringExtra("salatText");
        Intent rpeatin_intent2 = new Intent(context, SalatActivity.class);
        rpeatin_intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(context, 2, rpeatin_intent2, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder2 = createNotif(pendingIntent2, context,salatTitle,salatText);
        NotificationManagerCompat notificationManagerCompat2 = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManagerCompat2.notify(202, builder2.build());
    }
    private NotificationCompat.Builder createNotif(PendingIntent pendingIntent, Context context, String title, String text){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Notification")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.dikr)
                .setContentTitle(title)
                .setContentText(text)
                .setAutoCancel(true);
        return  builder;
    }
}
