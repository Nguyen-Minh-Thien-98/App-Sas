package com.example.educationapp.Game;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.educationapp.Game.Database.Databasehelper;
import com.example.educationapp.Game.Fragment.Fragment1;
import com.example.educationapp.Game.Model.m_User;

import com.example.educationapp.R;
import com.example.educationapp.Service.BackgroundsSoundCottruyen;


public class ActivityCottruyen extends AppCompatActivity {

    public FrameLayout fmcontainer;
    public Databasehelper databasehelper;
    static SoundPool soundPool;
    int[] sm;
    public m_User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cottruyen);
        fmcontainer = findViewById(R.id.fragmentcontent);


        databasehelper = new Databasehelper(this);
        user = databasehelper.getUserfromID(1);

        //Hiệu ứng âm thanh
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes attrs = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .setAudioAttributes(attrs)
                    .build();
        } else {
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        }
        // người dùng chỉnh độ to nhỏ hiệu ứng âm thanh
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        sm = new int[10];
        // ánh xạ sound effect
        sm[0] = soundPool.load(this, R.raw.buttonclick, 1);
        sm[1] = soundPool.load(this, R.raw.transiction, 1);
        sm[2] = soundPool.load(this, R.raw.levelup, 1);
        sm[3] = soundPool.load(this, R.raw.correct, 1);
        sm[4] = soundPool.load(this, R.raw.wrong, 1);
        sm[5] = soundPool.load(this, R.raw.radiobutton, 1);


//        ThuvienFragment thuvienFragment = new ThuvienFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.fragmentcontainer,thuvienFragment);
//        transaction.commit();

        if (user.getLevelhomequiz() == 1) {
            // load cot truyen
            //1
            startService(new Intent(ActivityCottruyen.this, BackgroundsSoundCottruyen.class));
            Fragment1 fm1 = new Fragment1();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragmentcontent, fm1);
            transaction.commit();
        }else{
            Intent intent = new Intent(ActivityCottruyen.this, HomeQuizActivity.class);
            startActivity(intent);
            finish();
        }

    }
}