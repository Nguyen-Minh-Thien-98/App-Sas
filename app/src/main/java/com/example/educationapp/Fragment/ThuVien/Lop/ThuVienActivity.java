package com.example.educationapp.Fragment.ThuVien.Lop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;
import com.example.educationapp.Service.BackgroudSoundWellcome;

public class ThuVienActivity extends AppCompatActivity {
    Button btnhome, btnback;
    Button btnlop6, btnlop7, btnlop8, btnlop9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thu_vien);
        btnhome = findViewById(R.id.btnhome);
        btnback = findViewById(R.id.btnback);
        btnlop6 = findViewById(R.id.btnlop6);
        btnlop7 = findViewById(R.id.btnlop7);
        btnlop8 = findViewById(R.id.btnlop8);
        btnlop9 = findViewById(R.id.btnlop9);


        startService(new Intent(ThuVienActivity.this, BackgroudSoundWellcome.class));

        btnlop6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThuVienActivity.this, Lop9.class);
                intent.putExtra("lop","6");
                startActivity(intent);
            }
        });

        btnlop7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThuVienActivity.this, Lop9.class);
                intent.putExtra("lop","7");
                startActivity(intent);
            }
        });

        btnlop8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThuVienActivity.this, Lop9.class);
                intent.putExtra("lop", "8");
                startActivity(intent);
            }
        });

        btnlop9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThuVienActivity.this, Lop9.class);
                intent.putExtra("lop","9");
                startActivity(intent);
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThuVienActivity.this, HomeActivity.class));
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(new Intent(ThuVienActivity.this, BackgroudSoundWellcome.class));
        finish();
    }


}