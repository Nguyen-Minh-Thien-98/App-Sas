package com.example.educationapp.Game;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.educationapp.Game.Database.Databasehelper;
import com.example.educationapp.Game.Model.m_Level;
import com.example.educationapp.Game.Model.m_Question;
import com.example.educationapp.Game.Model.m_User;
import com.example.educationapp.R;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;



public class ActivityQuiz extends AppCompatActivity {
    public RelativeLayout rltquiz;
    public TextView tvscore, tvquestion, tvdiem, tvlevel;
    public RadioButton rdoanswerA, rdoanswerB, rdoanswerC, rdoanswerD;
    public RadioGroup rdganswer;
    public Button btnsubmid;
    public int diem = 1;
    public int total = 1;
    int dataType;
    private long mLastClickTime = 0;
    //Sqlite
    Databasehelper databasehelper;
    //Firebase
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databasequiz = firebaseDatabase.getReference("Quiz").child("quizid");
    //Sound Effect
    SoundPool soundPool;
    int[] sm;

    public Boolean pass = false;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ActivityQuiz.this, HomeQuizActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rltquiz = findViewById(R.id.rltquizactivity);
        tvscore = findViewById(R.id.tvScore);
        tvquestion = findViewById(R.id.tvQuestion);
        tvdiem = findViewById(R.id.tvdiem);
        tvlevel = findViewById(R.id.tvlevel);
        rdganswer = findViewById(R.id.rdganswer);
        rdoanswerA = findViewById(R.id.answerA);
        rdoanswerB = findViewById(R.id.answerB);
        rdoanswerC = findViewById(R.id.answerC);
        rdoanswerD = findViewById(R.id.answerD);
        btnsubmid = findViewById(R.id.btnSubmit);
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






        // bấm vào rlt để xem có kết nối internet ko
        rltquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (isNetworkConnected() == false){
                        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityQuiz.this);
                        builder.setTitle("Thông báo")
                                .setMessage("Vui lòng kiểm tra lại kết nối mạng")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        finish();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
            }
        });



        // xét xem thiết bị đã kết nối với internet chưa
        if (isNetworkConnected() == false){
            // không thì xuất ra dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityQuiz.this);
            builder.setTitle("Thông báo")
                    .setMessage("Vui lòng kiểm tra lại kết nối mạng")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            finish();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();

        }else{
            // có thì chạy chương trình
            // Database
            databasehelper = new Databasehelper(getApplicationContext());




            //xử lý sự kiện chechk radiobuton
            CompoundButton.OnCheckedChangeListener listenerRadio = new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    btnsubmid.setEnabled(true);

                }
            };
            // set defaut là false


            // Xử lý sự kiện chekcrdiobutton
            rdoanswerA.setOnCheckedChangeListener(listenerRadio);
            rdoanswerB.setOnCheckedChangeListener(listenerRadio);
            rdoanswerC.setOnCheckedChangeListener(listenerRadio);
            rdoanswerD.setOnCheckedChangeListener(listenerRadio);

            rdoanswerA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    soundPool.play(sm[5], 1, 1, 1, 0, (float) 0.7);
                }
            });

            rdoanswerB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    soundPool.play(sm[5], 1, 1, 1, 0, (float) 0.7);
                }
            });

            rdoanswerC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    soundPool.play(sm[5], 1, 1, 1, 0, (float) 0.7);
                }
            });

            rdoanswerD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    soundPool.play(sm[5], 1, 1, 1, 0, (float) 0.7);
                }
            });

            updatequestion();



            // xử lý Button submit
            btnsubmid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    soundPool.play(sm[0], 1, 1, 1, 0, (float) 1.0);
                    if (SystemClock.elapsedRealtime() - mLastClickTime < 3000) {
                        return;
                    }
                    mLastClickTime = SystemClock.elapsedRealtime();
                    updatequestion();
                }
            });


        }

    }

    // hàm này để verify answer



    // hàm updataquestion

    public void updatequestion(){
            // set vào model
//            m_level.setId(level);
            //get ra từ offline database

        if (total > 4){
            // chỉnh level 10
            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityQuiz.this);
            builder.setTitle("Thông báo")
                    .setMessage("Bạn đã hoàn thành Level: "+ HomeQuizActivity.levelhomequiz)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            soundPool.play(sm[2], 1, 1, 1, 0, (float) 1.0);
                            total = 1;
                            m_User user = new m_User();
                            user = databasehelper.getUserfromID(1);
                            int a = user.getLevelhomequiz();
                            Log.d(a+"","a nè");
                            int b = a + 1;
                            Log.d(String.valueOf(b), "level homequiz bênquizactivity");
                            m_User user1 = new m_User(1, b);
                            databasehelper.updateUser(user1);
                            Intent intent = new Intent(ActivityQuiz.this, HomeQuizActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();

        }else {


            m_Level m_level = new m_Level();
            m_level = databasehelper.getLevelID(HomeQuizActivity.levelhomequiz);
            DatabaseReference databasequestion = databasequiz.child(String.valueOf(m_level.getId())).child("questionid").child(String.valueOf(total));
            databasequestion.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    m_Question question = snapshot.getValue(m_Question.class);
                    dataType = snapshot.child("type").getValue(Integer.class);
//                    Log.d(String.valueOf(dataType), "dataType");
                    //read question
                    if (dataType == 1) {
                        rdoanswerA.setVisibility(View.VISIBLE);
                        rdoanswerB.setVisibility(View.VISIBLE);
                        rdoanswerC.setVisibility(View.VISIBLE);
                        rdoanswerD.setVisibility(View.VISIBLE);
                        Log.d(String.valueOf(dataType), "dataType nè");
                    } else if (dataType == 2) {
                        rdoanswerA.setVisibility(View.VISIBLE);
                        rdoanswerB.setVisibility(View.VISIBLE);
                        rdoanswerC.setVisibility(View.GONE);
                        rdoanswerD.setVisibility(View.GONE);
                        Log.d(String.valueOf(dataType), "dataType2");
                    } else if (dataType == 3) {
                        rdoanswerA.setVisibility(View.VISIBLE);
                        rdoanswerB.setVisibility(View.VISIBLE);
                        rdoanswerC.setVisibility(View.VISIBLE);
                        rdoanswerD.setVisibility(View.GONE);
                        Log.d(String.valueOf(dataType), "dataType3");
                    } else {

                    }

                    Log.d(total + "", "total nè");
                    Log.d(String.valueOf(dataType), "dataType nè ");

//                     so sánh xem có phải là yes/no question và idquestion có đúng không
//                     id lấy từ database
//                int id = question.getQuestionid();
                    String kqA = snapshot.child("choice1").getValue().toString();
                    String kqB = snapshot.child("choice2").getValue().toString();
                    String kqC = snapshot.child("choice3").getValue().toString();
                    String kqD = snapshot.child("choice4").getValue().toString();

                    rdoanswerA.setText(kqA);
                    rdoanswerB.setText(kqB);
                    rdoanswerC.setText(kqC);
                    rdoanswerD.setText(kqD);
                    tvlevel.setText(String.valueOf(HomeQuizActivity.levelhomequiz));
                    tvquestion.setText(question.getQuestioncontent());
                    tvdiem.setText(String.valueOf(total));

                    Log.d(question.getChoice3() + "", "Choice 3");


                    // xử lý sự kiện xem đã chọn đúng đáp án chưa

                    //Câu A đúng
                    if (rdoanswerA.isChecked() && kqA.equals(question.getCorrectchoice())) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                soundPool.play(sm[3], 1, 1, 1, 0, (float) 1.0);
                                Toast.makeText(ActivityQuiz.this, "Đúng rồi", Toast.LENGTH_LONG).show();
                                total++;
                                rdganswer.clearCheck();
                                updatequestion();
                            }
                        }, 2000);


                    }
                    //Câu A sai
                    else if (rdoanswerA.isChecked() && !kqA.equals(question.getCorrectchoice())) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                soundPool.play(sm[4], 1, 1, 1, 0, (float) 1.0);
                                Toast.makeText(ActivityQuiz.this, "Đáp án sai rồi", Toast.LENGTH_LONG).show();
                                rdganswer.clearCheck();

                            }
                        }, 2000);

                    }
                    //Câu B đúng
                    else if (rdoanswerB.isChecked() && kqB.equals(question.getCorrectchoice())) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                soundPool.play(sm[3], 1, 1, 1, 0, (float) 1.0);
                                Toast.makeText(ActivityQuiz.this, "Đúng rồi", Toast.LENGTH_LONG).show();
                                rdganswer.clearCheck();
                                total++;
                                updatequestion();
                            }
                        }, 2000);


                    }
                    //Câu B sai
                    else if (rdoanswerB.isChecked() && !kqB.equals(question.getCorrectchoice())) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                soundPool.play(sm[4], 1, 1, 1, 0, (float) 1.0);
                                rdganswer.clearCheck();
                                Toast.makeText(ActivityQuiz.this, "Đáp án sai rồi", Toast.LENGTH_LONG).show();
                            }
                        }, 2000);


                    }
                    //Câu C đúng
                    else if (rdoanswerC.isChecked() && kqC.equals(question.getCorrectchoice())) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                soundPool.play(sm[3], 1, 1, 1, 0, (float) 1.0);
                                Toast.makeText(ActivityQuiz.this, "Đúng rồi", Toast.LENGTH_LONG).show();
                                rdganswer.clearCheck();
                                total++;
                                updatequestion();
                            }
                        }, 2000);

                    }
                    // Câu C sai
                    else if (rdoanswerC.isChecked() && !kqC.equals(question.getCorrectchoice())) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                soundPool.play(sm[4], 1, 1, 1, 0, (float) 1.0);
                                rdganswer.clearCheck();
                                Toast.makeText(ActivityQuiz.this, "Đáp án sai rồi", Toast.LENGTH_LONG).show();
                            }
                        }, 2000);
                    }
                    // Câu D đúng
                    else if (rdoanswerD.isChecked() && kqD.equals(question.getCorrectchoice())) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                soundPool.play(sm[3], 1, 1, 1, 0, (float) 1.0);
                                rdganswer.clearCheck();
                                Toast.makeText(ActivityQuiz.this, "Đúng rồi", Toast.LENGTH_LONG).show();
                                total++;
                                updatequestion();


                            }
                        }, 2000);


                    }
                    //Câu D sai
                    else if (rdoanswerD.isChecked() && !kqD.equals(question.getCorrectchoice())) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                soundPool.play(sm[4], 1, 1, 1, 0, (float) 1.0);
                                rdganswer.clearCheck();
                                Toast.makeText(ActivityQuiz.this, "Đáp án sai rồi", Toast.LENGTH_LONG).show();
                            }
                        }, 2000);
                    } else if (!rdoanswerA.isChecked() && !rdoanswerB.isChecked() && !rdoanswerC.isChecked() && !rdoanswerD.isChecked()) {
//                        Toast.makeText(ActivityQuiz.this,"Không được bỏ trống",Toast.LENGTH_LONG).show();
                        rdganswer.clearCheck();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.d(error + "", "Database error");
                }
            });
        }







    }

    // Finish
    public void Finish(){
        finish();
    }



    // Hàm check kết nối internet từ thiết bị

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    // Tạo ra một map có bakcgroun như hình Phúc cho, mỗi 1 điểm level 1 là một cái imageview 1 -> 10
    // tạo ra một Dataase lưu ofline xong sau đó tạo 1 biến là level
    // cứ total mà > 4 thì level biến sẽ +1, và update level trong dataase ofline  leveldatabase = biến level
    // chuyển qua mành hình map, con nhân vật chuyển từ imageview này sang imaview khác
    // if(level == 2){imageview1.setVisibility(View.GONE), imageview2.setVisibility(View.GONE)};

}
