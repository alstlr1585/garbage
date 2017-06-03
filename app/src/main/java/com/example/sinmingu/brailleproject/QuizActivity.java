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
    int randomNum = 0;
    int finalconsonant_randomNum=0;
    int vowel_randomNum=0;
    int alphabet_randomNum=0;
    int abbreviation_randomNum=0;
    int number_randomNum=0;

    String present_valuse="";

    //6점 메뉴 버튼
    Button char_consonant_initial,char_finalconsonant_initial,char_vowel,char_alphabet,char_abbreviation,char_number,quiz_result_send;
    ImageButton quiz_braillebtn1,quiz_braillebtn2,quiz_braillebtn3,quiz_braillebtn4,quiz_braillebtn5,quiz_braillebtn6;
    int quiz_btnstatus1, quiz_btnstatus2, quiz_btnstatus3, quiz_btnstatus4, quiz_btnstatus5, quiz_btnstatus6;
    ImageView quiz_resultpicture, cha_result_12_picture;
    int quiz_picturenum;
    ImageButton quiz_ch_listen;
    TextView problem_cha_quiz_6;
    Random rand;
    Button next_question, quiz_solution;
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

    //6점 상태 변수
    int char_consonant_initial_status, char_finalconsonant_initial_status,char_vowel_status,char_alphabet_status,char_abbreviation_status,char_number_status;
    private TextToSpeech ttsClient;


    //-----------------------------------------------12점----------------------------------------

    int type_12 = 0;
    Button quiz_consonantinitial_btn_12, quiz_vowel_btn_12, quiz_alphabet_btn_12, quiz_abbreviation_btn_12;
    TextView problem_cha_quiz_12;
    Button next_question_12, quiz_solution_12, quiz_result_send_12;







    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ttsClient= new TextToSpeech(getApplicationContext(),this);

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
        //6점 상태 변수 초기화
        char_consonant_initial_status=0;
        char_finalconsonant_initial_status=0;
        char_vowel_status=0;
        char_alphabet_status=0;
        char_abbreviation_status=0;
        char_number_status=0;

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

        next_question=(Button)findViewById(R.id.next_question);
        quiz_solution=(Button)findViewById(R.id.quiz_solution);

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

        //-------------------------------------6점----------------------------------------------

        char_consonant_initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 1;
                randomNum = rand.nextInt(13);   // 0~12 난수
                consonant_initial_setting(randomNum);

                present_valuse=problem_cha_quiz_6.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
        char_finalconsonant_initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 2;
                finalconsonant_randomNum = rand.nextInt(14);   // 0~13 난수
                finalconsonant_initial_setting(finalconsonant_randomNum);

                present_valuse=problem_cha_quiz_6.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        char_vowel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 3;
                vowel_randomNum = rand.nextInt(17);   // 0~16 난수
                vowel_setting(vowel_randomNum);

                present_valuse=problem_cha_quiz_6.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        char_alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 4;
                alphabet_randomNum = rand.nextInt(26);   // 0~25 난수
                alphabet_setting(alphabet_randomNum);

                present_valuse=problem_cha_quiz_6.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        char_abbreviation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 5;
                abbreviation_randomNum = rand.nextInt(24);   // 0~25 난수
                abbreviation_setting(abbreviation_randomNum);

                present_valuse=problem_cha_quiz_6.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        char_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_6 = 6;
                number_randomNum = rand.nextInt(10);   // 0~9 난수
                number_setting(number_randomNum);

                present_valuse=problem_cha_quiz_6.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        //-----------------------------------------------------------------------------------

        //------------------------------------------12점---------------------------------------
        problem_cha_quiz_12=(TextView)findViewById(R.id.textView5_12);
        quiz_consonantinitial_btn_12 = (Button)findViewById(R.id.quiz_consonantinitial_btn_12);
        quiz_vowel_btn_12 = (Button)findViewById(R.id.quiz_vowel_btn_12);
        quiz_alphabet_btn_12 = (Button)findViewById(R.id.quiz_alphabet_btn_12);
        quiz_abbreviation_btn_12 = (Button)findViewById(R.id.quiz_abbreviation_btn_12);
        next_question_12 = (Button)findViewById(R.id.cha_result_send_12);
        quiz_solution_12 = (Button)findViewById(R.id.quiz_solution_12);
        quiz_result_send_12 = (Button)findViewById(R.id.quiz_result_send_12);

        quiz_consonantinitial_btn_12.setOnClickListener(new View.OnClickListener() {    // 12점 초성자음
            @Override
            public void onClick(View v) {
                next_question_12.setVisibility(View.INVISIBLE);
                type_12 = 1;
                randomNum = rand.nextInt(5);   // 0~4 난수
                initial_setting_12(randomNum);

                present_valuse=problem_cha_quiz_12.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        quiz_vowel_btn_12.setOnClickListener(new View.OnClickListener() {   // 12점 모음
            @Override
            public void onClick(View v) {
                next_question_12.setVisibility(View.INVISIBLE);
                type_12 = 2;
                randomNum = rand.nextInt(4) + 5;   // 5~8 난수
                initial_setting_12(randomNum);

                present_valuse=problem_cha_quiz_12.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        quiz_alphabet_btn_12.setOnClickListener(new View.OnClickListener() {    // 12점 대문자
            @Override
            public void onClick(View v) {
                next_question_12.setVisibility(View.INVISIBLE);
                type_12 = 3;
                randomNum = rand.nextInt(26) + 9;   // 9~34 난수
                initial_setting_12(randomNum);

                present_valuse=problem_cha_quiz_12.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        quiz_abbreviation_btn_12.setOnClickListener(new View.OnClickListener() {    // 12점 약자
            @Override
            public void onClick(View v) {
                next_question_12.setVisibility(View.INVISIBLE);
                type_12 = 4;
                randomNum = rand.nextInt(7) + 35;   // 35~41 난수
                initial_setting_12(randomNum);

                present_valuse=problem_cha_quiz_12.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        next_question_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // 12점 다음문제 클릭 시
                next_question_12.setVisibility(View.INVISIBLE);
                quiz_resultpicture.setImageResource(0);  // 정답 O,X 표시 지우기

                //12점 초성자음
                if(type_12==1){
                    randomNum = rand.nextInt(5);   // 0~4 난수
                    initial_setting_12(randomNum);
                }
                //12점 모음
                else if(type_12==2){
                    randomNum = rand.nextInt(4) + 5;   // 5~8 난수
                    initial_setting_12(randomNum);
                }
                //12점 대문자
                else if(type_12==3){
                    randomNum = rand.nextInt(26) + 9;   // 0~16 난수
                    initial_setting_12(randomNum);
                }
                //12점 약자
                else if(type_12==4){
                    randomNum = rand.nextInt(7) + 35;   // 35~41 난수
                    initial_setting_12(randomNum);
                }
                present_valuse=problem_cha_quiz_12.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        quiz_solution_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type_12 == 0) {
                    Toast.makeText(QuizActivity.this, "타입을 선택해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    switch (randomNum) {
                        // 12점 초성자음
                        case 0: // ㄲ
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn9_12();
                            break;
                        case 1: // ㄸ
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn7_12();
                            choice_btn9_12();
                            break;
                        case 2: // ㅃ
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            break;
                        case 3: // ㅆ
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn11_12();
                            break;
                        case 4: // ㅉ
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn9_12();
                            choice_btn11_12();
                            break;

                        // 12점 모음
                        case 5: // ㅟ
                            braille12_all();
                            no_choice_btn1_12();
                            no_choice_btn4_12();
                            no_choice_btn5_12();
                            no_choice_btn9_12();
                            no_choice_btn11_12();
                            break;
                        case 6: // ㅒ
                            braille12_all();
                            no_choice_btn0_12();
                            no_choice_btn1_12();
                            no_choice_btn5_12();
                            no_choice_btn9_12();
                            no_choice_btn11_12();
                            break;
                        case 7: // ㅙ
                            braille12_all();
                            no_choice_btn3_12();
                            no_choice_btn4_12();
                            no_choice_btn9_12();
                            no_choice_btn11_12();
                            break;
                        case 8: // ㅞ
                            braille12_all();
                            no_choice_btn4_12();
                            no_choice_btn5_12();
                            no_choice_btn9_12();
                            no_choice_btn11_12();
                            break;

                        // 12점 대문자
                        case 9: // A
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            break;
                        case 10: // B
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn7_12();
                            break;
                        case 11: // C
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn9_12();
                            break;
                        case 12: // D
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            break;
                        case 13: // E
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn10_12();
                            break;
                        case 14: // F
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn7_12();
                            choice_btn9_12();
                            break;
                        case 15: // G
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn7_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            break;
                        case 16: // H
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn7_12();
                            choice_btn10_12();
                            break;
                        case 17: // I
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn7_12();
                            choice_btn9_12();
                            break;
                        case 18: // J
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn7_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            break;
                        case 19: // K
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn8_12();
                            break;
                        case 20: // L
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn7_12();
                            choice_btn8_12();
                            break;
                        case 21: // M
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn8_12();
                            choice_btn9_12();
                            break;
                        case 22: // N
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            break;
                        case 23: // O
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn8_12();
                            choice_btn10_12();
                            break;
                        case 24: // P
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn7_12();
                            choice_btn8_12();
                            choice_btn9_12();
                            break;
                        case 25: // Q
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn7_12();
                            choice_btn8_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            break;
                        case 26: // R
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn7_12();
                            choice_btn8_12();
                            choice_btn10_12();
                            break;
                        case 27: // S
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn7_12();
                            choice_btn8_12();
                            choice_btn9_12();
                            break;
                        case 28: // T
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn7_12();
                            choice_btn8_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            break;
                        case 29: // U
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn8_12();
                            choice_btn11_12();
                            break;
                        case 30: // V
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn7_12();
                            choice_btn8_12();
                            choice_btn11_12();
                            break;
                        case 31: // W
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn7_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            choice_btn11_12();
                            break;
                        case 32: // X
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn8_12();
                            choice_btn9_12();
                            choice_btn11_12();
                            break;
                        case 33: // Y
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn8_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            choice_btn11_12();
                            break;
                        case 34: // Z
                            braille12_reflash();
                            choice_btn5_12();
                            choice_btn6_12();
                            choice_btn8_12();
                            choice_btn10_12();
                            choice_btn11_12();
                            break;

                        // 12점 약자
                        case 35: // 그래서
                            braille12_reflash();
                            choice_btn0_12();
                            choice_btn7_12();
                            choice_btn8_12();
                            choice_btn9_12();
                            break;
                        case 36: // 그러나
                            braille12_reflash();
                            choice_btn0_12();
                            choice_btn6_12();
                            choice_btn9_12();
                            break;
                        case 37: // 그러면
                            braille12_reflash();
                            choice_btn0_12();
                            choice_btn7_12();
                            choice_btn10_12();
                            break;
                        case 38: // 그러므로
                            braille12_reflash();
                            choice_btn0_12();
                            choice_btn7_12();
                            choice_btn11_12();
                            break;
                        case 39: // 그런데
                            braille12_reflash();
                            choice_btn0_12();
                            choice_btn6_12();
                            choice_btn8_12();
                            choice_btn9_12();
                            choice_btn10_12();
                            break;
                        case 40: // 그리고
                            braille12_reflash();
                            choice_btn0_12();
                            choice_btn6_12();
                            choice_btn8_12();
                            choice_btn11_12();
                            break;
                        case 41: // 그리하여
                            braille12_reflash();
                            choice_btn0_12();
                            choice_btn6_12();
                            choice_btn10_12();
                            choice_btn11_12();
                            break;


                    }
                }
            }
        });

        quiz_result_send_12.setOnClickListener(new View.OnClickListener() { // 12점 확인버튼 클릭 시
            @Override
            public void onClick(View v) {
                boolean result;
                switch(problem_cha_quiz_12.getText().toString()){
                        // 12점 초성자음
                    case "ㄲ":
                        if (onSolutionCheck_12("000001000100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "ㄸ":
                        if (onSolutionCheck_12("000001010100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "ㅃ":
                        if (onSolutionCheck_12("000001000110") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                        // 12점 모음
                    case "ㅆ":
                        if (onSolutionCheck_12("000001000001") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "ㅉ":
                        if (onSolutionCheck_12("000001000101") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "ㅟ":
                        if (onSolutionCheck_12("101100111010") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "ㅒ":
                        if (onSolutionCheck_12("001110111010") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "ㅙ":
                        if (onSolutionCheck_12("111001111010") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "ㅞ":
                        if (onSolutionCheck_12("111100111010") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                        // 12점 대문자
                    case "A":
                        if (onSolutionCheck_12("000001100000") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "B":
                        if (onSolutionCheck_12("000001110000") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "C":
                        if (onSolutionCheck_12("000001100100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "D":
                        if (onSolutionCheck_12("000001100110") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "E":
                        if (onSolutionCheck_12("000001100010") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "F":
                        if (onSolutionCheck_12("000001110100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "G":
                        if (onSolutionCheck_12("000001110110") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "H":
                        if (onSolutionCheck_12("000001110010") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "I":
                        if (onSolutionCheck_12("000001010100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "J":
                        if (onSolutionCheck_12("000001010110") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "K":
                        if (onSolutionCheck_12("000001101000") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "L":
                        if (onSolutionCheck_12("000001111000") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "M":
                        if (onSolutionCheck_12("000001101100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "N":
                        if (onSolutionCheck_12("000001100110") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "O":
                        if (onSolutionCheck_12("000001101010") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "P":
                        if (onSolutionCheck_12("000001111100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "Q":
                        if (onSolutionCheck_12("000001111110") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "R":
                        if (onSolutionCheck_12("000001111010") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "S":
                        if (onSolutionCheck_12("000001011100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "T":
                        if (onSolutionCheck_12("000001011110") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "U":
                        if (onSolutionCheck_12("000001101001") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "V":
                        if (onSolutionCheck_12("000001111001") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "W":
                        if (onSolutionCheck_12("000001010111") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "X":
                        if (onSolutionCheck_12("000001101101") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "Y":
                        if (onSolutionCheck_12("000001101111") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "Z":
                        if (onSolutionCheck_12("000001101011") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                        // 12점 약자
                    case "그래서":
                        if (onSolutionCheck_12("100000011100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "그러나":
                        if (onSolutionCheck_12("100000100100") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "그러면":
                        if (onSolutionCheck_12("100000010010") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "그러므로":
                        if (onSolutionCheck_12("100000010001") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "그런데":
                        if (onSolutionCheck_12("100000101110") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "그리고":
                        if (onSolutionCheck_12("100000101001") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    case "그리하여":
                        if (onSolutionCheck_12("100000100011") == true)
                            braillebtn_false_ok_12();
                        else
                            braillebtn_false_no_12();
                        break;
                    default:
                        Toast.makeText(QuizActivity.this, "타입을 선택해주세요.", Toast.LENGTH_SHORT).show();
                        break;
                }
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
                rect12_1.set(cha_braillebtn1_12.getLeft() + linear_quiz12_left.getLeft(), cha_braillebtn1_12.getTop() + linear_quiz12_enter.getTop() , cha_braillebtn1_12.getRight() + linear_quiz12_left.getLeft(), cha_braillebtn1_12.getBottom() + linear_quiz12_enter.getTop());
                rect12_2.set(cha_braillebtn2_12.getLeft() + linear_quiz12_left.getLeft(),  cha_braillebtn2_12.getTop() + linear_quiz12_2.getTop() + linear_quiz12_enter.getTop() , cha_braillebtn2_12.getRight() + linear_quiz12_left.getLeft(), cha_braillebtn2_12.getBottom() + linear_quiz12_2.getTop() + linear_quiz12_enter.getTop());
                rect12_3.set(cha_braillebtn3_12.getLeft() + linear_quiz12_left.getLeft(), cha_braillebtn3_12.getTop() + linear_quiz12_3.getTop() + linear_quiz12_enter.getTop() , cha_braillebtn3_12.getRight() + linear_quiz12_left.getLeft(), cha_braillebtn3_12.getBottom() + linear_quiz12_3.getTop() + linear_quiz12_enter.getTop());

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
                        case 0:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㄴ
                        case 1:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㄷ
                        case 2:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㄹ
                        case 3:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅁ
                        case 4:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅂ
                        case 5:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅅ
                        case 6:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅈ
                        case 7:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅊ
                        case 8:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅋ
                        case 9:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅌ
                        case 10:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅍ
                        case 11:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅎ
                        case 12:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;

                        default:
                    }

                }
                else if(type_6 == 2){
                    switch (finalconsonant_randomNum){
                        //ㄱ
                        case 0:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㄴ
                        case 1:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㄷ
                        case 2:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㄹ
                        case 3:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅁ
                        case 4:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅂ
                        case 5:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅅ
                        case 6:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅇ
                        case 7:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅈ
                        case 8:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅊ
                        case 9:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅋ
                        case 10:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅌ
                        case 11:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅍ
                        case 12:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅎ
                        case 13:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                    }

                }
                else if(type_6 == 3){
                    switch (vowel_randomNum){
                        //ㅏ
                        case 0:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅑ
                        case 1:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅓ
                        case 2:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅕ
                        case 3:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅗ
                        case 4:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅛ
                        case 5:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅜ
                        case 6:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅠ
                        case 7:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅡ
                        case 8:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==5)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅣ
                        case 9:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅐ
                        case 10:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅔ
                        case 11:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅚ
                        case 12:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅘ
                        case 13:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅝ
                        case 14:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅢ
                        case 15:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //ㅖ
                        case 16:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                    }

                }
                else if(type_6 == 4){
                    switch (alphabet_randomNum){
                        //a
                        case 0:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //b
                        case 1:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //c
                        case 2:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //d
                        case 3:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //e
                        case 4:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //f
                        case 5:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //g
                        case 6:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //h
                        case 7:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //i
                        case 8:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //j
                        case 9:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //k
                        case 10:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //l
                        case 11:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //m
                        case 12:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //n
                        case 13:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //o
                        case 14:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //p
                        case 15:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //q
                        case 16:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //r
                        case 17:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //s
                        case 18:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //t
                        case 19:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //u
                        case 20:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //v
                        case 21:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //w
                        case 22:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //x
                        case 23:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //y
                        case 24:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //z
                        case 25:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                    }

                }
                else if(type_6 == 5){
                    switch (abbreviation_randomNum){
                        //가
                        case 0:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //나
                        case 1:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //다
                        case 2:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //마
                        case 3:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //바
                        case 4:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //사
                        case 5:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //자
                        case 6:
                            if(braille[0]==0&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //카
                        case 7:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //타
                        case 8:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //파
                        case 9:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //하
                        case 10:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //억
                        case 11:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //언
                        case 12:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //얼
                        case 13:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //연
                        case 14:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //열
                        case 15:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //영
                        case 16:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //옥
                        case 17:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //온
                        case 18:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //옹
                        case 19:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //운
                        case 20:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //울
                        case 21:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //은
                        case 22:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==1&&braille[3]==0&&braille[4]==1&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //을
                        case 23:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==1&&braille[3]==1&&braille[4]==0&&braille[5]==1)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                    }

                }
                else if(type_6 == 6){
                    switch (number_randomNum){
                        //1
                        case 0:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //2
                        case 1:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //3
                        case 2:
                            if(braille[0]==1&&braille[1]==0&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //4
                        case 3:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //5
                        case 4:
                            if(braille[0]==1&&braille[1]==0&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //6
                        case 5:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //7
                        case 6:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //8
                        case 7:
                            if(braille[0]==1&&braille[1]==1&&braille[2]==0&&braille[3]==0&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //9
                        case 8:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                        //0
                        case 9:
                            if(braille[0]==0&&braille[1]==1&&braille[2]==0&&braille[3]==1&&braille[4]==1&&braille[5]==0)
                                braillebtn_false_ok();
                            else
                                braillebtn_false_no();
                            break;
                    }

                }
                else{
                    Toast.makeText(getApplicationContext(), "타입을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_question.setVisibility(View.INVISIBLE);
                quiz_resultpicture.setImageResource(0);

                //초성자음
                if(type_6==1){
                    randomNum = rand.nextInt(13);   // 0~12 난수
                    consonant_initial_setting(randomNum);
                }
                //종성자음
                else if(type_6==2){
                    finalconsonant_randomNum = rand.nextInt(14);   // 0~13 난수
                    finalconsonant_initial_setting(finalconsonant_randomNum);
                }
                //모음
                else if(type_6==3){
                    vowel_randomNum = rand.nextInt(17);   // 0~16 난수
                    vowel_setting(vowel_randomNum);
                }
                //알파벳
                else if(type_6==4){
                    alphabet_randomNum = rand.nextInt(26);   // 0~25 난수
                    alphabet_setting(alphabet_randomNum);
                }
                //약자
                else if(type_6==5){
                    abbreviation_randomNum = rand.nextInt(24);   // 0~25 난수
                    abbreviation_setting(abbreviation_randomNum);
                }
                //숫자
                else if(type_6==6){
                    number_randomNum = rand.nextInt(10);   // 0~9 난수
                    number_setting(number_randomNum);
                }

                present_valuse=problem_cha_quiz_6.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        quiz_ch_listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                present_valuse=problem_cha_quiz_6.getText().toString();
                ttsClient.speak(present_valuse, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        quiz_solution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //초성자음
                if(type_6==1){
                    switch (randomNum){
                        //ㄱ
                        case 0:
                            braille6_reflash();
                            choice_btn3();
                            break;
                        //ㄴ
                        case 1:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn3();
                            break;
                        //ㄷ
                        case 2:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn3();
                            break;
                        //ㄹ
                        case 3:
                            braille6_reflash();
                            choice_btn4();
                            break;
                        //ㅁ
                        case 4:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn4();
                            break;
                        //ㅂ
                        case 5:
                            braille6_reflash();
                            choice_btn3();
                            choice_btn4();
                            break;
                        //ㅅ
                        case 6:
                            braille6_reflash();
                            choice_btn5();
                            break;
                        //ㅈ
                        case 7:
                            braille6_reflash();
                            choice_btn3();
                            choice_btn5();
                            break;
                        //ㅊ
                        case 8:
                            braille6_reflash();
                            choice_btn4();
                            choice_btn5();
                            break;
                        //ㅋ
                        case 9:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn3();
                            choice_btn4();
                            choice_btn5();
                            break;
                        //ㅌ
                        case 10:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn4();
                            break;
                        //ㅍ
                        case 11:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn3();
                            choice_btn4();
                            break;
                        //ㅎ
                        case 12:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn3();
                            choice_btn4();
                            break;

                        default:
                    }
                }
                //종성자음
                else if(type_6==2){
                    switch (finalconsonant_randomNum){
                        //ㄱ
                        case 0:
                            braille6_reflash();
                            choice_btn0();
                            break;
                        //ㄴ
                        case 1:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn4();
                            break;
                        //ㄷ
                        case 2:
                            braille6_reflash();
                            choice_btn2();
                            choice_btn4();
                            break;
                        //ㄹ
                        case 3:
                            braille6_reflash();
                            choice_btn1();
                            break;
                        //ㅁ
                        case 4:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn5();
                            break;
                        //ㅂ
                        case 5:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            break;
                        //ㅅ
                        case 6:
                            braille6_reflash();
                            choice_btn2();
                            break;
                        //ㅇ
                        case 7:
                            braille6_all();
                            no_choice_btn0();
                            no_choice_btn3();
                            break;
                        //ㅈ
                        case 8:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn2();
                            break;
                        //ㅊ
                        case 9:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn2();
                            break;
                        //ㅋ
                        case 10:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn2();
                            choice_btn4();
                            break;
                        //ㅌ
                        case 11:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn2();
                            choice_btn5();
                            break;
                        //ㅍ
                        case 12:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn4();
                            choice_btn5();
                            break;
                        //ㅎ
                        case 13:
                            braille6_reflash();
                            choice_btn2();
                            choice_btn4();
                            choice_btn5();
                            break;
                    }

                }
                //모음
                else if(type_6==3){
                    switch (vowel_randomNum){
                        //ㅏ
                        case 0:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn5();
                            break;
                        //ㅑ
                        case 1:
                            braille6_reflash();
                            choice_btn2();
                            choice_btn3();
                            choice_btn4();
                            break;
                        //ㅓ
                        case 2:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn2();
                            choice_btn3();
                            break;
                        //ㅕ
                        case 3:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn4();
                            choice_btn5();
                            break;
                        //ㅗ
                        case 4:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn2();
                            choice_btn5();
                            break;
                        //ㅛ
                        case 5:
                            braille6_reflash();
                            choice_btn2();
                            choice_btn3();
                            choice_btn5();
                            break;
                        //ㅜ
                        case 6:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn2();
                            choice_btn3();
                            break;
                        //ㅠ
                        case 7:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn3();
                            choice_btn5();
                            break;
                        //ㅡ
                        case 8:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn3();
                            break;
                        //ㅣ
                        case 9:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn2();
                            choice_btn4();
                            break;
                        //ㅐ
                        case 10:
                            braille6_all();
                            no_choice_btn3();
                            no_choice_btn5();
                            break;
                        //ㅔ
                        case 11:
                            braille6_all();
                            no_choice_btn1();
                            no_choice_btn5();
                            break;
                        //ㅚ
                        case 12:
                            braille6_all();
                            no_choice_btn1();
                            break;
                        //ㅘ
                        case 13:
                            braille6_all();
                            no_choice_btn3();
                            no_choice_btn4();
                            break;
                        //ㅝ
                        case 14:
                            braille6_all();
                            no_choice_btn4();
                            no_choice_btn5();
                            break;
                        //ㅢ
                        case 15:
                            braille6_all();
                            no_choice_btn0();
                            no_choice_btn2();
                            break;
                        //ㅖ
                        case 16:
                            braille6_reflash();
                            choice_btn2();
                            choice_btn3();
                            break;
                    }
                }
                //알파벳
                else if(type_6==4){
                    switch (alphabet_randomNum) {
                        //a
                        case 0:
                            braille6_reflash();
                            choice_btn0();
                            break;
                        //b
                        case 1:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            break;
                        //c
                        case 2:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn3();
                            break;
                        //d
                        case 3:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn3();
                            choice_btn4();
                            break;
                        //e
                        case 4:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn4();
                            break;
                        //f
                        case 5:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn3();
                            break;
                        //g
                        case 6:
                            braille6_all();
                            no_choice_btn2();
                            no_choice_btn5();
                            break;
                        //h
                        case 7:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn4();
                            break;
                        //i
                        case 8:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn3();
                            break;
                        //j
                        case 9:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn3();
                            choice_btn4();
                            break;
                        //k
                        case 10:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn2();
                            break;
                        //l
                        case 11:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn2();
                            break;
                        //m
                        case 12:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn2();
                            choice_btn3();
                            break;
                        //n
                        case 13:
                            braille6_all();
                            no_choice_btn1();
                            no_choice_btn5();
                            break;
                        //o
                        case 14:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn2();
                            choice_btn4();
                            break;
                        //p
                        case 15:
                            braille6_all();
                            no_choice_btn4();
                            no_choice_btn5();
                            break;
                        //q
                        case 16:
                            braille6_all();
                            no_choice_btn5();
                            break;
                        //r
                        case 17:
                            braille6_all();
                            no_choice_btn3();
                            break;
                        //s
                        case 18:
                            braille6_all();
                            no_choice_btn0();
                            no_choice_btn4();
                            no_choice_btn5();
                            break;
                        //t
                        case 19:
                            braille6_all();
                            no_choice_btn0();
                            no_choice_btn5();
                            break;
                        //u
                        case 20:
                            braille6_all();
                            no_choice_btn1();
                            no_choice_btn3();
                            no_choice_btn4();
                            break;
                        //v
                        case 21:
                            braille6_all();
                            no_choice_btn3();
                            no_choice_btn4();
                            break;
                        //w
                        case 22:
                            braille6_all();
                            no_choice_btn0();
                            no_choice_btn2();
                            break;
                        //x
                        case 23:
                            braille6_all();
                            no_choice_btn1();
                            no_choice_btn4();
                            break;
                        //y
                        case 24:
                            braille6_all();
                            no_choice_btn1();
                            break;
                        //z
                        case 25:
                            braille6_all();
                            no_choice_btn1();
                            no_choice_btn3();
                            break;
                    }
                }
                //약자
                else if(type_6==5){
                    switch (abbreviation_randomNum){
                        //가
                        case 0:
                            braille6_all();
                            no_choice_btn2();
                            no_choice_btn4();
                            break;
                        //나
                        case 1:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn3();
                            break;
                        //다
                        case 2:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn3();
                            break;
                        //마
                        case 3:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn4();
                            break;
                        //바
                        case 4:
                            braille6_reflash();
                            choice_btn3();
                            choice_btn4();
                            break;
                        //사
                        case 5:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn2();
                            break;
                        //자
                        case 6:
                            braille6_reflash();
                            choice_btn3();
                            choice_btn5();
                            break;
                        //카
                        case 7:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn3();
                            break;
                        //타
                        case 8:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn4();
                            break;
                        //파
                        case 9:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn3();
                            choice_btn4();
                            break;
                        //하
                        case 10:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn3();
                            choice_btn4();
                            break;
                        //억
                        case 11:
                            braille6_all();
                            no_choice_btn1();
                            no_choice_btn2();
                            break;
                        //언
                        case 12:
                            braille6_all();
                            no_choice_btn0();
                            break;
                        //얼
                        case 13:
                            braille6_all();
                            no_choice_btn0();
                            no_choice_btn5();
                            break;
                        //연
                        case 14:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn5();
                            break;
                        //열
                        case 15:
                            braille6_all();
                            no_choice_btn2();
                            no_choice_btn3();
                            break;
                        //영
                        case 16:
                            braille6_all();
                            no_choice_btn2();
                            break;
                        //옥
                        case 17:
                            braille6_all();
                            no_choice_btn1();
                            no_choice_btn4();
                            break;
                        //온
                        case 18:
                            braille6_all();
                            no_choice_btn3();
                            break;
                        //옹
                        case 19:
                            braille6_all();
                            break;
                        //운
                        case 20:
                            braille6_all();
                            no_choice_btn2();
                            no_choice_btn5();
                            break;
                        //울
                        case 21:
                            braille6_all();
                            no_choice_btn4();
                            break;
                        //은
                        case 22:
                            braille6_all();
                            no_choice_btn1();
                            no_choice_btn3();
                            break;
                        //을
                        case 23:
                            braille6_all();
                            no_choice_btn0();
                            no_choice_btn4();
                            break;
                    }
                }
                //숫자
                else if(type_6==6){
                    switch (number_randomNum){
                        //1
                        case 0:
                            braille6_reflash();
                            choice_btn0();
                            break;
                        //2
                        case 1:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            break;
                        //3
                        case 2:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn3();
                            break;
                        //4
                        case 3:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn2();
                            choice_btn5();
                            break;
                        //5
                        case 4:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn4();
                            break;
                        //6
                        case 5:
                            braille6_reflash();
                            choice_btn0();
                            choice_btn1();
                            choice_btn3();
                            break;
                        //7
                        case 6:
                            braille6_all();
                            no_choice_btn2();
                            no_choice_btn5();
                            break;
                        //8
                        case 7:
                            braille6_all();
                            no_choice_btn2();
                            no_choice_btn3();
                            no_choice_btn5();
                            break;
                        //9
                        case 8:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn3();
                            break;
                        //0
                        case 9:
                            braille6_reflash();
                            choice_btn1();
                            choice_btn3();
                            choice_btn4();
                            break;
                    }
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
        ttsClient.speak("정답", TextToSpeech.QUEUE_FLUSH, null);

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
        ttsClient.speak("정답", TextToSpeech.QUEUE_FLUSH, null);

        next_question.setVisibility(View.VISIBLE);
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
        ttsClient.speak("오답", TextToSpeech.QUEUE_FLUSH, null);

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
        ttsClient.speak("오답", TextToSpeech.QUEUE_FLUSH, null);

        next_question.setVisibility(View.INVISIBLE);

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
            case 13:
                problem_cha_quiz_6.setText("n");
                break;
            case 14:
                problem_cha_quiz_6.setText("o");
                break;
            case 15:
                problem_cha_quiz_6.setText("p");
                break;
            case 16:
                problem_cha_quiz_6.setText("q");
                break;
            case 17:
                problem_cha_quiz_6.setText("r");
                break;
            case 18:
                problem_cha_quiz_6.setText("s");
                break;
            case 19:
                problem_cha_quiz_6.setText("t");
                break;
            case 20:
                problem_cha_quiz_6.setText("u");
                break;
            case 21:
                problem_cha_quiz_6.setText("v");
                break;
            case 22:
                problem_cha_quiz_6.setText("w");
                break;
            case 23:
                problem_cha_quiz_6.setText("z");
                break;
            case 24:
                problem_cha_quiz_6.setText("y");
                break;
            case 25:
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

    public void braille6_reflash(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn1);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn2);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn3);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn4);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn5);
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn6);

        braille[0]=0;
        braille[1]=0;
        braille[2]=0;
        braille[3]=0;
        braille[4]=0;
        braille[5]=0;
    }

    public void choice_btn0(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn1);
        braille[0]=1;
    }
    public void choice_btn1(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn2);
        braille[1]=1;
    }
    public void choice_btn2(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn3);
        braille[2]=1;
    }
    public void choice_btn3(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn4);
        braille[3]=1;
    }
    public void choice_btn4(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn5);
        braille[4]=1;
    }
    public void choice_btn5(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn6);
        braille[5]=1;
    }

    public void braille6_all(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn1);
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn2);
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn3);
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn4);
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn5);
        Glide.with(this).load(R.drawable.braillebtn_true).into(quiz_braillebtn6);

        braille[0]=1;
        braille[1]=1;
        braille[2]=1;
        braille[3]=1;
        braille[4]=1;
        braille[5]=1;
    }

    public void no_choice_btn0(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn1);
        braille[0]=0;
    }
    public void no_choice_btn1(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn2);
        braille[1]=0;
    }
    public void no_choice_btn2(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn3);
        braille[2]=0;
    }
    public void no_choice_btn3(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn4);
        braille[3]=0;
    }
    public void no_choice_btn4(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn5);
        braille[4]=0;
    }
    public void no_choice_btn5(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(quiz_braillebtn6);
        braille[5]=0;
    }

    //--------------------------------12점---------------------------------------------
    public void initial_setting_12(int number){
        switch (number){

            case 0 :
                problem_cha_quiz_12.setText("ㄲ");
                break;
            case 1:
                problem_cha_quiz_12.setText("ㄸ");
                break;
            case 2:
                problem_cha_quiz_12.setText("ㅃ");
                break;
            case 3:
                problem_cha_quiz_12.setText("ㅆ");
                break;
            case 4:
                problem_cha_quiz_12.setText("ㅉ");
                break;
            case 5:
                problem_cha_quiz_12.setText("ㅟ");
                break;
            case 6:
                problem_cha_quiz_12.setText("ㅒ");
                break;
            case 7:
                problem_cha_quiz_12.setText("ㅙ");
                break;
            case 8:
                problem_cha_quiz_12.setText("ㅞ");
                break;
            case 9:
                problem_cha_quiz_12.setText("A");
                break;
            case 10:
                problem_cha_quiz_12.setText("B");
                break;
            case 11:
                problem_cha_quiz_12.setText("C");
                break;
            case 12:
                problem_cha_quiz_12.setText("D");
                break;
            case 13:
                problem_cha_quiz_12.setText("E");
                break;
            case 14:
                problem_cha_quiz_12.setText("F");
                break;
            case 15:
                problem_cha_quiz_12.setText("G");
                break;
            case 16:
                problem_cha_quiz_12.setText("H");
                break;
            case 17:
                problem_cha_quiz_12.setText("I");
                break;
            case 18:
                problem_cha_quiz_12.setText("J");
                break;
            case 19:
                problem_cha_quiz_12.setText("K");
                break;
            case 20:
                problem_cha_quiz_12.setText("L");
                break;
            case 21:
                problem_cha_quiz_12.setText("M");
                break;
            case 22:
                problem_cha_quiz_12.setText("N");
                break;
            case 23:
                problem_cha_quiz_12.setText("O");
                break;
            case 24:
                problem_cha_quiz_12.setText("P");
                break;
            case 25:
                problem_cha_quiz_12.setText("Q");
                break;
            case 26:
                problem_cha_quiz_12.setText("R");
                break;
            case 27:
                problem_cha_quiz_12.setText("S");
                break;
            case 28:
                problem_cha_quiz_12.setText("T");
                break;
            case 29:
                problem_cha_quiz_12.setText("U");
                break;
            case 30:
                problem_cha_quiz_12.setText("V");
                break;
            case 31:
                problem_cha_quiz_12.setText("W");
                break;
            case 32:
                problem_cha_quiz_12.setText("X");
                break;
            case 33:
                problem_cha_quiz_12.setText("Y");
                break;
            case 34:
                problem_cha_quiz_12.setText("Z");
                break;
            case 35:
                problem_cha_quiz_12.setText("그래서");
                break;
            case 36:
                problem_cha_quiz_12.setText("그러나");
                break;
            case 37:
                problem_cha_quiz_12.setText("그러면");
                break;
            case 38:
                problem_cha_quiz_12.setText("그러므로");
                break;
            case 39:
                problem_cha_quiz_12.setText("그런데");
                break;
            case 40:
                problem_cha_quiz_12.setText("그리고");
                break;
            case 41:
                problem_cha_quiz_12.setText("그리하여");
                break;
            default:
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

        }
    }

    public void braille12_reflash(){
        // 12개의 점 모두 이미지 초기화
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

        braille_12[0] = 0;
        braille_12[1] = 0;
        braille_12[2] = 0;
        braille_12[3] = 0;
        braille_12[4] = 0;
        braille_12[5] = 0;
        braille_12[6] = 0;
        braille_12[7] = 0;
        braille_12[8] = 0;
        braille_12[9] = 0;
        braille_12[10] = 0;
        braille_12[11] = 0;
    }

    public void choice_btn0_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn1_12);
        braille_12[0] = 1;
    }
    public void choice_btn1_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn2_12);
        braille_12[1] = 1;
    }
    public void choice_btn2_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn3_12);
        braille_12[2] = 1;
    }
    public void choice_btn3_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn4_12);
        braille_12[3] = 1;
    }
    public void choice_btn4_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn5_12);
        braille_12[4] = 1;
    }
    public void choice_btn5_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn6_12);
        braille_12[5] = 1;
    }
    public void choice_btn6_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn7_12);
        braille_12[6] = 1;
    }
    public void choice_btn7_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn8_12);
        braille_12[7] = 1;
    }
    public void choice_btn8_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn9_12);
        braille_12[8] = 1;
    }
    public void choice_btn9_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn10_12);
        braille_12[9] = 1;
    }
    public void choice_btn10_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn11_12);
        braille_12[10] = 1;
    }
    public void choice_btn11_12(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn12_12);
        braille_12[11] = 1;
    }



    public void braille12_all(){
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn1_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn2_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn3_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn4_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn5_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn6_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn7_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn8_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn9_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn10_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn11_12);
        Glide.with(this).load(R.drawable.braillebtn_true).into(cha_braillebtn12_12);

        braille_12[0] = 1;
        braille_12[1] = 1;
        braille_12[2] = 1;
        braille_12[3] = 1;
        braille_12[4] = 1;
        braille_12[5] = 1;
        braille_12[6] = 1;
        braille_12[7] = 1;
        braille_12[8] = 1;
        braille_12[9] = 1;
        braille_12[10] = 1;
        braille_12[11] = 1;
    }

    public void no_choice_btn0_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn1_12);
        braille_12[0] = 0;
    }
    public void no_choice_btn1_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn2_12);
        braille_12[1] = 0;
    }
    public void no_choice_btn2_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn3_12);
        braille_12[2] = 0;
    }
    public void no_choice_btn3_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn4_12);
        braille_12[3] = 0;
    }
    public void no_choice_btn4_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn5_12);
        braille_12[4] = 0;
    }
    public void no_choice_btn5_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn6_12);
        braille_12[5] = 0;
    }
    public void no_choice_btn6_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn7_12);
        braille_12[6] = 0;
    }
    public void no_choice_btn7_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn8_12);
        braille_12[7] = 0;
    }
    public void no_choice_btn8_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn9_12);
        braille_12[8] = 0;
    }
    public void no_choice_btn9_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn10_12);
        braille_12[9] = 0;
    }
    public void no_choice_btn10_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn11_12);
        braille_12[10] = 0;
    }
    public void no_choice_btn11_12(){
        Glide.with(this).load(R.drawable.braillebtn_false).into(cha_braillebtn12_12);
        braille_12[11] = 0;
    }

    public boolean onSolutionCheck_12(String solution){
        String now="";

        for(int i=0;i<12;i++)
            now += braille_12[i];

        if (now.equals(solution) == true)
            next_question_12.setVisibility(View.VISIBLE);

        return now.equals(solution);
    }



}
