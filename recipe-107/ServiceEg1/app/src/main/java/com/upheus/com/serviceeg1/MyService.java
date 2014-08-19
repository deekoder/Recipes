package com.upheus.com.serviceeg1;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }
    MediaPlayer mediaPlayer = null;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "OnStartCmd",Toast.LENGTH_LONG);

        try {

            String url = ""; // your URL here
            mediaPlayer = MediaPlayer.create(this, R.raw.sd);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

        } catch (Exception e){
            Log.e("Services :", "error: " + e.getMessage(), e);
        }

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        if (mediaPlayer != null) {

            mediaPlayer.release();
            mediaPlayer = null;

        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
