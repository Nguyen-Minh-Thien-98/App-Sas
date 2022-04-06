package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.ChaoembeService;
import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;

public class Activity9_2 extends AppCompatActivity {
    Button btnback, btnhome, btn921, btn922;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(new Intent(Activity9_2.this, ChaoembeService.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_2);
        btnback = findViewById(R.id.btnback);
        btnhome = findViewById(R.id.btnhome);
        btn921 = findViewById(R.id.btn9_2_1);
        btn922 = findViewById(R.id.btn9_2_2);

        startService(new Intent(Activity9_2.this, ChaoembeService.class));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_2.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // em bé đến từ đâu
        btn921.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_2.this, Activity9_2_1.class);
                startActivity(intent);
            }
        });
        // Video liên quan
        btn922.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity9_2.this, Activity9_2_2.class);
                startActivity(intent);
            }
        });
    }
}