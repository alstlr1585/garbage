package com.example.sinmingu.brailleproject;


import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class QuizActivity extends BaseActivity implements TextToSpeech.OnInitListener{

    int value=10;
    TextView count_text;
    ImageView quiz_clock;

    Button quiz_consonant_initial,quiz_result_send,quiz_startbtn,quiz_soundon,quiz_soundoff;

    ImageButton quiz_braillebtn1,quiz_braillebtn2,quiz_braillebtn3,quiz_braillebtn4,quiz_braillebtn5,quiz_braillebtn6;
    int quiz_btnstatus1, quiz_btnstatus2, quiz_btnstatus3, quiz_btnstatus4, quiz_btnstatus5, quiz_btnstatus6;
    ImageView quiz_consonant_initial1,quiz_resultpicture, quizstart,soundon,soundoff;
    int quiz_picturenum;

    TabHost quiz_tab_host;

    private TextToSpeech ttsClient;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        count_text=(TextView)findViewById(R.id.count_text);
        quiz_clock=(ImageView)findViewById(R.id.quiz_clock);

        quiz_tab_host= (TabHost) findViewById(R.id.quiz_tab_host);

        TabHost tabHost = (TabHost)findViewById(R.id.quiz_tab_host);

        Glide.with(this).load(R.drawable.quiz_clock).into(quiz_clock);

        quiz_consonant_initial=(Button)findViewById(R.id.quiz_consonant_initial);

        //정답확인 버튼
        quiz_result_send=(Button)findViewById(R.id.quiz_result_send);

        quiz_soundon=(Button) findViewById(R.id.quiz_soundon);
        quiz_soundoff=(Button)findViewById(R.id.quiz_soundoff);
        quiz_startbtn=(Button) findViewById(R.id.quiz_startbtn);

        //1~6버튼 상태 초기화
        quiz_btnstatus1=0;
        quiz_btnstatus2=0;
        quiz_btnstatus3=0;
        quiz_btnstatus4=0;
        quiz_btnstatus5=0;
        quiz_btnstatus6=0;
        quiz_picturenum=1;

        //1~6 이미지버튼
        quiz_braillebtn1=(ImageButton)findViewById(R.id.quiz_braillebtn1);
        quiz_braillebtn2=(ImageButton)findViewById(R.id.quiz_braillebtn2);
        quiz_braillebtn3=(ImageButton)findViewById(R.id.quiz_braillebtn3);
        quiz_braillebtn4=(ImageButton)findViewById(R.id.quiz_braillebtn4);
        quiz_braillebtn5=(ImageButton)findViewById(R.id.quiz_braillebtn5);
        quiz_braillebtn6=(ImageButton)findViewById(R.id.quiz_braillebtn6);

        //이미지
        quiz_consonant_initial1=(ImageView)findViewById(R.id.quiz_consonant_initial1);
        quiz_resultpicture=(ImageView)findViewById(R.id.quiz_resultpicture);
        quizstart=(ImageView)findViewById(R.id.quizstart);
        soundon=(ImageView)findViewById(R.id.soundon);
        soundoff=(ImageView)findViewById(R.id.soundoff);


        // 이미지 자동할당
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn1);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn2);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn3);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn4);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn5);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn6);
        Glide.with(this).load(R.drawable.start).into(quizstart);
        Glide.with(this).load(R.drawable.soundon).into(soundon);
        Glide.with(this).load(R.drawable.soundoff).into(soundoff);
        Glide.with(this).load(R.drawable.consonant_initial_1).into(quiz_consonant_initial1);
        Glide.with(this).load(R.drawable.resultok).into(quiz_resultpicture);



        tabHost.setup();

        // Tab1 Setting
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");
        //tabSpec1.setIndicator("",getResources().getDrawable(R.drawable.soundon));
        tabSpec1.setIndicator("초급"); // Tab Subject
        tabSpec1.setContent(R.id.quiz_tab_view1); // Tab Content
        tabHost.addTab(tabSpec1);

        // Tab2 Setting
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");
        tabSpec2.setIndicator("중급"); // Tab Subject
        tabSpec2.setContent(R.id.quiz_tab_view2); // Tab Content
        tabHost.addTab(tabSpec2);


        // Tab3 Setting
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab3");
        tabSpec3.setIndicator("고급"); // Tab Subject
        tabSpec3.setContent(R.id.quiz_tab_view3); // Tab Content
        tabHost.addTab(tabSpec3);

        // show First Tab Content
        tabHost.setCurrentTab(0);



        quiz_startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CountDownTimer quiz_CountDown=null;

                quiz_CountDown=new CountDownTimer(11000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        if(value!=0)
                            quiz_startbtn.setEnabled(false);

                        value--;
                        count_text.setText("남은시간 : "+value);
                        if(value==0) {
                            Glide.with(QuizActivity.this).load(R.drawable.resultno).into(quiz_resultpicture);
                            value = 10;
                            quiz_startbtn.setEnabled(true);
                        }




                    }
                    @Override
                    public void onFinish() {

                    }
                }.start();

            }

        });

        quiz_braillebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((quiz_btnstatus1%2)==0){
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn1);
                }
                else {
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn1);
                }

                quiz_btnstatus1++;
            }
        });

        quiz_braillebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((quiz_btnstatus2%2)==0){
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn2);
                }
                else {
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn2);
                }

                quiz_btnstatus2++;
            }
        });

        quiz_braillebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((quiz_btnstatus3%2)==0){
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn3);
                }
                else {
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn3);
                }

                quiz_btnstatus3++;
            }
        });

        quiz_braillebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((quiz_btnstatus4%2)==0){
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn4);
                }
                else {
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn4);
                }

                quiz_btnstatus4++;
            }
        });

        quiz_braillebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((quiz_btnstatus5%2)==0){
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn5);
                }
                else {
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn5);
                }

                quiz_btnstatus5++;
            }
        });

        quiz_braillebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((quiz_btnstatus6%2)==0){
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn6);
                }
                else {
                    Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn6);
                }

                quiz_btnstatus6++;
            }
        });



    }


    @Override
    public void onInit(int status) {

    }


    @Override
    public void onBackPressed() {
        if(value!=10){
            Toast.makeText(QuizActivity.this,"타이머 작동중 입니다.",Toast.LENGTH_SHORT).show();

        }

        if(value==10) {
            finish();
            overridePendingTransition(R.anim.not_move_activit, R.anim.rightout_activity);
        }

    }


}
