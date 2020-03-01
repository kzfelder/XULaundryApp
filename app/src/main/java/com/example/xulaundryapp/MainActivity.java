package com.example.xulaundryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity.java";
    Button btnNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotif = findViewById(R.id.btnNotif);

        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "TEST MESSAGE";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_warning_black_24dp)
                        .setContentTitle("NEW NOTIF")
                        .setContentText(message)
                        .setAutoCancel(true);

                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message", message);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
                        0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService(
                        Context.NOTIFICATION_SERVICE
                );
                notificationManager.notify(0,builder.build());
            }
        });

        LaundryRoom sampleRoom = new LaundryRoom("DP",5);
        sampleRoom.add("031-GNB",true);
        sampleRoom.add("030-GNB",true);
        sampleRoom.add("029-GNB",true);
        sampleRoom.add("035-GNB",false);
        sampleRoom.add("034-GNB",false);
        sampleRoom.add("033-GNB",false);
        sampleRoom.add("032-GNB",false);

        User user0 = new User("John", "Doe", 900123456,"jdoe@xula.edu");
        sampleRoom.reserve("031-GNB", user0);
        Log.i(TAG, "031-GNB status: " + sampleRoom.getUnitStatus("031-GNB"));

    }
}
