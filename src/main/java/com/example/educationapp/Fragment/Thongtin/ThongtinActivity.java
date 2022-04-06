package com.example.educationapp.Fragment.Thongtin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.educationapp.R;
import com.example.educationapp.Service.BackgroundSoundThongtin;

public class ThongtinActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        stopService(new Intent(ThongtinActivity.this, BackgroundSoundThongtin.class));

    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(new Intent(ThongtinActivity.this, BackgroundSoundThongtin.class));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);
    }
}