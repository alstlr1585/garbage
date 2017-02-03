package com.example.sinmingu.brailleproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class MainActivity extends BaseActivity {

    private BackPressCloseHandler backPressCloseHandler;

    View dialogView;


    Button btn_Translation, btn_BackTranslation, btn_Study, btn_Quiz;

    ImageButton btn_Brailleinfor,btn_Braillesite, btn_Brailletable, btn_Brraillehistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backPressCloseHandler = new BackPressCloseHandler(this);





        //번역, 역번역, 학습, 퀴즈 버튼
        btn_Translation=(Button)findViewById(R.id.btn_Translation);
        btn_BackTranslation=(Button)findViewById(R.id.btn_BackTranslation);
        btn_Study=(Button)findViewById(R.id.btn_Study);
        btn_Quiz=(Button)findViewById(R.id.btn_Quiz);


        //점자란, 점자역사, 점자세상, 점자표 버튼
        btn_Brailleinfor=(ImageButton) findViewById(R.id.btn_Brabilleinfo);
        btn_Braillesite=(ImageButton)findViewById(R.id.btn_Braillesite);
        btn_Brailletable=(ImageButton)findViewById(R.id.btn_Brailltable);
        btn_Brraillehistory=(ImageButton)findViewById(R.id.btn_Braillehistory);

        Glide.with(this).load(R.drawable.mainbailleinfor).fitCenter().into(btn_Brailleinfor);
        Glide.with(this).load(R.drawable.mainbraillesite).fitCenter().into(btn_Braillesite);
        Glide.with(this).load(R.drawable.mainbraille_table).fitCenter().into(btn_Brailletable);
        Glide.with(this).load(R.drawable.mainbraillehistory).fitCenter().into(btn_Brraillehistory);






        //번역기능
        btn_Translation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,translationActivity.class);
                startActivity(intent);

            }
        });

        //역변역기능
        btn_BackTranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,backtranslationActivity.class);
                startActivity(intent);

            }
        });

        //학습기능
        btn_Study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,StudyActivity.class);
                startActivity(intent);

            }
        });


        //퀴즈기능
        btn_Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,QuizActivity.class);
                startActivity(intent);

            }
        });


        //점자란
        btn_Brailleinfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View)View.inflate(MainActivity.this,R.layout.brailleinfor,null);
                AlertDialog.Builder dlg= new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("점자란");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();
            }
        });


        //점자표
        btn_Brailletable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = (View)View.inflate(MainActivity.this,R.layout.brailletable,null);
                AlertDialog.Builder dlg= new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("점자표");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();

            }
        });

        //점자역사
        btn_Brraillehistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = (View)View.inflate(MainActivity.this,R.layout.brailehistory,null);
                AlertDialog.Builder dlg= new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("점자역사");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();

            }
        });


        //점자세상
        btn_Braillesite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View)View.inflate(MainActivity.this,R.layout.braillesite,null);
                AlertDialog.Builder dlg= new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("점자세상");
                dlg.setView(dialogView);
                dlg.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.setNegativeButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.braillekorea.org/"));
                        startActivity(intent);
                    }
                });
                dlg.show();

            }
        });

    }



    // 두번 클릭시 종료

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        backPressCloseHandler.onBackPressed();

    }

}
