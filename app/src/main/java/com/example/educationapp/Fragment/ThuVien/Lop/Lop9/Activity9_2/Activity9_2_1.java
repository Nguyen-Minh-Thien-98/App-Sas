package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.embedentudauService;
import com.example.educationapp.R;

public class Activity9_2_1 extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_2_1);
    }
}