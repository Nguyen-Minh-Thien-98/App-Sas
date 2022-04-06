package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_7.Activity9_7_4;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.machnhovecontimService;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_9 extends AppCompatActivity {
    Button btnback, btnhome, btn991, btn992, btn993;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        stopService(new Intent(Activity9_9.this, machnhovecontimService.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_9);
        btnback = findViewById(R.id.btnback);
        btnhome = findViewById(R.id.btnhome);
        btn991 = findViewById(R.id.btn9_9_1);
        btn992 = findViewById(R.id.btn9_9_2);
        btn993 = findViewById(R.id.btn9_9_3);

        startService(new Intent(Activity9_9.this, machnhovecontimService.class));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_9.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn991.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_9.this, Activity9_9_1.class);
                startActivity(intent);
            }
        });

        btn992.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_9.this, Activity9_9_2.class);
                startActivity(intent);
            }
        });

        btn993.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_9.this, Activity9_9_3.class);
                startActivity(intent);
            }
        });

    }
}