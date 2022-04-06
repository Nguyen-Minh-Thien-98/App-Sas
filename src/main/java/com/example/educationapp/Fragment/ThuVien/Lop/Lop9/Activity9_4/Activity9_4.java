package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_4;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.thudamService;
import com.example.educationapp.R;

public class Activity9_4 extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        stopService(new Intent(Activity9_4.this, thudamService.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_4);
        startService(new Intent(Activity9_4.this, thudamService.class));
    }
}