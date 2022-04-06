package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.kynangService;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_13 extends AppCompatActivity {
    Button btnback, btnhome, btn9131, btn9132, btn9133, btn9134, btn9135, btn9136, btn9137;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        stopService((new Intent(Activity9_13.this, kynangService.class)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_13);
        btnback = findViewById(R.id.btnback);
        btnhome = findViewById(R.id.btnhome);
        btn9131 = findViewById(R.id.btn9_13_1);
        btn9132 = findViewById(R.id.btn9_13_2);
        btn9133 = findViewById(R.id.btn9_13_3);
        btn9134 = findViewById(R.id.btn9_13_4);
        btn9135 = findViewById(R.id.btn9_13_5);
        btn9136 = findViewById(R.id.btn9_13_6);
        btn9137 = findViewById(R.id.btn9_13_7);

        startService(new Intent(Activity9_13.this, kynangService.class));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_13.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Quy tắc bàn tay giao tiêp
        btn9131.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_13.this, Activity9_13_1.class);
                startActivity(intent);
            }
        });

        //Nguyên tắc đồ lót
        btn9132.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_13.this, Activity9_13_2.class);
                startActivity(intent);
            }
        });

        //Khoảng cách phù hợp, an toàn theo sau
        btn9133.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_13.this, Activity9_13_3.class);
                startActivity(intent);
            }
        });

        //Quy tắc “9 không”
        btn9134.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_13.this, Activity9_13_4.class);
                startActivity(intent);
            }
        });

        //Kỹ năng từ chối
        btn9135.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_13.this, Activity9_13_5.class);
                startActivity(intent);
            }
        });

        //Ngồi hợp lý, thật ăn ý
        btn9136.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_13.this, Activity9_13_6.class);
                startActivity(intent);
            }
        });

        //Video liên quan kỹ năng
        btn9137.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_13.this, Activity9_13_7.class);
                startActivity(intent);
            }
        });
    }
}