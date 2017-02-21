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
    ImageView consonant_initial1,studyresultpicture;
    Button study_consonantinitial_btn, study_finalconsonantinitial_btn, study_vowel_btn;
    int consonantinitial_picturenum;
    int[] consonant_initial_imgs = {R.drawable.consonant_initial_1,R.drawable.consonant_initial_2,R.drawable.consonant_initial_3,
            R.drawable.consonant_initial_4,R.drawable.consonant_initial_5,R.drawable.consonant_initial_6};
    int braille[];
    String menu_type;

    private TextToSpeech ttsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braillestudy);

        study_part=(TextView)findViewById(R.id.stduy_part);

        ttsClient= new TextToSpeech(getApplicationContext(),this);

        btnstatus1=0;
        btnstatus2=0;
        btnstatus3=0;
        btnstatus4=0;
        btnstatus5=0;
        btnstatus6=0;
        consonantinitial_picturenum=0;
        braille=new int[6];

        braillebtn1=(ImageButton)findViewById(R.id.braillebtn1);
        braillebtn2=(ImageButton)findViewById(R.id.braillebtn2);
        braillebtn3=(ImageButton)findViewById(R.id.braillebtn3);
        braillebtn4=(ImageButton)findViewById(R.id.braillebtn4);
        braillebtn5=(ImageButton)findViewById(R.id.braillebtn5);
        braillebtn6=(ImageButton)findViewById(R.id.braillebtn6);

        study_consonantinitial_btn=(Button)findViewById(R.id.study_consonantinitial_btn);
        study_finalconsonantinitial_btn=(Button)findViewById(R.id.study_finalconsonantinitial_btn);
        study_vowel_btn=(Button)findViewById(R.id.study_vowel_btn);

        btn_before=(Button)findViewById(R.id.btn_before);
        btn_next=(Button)findViewById(R.id.btn_next);
        result_send=(Button)findViewById(R.id.result_send);

        studyresult=(TextView)findViewById(R.id.textView);
        studyresultpicture=(ImageView)findViewById(R.id.studyresultpicture);

        consonant_initial1=(ImageView)findViewById(R.id.consonant_initial1);

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

                Glide.with(braillestudyActivity.this).load(consonant_initial_imgs[consonantinitial_picturenum]).into(consonant_initial1);
                study_part.setText("초성자음");
                menu_type="초성자음";

            }
        });






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

                switch (menu_type){
                    case "초성자음":

                        if(consonantinitial_picturenum!=0)
                            consonantinitial_picturenum--;
                        Glide.with(braillestudyActivity.this).load(consonant_initial_imgs[consonantinitial_picturenum]).into(consonant_initial1);



                    case "종성자음":

                        break;

                    case "모음":

                        break;

                    default:

                }

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (menu_type){
                    case "초성자음":

                        if(consonantinitial_picturenum!=5)
                            consonantinitial_picturenum++;
                        Glide.with(braillestudyActivity.this).load(consonant_initial_imgs[consonantinitial_picturenum]).into(consonant_initial1);
                        break;


                    case "종성자음":

                        break;

                    case "모음":

                        break;

                    default:

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

}