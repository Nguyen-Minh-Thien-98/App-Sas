package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_13.Activity9_13;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_13.Activity9_13_7;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.ChaoembeService;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.kynangService;
import com.example.educationapp.R;
import com.example.educationapp.Service.BackgroudSoundWellcome;

public class Activity9_2_2 extends AppCompatActivity {

    public BackgroudSoundWellcome backgroudSoundWellcome;
    public Lop9 lop9;
    public Activity9_13 activity9_13;
    public Button btnvideothutinh;
    public String link = "https://www.youtube.com/watch?v=IdeOsdCVa6I";

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_2_2);

        if (!isMyServiceRunning(BackgroudSoundWellcome.class)){
            //do nothing
            startService(new Intent(Activity9_2_2.this, BackgroudSoundWellcome.class));
        }

        btnvideothutinh = findViewById(R.id.btnVideothutinh);

        btnvideothutinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(link);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                stopService(new Intent(Activity9_2_2.this, BackgroudSoundWellcome.class));
                stopService(new Intent(Activity9_2_2.this, ChaoembeService.class));

            }
        });
    }

    // check xem Service có đang Running hay không
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;


    }
}