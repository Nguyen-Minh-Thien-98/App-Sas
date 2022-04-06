package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.ChaobenhquaquanheService;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.cocaubecothemacbenhkhongService;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_8 extends AppCompatActivity {
    Button btnback, btnhome, btn981, btn982, btn9811, btn9812;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(new Intent(Activity9_8.this, cocaubecothemacbenhkhongService.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_8);
        btnback = findViewById(R.id.btnback);
        btnhome = findViewById(R.id.btnhome);
        btn981 = findViewById(R.id.btn9_8_1);
        btn982 = findViewById(R.id.btn9_8_2);

        startService(new Intent(Activity9_8.this, cocaubecothemacbenhkhongService.class));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_8.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn981.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_8.this, Activity9_8_1.class);
                startActivity(intent);

            }
        });

        btn982.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_8.this, Activity9_8_2.class);
                startActivity(intent);
            }
        });


    }
}