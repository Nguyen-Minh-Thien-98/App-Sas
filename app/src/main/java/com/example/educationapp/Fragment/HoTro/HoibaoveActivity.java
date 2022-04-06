package com.example.educationapp.Fragment.HoTro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.educationapp.R;

public class HoibaoveActivity extends AppCompatActivity {
    Button btngoidien, btndiachi, btndiachiwebsite, btnfacebook;
    private static final int MY_PERMISSION_REQUEST_CODE_CALL_PHONE = 555;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoibaove);
        btngoidien = findViewById(R.id.btnGoidienthoai);
        btndiachi = findViewById(R.id.btnDiachi);
        btndiachiwebsite = findViewById(R.id.btnwWbsite);
        btnfacebook = findViewById(R.id.btnFacebook);

        btngoidien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermissionAndCall();
            }
        });

        btndiachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = "https://www.google.com/maps/place/H%E1%BB%99i+B%E1%BA%A3o+Tr%E1%BB%A3+Tr%E1%BA%BB+Em+Tp.Hcm,+85+Ph%E1%BA%A1m+Vi%E1%BA%BFt+Ch%C3%A1nh,+Ph%C6%B0%E1%BB%9Dng+19,+B%C3%ACnh+Th%E1%BA%A1nh,+Th%C3%A0nh+ph%E1%BB%91+H%E1%BB%93+Ch%C3%AD+Minh/@10.8670822,106.6427413,13z/data=!4m6!3m5!1s0x317528ad9b995c6b:0x9d3b5548d42af882!7e2!8m2!3d10.7915621!4d106.712613";
                Uri uri = Uri.parse(link);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        btndiachiwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = "https://hcwa.org.vn/?fbclid=IwAR12iBG1zOF49I7J-J8UFiv1FNazp5dJHRL1P66-CJX04V_Dx6YL7-FoowE";
                Uri uri = Uri.parse(link);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = "https://www.facebook.com/hcwa.org.vn/?__xts__[0]=68.ARAU6LO_AnWMDKMHAP3Z2HZfI7yIOg0riHeDsjrz61oTJnks_EuytdzIXJMZnCBTaQwZAN9Yv96E_M5VliOCIR4q9f6jk0pu-DZRdHVJS5nZJ71xEVcA-VwOO17jaQ9wYr0Kom4eymHuNY9WPvh-UenIuqQmF2JUV441zJ1o55jF-GpWDKYaYORHLBJnE4oAjYs-FCYqBd3hbjULH6ockg_FSB1GLjuiTW7CJNoU66D6mQNA5zPAOsn-MDHm33qzjK6Ocp-IxGnSxtlNQuEEDWA08kG65rJ1iWxSUlkvBuUkHNykehs";
                Uri uri = Uri.parse(link);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });
    }

    private void askPermissionAndCall() {

        // With Android Level >= 23, you have to ask the user
        // for permission to Call.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) { // 23

            // Check if we have Call permission
            int sendSmsPermisson = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE);

            if (sendSmsPermisson != PackageManager.PERMISSION_GRANTED) {
                // If don't have permission so prompt the user.
                this.requestPermissions(
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSION_REQUEST_CODE_CALL_PHONE
                );
                return;
            }
        }
        this.callNow();
    }

    @SuppressLint("MissingPermission")
    private void callNow() {
        String phoneNumber = "02838401406";

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        try {
            this.startActivity(callIntent);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Your call failed... " + ex.getMessage(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }


    // When you have the request results
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_CODE_CALL_PHONE: {

                // Note: If request is cancelled, the result arrays are empty.
                // Permissions granted (CALL_PHONE).
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.i( "permision","Permission granted!");
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_LONG).show();

                    this.callNow();
                }
                // Cancelled or denied.
                else {
                    Log.i( "tu choi","Permission denied!");
                    Toast.makeText(this, "Permission denied!", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    // When results returned
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_PERMISSION_REQUEST_CODE_CALL_PHONE) {
            if (resultCode == RESULT_OK) {
                // Do something with data (Result returned).
                Toast.makeText(this, "Action OK", Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}