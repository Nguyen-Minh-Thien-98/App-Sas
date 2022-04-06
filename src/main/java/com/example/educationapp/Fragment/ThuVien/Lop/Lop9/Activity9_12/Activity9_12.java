package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_12 extends AppCompatActivity {
    Button btnback, btnhome;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_12);
        btnback = findViewById(R.id.btnback);
        btnhome = findViewById(R.id.btnhome);


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_12.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}