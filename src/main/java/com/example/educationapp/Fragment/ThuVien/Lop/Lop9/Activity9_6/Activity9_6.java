package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.ChaotranhthaiService;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.tranhthaiService;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_6 extends AppCompatActivity {
    Button btnback, btnhome, btn9_6_1, btn9_6_2;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        stopService(new Intent(Activity9_6.this, tranhthaiService.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_6);
        btnback = findViewById(R.id.btnback);
        btnhome = findViewById(R.id.btnhome);
        btn9_6_1 = findViewById(R.id.btn9_6_1);
        btn9_6_2 = findViewById(R.id.btn9_6_2);


        startService(new Intent(Activity9_6.this, tranhthaiService.class));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_6.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn9_6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_6.this, Activity9_6_1.class);
                startActivity(intent);
            }
        });

        btn9_6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_6.this, Activity9_6_2.class);
                startActivity(intent);
            }
        });


    }
}