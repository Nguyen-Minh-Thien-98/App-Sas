package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.ChaochuyenayayService;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.chuyenayayService;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_3 extends AppCompatActivity {


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        stopService(new Intent(Activity9_3.this, chuyenayayService.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_3);
        startService(new Intent(Activity9_3.this, chuyenayayService.class));

    }
}