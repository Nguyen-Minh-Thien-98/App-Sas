package com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Activity9_13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9;
import com.example.educationapp.Fragment.ThuVien.Lop.Lop9.Lop9Service.kynangService;
import com.example.educationapp.Fragment.ThuVien.Lop.ThuVienActivity;
import com.example.educationapp.R;
import com.example.educationapp.Service.BackgroudSoundWellcome;

public class Activity9_13_7 extends AppCompatActivity {
    public BackgroudSoundWellcome backgroudSoundWellcome;
    public Lop9 lop9;
    public Activity9_13 activity9_13;
    public Button btnvideokynang;
    public String link = "https://www.youtube.com/watch?v=5a4KKaaqpMc&ab_channel=BProductions";

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_13_7);
        btnvideokynang = findViewById(R.id.btnVideoKyNang);

        if(isMyServiceRunning(BackgroudSoundWellcome.class) == false){
            startService(new Intent(Activity9_13_7.this, BackgroudSoundWellcome.class));
        }

        btnvideokynang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(link);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                stopService(new Intent(Activity9_13_7.this, BackgroudSoundWellcome.class));
                stopService(new Intent(Activity9_13_7.this, kynangService.class));

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