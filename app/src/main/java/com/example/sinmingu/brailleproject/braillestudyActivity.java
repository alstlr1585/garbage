package com.example.sinmingu.brailleproject;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static java.lang.System.exit;

public class braillestudyActivity extends FragmentActivity {

    Button study1_consonantinitial_btn,btn_before, btn_next,result_send;
    ImageButton braillebtn1,braillebtn2,braillebtn3,braillebtn4,braillebtn5,braillebtn6;
    int btnstatus1, btnstatus2, btnstatus3, btnstatus4, btnstatus5, btnstatus6;
    TextView studyresult;
    ImageView consonant_initial1,studyresultpicture;
    int picturenum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braillestudy);

        study1_consonantinitial_btn=(Button)findViewById(R.id.study1_consonantinitial_btn);

        btnstatus1=0;
        btnstatus2=0;
        btnstatus3=0;
        btnstatus4=0;
        btnstatus5=0;
        btnstatus6=0;
        picturenum=1;

        braillebtn1=(ImageButton)findViewById(R.id.braillebtn1);
        braillebtn2=(ImageButton)findViewById(R.id.braillebtn2);
        braillebtn3=(ImageButton)findViewById(R.id.braillebtn3);
        braillebtn4=(ImageButton)findViewById(R.id.braillebtn4);
        braillebtn5=(ImageButton)findViewById(R.id.braillebtn5);
        braillebtn6=(ImageButton)findViewById(R.id.braillebtn6);

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

        Glide.with(this).load(R.drawable.consonant_initial_1).into(consonant_initial1);


        Glide.with(this).load(R.drawable.resultok).into(studyresultpicture);

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


        study1_consonantinitial_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }


        });

        braillebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus1%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn1);
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn1);
                }

                btnstatus1++;
            }
        });

        braillebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus2%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn2);
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn2);
                }

                btnstatus2++;
            }
        });

        braillebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus3%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn3);
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn3);
                }

                btnstatus3++;
            }
        });

        braillebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus4%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn4);
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn4);
                }

                btnstatus4++;
            }
        });

        braillebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus5%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn5);
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn5);
                }

                btnstatus5++;
            }
        });

        braillebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((btnstatus6%2)==0){
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_true).into(braillebtn6);
                }
                else {
                    Glide.with(braillestudyActivity.this).load(R.drawable.braillebtn_false).into(braillebtn6);
                }

                btnstatus6++;
            }
        });







    }

}