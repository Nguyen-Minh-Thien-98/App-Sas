package com.example.educationapp.Game;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.educationapp.Game.Database.Databasehelper;
import com.example.educationapp.Game.Model.m_Level;
import com.example.educationapp.Game.Model.m_User;

import com.example.educationapp.HomeActivity;
import com.example.educationapp.R;
import com.example.educationapp.Service.BackgroundSoundMenu;
import com.example.educationapp.Service.BackgroundSoundService;


public class HomeQuizActivity extends AppCompatActivity {
    public ImageView imv1, imv2, imv3, imv4, imv5, imv6, imv7, imv8, imv9, imv10;

    public ConstraintLayout constraintLayout;
    public Databasehelper databasehelper = new Databasehelper(this);
    public m_Level m_level;
    public m_User m_user;
    public static int levelhomequiz;
    SoundPool soundPool;
    int[] sm;




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(new Intent(HomeQuizActivity.this, BackgroundSoundService.class));
        startActivity(new Intent(HomeQuizActivity.this, HomeActivity.class));
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(HomeQuizActivity.this, BackgroundSoundService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(new Intent(HomeQuizActivity.this, BackgroundSoundService.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_quiz);

        constraintLayout = findViewById(R.id.Ctrhomequiz);

        imv1 = findViewById(R.id.imvLevel1);
        imv2 = findViewById(R.id.imvLevel2);
        imv3 = findViewById(R.id.imvLevel3);
        imv4 = findViewById(R.id.imvLevel4);
        imv5 = findViewById(R.id.imvLevel5);
        imv6 = findViewById(R.id.imvLevel6);
        imv7 = findViewById(R.id.imvLevel7);
        imv8 = findViewById(R.id.imvLevel8);
        imv9 = findViewById(R.id.imvLevel9);
        imv10 = findViewById(R.id.imvLevel10);



        //Hiệu ứng âm thanh
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes attrs = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .setAudioAttributes(attrs)
                    .build();
        } else {
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        }
        // người dùng chỉnh độ to nhỏ hiệu ứng âm thanh
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        sm = new int[10];
        // ánh xạ sound effect
        sm[0] = soundPool.load(this, R.raw.buttonclick, 1);
        sm[1] = soundPool.load(this, R.raw.transiction, 1);
        sm[2] = soundPool.load(this, R.raw.levelup, 1);
        sm[3] = soundPool.load(this, R.raw.correct, 1);
        sm[4] = soundPool.load(this, R.raw.wrong, 1);
        sm[5] = soundPool.load(this, R.raw.radiobutton, 1);



        m_user = databasehelper.getUserfromID(1);
        levelhomequiz = m_user.getLevelhomequiz();


        Log.d(String.valueOf(levelhomequiz), "levelhomequiz nè");
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenvegame(levelhomequiz);
            }
        });

        if (levelhomequiz == 1){
            imv1.setVisibility(View.VISIBLE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }else if (levelhomequiz == 2){
            imv1.setVisibility(View.GONE);
            imv2.setVisibility(View.VISIBLE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }else if (levelhomequiz == 3){
            imv1.setVisibility(View.GONE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.VISIBLE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }else if (levelhomequiz == 4){
            imv1.setVisibility(View.GONE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.VISIBLE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }else if (levelhomequiz == 5){
            imv1.setVisibility(View.GONE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.VISIBLE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }else if(levelhomequiz == 6){
            imv1.setVisibility(View.GONE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.VISIBLE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }else if(levelhomequiz == 7){
            imv1.setVisibility(View.GONE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.VISIBLE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }else if (levelhomequiz == 8){
            imv1.setVisibility(View.GONE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.VISIBLE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }else if (levelhomequiz == 9){
            imv1.setVisibility(View.GONE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.VISIBLE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }else if (levelhomequiz == 10){
            imv1.setVisibility(View.GONE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.VISIBLE);
            chuyenvegame(levelhomequiz);
        }else if(levelhomequiz == 11){
            m_User user1 = new m_User(1, 1);
            databasehelper.updateUser(user1);
            levelhomequiz = user1.getLevelhomequiz();
            imv1.setVisibility(View.VISIBLE);
            imv2.setVisibility(View.GONE);
            imv3.setVisibility(View.GONE);
            imv4.setVisibility(View.GONE);
            imv5.setVisibility(View.GONE);
            imv6.setVisibility(View.GONE);
            imv7.setVisibility(View.GONE);
            imv8.setVisibility(View.GONE);
            imv9.setVisibility(View.GONE);
            imv10.setVisibility(View.GONE);
            chuyenvegame(levelhomequiz);
        }

    }

    public  void xulysukienonclick(){
        Intent intent = new Intent(HomeQuizActivity.this, ActivityQuiz.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        //Lúc đầu
//        m_level = databasehelper.getLevelID(1);
//        int isPass1 = m_level.getPass();
//        int idQuiz1 = m_level.getId();
//
//        //Lúc sau
//
//        // lần 2
//        m_level = databasehelper.getLevelID(2);
//        int isPass2 = m_level.getPass();
//        int idQuiz2 = m_level.getId();
//
//        //Lúc sau
//        // lần 3
//        m_level = databasehelper.getLevelID(3);
//        int isPass3 = m_level.getPass();
//        int idQuiz3 = m_level.getId();
//        // lần 4
//        m_level = databasehelper.getLevelID(4);
//        int isPass4 = m_level.getPass();
//        int idQuiz4 = m_level.getId();
//        // lần 5
//        m_level = databasehelper.getLevelID(5);
//        int isPass5 = m_level.getPass();
//        int idQuiz5 = m_level.getId();
//        // lần 6
//        m_level = databasehelper.getLevelID(6);
//        int isPass6 = m_level.getPass();
//        int idQuiz6 = m_level.getId();
//        // lần 7
//        m_level = databasehelper.getLevelID(7);
//        int isPass7 = m_level.getPass();
//        int idQuiz7 = m_level.getId();
//        // lần 8
//        m_level = databasehelper.getLevelID(8);
//        int isPass8 = m_level.getPass();
//        int idQuiz8 = m_level.getId();
//        // lần 9
//        m_level = databasehelper.getLevelID(9);
//        int isPass9 = m_level.getPass();
//        int idQuiz9 = m_level.getId();
//        // lần 10
//        m_level = databasehelper.getLevelID(10);
//        int isPass10 = m_level.getPass();
//        int idQuiz10 = m_level.getId();







    }



    public void chuyenvegame(int a){
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeQuizActivity.this);

        builder.setTitle("Thông Báo")
                .setMessage("Bạn đang ở Level:"+a+", Bạn có muốn tiếp tục không?")
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        soundPool.play(sm[2], 1, 1, 1, 0, (float) 1.0);
                        Intent intent = new Intent(HomeQuizActivity.this, ActivityQuiz.class);
                        startActivity(intent);
                        stopService(new Intent(HomeQuizActivity.this, BackgroundSoundService.class));
                        finish();

                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        stopService(new Intent(HomeQuizActivity.this, BackgroundSoundService.class));
                        startActivity(new Intent(HomeQuizActivity.this, HomeActivity.class));
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // Vấn đề đang gặp
    // Làm sao để máy có thể Lưu tiến trình công việc và bắt đầu công việc tại tiến trình đó
    // tạo 1 biến tiến trình lưu vào database ?
    // levelhome quizz ?
    // Viết một void chạy trò chơi vừa thỏa chạy lúc đầu vừa thỏa chạy lúc sau ?
}