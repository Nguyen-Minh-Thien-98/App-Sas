package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.educationapp.R;

public class chuyenayayService extends Service {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    int volume;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer = MediaPlayer.create(this, R.raw.chuyenayay);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public boolean stopService(Intent name) {

        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;

    }
}
