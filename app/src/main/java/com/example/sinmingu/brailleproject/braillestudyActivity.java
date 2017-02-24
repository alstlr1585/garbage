package com.example.sinmingu.brailleproject;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static java.lang.System.exit;

public class braillestudyActivity extends BaseActivity implements TextToSpeech.OnInitListener{

    Button btn_before, btn_next,result_send;
    ImageButton braillebtn1,braillebtn2,braillebtn3,braillebtn4,braillebtn5,braillebtn6;
    int btnstatus1, btnstatus2, btnstatus3, btnstatus4, btnstatus5, btnstatus6;
    TextView studyresult,study_part;
    ImageView brailleImage,studyresultpicture;
    Button study_consonantinitial_btn, study_finalconsonantinitial_btn, study_vowel_btn, study_alphabet_btn, study_number_btn,
            study_conjunction_btn, study_abbreviation_btn;
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

    int[] brailleconjunction_imgs={R.drawable.braille_conjunction_1,R.drawable.braille_conjunction_2,R.drawable.braille_conjunction_3,R.drawable.braille_conjunction_4,
            R.drawable.braille_conjunction_5,R.drawable.braille_conjunction_6,R.drawable.braille_conjunction_7,R.drawable.braille_conjunction_8,R.drawable.braille_conjunction_9,
            R.drawable.braille_conjunction_10,R.drawable.braille_conjunction_11,R.drawable.braille_conjunction_12,R.drawable.braille_conjunction_13,R.drawable.braille_conjunction_14,
            R.drawable.braille_conjunction_15,R.drawable.braille_conjunction_16,R.drawable.braille_conjunction_17,R.drawable.braille_conjunction_18};

    int [] braille_abbreviation_imgs={R.drawable.braille_abbreviation_1,R.drawable.braille_abbreviation_2,R.drawable.braille_abbreviation_3,R.drawable.braille_abbreviation_4,
            R.drawable.braille_abbreviation_5,R.drawable.braille_abbreviation_6,R.drawable.braille_abbreviation_7,R.drawable.braille_abbreviation_8,R.drawable.braille_abbreviation_9,
            R.drawable.braille_abbreviation_10,R.drawable.braille_abbreviation_11,R.drawable.braille_abbreviation_12,R.drawable.braille_abbreviation_13,R.drawable.braille_abbreviation_14,
            R.drawable.braille_abbreviation_15,R.drawable.braille_abbreviation_16,R.drawable.braille_abbreviation_17,R.drawable.braille_abbreviation_18,R.drawable.braille_abbreviation_19,
            R.drawable.braille_abbreviation_20,R.drawable.braille_abbreviation_21,R.drawable.braille_abbreviation_22,R.drawable.braille_abbreviation_23,R.drawable.braille_abbreviation_24,
            R.drawable.braille_abbreviation_25,R.drawable.braille_abbreviation_26};

    int [] braille_alphabet_imgs={R.drawable.braille_alphabet_1,R.drawable.braille_alphabet_2,R.drawable.braille_alphabet_3,R.drawable.braille_alphabet_4,R.drawable.braille_alphabet_5,
            R.drawable.braille_alphabet_6,R.drawable.braille_alphabet_7,R.drawable.braille_alphabet_8,R.drawable.braille_alphabet_9,R.drawable.braille_alphabet_10,R.drawable.braille_alphabet_11,
            R.drawable.braille_alphabet_12,R.drawable.braille_alphabet_13,R.drawable.braille_alphabet_14,R.drawable.braille_alphabet_15,R.drawable.braille_alphabet_16,R.drawable.braille_alphabet_17,
            R.drawable.braille_alphabet_18,R.drawable.braille_alphabet_19,R.drawable.braille_alphabet_20,R.drawable.braille_alphabet_21,R.drawable.braille_alphabet_22,R.drawable.braille_alphabet_23,
            R.drawable.braille_alphabet_24,R.drawable.braille_alphabet_25,R.drawable.braille_alphabet_26};

    int braille[];
    String menu_type;
    private TextToSpeech ttsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braillestudy);

        study_part=(TextView)findViewById(R.id.stduy_part);

        ttsClient= new TextToSpeech(getApplicationContext(),this);

        menu_type="";

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
        braille_conjunction_picturenum=0;
        braille_abbreviation_picturenum=0;
        braille_alphabet_picturenum=0;
        braille=new int[6];

        braillebtn1=(ImageButton)findViewById(R.id.braillebtn1);
        braillebtn2=(ImageButton)findViewById(R.id.braillebtn2);
        braillebtn3=(ImageButton)findViewById(R.id.braillebtn3);
        braillebtn4=(ImageButton)findViewById(R.id.braillebtn4);
        braillebtn5=(ImageButton)findViewById(R.id.braillebtn5);
        braillebtn6=(ImageButton)findViewById(R.id.braillebtn6);

        //초급 버튼
        study_consonantinitial_btn=(Button)findViewById(R.id.study_consonantinitial_btn);
        study_finalconsonantinitial_btn=(Button)findViewById(R.id.study_finalconsonantinitial_btn);
        study_vowel_btn=(Button)findViewById(R.id.study_vowel_btn);
        study_abbreviation_btn=(Button)findViewById(R.id.study_abbreviation_btn);
        study_alphabet_btn=(Button)findViewById(R.id.study_alphabet_btn);
        study_conjunction_btn=(Button)findViewById(R.id.study_conjunction_btn);
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
        tabSpec1.setIndicator("초급"); // Tab Subject
        tabSpec1.setContent(R.id.tab_view1); // Tab Content
        tabHost.addTab(tabSpec1);
        // Tab2 Setting
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");
        tabSpec2.setIndicator("중급"); // Tab Subject
        tabSpec2.setContent(R.id.tab_view2); // Tab Content
        tabHost.addTab(tabSpec2);
        // Tab3 Setting
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab3");
        tabSpec3.setIndicator("고급"); // Tab Subject
        tabSpec3.setContent(R.id.tab_view3); // Tab Content
        tabHost.addTab(tabSpec3);
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

                Glide.with(braillestudyActivity.this).load(braillenumber_imgs[vowel_picturenum]).into(brailleImage);
                study_part.setText("숫자");
                menu_type="숫자";

                BtnEnableTrue();

            }
        });

        study_conjunction_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(braillestudyActivity.this).load(brailleconjunction_imgs[braille_conjunction_picturenum]).into(brailleImage);
                study_part.setText("접속사");
                menu_type="접속사";

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

        //점자 1번 클릭
        braillebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus1%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn1);
                    braille[0]=1;
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn1);
                    braille[0]=0;
                }

                btnstatus1++;
            }
        });

        //점자 2번 클릭
        braillebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus2%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn2);
                    braille[1]=1;
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn2);
                    braille[1]=0;
                }

                btnstatus2++;
            }
        });

        //점자 3번 클릭
        braillebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus3%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn3);
                    braille[2]=1;
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn3);
                    braille[2]=0;
                }

                btnstatus3++;
            }
        });

        //점자 4번 클릭
        braillebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus4%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn4);
                    braille[3]=1;
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn4);
                    braille[3]=0;
                }

                btnstatus4++;
            }
        });

        //점자 5번 클릭
        braillebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus5%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn5);
                    braille[4]=1;
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn5);
                    braille[4]=0;
                }

                btnstatus5++;
            }
        });

        //점자 6번 클릭
        braillebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus6%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn6);
                    braille[5]=1;
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn6);
                    braille[5]=0;
                }

                btnstatus6++;
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

                    case "접속사":

                        if(braille_conjunction_picturenum!=0)
                            braille_conjunction_picturenum--;
                        Glide.with(braillestudyActivity.this).load(brailleconjunction_imgs[braille_conjunction_picturenum]).into(brailleImage);
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

                        if(vowel_picturenum!=24)
                            vowel_picturenum++;
                        Glide.with(braillestudyActivity.this).load(vowel_imgs[vowel_picturenum]).into(brailleImage);
                        break;

                    case "숫자":

                        if(braillenumber_picturenum!=9)
                            braillenumber_picturenum++;
                        Glide.with(braillestudyActivity.this).load(braillenumber_imgs[braillenumber_picturenum]).into(brailleImage);
                        break;

                    case "접속사":

                        if(braille_conjunction_picturenum!=17)
                            braille_conjunction_picturenum++;
                        Glide.with(braillestudyActivity.this).load(brailleconjunction_imgs[braille_conjunction_picturenum]).into(brailleImage);
                        break;

                    case "약자":

                        if(braille_abbreviation_picturenum!=25)
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

        result_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (menu_type){
                    case "초성자음":

                        switch (consonantinitial_picturenum){

                            case 0:
                                if(braille[0]==0&&braille[1]==0&&braille[2]==0&&braille[3]==1&&braille[4]==0&&braille[5]==0) {
                                    Glide.with(braillestudyActivity.this).load(R.drawable.resultok).into(studyresultpicture);
                                    ttsClient.speak("정답", TextToSpeech.QUEUE_FLUSH, null);
                                }
                                else {
                                    Glide.with(braillestudyActivity.this).load(R.drawable.resultno).into(studyresultpicture);
                                    ttsClient.speak("오답", TextToSpeech.QUEUE_FLUSH, null);
                                }
                                break;

                            default:

                        }
                        break;

                    case "종성자음":

                        break;

                    case "모음":

                        break;

                    case "알파벳":

                        break;

                    case "약자":

                        break;

                    case "접속사":

                        break;

                    case "숫자":

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

    public void BtnEnableTrue(){
        btn_before.setEnabled(true);
        btn_next.setEnabled(true);
    }

}