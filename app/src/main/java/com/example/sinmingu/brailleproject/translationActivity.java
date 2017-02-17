package com.example.sinmingu.brailleproject;


import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class translationActivity extends BaseActivity {

    ImageButton translation_braillebtn1, translation_braillebtn2, translation_braillebtn3, translation_braillebtn4,
            translation_braillebtn5,translation_braillebtn6;
    //이미지뷰
    ImageView pencil_picture;

    int translation_btnstatus1, translation_btnstatus2, translation_btnstatus3, translation_btnstatus4, translation_btnstatus5, translation_btnstatus6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        translation_btnstatus1=0;
        translation_btnstatus2=0;
        translation_btnstatus3=0;
        translation_btnstatus4=0;
        translation_btnstatus5=0;
        translation_btnstatus6=0;

        translation_braillebtn1=(ImageButton) findViewById(R.id.translation_braillebtn1);
        translation_braillebtn2=(ImageButton) findViewById(R.id.translation_braillebtn2);
        translation_braillebtn3=(ImageButton) findViewById(R.id.translation_braillebtn3);
        translation_braillebtn4=(ImageButton) findViewById(R.id.translation_braillebtn4);
        translation_braillebtn5=(ImageButton) findViewById(R.id.translation_braillebtn5);
        translation_braillebtn6=(ImageButton) findViewById(R.id.translation_braillebtn6);

        pencil_picture=(ImageView)findViewById(R.id.pencil_pucture);

        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn1);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn2);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn3);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn4);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn5);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn6);

        Glide.with(this).load(R.drawable.pencil).into(pencil_picture);

        translation_braillebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus1%2==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn1);
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn1);
                }

                translation_btnstatus1++;

            }
        });

        translation_braillebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus2%2==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn2);
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn2);
                }

                translation_btnstatus2++;

            }
        });

        translation_braillebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus3%2==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn3);
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn3);
                }

                translation_btnstatus3++;

            }
        });

        translation_braillebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus4%2==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn4);
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn4);
                }

                translation_btnstatus4++;

            }
        });

        translation_braillebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus5%2==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn5);
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn5);
                }

                translation_btnstatus5++;

            }
        });

        translation_braillebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus6%2==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn6);
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn6);
                }

                translation_btnstatus6++;

            }
        });


    }


}
