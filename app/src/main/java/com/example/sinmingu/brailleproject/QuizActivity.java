package com.example.sinmingu.brailleproject;


import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Random;

public class QuizActivity extends BaseActivity implements TextToSpeech.OnInitListener{

    int type_6 = 0;
    int randomNum = 1;
    //6점 메뉴 버튼
    Button char_consonant_initial,char_finalconsonant_initial,char_vowel,char_alphabet,char_abbreviation,char_number,quiz_result_send;

    ImageButton quiz_braillebtn1,quiz_braillebtn2,quiz_braillebtn3,quiz_braillebtn4,quiz_braillebtn5,quiz_braillebtn6;
    int quiz_btnstatus1, quiz_btnstatus2, quiz_btnstatus3, quiz_btnstatus4, quiz_btnstatus5, quiz_btnstatus6;
    ImageView quiz_resultpicture, cha_result_12_picture;
    int quiz_picturenum;
    ImageButton quiz_ch_listen;

    TextView problem_cha_quiz_6;

    Random rand;



    TabHost quiz_tab_host;

    ImageButton cha_braillebtn1_12, cha_braillebtn2_12, cha_braillebtn3_12, cha_braillebtn4_12, cha_braillebtn5_12, cha_braillebtn6_12, cha_braillebtn7_12,
            cha_braillebtn8_12,cha_braillebtn9_12,cha_braillebtn10_12,cha_braillebtn11_12,cha_braillebtn12_12;
    ImageButton quiz_ch_listen_12;

    LinearLayout linear_quiz6, linear_quiz6_1, linear_quiz6_2, linear_quiz6_3;

    LinearLayout linear_quiz12, linear_quiz12_1, linear_quiz12_2, linear_quiz12_3, linear_quiz12_left, linear_quiz12_right, linear_quiz12_enter;

    RectF rect6_1, rect6_2, rect6_3, rect6_4, rect6_5, rect6_6;
    RectF rect12_1, rect12_2, rect12_3, rect12_4, rect12_5, rect12_6, rect12_7, rect12_8, rect12_9, rect12_10, rect12_11, rect12_12;

    int braille[];

    int braille_12[];
    int btnstatus1_12,btnstatus2_12,btnstatus3_12,btnstatus4_12,btnstatus5_12,btnstatus6_12,btnstatus7_12,btnstatus8_12,btnstatus9_12,btnstatus10_12,btnstatus11_12,btnstatus12_12;

    private TextToSpeech ttsClient;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        problem_cha_quiz_6=(TextView)findViewById(R.id.problem_cha_quiz_6);

        quiz_tab_host= (TabHost) findViewById(R.id.quiz_tab_host);
        quiz_ch_listen=(ImageButton)findViewById(R.id.quiz_ch_listen);
        TabHost tabHost = (TabHost)findViewById(R.id.quiz_tab_host);

        //6점 메뉴버튼 초기화
        char_consonant_initial=(Button)findViewById(R.id.char_consonant_initial);
        char_finalconsonant_initial=(Button)findViewById(R.id.char_finalconsonant_initial);
        char_vowel=(Button)findViewById(R.id.char_vowel);
        char_alphabet=(Button)findViewById(R.id.char_alphabet);
        char_abbreviation=(Button)findViewById(R.id.char_abbreviation);
        char_number=(Button)findViewById(R.id.char_number);
        //정답확인 버튼
        quiz_result_send=(Button)findViewById(R.id.quiz_result_send);
        cha_result_12_picture = (ImageView)findViewById(R.id.cha_result_12_picture);
        //1~6버튼 상태 초기화
        quiz_btnstatus1=0;
        quiz_btnstatus2=0;
        quiz_btnstatus3=0;
        quiz_btnstatus4=0;
        quiz_btnstatus5=0;
        quiz_btnstatus6=0;
        quiz_picturenum=1;

        braille=new int[6];

        rect6_1 = new RectF();
        rect6_2 = new RectF();
        rect6_3 = new RectF();
        rect6_4 = new RectF();
        rect6_5 = new RectF();
        rect6_6 = new RectF();

        rect12_1 = new RectF();
        rect12_2 = new RectF();
        rect12_3 = new RectF();
        rect12_4 = new RectF();
        rect12_5 = new RectF();
        rect12_6 = new RectF();
        rect12_7 = new RectF();
        rect12_8 = new RectF();
        rect12_9 = new RectF();
        rect12_10 = new RectF();
        rect12_11 = new RectF();
        rect12_12 = new RectF();

        braille_12=new int[12];
        btnstatus1_12=0;
        btnstatus2_12=0;
        btnstatus3_12=0;
        btnstatus4_12=0;
        btnstatus5_12=0;
        btnstatus6_12=0;
        btnstatus7_12=0;
        btnstatus8_12=0;
        btnstatus9_12=0;
        btnstatus10_12=0;
        btnstatus11_12=0;
        btnstatus12_12=0;


        //1~6 이미지버튼
        quiz_braillebtn1=(ImageButton)findViewById(R.id.quiz_braillebtn1);
        quiz_braillebtn2=(ImageButton)findViewById(R.id.quiz_braillebtn2);
        quiz_braillebtn3=(ImageButton)findViewById(R.id.quiz_braillebtn3);
        quiz_braillebtn4=(ImageButton)findViewById(R.id.quiz_braillebtn4);
        quiz_braillebtn5=(ImageButton)findViewById(R.id.quiz_braillebtn5);
        quiz_braillebtn6=(ImageButton)findViewById(R.id.quiz_braillebtn6);

        // 6점 리니어 레이아웃
        linear_quiz6 = (LinearLayout) findViewById(R.id.linear_quiz6);
        linear_quiz6_1 = (LinearLayout) findViewById(R.id.linear_quiz6_1);
        linear_quiz6_2 = (LinearLayout) findViewById(R.id.linear_quiz6_2);
        linear_quiz6_3 = (LinearLayout) findViewById(R.id.linear_quiz6_3);

        // 12점 리니어 레이아웃

        linear_quiz12 = (LinearLayout) findViewById(R.id.linear_quiz12);
        linear_quiz12_1 = (LinearLayout) findViewById(R.id.linear_quiz12_1);
        linear_quiz12_2 = (LinearLayout) findViewById(R.id.linear_quiz12_2);
        linear_quiz12_3 = (LinearLayout) findViewById(R.id.linear_quiz12_3);
        linear_quiz12_left = (LinearLayout) findViewById(R.id.linear_quiz12_left);
        linear_quiz12_right = (LinearLayout) findViewById(R.id.linear_quiz12_right);
        linear_quiz12_enter = (LinearLayout) findViewById(R.id.linear_quiz12_enter);

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


        //-----------------------------------------------------------------------------
        quiz_ch_listen_12=(ImageButton)findViewById(R.id.quiz_ch_listen_12);

        cha_braillebtn1_12=(ImageButton)findViewById(R.id.cha_braillebtn1_12);
        cha_braillebtn2_12=(ImageButton)findViewById(R.id.cha_braillebtn2_12);
        cha_braillebtn3_12=(ImageButton)findViewById(R.id.cha_braillebtn3_12);
        cha_braillebtn4_12=(ImageButton)findViewById(R.id.cha_braillebtn4_12);
        cha_braillebtn5_12=(ImageButton)findViewById(R.id.cha_braillebtn5_12);
        cha_braillebtn6_12=(ImageButton)findViewById(R.id.cha_braillebtn6_12);
        cha_braillebtn7_12=(ImageButton)findViewById(R.id.cha_braillebtn7_12);
        cha_braillebtn8_12=(ImageButton)findViewById(R.id.cha_braillebtn8_12);
        cha_braillebtn9_12=(ImageButton)findViewById(R.id.cha_braillebtn9_12);
        cha_braillebtn10_12=(ImageButton)findViewById(R.id.cha_braillebtn10_12);
        cha_braillebtn11_12=(ImageButton)findViewById(R.id.cha_braillebtn11_12);
        cha_braillebtn12_12=(ImageButton)findViewById(R.id.cha_braillebtn12_12);

        Glide.with(this).load(R.drawable.quiz_headphone).fitCenter().into(quiz_ch_listen_12);

        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn1_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn2_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn3_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn4_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn5_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn6_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn7_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn8_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn9_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn10_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn11_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn12_12);

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

        // 랜덤 숫자 생성용
        rand = new Random();


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

        char_consonant_initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 1;
                randomNum = rand.nextInt(13);   // 0~12 난수

                consonant_initial_setting(randomNum);

            }
        });
        char_finalconsonant_initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 2;
                randomNum = rand.nextInt(14);   // 0~13 난수

                finalconsonant_initial_setting(randomNum);
            }
        });
        char_vowel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 3;
                randomNum = rand.nextInt(17);   // 0~16 난수

                vowel_setting(randomNum);
            }
        });
        char_alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 4;
                randomNum = rand.nextInt(26);   // 0~25 난수

                alphabet_setting(randomNum);
            }
        });
        char_abbreviation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 5;
                randomNum = rand.nextInt(24);   // 0~25 난수

                abbreviation_setting(randomNum);
            }
        });
        char_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 6;
                randomNum = rand.nextInt(10);   // 0~9 난수

                number_setting(randomNum);
            }
        });

        quiz_braillebtn1.setClickable(false);
        quiz_braillebtn2.setClickable(false);
        quiz_braillebtn3.setClickable(false);
        quiz_braillebtn4.setClickable(false);
        quiz_braillebtn5.setClickable(false);
        quiz_braillebtn6.setClickable(false);

        linear_quiz6.setOnTouchListener(new View.OnTouchListener() {
            int flag = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                rect6_1.set(quiz_braillebtn1.getLeft(), quiz_braillebtn1.getTop(), quiz_braillebtn1.getRight(), quiz_braillebtn1.getBottom());
                rect6_2.set(quiz_braillebtn2.getLeft(), quiz_braillebtn2.getTop() + linear_quiz6_2.getTop(), quiz_braillebtn2.getRight(), quiz_braillebtn2.getBottom() + linear_quiz6_2.getTop());
                rect6_3.set(quiz_braillebtn3.getLeft(), quiz_braillebtn3.getTop() + linear_quiz6_3.getTop(), quiz_braillebtn3.getRight(), quiz_braillebtn3.getBottom() + linear_quiz6_3.getTop());
                rect6_4.set(quiz_braillebtn4.getLeft(), quiz_braillebtn4.getTop(), quiz_braillebtn4.getRight(), quiz_braillebtn4.getBottom());
                rect6_5.set(quiz_braillebtn5.getLeft(), quiz_braillebtn5.getTop() + linear_quiz6_2.getTop(), quiz_braillebtn5.getRight(), quiz_braillebtn5.getBottom() + linear_quiz6_2.getTop());
                rect6_6.set(quiz_braillebtn6.getLeft(), quiz_braillebtn6.getTop() + linear_quiz6_3.getTop(), quiz_braillebtn6.getRight(), quiz_braillebtn6.getBottom() + linear_quiz6_3.getTop());

                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {

                    if (rect6_1.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((quiz_btnstatus1 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn1);
                                braille[0] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn1);
                                braille[0] = 0;
                            }

                            quiz_btnstatus1++;
                            flag = 1;
                        }
                    } else if (rect6_2.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((quiz_btnstatus2 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn2);
                                braille[1] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn2);
                                braille[1] = 0;
                            }

                            quiz_btnstatus2++;
                            flag = 1;
                        }
                    } else if (rect6_3.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((quiz_btnstatus3 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn3);
                                braille[2] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn3);
                                braille[2] = 0;
                            }

                            quiz_btnstatus3++;
                            flag = 1;
                        }
                    } else if (rect6_4.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((quiz_btnstatus4 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn4);
                                braille[3] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn4);
                                braille[3] = 0;
                            }

                            quiz_btnstatus4++;
                            flag = 1;
                        }
                    } else if (rect6_5.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((quiz_btnstatus5 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn5);
                                braille[4] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn5);
                                braille[4] = 0;
                            }

                            quiz_btnstatus5++;
                            flag = 1;
                        }
                    } else if (rect6_6.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((quiz_btnstatus6 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(quiz_braillebtn6);
                                braille[5] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn6);
                                braille[5] = 0;
                            }

                            quiz_btnstatus6++;
                            flag = 1;
                        }
                    }
                    else {
                        if (flag == 1) {
                            flag = 0;
                        }
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP)
                    flag = 0;
                return true;
            }
        });

        cha_braillebtn1_12.setClickable(false);
        cha_braillebtn2_12.setClickable(false);
        cha_braillebtn3_12.setClickable(false);
        cha_braillebtn4_12.setClickable(false);
        cha_braillebtn5_12.setClickable(false);
        cha_braillebtn6_12.setClickable(false);
        cha_braillebtn7_12.setClickable(false);
        cha_braillebtn8_12.setClickable(false);
        cha_braillebtn9_12.setClickable(false);
        cha_braillebtn10_12.setClickable(false);
        cha_braillebtn11_12.setClickable(false);
        cha_braillebtn12_12.setClickable(false);

        linear_quiz12.setOnTouchListener(new View.OnTouchListener() {
            int flag = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                rect12_1.set(cha_braillebtn1_12.getLeft() + linear_quiz12_left.getLeft(), cha_braillebtn1_12.getTop() + linear_quiz12_enter.getTop(), cha_braillebtn1_12.getRight() + linear_quiz12_left.getLeft(), cha_braillebtn1_12.getBottom() + linear_quiz12_enter.getTop());
                rect12_2.set(cha_braillebtn2_12.getLeft() + linear_quiz12_left.getLeft(),  cha_braillebtn2_12.getTop() + linear_quiz12_2.getTop() + linear_quiz12_enter.getTop(), cha_braillebtn2_12.getRight() + linear_quiz12_left.getLeft(), cha_braillebtn2_12.getBottom() + linear_quiz12_2.getTop() + linear_quiz12_enter.getTop());
                rect12_3.set(cha_braillebtn3_12.getLeft() + linear_quiz12_left.getLeft(), cha_braillebtn3_12.getTop() + linear_quiz12_3.getTop() + linear_quiz12_enter.getTop(), cha_braillebtn3_12.getRight() + linear_quiz12_left.getLeft(), cha_braillebtn3_12.getBottom() + linear_quiz12_3.getTop() + linear_quiz12_enter.getTop());

                rect12_4.set(cha_braillebtn4_12.getLeft() + linear_quiz12_left.getLeft(), cha_braillebtn4_12.getTop() + linear_quiz12_enter.getTop(), cha_braillebtn4_12.getRight() + linear_quiz12_left.getLeft(), cha_braillebtn4_12.getBottom() + + linear_quiz12_enter.getTop());
                rect12_5.set(cha_braillebtn5_12.getLeft() + linear_quiz12_left.getLeft(), cha_braillebtn5_12.getTop() + linear_quiz12_enter.getTop() + linear_quiz12_2.getTop(), cha_braillebtn5_12.getRight() + linear_quiz12_left.getLeft(), cha_braillebtn5_12.getBottom() + linear_quiz12_2.getTop() + linear_quiz12_enter.getTop());
                rect12_6.set(cha_braillebtn6_12.getLeft() + linear_quiz12_left.getLeft(), cha_braillebtn6_12.getTop() + linear_quiz12_enter.getTop() + linear_quiz12_3.getTop(), cha_braillebtn6_12.getRight() + linear_quiz12_left.getLeft(), cha_braillebtn6_12.getBottom() + linear_quiz12_3.getTop() + linear_quiz12_enter.getTop());

                rect12_7.set(cha_braillebtn1_12.getLeft() + linear_quiz12_right.getLeft(), cha_braillebtn1_12.getTop() + linear_quiz12_enter.getTop(), cha_braillebtn1_12.getRight() + linear_quiz12_right.getLeft(), cha_braillebtn1_12.getBottom() + linear_quiz12_enter.getTop());
                rect12_8.set(cha_braillebtn2_12.getLeft() + linear_quiz12_right.getLeft(),  cha_braillebtn2_12.getTop() + linear_quiz12_2.getTop() + linear_quiz12_enter.getTop(), cha_braillebtn2_12.getRight() + linear_quiz12_right.getLeft(), cha_braillebtn2_12.getBottom() + linear_quiz12_2.getTop() + linear_quiz12_enter.getTop());
                rect12_9.set(cha_braillebtn3_12.getLeft() + linear_quiz12_right.getLeft(), cha_braillebtn3_12.getTop() + linear_quiz12_3.getTop() + linear_quiz12_enter.getTop(), cha_braillebtn3_12.getRight() + linear_quiz12_right.getLeft(), cha_braillebtn3_12.getBottom() + linear_quiz12_3.getTop() + linear_quiz12_enter.getTop());

                rect12_10.set(cha_braillebtn4_12.getLeft() + linear_quiz12_right.getLeft(), cha_braillebtn4_12.getTop() + linear_quiz12_enter.getTop(), cha_braillebtn4_12.getRight() + linear_quiz12_right.getLeft(), cha_braillebtn4_12.getBottom() + + linear_quiz12_enter.getTop());
                rect12_11.set(cha_braillebtn5_12.getLeft() + linear_quiz12_right.getLeft(), cha_braillebtn5_12.getTop() + linear_quiz12_enter.getTop() + linear_quiz12_2.getTop(), cha_braillebtn5_12.getRight() + linear_quiz12_right.getLeft(), cha_braillebtn5_12.getBottom() + linear_quiz12_2.getTop() + linear_quiz12_enter.getTop());
                rect12_12.set(cha_braillebtn6_12.getLeft() + linear_quiz12_right.getLeft(), cha_braillebtn6_12.getTop() + linear_quiz12_enter.getTop() + linear_quiz12_3.getTop(), cha_braillebtn6_12.getRight() + linear_quiz12_right.getLeft(), cha_braillebtn6_12.getBottom() + linear_quiz12_3.getTop() + linear_quiz12_enter.getTop());

                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {

                    if (rect12_1.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus1_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn1_12);
                                braille_12[0] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn1_12);
                                braille_12[0] = 0;
                            }

                            btnstatus1_12++;
                            flag = 1;
                        }
                    } else if (rect12_2.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus2_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn2_12);
                                braille_12[1] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn2_12);
                                braille_12[1] = 0;
                            }

                            btnstatus2_12++;
                            flag = 1;
                        }
                    } else if (rect12_3.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus3_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn3_12);
                                braille_12[2] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn3_12);
                                braille_12[2] = 0;
                            }

                            btnstatus3_12++;
                            flag = 1;
                        }
                    } else if (rect12_4.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus4_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn4_12);
                                braille_12[3] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn4_12);
                                braille_12[3] = 0;
                            }

                            btnstatus4_12++;
                            flag = 1;
                        }
                    } else if (rect12_5.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus5_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn5_12);
                                braille_12[4] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn5_12);
                                braille_12[4] = 0;
                            }

                            btnstatus5_12++;
                            flag = 1;
                        }
                    } else if (rect12_6.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus6_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn6_12);
                                braille_12[5] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn6_12);
                                braille_12[5] = 0;
                            }

                            btnstatus6_12++;
                            flag = 1;
                        }
                    } else if (rect12_7.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus7_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn7_12);
                                braille_12[6] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn7_12);
                                braille_12[6] = 0;
                            }

                            btnstatus7_12++;
                            flag = 1;
                        }
                    } else if (rect12_8.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus8_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn8_12);
                                braille_12[7] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn8_12);
                                braille_12[7] = 0;
                            }

                            btnstatus8_12++;
                            flag = 1;
                        }
                    } else if (rect12_9.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus9_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn9_12);
                                braille_12[8] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn9_12);
                                braille_12[8] = 0;
                            }

                            btnstatus9_12++;
                            flag = 1;
                        }
                    } else if (rect12_10.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus10_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn10_12);
                                braille_12[9] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn10_12);
                                braille_12[9] = 0;
                            }

                            btnstatus10_12++;
                            flag = 1;
                        }
                    } else if (rect12_11.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus11_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn11_12);
                                braille_12[10] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn11_12);
                                braille_12[10] = 0;
                            }

                            btnstatus11_12++;
                            flag = 1;
                        }
                    } else if (rect12_12.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus12_12 % 2) == 0) {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_true).into(cha_braillebtn12_12);
                                braille_12[11] = 1;
                            } else {
                                Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn12_12);
                                braille_12[11] = 0;
                            }

                            btnstatus12_12++;
                            flag = 1;
                        }
                    }
                    else {
                        if (flag == 1) {
                            flag = 0;
                        }
                    }
                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                    flag = 0;

                return true;
            }
        });

        quiz_result_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(type_6 == 1) {
                    switch (randomNum) {
                        case 1:
                            if (braille[0] == 0 && braille[1] == 0 && braille[2] == 0 && braille[3] == 1 && braille[4] == 0 && braille[5] == 0) {
                                braillebtn_false_ok();
                            } else {
                                braillebtn_false_no();
                            }
                            break;
                    }
                }
                else if(type_6 == 2){

                }
                else if(type_6 == 3){

                }
                else if(type_6 == 4){

                }
                else if(type_6 == 5){

                }
                else if(type_6 == 6){

                }
                else{
                    Toast.makeText(getApplicationContext(), "타입을 눌러주세요", Toast.LENGTH_SHORT).show();
                }
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

    public void braillebtn_false_ok_12(){

        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn1_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn2_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn3_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn4_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn5_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn6_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn7_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn8_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn9_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn10_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn11_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn12_12);

        btnstatus1_12 = 0;
        btnstatus2_12 = 0;
        btnstatus3_12 = 0;
        btnstatus4_12 = 0;
        btnstatus5_12 = 0;
        btnstatus6_12 = 0;
        btnstatus7_12 = 0;
        btnstatus8_12 = 0;
        btnstatus9_12 = 0;
        btnstatus10_12 = 0;
        btnstatus11_12 = 0;
        btnstatus12_12 = 0;

        for(int i=0;i<12;i++){
            braille_12[i]=0;

        }

        Glide.with(QuizActivity.this).load(R.drawable.resultok).into(cha_result_12_picture);
        //ttsClient.speak("정답", TextToSpeech.QUEUE_FLUSH, null);

    }
    public void braillebtn_false_ok(){

        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn1);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn2);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn3);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn4);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn5);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn6);

        quiz_btnstatus1=0;
        quiz_btnstatus2=0;
        quiz_btnstatus3=0;
        quiz_btnstatus4=0;
        quiz_btnstatus5=0;
        quiz_btnstatus6=0;

        braille[0]=0;
        braille[1]=0;
        braille[2]=0;
        braille[3]=0;
        braille[4]=0;
        braille[5]=0;

        Glide.with(QuizActivity.this).load(R.drawable.resultok).into(quiz_resultpicture);
        //ttsClient.speak("정답", TextToSpeech.QUEUE_FLUSH, null);
    }

    public void braillebtn_false_no_12(){

        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn1_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn2_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn3_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn4_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn5_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn6_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn7_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn8_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn9_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn10_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn11_12);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(cha_braillebtn12_12);

        btnstatus1_12 = 0;
        btnstatus2_12 = 0;
        btnstatus3_12 = 0;
        btnstatus4_12 = 0;
        btnstatus5_12 = 0;
        btnstatus6_12 = 0;
        btnstatus7_12 = 0;
        btnstatus8_12 = 0;
        btnstatus9_12 = 0;
        btnstatus10_12 = 0;
        btnstatus11_12 = 0;
        btnstatus12_12 = 0;

        for(int i=0;i<12;i++){
            braille_12[i]=0;

        }

        Glide.with(QuizActivity.this).load(R.drawable.resultno).into(cha_result_12_picture);
        //ttsClient.speak("오답", TextToSpeech.QUEUE_FLUSH, null);

    }

    public void braillebtn_false_no(){

        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn1);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn2);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn3);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn4);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn5);
        Glide.with(QuizActivity.this).load(R.drawable.braillebtn_false).into(quiz_braillebtn6);

        quiz_btnstatus1=0;
        quiz_btnstatus2=0;
        quiz_btnstatus3=0;
        quiz_btnstatus4=0;
        quiz_btnstatus5=0;
        quiz_btnstatus6=0;

        braille[0]=0;
        braille[1]=0;
        braille[2]=0;
        braille[3]=0;
        braille[4]=0;
        braille[5]=0;

        Glide.with(QuizActivity.this).load(R.drawable.resultno).into(quiz_resultpicture);
        //ttsClient.speak("오답", TextToSpeech.QUEUE_FLUSH, null);

    }

    public void consonant_initial_setting(int number){
        switch (number){

            case 0 :
                problem_cha_quiz_6.setText("ㄱ");
                break;
            case 1:
                problem_cha_quiz_6.setText("ㄴ");
                break;
            case 2:
                problem_cha_quiz_6.setText("ㄷ");
                break;
            case 3:
                problem_cha_quiz_6.setText("ㄹ");
                break;
            case 4:
                problem_cha_quiz_6.setText("ㅁ");
                break;
            case 5:
                problem_cha_quiz_6.setText("ㅂ");
                break;
            case 6:
                problem_cha_quiz_6.setText("ㅅ");
                break;
            case 7:
                problem_cha_quiz_6.setText("ㅈ");
                break;
            case 8:
                problem_cha_quiz_6.setText("ㅊ");
                break;
            case 9:
                problem_cha_quiz_6.setText("ㅋ");
                break;
            case 10:
                problem_cha_quiz_6.setText("ㅌ");
                break;
            case 11:
                problem_cha_quiz_6.setText("ㅍ");
                break;
            case 12:
                problem_cha_quiz_6.setText("ㅎ");
                break;
            default:
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

        }
    }

    public void finalconsonant_initial_setting(int number){

        switch (number){

            case 0 :
                problem_cha_quiz_6.setText("ㄱ");
                break;
            case 1:
                problem_cha_quiz_6.setText("ㄴ");
                break;
            case 2:
                problem_cha_quiz_6.setText("ㄷ");
                break;
            case 3:
                problem_cha_quiz_6.setText("ㄹ");
                break;
            case 4:
                problem_cha_quiz_6.setText("ㅁ");
                break;
            case 5:
                problem_cha_quiz_6.setText("ㅂ");
                break;
            case 6:
                problem_cha_quiz_6.setText("ㅅ");
                break;
            case 7:
                problem_cha_quiz_6.setText("ㅇ");
                break;
            case 8:
                problem_cha_quiz_6.setText("ㅈ");
                break;
            case 9:
                problem_cha_quiz_6.setText("ㅊ");
                break;
            case 10:
                problem_cha_quiz_6.setText("ㅋ");
                break;
            case 11:
                problem_cha_quiz_6.setText("ㅌ");
                break;
            case 12:
                problem_cha_quiz_6.setText("ㅍ");
                break;
            case 13:
                problem_cha_quiz_6.setText("ㅎ");
                break;
            default:
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

        }
    }

    public void vowel_setting(int number){

        switch (number){

            case 0 :
                problem_cha_quiz_6.setText("ㅏ");
                break;
            case 1:
                problem_cha_quiz_6.setText("ㅑ");
                break;
            case 2:
                problem_cha_quiz_6.setText("ㅓ");
                break;
            case 3:
                problem_cha_quiz_6.setText("ㅕ");
                break;
            case 4:
                problem_cha_quiz_6.setText("ㅗ");
                break;
            case 5:
                problem_cha_quiz_6.setText("ㅛ");
                break;
            case 6:
                problem_cha_quiz_6.setText("ㅜ");
                break;
            case 7:
                problem_cha_quiz_6.setText("ㅠ");
                break;
            case 8:
                problem_cha_quiz_6.setText("ㅡ");
                break;
            case 9:
                problem_cha_quiz_6.setText("ㅣ");
                break;
            case 10:
                problem_cha_quiz_6.setText("ㅐ");
                break;
            case 11:
                problem_cha_quiz_6.setText("ㅔ");
                break;
            case 12:
                problem_cha_quiz_6.setText("ㅚ");
                break;
            case 13:
                problem_cha_quiz_6.setText("ㅘ");
                break;
            case 14:
                problem_cha_quiz_6.setText("ㅝ");
                break;
            case 15:
                problem_cha_quiz_6.setText("ㅢ");
                break;
            case 16:
                problem_cha_quiz_6.setText("ㅖ");
                break;
            default:
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

        }

    }

    public void alphabet_setting(int number){

        switch (number){

            case 0 :
                problem_cha_quiz_6.setText("a");
                break;
            case 1:
                problem_cha_quiz_6.setText("b");
                break;
            case 2:
                problem_cha_quiz_6.setText("c");
                break;
            case 3:
                problem_cha_quiz_6.setText("d");
                break;
            case 4:
                problem_cha_quiz_6.setText("e");
                break;
            case 5:
                problem_cha_quiz_6.setText("f");
                break;
            case 6:
                problem_cha_quiz_6.setText("g");
                break;
            case 7:
                problem_cha_quiz_6.setText("h");
                break;
            case 8:
                problem_cha_quiz_6.setText("i");
                break;
            case 9:
                problem_cha_quiz_6.setText("j");
                break;
            case 10:
                problem_cha_quiz_6.setText("k");
                break;
            case 11:
                problem_cha_quiz_6.setText("l");
                break;
            case 12:
                problem_cha_quiz_6.setText("m");
                break;
            case 14:
                problem_cha_quiz_6.setText("n");
                break;
            case 15:
                problem_cha_quiz_6.setText("o");
                break;
            case 16:
                problem_cha_quiz_6.setText("p");
                break;
            case 17:
                problem_cha_quiz_6.setText("q");
                break;
            case 18:
                problem_cha_quiz_6.setText("r");
                break;
            case 19:
                problem_cha_quiz_6.setText("s");
                break;
            case 20:
                problem_cha_quiz_6.setText("t");
                break;
            case 21:
                problem_cha_quiz_6.setText("u");
                break;
            case 22:
                problem_cha_quiz_6.setText("v");
                break;
            case 23:
                problem_cha_quiz_6.setText("w");
                break;
            case 24:
                problem_cha_quiz_6.setText("z");
                break;
            case 25:
                problem_cha_quiz_6.setText("y");
                break;
            case 26:
                problem_cha_quiz_6.setText("z");
                break;
            default:
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

        }

    }

    public void abbreviation_setting(int number){

        switch (number){

            case 0 :
                problem_cha_quiz_6.setText("가");
                break;
            case 1:
                problem_cha_quiz_6.setText("나");
                break;
            case 2:
                problem_cha_quiz_6.setText("다");
                break;
            case 3:
                problem_cha_quiz_6.setText("마");
                break;
            case 4:
                problem_cha_quiz_6.setText("바");
                break;
            case 5:
                problem_cha_quiz_6.setText("사");
                break;
            case 6:
                problem_cha_quiz_6.setText("자");
                break;
            case 7:
                problem_cha_quiz_6.setText("카");
                break;
            case 8:
                problem_cha_quiz_6.setText("타");
                break;
            case 9:
                problem_cha_quiz_6.setText("파");
                break;
            case 10:
                problem_cha_quiz_6.setText("하");
                break;
            case 11:
                problem_cha_quiz_6.setText("억");
                break;
            case 12:
                problem_cha_quiz_6.setText("언");
                break;
            case 13:
                problem_cha_quiz_6.setText("얼");
                break;
            case 14:
                problem_cha_quiz_6.setText("연");
                break;
            case 15:
                problem_cha_quiz_6.setText("열");
                break;
            case 16:
                problem_cha_quiz_6.setText("영");
                break;
            case 17:
                problem_cha_quiz_6.setText("옥");
                break;
            case 18:
                problem_cha_quiz_6.setText("온");
                break;
            case 19:
                problem_cha_quiz_6.setText("옹");
                break;
            case 20:
                problem_cha_quiz_6.setText("운");
                break;
            case 21:
                problem_cha_quiz_6.setText("울");
                break;
            case 22:
                problem_cha_quiz_6.setText("은");
                break;
            case 23:
                problem_cha_quiz_6.setText("을");
                break;
            default:
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

        }

    }

    public void number_setting(int number){

        switch (number){

            case 0 :
                problem_cha_quiz_6.setText("1");
                break;
            case 1:
                problem_cha_quiz_6.setText("2");
                break;
            case 2:
                problem_cha_quiz_6.setText("3");
                break;
            case 3:
                problem_cha_quiz_6.setText("4");
                break;
            case 4:
                problem_cha_quiz_6.setText("5");
                break;
            case 5:
                problem_cha_quiz_6.setText("6");
                break;
            case 6:
                problem_cha_quiz_6.setText("7");
                break;
            case 7:
                problem_cha_quiz_6.setText("8");
                break;
            case 8:
                problem_cha_quiz_6.setText("9");
                break;
            case 9:
                problem_cha_quiz_6.setText("0");
                break;
            default:
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

        }

    }
}
