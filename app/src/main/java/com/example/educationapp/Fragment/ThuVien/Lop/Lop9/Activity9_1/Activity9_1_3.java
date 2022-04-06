package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_1_3 extends AppCompatActivity {
    Button btnback, btnhome, btn9131, btn9132;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_1_3);
        btnback = findViewById(R.id.btnback);
        btnhome = findViewById(R.id.btnhome);
        btn9131 = findViewById(R.id.btn9_1_3_1);
        btn9132 = findViewById(R.id.btn9_1_3_2);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity9_1_3.this, HomeActivity.class));
            }
        });

        btn9131.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity9_1_3.this, Activity9_1_3_1.class));
            }
        });

        btn9132.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity9_1_3.this, Activity9_1_3_2.class));
            }
        });
    }
}