package com.example.dhikr_allah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnAdikr, btnSalat, btnTasbih, btnAibar, btnIstighfar;
    AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("success","millis "+System.currentTimeMillis());
        System.out.println("millis "+System.currentTimeMillis());

        notificationChannel();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        initViews();

        btnTasbih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TasbihActivity.class);
                startActivity(intent);
                // Create an Intent with the broadcast receiver and add extras
                Intent tasbihIntent = new Intent(MainActivity.this, ReceiverBroadCast.class);
                tasbihIntent.putExtra("tasbihTitle", "لا تنسى أن تسبح لله");
                tasbihIntent.putExtra("tasbihText", "قال تعالى ﴿ فَسَبِّحْ بِحَمْدِ رَبِّكَ وَاسْتَغْفِرْهُ إِنَّهُ كَانَ تَوَّابًا ﴾ [النَّصر: 3]");
                PendingIntent pendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(), 0, tasbihIntent, PendingIntent.FLAG_IMMUTABLE);
                setNotifAlarm(60*1000,18,0,pendingIntent1);

            }
        });
        btnSalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SalatActivity.class);
                startActivity(intent);
                // Create an Intent with the broadcast receiver and add extras
                Intent salatIntent = new Intent(MainActivity.this, ReceiverBroadCast.class);
                salatIntent.putExtra("salatTitle", "لا تنسى الصلاة على النبي");
                salatIntent.putExtra("salatText", "قال تعالى: ﴿ إِنَّ اللَّـهَ وَمَلَائِكَتَهُ يُصَلُّونَ عَلَى النَّبِيِّ يَا أَيُّهَا الَّذِينَ آمَنُوا صَلُّوا عَلَيْهِ وَسَلِّمُوا تَسْلِيمًا ﴾");
                PendingIntent pendingIntent3 = PendingIntent.getBroadcast(getApplicationContext(), 1, salatIntent, PendingIntent.FLAG_IMMUTABLE);
                setNotifAlarm(60*1000,18,45,pendingIntent3);
            }
        });
        btnIstighfar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IsighfarActivity.class);
                startActivity(intent);
                // Create an Intent with the broadcast receiver and add extras
                Intent istighfarIntent = new Intent(MainActivity.this, ReceiverBroadCast.class);
                istighfarIntent.putExtra("istighfarTitle", "لا تنسى أن تستغفر الله");
                istighfarIntent.putExtra("istighfarText", "من لزم الاستغفار جعل الله له من كل هم فرجا, ومن كل ضيق مخرجا, ورزقه من حيث لا يحتسب");
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(getApplicationContext(), 1, istighfarIntent, PendingIntent.FLAG_IMMUTABLE);
                setNotifAlarm(60*1000,18,40,pendingIntent2);
            }
        });
        btnAdikr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AdkarActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initViews(){
        btnAdikr = findViewById(R.id.btnadikr);
        btnTasbih = findViewById(R.id.btnTasbih);
        btnSalat = findViewById(R.id.btnSalat);
        btnAibar = findViewById(R.id.btnAibar);
        btnIstighfar = findViewById(R.id.btnIstighfar);
    }
    public void setNotifAlarm(long interval, int hour, int minute, PendingIntent pendingIntent) {
        long triggerAtMillis = System.currentTimeMillis() + interval;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval, pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerAtMillis, pendingIntent);
        }
    }

    private void notificationChannel(){
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            CharSequence name = "Reminder";
            String description = "It's dikr Time!";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Notification", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}