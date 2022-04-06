package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.chuyendaythiService;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_7 extends AppCompatActivity {
    Button btnback, btnhome, btn971, btn972, btn973, btn974;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        stopService(new Intent(Activity9_7.this, chuyendaythiService.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_7);
        btnback = findViewById(R.id.btnback);
        btnhome = findViewById(R.id.btnhome);
        btn971 = findViewById(R.id.btn9_7_1);
        btn972 = findViewById(R.id.btn9_7_2);
        btn973 = findViewById(R.id.btn9_7_3);
        btn974 = findViewById(R.id.btn9_7_4);
        startService(new Intent(Activity9_7.this, chuyendaythiService.class));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_7.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn971.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_7.this, Activity9_7_1.class);
                startActivity(intent);
            }
        });

        btn972.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_7.this, Activity9_7_2.class);
                startActivity(intent);
            }
        });

        btn973.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_7.this, Activity9_7_3.class);
                startActivity(intent);
            }
        });

        btn974.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_7.this, Activity9_7_4.class);
                startActivity(intent);
            }
        });


    }
}