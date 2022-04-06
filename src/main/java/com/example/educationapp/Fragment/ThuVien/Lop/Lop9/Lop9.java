package com.example.educationapp.Fragment.ThuVien.Lop.Lop9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_1.Activity9_1;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_10.Activity9_10;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_11.Activity9_11;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_12.Activity9_12;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_13.Activity9_13;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_2.Activity9_2;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_3.Activity9_3;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_4.Activity9_4;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_5.Activity9_5;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_6.Activity9_6;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_7.Activity9_7;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_8.Activity9_8;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_9.Activity9_9;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

import static android.view.View.GONE;

public class Lop9 extends AppCompatActivity  {

    Button btn9_1, btn9_2, btn9_3, btn9_4, btn9_5, btn9_6, btn9_7, btn9_8, btn9_9, btn9_10, btn9_11, btn9_12, btn9_13, btn9_14, btn9_15;
    Button btnhome, btnback;
    TextView tvlop;
    SoundPool soundPool;
    int[] sm;
    String lop;

    @Override
    public void onBackPressed() {
            super.onBackPressed();
            finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop9);
        tvlop = findViewById(R.id.Lop);
        btn9_1 = findViewById(R.id.btn9_1);
        btn9_2 = findViewById(R.id.btn9_2);
        btn9_3 = findViewById(R.id.btn9_3);
        btn9_4 = findViewById(R.id.btn9_4);
        btn9_5 = findViewById(R.id.btn9_5);
        btn9_6 = findViewById(R.id.btn9_6);
        btn9_7 = findViewById(R.id.btn9_7);
        btn9_8 = findViewById(R.id.btn9_8);
        btn9_9 = findViewById(R.id.btn9_9);
        btn9_10 = findViewById(R.id.btn9_10);
        btn9_11 = findViewById(R.id.btn9_11);
        btn9_12 = findViewById(R.id.btn9_12);
        btn9_13 = findViewById(R.id.btn9_13);
        btnhome = findViewById(R.id.btnhome);
        btnback = findViewById(R.id.btnback);

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

        sm = new int[30];
        // ánh xạ sound effect
        sm[0] = soundPool.load(this, R.raw.buttonclick, 1);
        sm[1] = soundPool.load(this, R.raw.transiction, 1);
        sm[2] = soundPool.load(this, R.raw.levelup, 1);
        sm[3] = soundPool.load(this, R.raw.correct, 1);
        sm[4] = soundPool.load(this, R.raw.wrong, 1);
        sm[5] = soundPool.load(this, R.raw.radiobutton, 1);





        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lop9.this, HomeActivity.class));
                finish();
            }
        });

        // nhan gia tri tu Thu Vien

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                lop = null;
            } else {
                lop = extras.getString("lop");
                routerLop(lop);
            }
        } else {
            lop = (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }

        // Phần e thẹn trên cơ thể
        btn9_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_1.class);
                startActivity(intent);
            }
        });

        // Em bé sinh ra từ đâu
        btn9_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_2.class);
                startActivity(intent);
            }
        });

        // Chuyện ấy ấy
        btn9_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_3.class);
                startActivity(intent);
            }
        });

        // Mát-xa bé con cho bản thân
        btn9_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_4.class);
                startActivity(intent);
            }
        });

        //Phim 18+
        btn9_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_5.class);
                startActivity(intent);
            }
        });

        // Tránh thai điều bạn cần biết
        btn9_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_6.class);
                startActivity(intent);
            }
        });


        // Chuyện dậy thì
        btn9_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_7.class);
                startActivity(intent);
            }
        });

        // Cô cậu bé có mắc bệnh không nhỉ
        btn9_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_8.class);
                startActivity(intent);
            }
        });

        // Mách nhỏ về con tim
        btn9_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_9.class);
                startActivity(intent);
            }
        });

        // Chuyện trăm năm
        btn9_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_10.class);
                startActivity(intent);
            }
        });

        // LGBT
        btn9_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_11.class);
                startActivity(intent);
            }
        });


        // Kỹ năng chỉ là chuyện nhỏ
        btn9_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lop9.this, Activity9_13.class);
                startActivity(intent);
            }
        });
    }

    public void routerLop(String lop){
        if (lop.equalsIgnoreCase("6")){
            btn9_3.setVisibility(GONE);
            btn9_4.setVisibility(GONE);
            btn9_5.setVisibility(GONE);
            btn9_6.setVisibility(GONE);
            btn9_12.setVisibility(GONE);
            tvlop.setText("Lớp 6");
        }else if (lop.equalsIgnoreCase("7")){
            btn9_4.setVisibility(GONE);
            btn9_12.setVisibility(GONE);
            tvlop.setText("Lớp 7");
        }else if (lop.equalsIgnoreCase("8")){
            btn9_12.setVisibility(GONE);
            tvlop.setText("Lớp 8");
        }else{
            btn9_12.setVisibility(GONE);
            // do nothing
        }
    }



}