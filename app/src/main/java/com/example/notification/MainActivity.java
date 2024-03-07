package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
public static final String Channel_id="MY Channel";
public  static final int  NOTIFICATION_ID=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.database,null);
        BitmapDrawable bitmapDrawable=(BitmapDrawable) drawable;
        Bitmap largeIcon=bitmapDrawable.getBitmap();
        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
         Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationCompat.Builder notification= new NotificationCompat.Builder(this,Channel_id)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.database)
                    .setContentText("NEW MESSAGE")
                    .setSubText("NEW MESSAGE FROM RAHUL")
                    .setChannelId(Channel_id);
            .build();
            nm.createNotificationChannel(new NotificationChannel(Channel_id,"new channel",NotificationManager));
        }else
        {
            Notification.Builder  notification= new Notification.Builder(this,Channel_id)

                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.database)
                    .setContentText("NEW MESSAGE")
                    .setSubText("NEW MESSAGE FROM RAHUL")
                    .setChannelId(Channel_id);
            .build();
        }
  nm.notify(NOTIFICATION_ID,notification);
    }
}