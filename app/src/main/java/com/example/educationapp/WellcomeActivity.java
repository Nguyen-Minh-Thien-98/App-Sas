package com.example.educationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.educationapp.Service.BackgroudSoundWellcome;
import com.squareup.picasso.Picasso;

import java.net.URL;


public class WellcomeActivity extends AppCompatActivity {

    // set biến thời gian load màn hình
    private static int Timeout = 3000;

    public ImageView imglogo;
    public TextView tvslogan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        //Sound Effect


        //Animation
        Animation animationLefttoright = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lefttoright);
        imglogo = findViewById(R.id.imgLogo);
        tvslogan = findViewById(R.id.tvSlogan);
        imglogo.setAnimation(animationLefttoright);
        tvslogan.setAnimation(animationLefttoright);
//        startService(new Intent(WellcomeActivity.this, BackgroudSoundWellcome.class));


        setTimeout();



    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    //load màn hình trong 3s
    public void setTimeout(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WellcomeActivity.this, HomeActivity.class);
                startActivity(intent);
//                stopService(new Intent(WellcomeActivity.this, BackgroudSoundWellcome.class));
                finish();
            }
        }, Timeout);
    }



}