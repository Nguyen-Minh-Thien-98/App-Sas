package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_11;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.lgbtService;
import com.example.educationapp.R;

public class Activity9_11 extends AppCompatActivity {


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        stopService(new Intent(Activity9_11.this, lgbtService.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_11);
        startService(new Intent(Activity9_11.this, lgbtService.class));



    }
}