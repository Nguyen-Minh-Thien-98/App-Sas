package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_8_1 extends AppCompatActivity {
    Button btnhome, btnback, btn9811, btn9812;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_8_1);
        btnback = findViewById(R.id.btnback);
        btnhome = findViewById(R.id.btnhome);
        btn9811 = findViewById(R.id.btn9_8_1_1);
        btn9812 = findViewById(R.id.btn9_8_1_2);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_8_1.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btn9811.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_8_1.this, Activity9_8_1_1.class);
                startActivity(intent);
            }
        });


        btn9812.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_8_1.this, Activity9_8_1_2.class);
                startActivity(intent);
            }
        });
    }
}