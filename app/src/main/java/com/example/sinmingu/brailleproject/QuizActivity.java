package com.example.sinmingu.brailleproject;


import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class QuizActivity extends BaseActivity implements TextToSpeech.OnInitListener{


    Button quiz_consonant_initial,quiz_result_send;

    ImageButton quiz_braillebtn1,quiz_braillebtn2,quiz_braillebtn3,quiz_braillebtn4,quiz_braillebtn5,quiz_braillebtn6;
    int quiz_btnstatus1, quiz_btnstatus2, quiz_btnstatus3, quiz_btnstatus4, quiz_btnstatus5, quiz_btnstatus6;
    ImageView quiz_resultpicture;
    int quiz_picturenum;
    ImageButton quiz_ch_listen;

    TabHost quiz_tab_host;

    private TextToSpeech ttsClient;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz_tab_host= (TabHost) findViewById(R.id.quiz_tab_host);
        quiz_ch_listen=(ImageButton)findViewById(R.id.quiz_ch_listen);
        TabHost tabHost = (TabHost)findViewById(R.id.quiz_tab_host);
        quiz_consonant_initial=(Button)findViewById(R.id.quiz_consonant_initial);

        //정답확인 버튼
        quiz_result_send=(Button)findViewById(R.id.quiz_result_send);

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
        quiz_resultpicture=(ImageView)findViewById(R.id.quiz_resultpicture);

        // 이미지 자동할당


        Glide.with(this).load(R.drawable.quiz_headphone).fitCenter().into(quiz_ch_listen);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn1);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn2);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn3);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn4);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn5);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn6);
        Glide.with(this).load(R.drawable.resultok).into(quiz_resultpicture);

        Typeface font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/BMJUA_ttf.ttf");

        tabHost.setup();

        // Tab1 Setting
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");
        //tabSpec1.setIndicator("",getResources().getDrawable(R.drawable.soundon));
        tabSpec1.setIndicator("6점"); // Tab Subject
        tabSpec1.setContent(R.id.quiz_tab_view1); // Tab Content
        tabHost.addTab(tabSpec1);

        // Tab2 Setting
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");
        tabSpec2.setIndicator("12점"); // Tab Subject
        tabSpec2.setContent(R.id.quiz_tab_view2); // Tab Content
        tabHost.addTab(tabSpec2);



        // show First Tab Content
        tabHost.setCurrentTab(0);

        //tab글꼴 변경
        for (int i=0; i<tabHost.getTabWidget().getChildCount(); i++) {
            LinearLayout relLayout = (LinearLayout) tabHost.getTabWidget().getChildAt(i);
            TextView tv = (TextView)relLayout.getChildAt(1);
            tv.setTypeface(font);
            tv.setTextColor(Color.parseColor("#000000"));
            tv.setTextSize(16);
        }


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

        finish();
        overridePendingTransition(R.anim.not_move_activit, R.anim.rightout_activity);


    }


}
