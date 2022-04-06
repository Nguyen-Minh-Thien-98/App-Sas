package com.example.educationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.VideoView;

import com.example.educationapp.Fragment.HoTro.HotroActivity;
import com.example.educationapp.Fragment.Thongtin.ThongtinActivity;
import com.example.educationapp.Fragment.ThuVien.Lop.ThuVienActivity;
import com.example.educationapp.Game.ActivityCottruyen;
import com.example.educationapp.Service.BackgroundSoundMenu;

public class HomeActivity extends AppCompatActivity {

    public VideoView vdhome;
    public Button btnthuvien, btnhotro, btnthongtin, btnluyentap;
    public static FrameLayout fragmentcontainer;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(new Intent(HomeActivity.this, BackgroundSoundMenu.class));
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(HomeActivity.this, BackgroundSoundMenu.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(new Intent(HomeActivity.this, BackgroundSoundMenu.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Animation
        Animation animationLefttoright = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lefttoright);
        //ánh xạ
        fragmentcontainer = findViewById(R.id.fragmentcontainer);
        btnthuvien = findViewById(R.id.btnthuvien);
        btnhotro = findViewById(R.id.btnHotro);
        btnthongtin = findViewById(R.id.btnThongtin);
        btnluyentap = findViewById(R.id.btnLuyentap);

        btnthuvien.startAnimation(animationLefttoright );
        btnhotro.startAnimation(animationLefttoright );
        btnluyentap.startAnimation(animationLefttoright );
        btnthongtin.startAnimation(animationLefttoright );





        // sự kiện button thu vien
        btnthuvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ThuVienActivity.class);
                stopService(new Intent(HomeActivity.this, BackgroundSoundMenu.class));
                startActivity(intent);
            }
        });
        //sự kiện button Hotro
        btnhotro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HotroActivity.class);
                stopService(new Intent(HomeActivity.this, BackgroundSoundMenu.class));
                startActivity(intent);
            }
        });
        //sự kiện luyện tập
        btnluyentap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ActivityCottruyen.class);
                stopService(new Intent(HomeActivity.this, BackgroundSoundMenu.class));
                startActivity(intent);
            }
        });

        // button thong tin

        btnthongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ThongtinActivity.class);
                stopService(new Intent(HomeActivity.this, BackgroundSoundMenu.class));
                startActivity(intent);
            }
        });






    }


}