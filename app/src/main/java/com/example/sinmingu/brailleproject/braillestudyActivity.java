package com.example.sinmingu.brailleproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static android.R.attr.id;
import static java.lang.System.exit;

public class braillestudyActivity extends BaseActivity implements TextToSpeech.OnInitListener{

    //6점
    Button btn_before, btn_next,result_send;
    ImageButton braillebtn1,braillebtn2,braillebtn3,braillebtn4,braillebtn5,braillebtn6;
    int btnstatus1, btnstatus2, btnstatus3, btnstatus4, btnstatus5, btnstatus6;
    TextView studyresult,study_part;
    ImageView brailleImage,studyresultpicture;
    RectF rect1, rect2, rect3, rect4, rect5, rect6;
    RectF rect12_1, rect12_2, rect12_3, rect12_4, rect12_5, rect12_6, rect12_7, rect12_8, rect12_9, rect12_10, rect12_11, rect12_12;
    Button study_consonantinitial_btn, study_finalconsonantinitial_btn, study_vowel_btn, study_alphabet_btn, study_number_btn,
            study_abbreviation_btn;
    int consonantinitial_picturenum,finalconsonantinitial_picturenum,vowel_picturenum,braillenumber_picturenum,braille_conjunction_picturenum,braille_abbreviation_picturenum,braille_alphabet_picturenum;

    int[] consonant_initial_imgs = {R.drawable.consonant_initial_1,R.drawable.consonant_initial_2,R.drawable.consonant_initial_3,
            R.drawable.consonant_initial_4,R.drawable.consonant_initial_5,R.drawable.consonant_initial_6,R.drawable.consonant_initial_7,
            R.drawable.consonant_initial_8,R.drawable.consonant_initial_9,R.drawable.consonant_initial_10,R.drawable.consonant_initial_11,
            R.drawable.consonant_initial_12,R.drawable.consonant_initial_13};

    int[] finalconsonant_initial_imgs={R.drawable.finalconsonant_ini_1,R.drawable.finalconsonant_ini_2,R.drawable.finalconsonant_ini_3,
            R.drawable.finalconsonant_ini_4,R.drawable.finalconsonant_ini_5,R.drawable.finalconsonant_ini_6,R.drawable.finalconsonant_ini_7,
            R.drawable.finalconsonant_ini_8,R.drawable.finalconsonant_ini_9,R.drawable.finalconsonant_ini_10,R.drawable.finalconsonant_ini_11,
            R.drawable.finalconsonant_ini_12,R.drawable.finalconsonant_ini_13,R.drawable.finalconsonant_ini_14};

    int[] vowel_imgs={R.drawable.vowel_1,R.drawable.vowel_2,R.drawable.vowel_3,R.drawable.vowel_4,R.drawable.vowel_5,R.drawable.vowel_6,
            R.drawable.vowel_7,R.drawable.vowel_8,R.drawable.vowel_9,R.drawable.vowel_10,R.drawable.vowel_11,R.drawable.vowel_12,R.drawable.vowel_13,
            R.drawable.vowel_14,R.drawable.vowel_15,R.drawable.vowel_16,R.drawable.vowel_17,R.drawable.vowel_18,R.drawable.vowel_19,R.drawable.vowel_20,
            R.drawable.vowel_21,R.drawable.vowel_22,R.drawable.vowel_23,R.drawable.vowel_24,R.drawable.vowel_25};

    int[] braillenumber_imgs={R.drawable.braillnumber_1,R.drawable.braillnumber_2,R.drawable.braillnumber_3,R.drawable.braillnumber_4,
            R.drawable.braillnumber_5,R.drawable.braillnumber_6,R.drawable.braillnumber_7,R.drawable.braillnumber_8,R.drawable.braillnumber_9,
            R.drawable.braillnumber_10};
    int [] braille_abbreviation_imgs={R.drawable.braille_abbreviation_1,R.drawable.braille_abbreviation_2,R.drawable.braille_abbreviation_3,R.drawable.braille_abbreviation_4,
            R.drawable.braille_abbreviation_5,R.drawable.braille_abbreviation_6,R.drawable.braille_abbreviation_7,R.drawable.braille_abbreviation_8,R.drawable.braille_abbreviation_9,
            R.drawable.braille_abbreviation_10,R.drawable.braille_abbreviation_11,R.drawable.braille_abbreviation_12,R.drawable.braille_abbreviation_13,R.drawable.braille_abbreviation_14,
            R.drawable.braille_abbreviation_15,R.drawable.braille_abbreviation_16,R.drawable.braille_abbreviation_17,R.drawable.braille_abbreviation_18,R.drawable.braille_abbreviation_19,
            R.drawable.braille_abbreviation_20,R.drawable.braille_abbreviation_21,R.drawable.braille_abbreviation_22,R.drawable.braille_abbreviation_23,R.drawable.braille_abbreviation_24};

    int [] braille_alphabet_imgs={R.drawable.braille_alphabet_1,R.drawable.braille_alphabet_2,R.drawable.braille_alphabet_3,R.drawable.braille_alphabet_4,R.drawable.braille_alphabet_5,
            R.drawable.braille_alphabet_6,R.drawable.braille_alphabet_7,R.drawable.braille_alphabet_8,R.drawable.braille_alphabet_9,R.drawable.braille_alphabet_10,R.drawable.braille_alphabet_11,
            R.drawable.braille_alphabet_12,R.drawable.braille_alphabet_13,R.drawable.braille_alphabet_14,R.drawable.braille_alphabet_15,R.drawable.braille_alphabet_16,R.drawable.braille_alphabet_17,
            R.drawable.braille_alphabet_18,R.drawable.braille_alphabet_19,R.drawable.braille_alphabet_20,R.drawable.braille_alphabet_21,R.drawable.braille_alphabet_22,R.drawable.braille_alphabet_23,
            R.drawable.braille_alphabet_24,R.drawable.braille_alphabet_25,R.drawable.braille_alphabet_26};

    DB StudyBraille;
    SQLiteDatabase db;


    int braille[];
    String menu_type;

    //12점--------------------------------------------------------------------------------------------------------------------------------------
    int btnstatus1_12,btnstatus2_12,btnstatus3_12,btnstatus4_12,btnstatus5_12,btnstatus6_12,btnstatus7_12,btnstatus8_12,btnstatus9_12,btnstatus10_12,btnstatus11_12,btnstatus12_12;
    ImageView brailleImage_12, studyresult_12_picture;
    ImageButton braillebtn1_12,braillebtn2_12,braillebtn3_12,braillebtn4_12,braillebtn5_12,braillebtn6_12,braillebtn7_12,braillebtn8_12,braillebtn9_12,braillebtn10_12,braillebtn11_12,braillebtn12_12;
    Button btn_before_12, btn_next_12, result_send_12;
    Button study_abbreviation_btn_12, study_consonantinitial_btn_12, study_vowel_btn_12, study_alphabet_btn_12;
    TextView study_12_result, stduy_part_12;

    int braille_abbreviation12_picturenum, consonantinitial12_picturenum, vowel12_picturenum, braille_alphabet12_picturenum;
    int braille_12[];
    String menu_type_12;

    int [] braille_abbreviation12_imgs={R.drawable.braille_abbreviation12_1, R.drawable.braille_abbreviation12_2, R.drawable.braille_abbreviation12_3, R.drawable.braille_abbreviation12_4,
            R.drawable.braille_abbreviation12_5, R.drawable.braille_abbreviation12_6, R.drawable.braille_abbreviation12_7};

    int [] consonant_initial12_imgs={R.drawable.consonant_initial12_1,R.drawable.consonant_initial12_2, R.drawable.consonant_initial12_3, R.drawable.consonant_initial12_4, R.drawable.consonant_initial12_5};
    int[] vowel12_imgs={R.drawable.vowel12_1,R.drawable.vowel12_2,R.drawable.vowel12_3,R.drawable.vowel12_4};
    int [] braille_alphabet12_imgs={R.drawable.braille_alphabet12_1, R.drawable.braille_alphabet12_2, R.drawable.braille_alphabet12_3, R.drawable.braille_alphabet12_4, R.drawable.braille_alphabet12_5,
            R.drawable.braille_alphabet12_6, R.drawable.braille_alphabet12_7, R.drawable.braille_alphabet12_8, R.drawable.braille_alphabet12_9, R.drawable.braille_alphabet12_10,
            R.drawable.braille_alphabet12_11, R.drawable.braille_alphabet12_12, R.drawable.braille_alphabet12_13, R.drawable.braille_alphabet12_14, R.drawable.braille_alphabet12_15, R.drawable.braille_alphabet12_16,
            R.drawable.braille_alphabet12_17, R.drawable.braille_alphabet12_18, R.drawable.braille_alphabet12_19, R.drawable.braille_alphabet12_20, R.drawable.braille_alphabet12_21, R.drawable.braille_alphabet12_22, R.drawable.braille_alphabet12_23,
            R.drawable.braille_alphabet12_24, R.drawable.braille_alphabet12_25, R.drawable.braille_alphabet12_26};

    private TextToSpeech ttsClient;
    LinearLayout linear_touch, linear_touch_1, linear_touch_2, linear_touch_3;
    LinearLayout linear_touch2, linear_touch2_1, linear_touch2_2, linear_touch2_3;
    LinearLayout linear_touch2_left, linear_touch2_right, linear_touch2_enter;

    //---------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braillestudy);

        study_part=(TextView)findViewById(R.id.stduy_part);

        linear_touch = (LinearLayout)findViewById(R.id.linear_touch);
        linear_touch_1 = (LinearLayout)findViewById(R.id.linear_touch_1);
        linear_touch_2 = (LinearLayout)findViewById(R.id.linear_touch_2);
        linear_touch_3 = (LinearLayout)findViewById(R.id.linear_touch_3);

        linear_touch2 = (LinearLayout) findViewById(R.id.linear_touch2);
        linear_touch2_1 = (LinearLayout) findViewById(R.id.linear_touch2_1);
        linear_touch2_2 = (LinearLayout) findViewById(R.id.linear_touch2_2);
        linear_touch2_3 = (LinearLayout) findViewById(R.id.linear_touch2_3);

        linear_touch2_left = (LinearLayout) findViewById(R.id.linear_touch2_left);
        linear_touch2_right = (LinearLayout) findViewById(R.id.linear_touch2_right);
        linear_touch2_enter = (LinearLayout) findViewById(R.id.linear_touch2_enter);

        ttsClient= new TextToSpeech(getApplicationContext(),this);

        menu_type="";
        rect1 = new RectF();
        rect2 = new RectF();
        rect3 = new RectF();
        rect4 = new RectF();
        rect5 = new RectF();
        rect6 = new RectF();

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

        btnstatus1=0;
        btnstatus2=0;
        btnstatus3=0;
        btnstatus4=0;
        btnstatus5=0;
        btnstatus6=0;
        consonantinitial_picturenum=0;
        finalconsonantinitial_picturenum=0;
        vowel_picturenum=0;
        braillenumber_picturenum=0;
        braille_abbreviation_picturenum=0;
        braille_alphabet_picturenum=0;
        braille=new int[6];

        braillebtn1=(ImageButton)findViewById(R.id.braillebtn1);
        braillebtn2=(ImageButton)findViewById(R.id.braillebtn2);
        braillebtn3=(ImageButton)findViewById(R.id.braillebtn3);
        braillebtn4=(ImageButton)findViewById(R.id.braillebtn4);
        braillebtn5=(ImageButton)findViewById(R.id.braillebtn5);
        braillebtn6=(ImageButton)findViewById(R.id.braillebtn6);


        //12점---------------------------------------------------------------------------
        braille_12=new int[12];
        menu_type_12="";

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

        braille_abbreviation12_picturenum=0;
        vowel_picturenum=0;
        consonantinitial12_picturenum=0;
        braille_alphabet12_picturenum=0;

        study_alphabet_btn_12=(Button)findViewById(R.id.study_alphabet_btn_12);
        study_vowel_btn_12=(Button)findViewById(R.id.study_vowel_btn_12);
        study_consonantinitial_btn_12=(Button)findViewById(R.id.study_consonantinitial_btn_12);
        stduy_part_12=(TextView)findViewById(R.id.stduy_part_12);
        study_12_result=(TextView)findViewById(R.id.study_12_result);
        btn_before_12=(Button)findViewById(R.id.btn_before_12);
        btn_next_12=(Button)findViewById(R.id.btn_next_12);
        result_send_12=(Button)findViewById(R.id.result_send_12);
        study_abbreviation_btn_12=(Button)findViewById(R.id.study_abbreviation_btn_12);

        studyresult_12_picture=(ImageView)findViewById(R.id.studyresult_12_picture);
        brailleImage_12=(ImageView)findViewById(R.id.brailleImage_12);
        braillebtn1_12=(ImageButton)findViewById(R.id.braillebtn1_12);
        braillebtn2_12=(ImageButton)findViewById(R.id.braillebtn2_12);
        braillebtn3_12=(ImageButton)findViewById(R.id.braillebtn3_12);
        braillebtn4_12=(ImageButton)findViewById(R.id.braillebtn4_12);
        braillebtn5_12=(ImageButton)findViewById(R.id.braillebtn5_12);
        braillebtn6_12=(ImageButton)findViewById(R.id.braillebtn6_12);
        braillebtn7_12=(ImageButton)findViewById(R.id.braillebtn7_12);
        braillebtn8_12=(ImageButton)findViewById(R.id.braillebtn8_12);
        braillebtn9_12=(ImageButton)findViewById(R.id.braillebtn9_12);
        braillebtn10_12=(ImageButton)findViewById(R.id.braillebtn10_12);
        braillebtn11_12=(ImageButton)findViewById(R.id.braillebtn11_12);
        braillebtn12_12=(ImageButton)findViewById(R.id.braillebtn12_12);

        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn1_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn2_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn3_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn4_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn5_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn6_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn7_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn8_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn9_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn10_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn11_12);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn12_12);

        //--------------------------------------------------------------------------------

        //초급 버튼
        study_consonantinitial_btn=(Button)findViewById(R.id.study_consonantinitial_btn);
        study_finalconsonantinitial_btn=(Button)findViewById(R.id.study_finalconsonantinitial_btn);
        study_vowel_btn=(Button)findViewById(R.id.study_vowel_btn);
        study_abbreviation_btn=(Button)findViewById(R.id.study_abbreviation_btn);
        study_alphabet_btn=(Button)findViewById(R.id.study_alphabet_btn);

        study_number_btn=(Button)findViewById(R.id.study_number_btn);

        btn_before=(Button)findViewById(R.id.btn_before);
        btn_next=(Button)findViewById(R.id.btn_next);
        result_send=(Button)findViewById(R.id.result_send);

        studyresult=(TextView)findViewById(R.id.textView);
        studyresultpicture=(ImageView)findViewById(R.id.studyresultpicture);

        brailleImage=(ImageView)findViewById(R.id.brailleImage);

        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn1);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn2);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn3);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn4);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn5);
        Glide.with(this).load(R.drawable.braillebtn_false).into(braillebtn6);


        Typeface font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/BMJUA_ttf.ttf");

        final TabHost tabHost = (TabHost)findViewById(R.id.tab_host);

        tabHost.setup();

        // Tab1 Setting
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");
        tabSpec1.setIndicator("6점"); // Tab Subject
        tabSpec1.setContent(R.id.tab_view1); // Tab Content
        tabHost.addTab(tabSpec1);
        // Tab2 Setting
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");
        tabSpec2.setIndicator("12점"); // Tab Subject
        tabSpec2.setContent(R.id.tab_view2); // Tab Content
        tabHost.addTab(tabSpec2);
        // Tab3 Setting
        // show First Tab Content
        tabHost.setCurrentTab(0);

        // 탭 호스트 글꼴 변경
        for (int i=0; i<tabHost.getTabWidget().getChildCount(); i++) {
            LinearLayout relLayout = (LinearLayout) tabHost.getTabWidget().getChildAt(i);
            TextView tv = (TextView)relLayout.getChildAt(1);
            tv.setTypeface(font);
            tv.setTextColor(Color.parseColor("#000000"));
            tv.setTextSize(16);
        }

///////////////////////////////////

        braillebtn1.setClickable(false);
        braillebtn2.setClickable(false);
        braillebtn3.setClickable(false);
        braillebtn4.setClickable(false);
        braillebtn5.setClickable(false);
        braillebtn6.setClickable(false);

        /////////////////////////////////



        linear_touch.setOnTouchListener(new View.OnTouchListener() {
            int flag = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                rect1.set(braillebtn1.getLeft(), braillebtn1.getTop(), braillebtn1.getRight(), braillebtn1.getBottom());
                rect2.set(braillebtn2.getLeft(), braillebtn2.getTop() + linear_touch_2.getTop(), braillebtn2.getRight(), braillebtn2.getBottom() + linear_touch_2.getTop());
                rect3.set(braillebtn3.getLeft(), braillebtn3.getTop() + linear_touch_3.getTop(), braillebtn3.getRight(), braillebtn3.getBottom() + linear_touch_3.getTop());
                rect4.set(braillebtn4.getLeft(), braillebtn4.getTop(), braillebtn4.getRight(), braillebtn4.getBottom());
                rect5.set(braillebtn5.getLeft(), braillebtn5.getTop() + linear_touch_2.getTop(), braillebtn5.getRight(), braillebtn5.getBottom() + linear_touch_2.getTop());
                rect6.set(braillebtn6.getLeft(), braillebtn6.getTop() + linear_touch_3.getTop(), braillebtn6.getRight(), braillebtn6.getBottom() + linear_touch_3.getTop());

                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {

                    if (rect1.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus1 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn1);
                                braille[0] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn1);
                                braille[0] = 0;
                            }

                            btnstatus1++;
                            flag = 1;
                        }
                    } else if (rect2.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus2 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn2);
                                braille[1] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn2);
                                braille[1] = 0;
                            }

                            btnstatus2++;
                            flag = 1;
                        }
                    } else if (rect3.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus3 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn3);
                                braille[2] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn3);
                                braille[2] = 0;
                            }

                            btnstatus3++;
                            flag = 1;
                        }
                    } else if (rect4.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus4 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn4);
                                braille[3] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn4);
                                braille[3] = 0;
                            }

                            btnstatus4++;
                            flag = 1;
                        }
                    } else if (rect5.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus5 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn5);
                                braille[4] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn5);
                                braille[4] = 0;
                            }

                            btnstatus5++;
                            flag = 1;
                        }
                    } else if (rect6.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus6 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn6);
                                braille[5] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn6);
                                braille[5] = 0;
                            }

                            btnstatus6++;
                            flag = 1;
                        }
                    } else {
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

        braillebtn1_12.setClickable(false);
        braillebtn2_12.setClickable(false);
        braillebtn3_12.setClickable(false);
        braillebtn4_12.setClickable(false);
        braillebtn5_12.setClickable(false);
        braillebtn6_12.setClickable(false);
        braillebtn7_12.setClickable(false);
        braillebtn8_12.setClickable(false);
        braillebtn9_12.setClickable(false);
        braillebtn10_12.setClickable(false);
        braillebtn11_12.setClickable(false);
        braillebtn12_12.setClickable(false);

        linear_touch2.setOnTouchListener(new View.OnTouchListener() {
            int flag = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                rect12_1.set(braillebtn1_12.getLeft() + linear_touch2_left.getLeft(), braillebtn1_12.getTop() + linear_touch2_enter.getTop(), braillebtn1_12.getRight() + linear_touch2_left.getLeft(), braillebtn1_12.getBottom() + linear_touch2_enter.getTop());
                rect12_2.set(braillebtn2_12.getLeft() + linear_touch2_left.getLeft(),  braillebtn2_12.getTop() + linear_touch2_2.getTop() + linear_touch2_enter.getTop(), braillebtn2_12.getRight() + linear_touch2_left.getLeft(), braillebtn2_12.getBottom() + linear_touch2_2.getTop() + linear_touch2_enter.getTop());
                rect12_3.set(braillebtn3_12.getLeft() + linear_touch2_left.getLeft(), braillebtn3_12.getTop() + linear_touch2_3.getTop() + linear_touch2_enter.getTop(), braillebtn3_12.getRight() + linear_touch2_left.getLeft(), braillebtn3_12.getBottom() + linear_touch2_3.getTop() + linear_touch2_enter.getTop());

                rect12_4.set(braillebtn4_12.getLeft() + linear_touch2_left.getLeft(), braillebtn4_12.getTop() + linear_touch2_enter.getTop(), braillebtn4_12.getRight() + linear_touch2_left.getLeft(), braillebtn4_12.getBottom() + + linear_touch2_enter.getTop());
                rect12_5.set(braillebtn5_12.getLeft() + linear_touch2_left.getLeft(), braillebtn5_12.getTop() + linear_touch2_enter.getTop() + linear_touch2_2.getTop(), braillebtn5_12.getRight() + linear_touch2_left.getLeft(), braillebtn5_12.getBottom() + linear_touch2_2.getTop() + linear_touch2_enter.getTop());
                rect12_6.set(braillebtn6_12.getLeft() + linear_touch2_left.getLeft(), braillebtn6_12.getTop() + linear_touch2_enter.getTop() + linear_touch2_3.getTop(), braillebtn6_12.getRight() + linear_touch2_left.getLeft(), braillebtn6_12.getBottom() + linear_touch2_3.getTop() + linear_touch2_enter.getTop());

                rect12_7.set(braillebtn1_12.getLeft() + linear_touch2_right.getLeft(), braillebtn1_12.getTop() + linear_touch2_enter.getTop(), braillebtn1_12.getRight() + linear_touch2_right.getLeft(), braillebtn1_12.getBottom() + linear_touch2_enter.getTop());
                rect12_8.set(braillebtn2_12.getLeft() + linear_touch2_right.getLeft(),  braillebtn2_12.getTop() + linear_touch2_2.getTop() + linear_touch2_enter.getTop(), braillebtn2_12.getRight() + linear_touch2_right.getLeft(), braillebtn2_12.getBottom() + linear_touch2_2.getTop() + linear_touch2_enter.getTop());
                rect12_9.set(braillebtn3_12.getLeft() + linear_touch2_right.getLeft(), braillebtn3_12.getTop() + linear_touch2_3.getTop() + linear_touch2_enter.getTop(), braillebtn3_12.getRight() + linear_touch2_right.getLeft(), braillebtn3_12.getBottom() + linear_touch2_3.getTop() + linear_touch2_enter.getTop());

                rect12_10.set(braillebtn4_12.getLeft() + linear_touch2_right.getLeft(), braillebtn4_12.getTop() + linear_touch2_enter.getTop(), braillebtn4_12.getRight() + linear_touch2_right.getLeft(), braillebtn4_12.getBottom() + + linear_touch2_enter.getTop());
                rect12_11.set(braillebtn5_12.getLeft() + linear_touch2_right.getLeft(), braillebtn5_12.getTop() + linear_touch2_enter.getTop() + linear_touch2_2.getTop(), braillebtn5_12.getRight() + linear_touch2_right.getLeft(), braillebtn5_12.getBottom() + linear_touch2_2.getTop() + linear_touch2_enter.getTop());
                rect12_12.set(braillebtn6_12.getLeft() + linear_touch2_right.getLeft(), braillebtn6_12.getTop() + linear_touch2_enter.getTop() + linear_touch2_3.getTop(), braillebtn6_12.getRight() + linear_touch2_right.getLeft(), braillebtn6_12.getBottom() + linear_touch2_3.getTop() + linear_touch2_enter.getTop());

                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {

                    if (rect12_1.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus1_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn1_12);
                                braille_12[0] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn1_12);
                                braille_12[0] = 0;
                            }

                            btnstatus1_12++;
                            flag = 1;
                        }
                    } else if (rect12_2.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus2_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn2_12);
                                braille_12[1] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn2_12);
                                braille_12[1] = 0;
                            }

                            btnstatus2_12++;
                            flag = 1;
                        }
                    } else if (rect12_3.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus3_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn3_12);
                                braille_12[2] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn3_12);
                                braille_12[2] = 0;
                            }

                            btnstatus3_12++;
                            flag = 1;
                        }
                    } else if (rect12_4.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus4_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn4_12);
                                braille_12[3] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn4_12);
                                braille_12[3] = 0;
                            }

                            btnstatus4_12++;
                            flag = 1;
                        }
                    } else if (rect12_5.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus5_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn5_12);
                                braille_12[4] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn5_12);
                                braille_12[4] = 0;
                            }

                            btnstatus5_12++;
                            flag = 1;
                        }
                    } else if (rect12_6.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus6_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn6_12);
                                braille_12[5] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn6_12);
                                braille_12[5] = 0;
                            }

                            btnstatus6_12++;
                            flag = 1;
                        }
                    } else if (rect12_7.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus7_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn7_12);
                                braille_12[6] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn7_12);
                                braille_12[6] = 0;
                            }

                            btnstatus7_12++;
                            flag = 1;
                        }
                    } else if (rect12_8.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus8_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn8_12);
                                braille_12[7] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn8_12);
                                braille_12[7] = 0;
                            }

                            btnstatus8_12++;
                            flag = 1;
                        }
                    } else if (rect12_9.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus9_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn9_12);
                                braille_12[8] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn9_12);
                                braille_12[8] = 0;
                            }

                            btnstatus9_12++;
                            flag = 1;
                        }
                    } else if (rect12_10.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus10_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn10_12);
                                braille_12[9] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn10_12);
                                braille_12[9] = 0;
                            }

                            btnstatus10_12++;
                            flag = 1;
                        }
                    } else if (rect12_11.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus11_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn11_12);
                                braille_12[10] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn11_12);
                                braille_12[10] = 0;
                            }

                            btnstatus11_12++;
                            flag = 1;
                        }
                    } else if (rect12_12.contains(event.getX(), event.getY())) {
                        if (flag == 0) {
                            if ((btnstatus12_12 % 2) == 0) {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn12_12);
                                braille_12[11] = 1;
                            } else {
                                Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn12_12);
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


        study_consonantinitial_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(braillestudyActivity.this).load(consonant_initial_imgs[consonantinitial_picturenum]).into(brailleImage);
                study_part.setText("초성자음");
                menu_type="초성자음";

                BtnEnableTrue();
            }
        });

        study_finalconsonantinitial_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(braillestudyActivity.this).load(finalconsonant_initial_imgs[finalconsonantinitial_picturenum]).into(brailleImage);
                study_part.setText("종성자음");
                menu_type="종성자음";

                BtnEnableTrue();

            }
        });


        study_vowel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(braillestudyActivity.this).load(vowel_imgs[vowel_picturenum]).into(brailleImage);
                study_part.setText("모음");
                menu_type="모음";

                BtnEnableTrue();

            }
        });

        study_alphabet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(braillestudyActivity.this).load(braille_alphabet_imgs[braille_alphabet_picturenum]).into(brailleImage);
                study_part.setText("알파벳");
                menu_type="알파벳";

                BtnEnableTrue();

            }
        });

        study_number_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(braillestudyActivity.this).load(braillenumber_imgs[braillenumber_picturenum]).into(brailleImage);
                study_part.setText("숫자");
                menu_type="숫자";

                BtnEnableTrue();

            }
        });



        study_abbreviation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(braillestudyActivity.this).load(braille_abbreviation_imgs[braille_abbreviation_picturenum]).into(brailleImage);
                study_part.setText("약자");
                menu_type="약자";

                BtnEnableTrue();

            }
        });

        btn_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if(menu_type=="")
                    btn_before.setEnabled(false);


                switch (menu_type){
                    case "초성자음":

                        if(consonantinitial_picturenum!=0)
                            consonantinitial_picturenum--;
                        Glide.with(braillestudyActivity.this).load(consonant_initial_imgs[consonantinitial_picturenum]).into(brailleImage);
                        break;

                    case "종성자음":

                        if(finalconsonantinitial_picturenum!=0)
                            finalconsonantinitial_picturenum--;
                        Glide.with(braillestudyActivity.this).load(finalconsonant_initial_imgs[finalconsonantinitial_picturenum]).into(brailleImage);
                        break;

                    case "모음":

                        if(vowel_picturenum!=0)
                            vowel_picturenum--;
                        Glide.with(braillestudyActivity.this).load(vowel_imgs[vowel_picturenum]).into(brailleImage);
                        break;

                    case "숫자":

                        if(braillenumber_picturenum!=0)
                            braillenumber_picturenum--;
                        Glide.with(braillestudyActivity.this).load(braillenumber_imgs[braillenumber_picturenum]).into(brailleImage);
                        break;


                    case "약자":

                        if(braille_abbreviation_picturenum!=0)
                            braille_abbreviation_picturenum--;
                        Glide.with(braillestudyActivity.this).load(braille_abbreviation_imgs[braille_abbreviation_picturenum]).into(brailleImage);
                        break;

                    case "알파벳":

                        if(braille_alphabet_picturenum!=0)
                            braille_alphabet_picturenum--;
                        Glide.with(braillestudyActivity.this).load(braille_alphabet_imgs[braille_alphabet_picturenum]).into(brailleImage);
                        break;


                    default:
                        Toast.makeText(braillestudyActivity.this,"타입을 눌러주세요",Toast.LENGTH_SHORT).show();


                }

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(menu_type=="")
                    btn_next.setEnabled(false);

                switch (menu_type){
                    case "초성자음":

                        if(consonantinitial_picturenum!=12)
                            consonantinitial_picturenum++;
                        Glide.with(braillestudyActivity.this).load(consonant_initial_imgs[consonantinitial_picturenum]).into(brailleImage);
                        break;


                    case "종성자음":

                        if(finalconsonantinitial_picturenum!=13)
                            finalconsonantinitial_picturenum++;
                        Glide.with(braillestudyActivity.this).load(finalconsonant_initial_imgs[finalconsonantinitial_picturenum]).into(brailleImage);
                        break;

                    case "모음":

                        if(vowel_picturenum!=16)
                            vowel_picturenum++;
                        Glide.with(braillestudyActivity.this).load(vowel_imgs[vowel_picturenum]).into(brailleImage);
                        break;

                    case "숫자":

                        if(braillenumber_picturenum!=9)
                            braillenumber_picturenum++;
                        Glide.with(braillestudyActivity.this).load(braillenumber_imgs[braillenumber_picturenum]).into(brailleImage);
                        break;


                    case "약자":

                        if(braille_abbreviation_picturenum!=23)
                            braille_abbreviation_picturenum++;
                        Glide.with(braillestudyActivity.this).load(braille_abbreviation_imgs[braille_abbreviation_picturenum]).into(brailleImage);
                        break;

                    case "알파벳":

                        if(braille_alphabet_picturenum!=25)
                            braille_alphabet_picturenum++;
                        Glide.with(braillestudyActivity.this).load(braille_alphabet_imgs[braille_alphabet_picturenum]).into(brailleImage);
                        break;


                    default:
                        Toast.makeText(braillestudyActivity.this,"타입을 눌러주세요",Toast.LENGTH_SHORT).show();

                }

            }
        });

        //확인
        result_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (menu_type){
                    case "초성자음":

                        switch (consonantinitial_picturenum){
                            //ㄱ
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
                        break;

                    case "종성자음":

                        switch (finalconsonantinitial_picturenum){
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

                        break;

                    case "모음":
                        switch (vowel_picturenum){
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

                        break;

                    case "알파벳":
                        switch (braille_alphabet_picturenum){
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

                        break;

                    case "약자":
                        switch (braille_abbreviation_picturenum){
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

                        break;


                    case "숫자":

                        switch (braillenumber_picturenum){
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

                        break;

                    default:
                        Toast.makeText(braillestudyActivity.this,"타입을 눌러주세요",Toast.LENGTH_SHORT).show();


                }

            }
        });


        study_abbreviation_btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(braillestudyActivity.this).load(braille_abbreviation12_imgs[braille_abbreviation12_picturenum]).into(brailleImage_12);
                stduy_part_12.setText("약자");
                menu_type_12="약자";

                BtnEnableTure_12();

            }
        });

        study_consonantinitial_btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(braillestudyActivity.this).load(consonant_initial12_imgs[consonantinitial12_picturenum]).into(brailleImage_12);
                stduy_part_12.setText("초성자음");
                menu_type_12="초성자음";

                BtnEnableTure_12();

            }
        });

        study_vowel_btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(braillestudyActivity.this).load(vowel12_imgs[vowel12_picturenum]).into(brailleImage_12);
                stduy_part_12.setText("모음");
                menu_type_12="모음";

                BtnEnableTure_12();
            }
        });

        study_alphabet_btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(braillestudyActivity.this).load(braille_alphabet12_imgs[braille_alphabet12_picturenum]).into(brailleImage_12);
                stduy_part_12.setText("대문자");
                menu_type_12="대문자";

                BtnEnableTure_12();
            }
        });

        btn_before_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (menu_type_12 == "")
                    btn_before_12.setEnabled(false);


                switch (menu_type_12) {

                    case "초성자음":

                        if(consonantinitial12_picturenum!=0)
                            consonantinitial12_picturenum--;
                        Glide.with(braillestudyActivity.this).load(consonant_initial12_imgs[consonantinitial12_picturenum]).into(brailleImage_12);
                        break;

                    case "모음":
                        if(vowel12_picturenum!=0)
                            vowel12_picturenum--;
                        Glide.with(braillestudyActivity.this).load(vowel12_imgs[vowel12_picturenum]).into(brailleImage_12);
                        break;

                    case "대문자":
                        if(braille_alphabet12_picturenum!=0)
                            braille_alphabet12_picturenum--;
                        Glide.with(braillestudyActivity.this).load(braille_alphabet12_imgs[braille_alphabet12_picturenum]).into(brailleImage_12);
                        break;

                    case "약자":

                        if(braille_abbreviation12_picturenum!=0)
                            braille_abbreviation12_picturenum--;
                        Glide.with(braillestudyActivity.this).load(braille_abbreviation12_imgs[braille_abbreviation12_picturenum]).into(brailleImage_12);
                        break;


                    default:
                        Toast.makeText(braillestudyActivity.this,"타입을 눌러주세요",Toast.LENGTH_SHORT).show();

                }
            }
        });

        btn_next_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (menu_type_12=="")
                    btn_before_12.setEnabled(false);

                switch (menu_type_12) {

                    case "초성자음":

                        if(consonantinitial12_picturenum!=4)
                            consonantinitial12_picturenum++;
                        Glide.with(braillestudyActivity.this).load(consonant_initial12_imgs[consonantinitial12_picturenum]).into(brailleImage_12);
                        break;

                    case "모음":
                        if(vowel12_picturenum!=3)
                            vowel12_picturenum++;
                        Glide.with(braillestudyActivity.this).load(vowel12_imgs[vowel12_picturenum]).into(brailleImage_12);
                        break;

                    case "대문자":
                        if(braille_alphabet12_picturenum!=25)
                            braille_alphabet12_picturenum++;
                        Glide.with(braillestudyActivity.this).load(braille_alphabet12_imgs[braille_alphabet12_picturenum]).into(brailleImage_12);
                        break;

                    case "약자":

                        if(braille_abbreviation12_picturenum!=6)
                            braille_abbreviation12_picturenum++;
                        Glide.with(braillestudyActivity.this).load(braille_abbreviation12_imgs[braille_abbreviation12_picturenum]).into(brailleImage_12);
                        break;

                    default:
                        Toast.makeText(braillestudyActivity.this,"타입을 눌러주세요",Toast.LENGTH_SHORT).show();

                }
            }
        });
    /*
        if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==0
                &&braille_12[6]==0&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==0)
            braillebtn_false_ok_12();
        else
            braillebtn_false_no_12();
        break;
    */
        result_send_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (menu_type_12) {

                    case "초성자음":

                        switch (consonantinitial12_picturenum){
                            //ㄲ
                            case 0:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //ㄸ
                            case 1:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //ㅃ
                            case 2:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //ㅆ
                            case 3:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //ㅉ
                            case 4:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;

                            default:
                                Toast.makeText(braillestudyActivity.this,"타입을 눌러주세요",Toast.LENGTH_SHORT).show();

                        }

                        break;

                    case "모음":
                        switch (vowel12_picturenum){
                            //ㅟ
                            case 0:
                                if(braille_12[0]==1&&braille_12[1]==0&&braille_12[2]==1&&braille_12[3]==1&&braille_12[4]==0&&braille_12[5]==0
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //ㅒ
                            case 1:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==1&&braille_12[3]==1&&braille_12[4]==1&&braille_12[5]==0
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //ㅙ
                            case 2:
                                if(braille_12[0]==1&&braille_12[1]==1&&braille_12[2]==1&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;

                            //ㅞ
                            case 3:
                                if(braille_12[0]==1&&braille_12[1]==1&&braille_12[2]==1&&braille_12[3]==1&&braille_12[4]==0&&braille_12[5]==0
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                        }

                        break;

                    case "대문자":
                        switch (braille_alphabet12_picturenum){
                            //A
                            case 0:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //B
                            case 1:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //C
                            case 2:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //D
                            case 3:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //E
                            case 4:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //F
                            case 5:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //G
                            case 6:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //H
                            case 7:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //I
                            case 8:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //J
                            case 9:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //K
                            case 10:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //L
                            case 11:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //M
                            case 12:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //N
                            case 13:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //O
                            case 14:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //P
                            case 15:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //Q
                            case 16:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //R
                            case 17:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //S
                            case 18:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //T
                            case 19:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //U
                            case 20:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //V
                            case 21:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==1&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //W
                            case 22:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==0&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //X
                            case 23:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //Y
                            case 24:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //Z
                            case 25:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==1
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;

                        }
                        break;

                    case "약자":

                        switch (braille_abbreviation12_picturenum){
                            //그래서
                            case 0:
                                if(braille_12[0]==1&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==0
                                        &&braille_12[6]==0&&braille_12[7]==1 &&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //그러나
                            case 1:
                                if(braille_12[0]==1&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==0
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==1&&braille_12[10]==0&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //그러면
                            case 2:
                                if(braille_12[0]==1&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==0
                                        &&braille_12[6]==0&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //그러므로
                            case 3:
                                if(braille_12[0]==1&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==0
                                        &&braille_12[6]==0&&braille_12[7]==1&&braille_12[8]==0&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //그런데
                            case 4:
                                if(braille_12[0]==1&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==0
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==1&&braille_12[10]==1&&braille_12[11]==0)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //그리고
                            case 5:
                                if(braille_12[0]==1&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==0
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==1&&braille_12[9]==0&&braille_12[10]==0&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;
                            //그리하여
                            case 6:
                                if(braille_12[0]==0&&braille_12[1]==0&&braille_12[2]==0&&braille_12[3]==0&&braille_12[4]==0&&braille_12[5]==0
                                        &&braille_12[6]==1&&braille_12[7]==0&&braille_12[8]==0&&braille_12[9]==0&&braille_12[10]==1&&braille_12[11]==1)
                                    braillebtn_false_ok_12();
                                else
                                    braillebtn_false_no_12();
                                break;

                            default:
                                Toast.makeText(braillestudyActivity.this,"타입을 눌러주세요",Toast.LENGTH_SHORT).show();


                        }

                        break;

                    default:
                        Toast.makeText(braillestudyActivity.this,"타입을 눌러주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    //tts
    @Override
    public void onInit(int status) {

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.not_move_activit,R.anim.leftout_activity);

    }

    public void BtnEnableTure_12(){
        btn_before_12.setEnabled(true);
        btn_next_12.setEnabled(true);
    }

    public void BtnEnableTrue(){
        btn_before.setEnabled(true);
        btn_next.setEnabled(true);
    }


    public void braillebtn_false_ok_12(){

        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn1_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn2_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn3_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn4_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn5_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn6_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn7_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn8_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn9_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn10_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn11_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn12_12);

        btnstatus2_12 = 0;
        btnstatus1_12 = 0;
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

        Glide.with(braillestudyActivity.this).load(R.drawable.resultok).into(studyresult_12_picture);
        ttsClient.speak("정답", TextToSpeech.QUEUE_FLUSH, null);

    }
    public void braillebtn_false_ok(){

        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn1);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn2);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn3);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn4);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn5);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn6);

        btnstatus1=0;
        btnstatus2=0;
        btnstatus3=0;
        btnstatus4=0;
        btnstatus5=0;
        btnstatus6=0;
        braille[0]=0;
        braille[1]=0;
        braille[2]=0;
        braille[3]=0;
        braille[4]=0;
        braille[5]=0;

        Glide.with(braillestudyActivity.this).load(R.drawable.resultok).into(studyresultpicture);
        ttsClient.speak("정답", TextToSpeech.QUEUE_FLUSH, null);
    }

    public void braillebtn_false_no_12(){

        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn1_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn2_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn3_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn4_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn5_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn6_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn7_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn8_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn9_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn10_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn11_12);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn12_12);

        btnstatus2_12 = 0;
        btnstatus1_12 = 0;
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

        Glide.with(braillestudyActivity.this).load(R.drawable.resultno).into(studyresult_12_picture);
        ttsClient.speak("오답", TextToSpeech.QUEUE_FLUSH, null);

    }

    public void braillebtn_false_no(){

        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn1);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn2);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn3);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn4);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn5);
        Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn6);
        btnstatus1=0;
        btnstatus2=0;
        btnstatus3=0;
        btnstatus4=0;
        btnstatus5=0;
        btnstatus6=0;

        braille[0]=0;
        braille[1]=0;
        braille[2]=0;
        braille[3]=0;
        braille[4]=0;
        braille[5]=0;

        Glide.with(braillestudyActivity.this).load(R.drawable.resultno).into(studyresultpicture);
        ttsClient.speak("오답", TextToSpeech.QUEUE_FLUSH, null);

    }

}