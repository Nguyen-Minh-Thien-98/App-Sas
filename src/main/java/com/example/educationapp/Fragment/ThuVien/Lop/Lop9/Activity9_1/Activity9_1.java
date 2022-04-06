package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.ChaophanethenService;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_1 extends AppCompatActivity {
    Button btnback, btnhome;
    Button btn911, btn912, btn913;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        stopService(new Intent(Activity9_1.this, ChaophanethenService.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_1);
        btnhome = findViewById(R.id.btnhome);
        btnback = findViewById(R.id.btnback);
        btn911 = findViewById(R.id.btn9_1_1);
        btn912 = findViewById(R.id.btn9_1_2);
        btn913 = findViewById(R.id.btn9_1_3);

        startService(new Intent(Activity9_1.this, ChaophanethenService.class));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_1.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // Phần e thẹn bạn Nam
        btn911.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_1.this, Activity9_1_1.class);
                startActivity(intent);
            }
        });

        // Phần e thẹn bạn nữ
        btn912.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_1.this, Activity9_1_2.class);
                startActivity(intent);
            }
        });

        //Vệ sinh cô cậu bé
        btn913.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_1.this, Activity9_1_3.class);
                startActivity(intent);
            }
        });

    }
}