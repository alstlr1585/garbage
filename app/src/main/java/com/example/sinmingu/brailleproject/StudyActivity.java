package com.example.sinmingu.brailleproject;


import android.content.Intent;
import android.media.Image;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class StudyActivity extends BaseActivity {

    Button btntable, btnstudy;
    ImageView studyimage1, studyimage2,studyimagetop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        btntable=(Button)findViewById(R.id.btntable);
        btnstudy=(Button)findViewById(R.id.btnstudy);
        studyimage1=(ImageView)findViewById(R.id.studyimage1);
        studyimage2=(ImageView)findViewById(R.id.studyimage2);
        studyimagetop=(ImageView)findViewById(R.id.studyimagetop);

        Glide.with(this).load(R.drawable.study_brailleview).into(studyimage1);
        Glide.with(this).load(R.drawable.study_write).into(studyimage2);
        Glide.with(this).load(R.drawable.study_top).into(studyimagetop);

        btntable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudyActivity.this,brailletableActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.leftin_activity,R.anim.not_move_activit);
            }
        });

        btnstudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudyActivity.this, braillestudyActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.leftin_activity,R.anim.not_move_activit);
            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.not_move_activit,R.anim.leftout_activity);

    }
}

