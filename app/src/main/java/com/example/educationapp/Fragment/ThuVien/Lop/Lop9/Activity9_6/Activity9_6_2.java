package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_6_2 extends AppCompatActivity {
    Button btnhome, btnback, btn9621, btn9622, btn9623;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_6_2);
        btnhome = findViewById(R.id.btnhome);
        btnback = findViewById(R.id.btnback);
        btn9621 = findViewById(R.id.btn9_6_2_1);
        btn9622 = findViewById(R.id.btn9_6_2_2);
        btn9623 = findViewById(R.id.btn9_6_2_3);

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity9_6_2.this, HomeActivity.class));
                finish();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // bao cao su
        btn9621.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity9_6_2.this, Activity9_6_2_1.class));
            }
        });

        // Thuốc tránh thai
        btn9622.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity9_6_2.this, Activity9_6_2_2.class));
            }
        });

        //Vòng tránh thai
        btn9623.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity9_6_2.this, Activity9_6_2_3.class));
            }
        });
    }
}