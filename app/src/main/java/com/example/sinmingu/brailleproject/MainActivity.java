package com.example.sinmingu.brailleproject;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import org.w3c.dom.Text;
import static com.example.sinmingu.brailleproject.R.id.infor1;

public class MainActivity extends BaseActivity {

    private BackPressCloseHandler backPressCloseHandler;

    View dialogView;
    TextView text_brailleinfor;
    ImageButton btn_Translation, btn_BackTranslation, btn_Study, btn_Quiz;
    ImageButton btn_Brailleinfor,btn_Braillesite, btn_Brailletable, btn_Brraillehistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backPressCloseHandler = new BackPressCloseHandler(this);

        /* 특정 텍스트뷰 글씨 바꾸기
        text_brailleinfor=(TextView)findViewById(R.id.text_brailleinfor);
        Typeface font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/BMJUA_ttf.ttf");
        text_brailleinfor.setTypeface(font);
        */
        //번역, 역번역, 학습, 퀴즈 버튼
        btn_Translation=(ImageButton)findViewById(R.id.btn_Translation);
        btn_BackTranslation=(ImageButton)findViewById(R.id.btn_BackTranslation);
        btn_Study=(ImageButton)findViewById(R.id.btn_Study);
        btn_Quiz=(ImageButton)findViewById(R.id.btn_Quiz);

        //점자란, 점자역사, 점자세상, 점자표 버튼
        btn_Brailleinfor=(ImageButton) findViewById(R.id.btn_Brabilleinfo);
        btn_Braillesite=(ImageButton)findViewById(R.id.btn_Braillesite);
        btn_Brailletable=(ImageButton)findViewById(R.id.btn_Brailltable);
        btn_Brraillehistory=(ImageButton)findViewById(R.id.btn_Braillehistory);

        Glide.with(this).load(R.drawable.main_infor).fitCenter().into(btn_Brailleinfor);
        Glide.with(this).load(R.drawable.main_site).fitCenter().into(btn_Braillesite);
        Glide.with(this).load(R.drawable.main_table).fitCenter().into(btn_Brailletable);
        Glide.with(this).load(R.drawable.main_history).fitCenter().into(btn_Brraillehistory);

        Glide.with(this).load(R.drawable.main_move_1).fitCenter().into(btn_Translation);
        Glide.with(this).load(R.drawable.main_move_2).fitCenter().into(btn_BackTranslation);
        Glide.with(this).load(R.drawable.main_move_3).fitCenter().into(btn_Study);
        Glide.with(this).load(R.drawable.main_move_4).fitCenter().into(btn_Quiz);

        //번역기능
        btn_Translation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,StudyActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.leftin_activity,R.anim.not_move_activit);


            }
        });

        //역변역기능
        btn_BackTranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,backtranslationActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.rightin_activity,R.anim.not_move_activit);

            }
        });

        //학습기능
        btn_Study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,deepen_study_screen.class);
                startActivity(intent);

                overridePendingTransition(R.anim.leftin_activity,R.anim.not_move_activit);

            }
        });

        //퀴즈기능
        btn_Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,QuizSelect.class);
                startActivity(intent);

                overridePendingTransition(R.anim.rightin_activity,R.anim.not_move_activit);

            }
        });

        //점자란
        btn_Brailleinfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View)View.inflate(MainActivity.this,R.layout.brailleinfor,null);
                AlertDialog.Builder dlg= new AlertDialog.Builder(MainActivity.this);
                dlg.setView(dialogView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();

                TextView infor0 = (TextView) dialogView.findViewById(R.id.infor0);
                TextView infor1 = (TextView) dialogView.findViewById(R.id.infor1);
                TextView infor2 = (TextView) dialogView.findViewById(R.id.infor2);
                TextView infor3 = (TextView) dialogView.findViewById(R.id.infor3);
                TextView infor4 = (TextView) dialogView.findViewById(R.id.infor4);
                TextView infor5 = (TextView) dialogView.findViewById(R.id.infor5);

                Typeface font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/BMJUA_ttf.ttf");

                infor0.setTypeface(font);
                infor1.setTypeface(font);
                infor2.setTypeface(font);
                infor3.setTypeface(font);
                infor4.setTypeface(font);
                infor5.setTypeface(font);



            }


        });


        //점자표
        btn_Brailletable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = (View)View.inflate(MainActivity.this,R.layout.brailletable,null);
                AlertDialog.Builder dlg= new AlertDialog.Builder(MainActivity.this);
                dlg.setView(dialogView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();

                ImageView braillepicture=(ImageView)dialogView.findViewById(R.id.tablepicturegr);

                Glide.with(getApplicationContext()).load(R.drawable.braillepicturegr).fitCenter().into(braillepicture);

                TextView table0 = (TextView) dialogView.findViewById(R.id.table0);
                TextView table1 = (TextView) dialogView.findViewById(R.id.table1);
                TextView table2 = (TextView) dialogView.findViewById(R.id.table2);
                TextView table3 = (TextView) dialogView.findViewById(R.id.table3);

                Typeface font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/BMJUA_ttf.ttf");

                table0.setTypeface(font);
                table1.setTypeface(font);
                table2.setTypeface(font);
                table3.setTypeface(font);

            }
        });

        //점자역사
        btn_Brraillehistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = (View)View.inflate(MainActivity.this,R.layout.brailehistory,null);
                AlertDialog.Builder dlg= new AlertDialog.Builder(MainActivity.this);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlg.show();


                ImageView historypicture0=(ImageView)dialogView.findViewById(R.id.historypicture0);
                ImageView historypicture1=(ImageView)dialogView.findViewById(R.id.historypicture1);
                ImageView historypicture2=(ImageView)dialogView.findViewById(R.id.historypicture2);
                ImageView historypicture3=(ImageView)dialogView.findViewById(R.id.historypicture3);
                ImageView historypicture4=(ImageView)dialogView.findViewById(R.id.historypicture4);

                Glide.with(getApplicationContext()).load(R.drawable.historytopgr).into(historypicture0);
                Glide.with(getApplicationContext()).load(R.drawable.louispicturegr).into(historypicture1);
                Glide.with(getApplicationContext()).load(R.drawable.louisp).into(historypicture2);
                Glide.with(getApplicationContext()).load(R.drawable.dusungpicturegr).into(historypicture3);
                Glide.with(getApplicationContext()).load(R.drawable.packdusung).into(historypicture4);

                TextView history0 = (TextView) dialogView.findViewById(R.id.history0);
                TextView history1 = (TextView) dialogView.findViewById(R.id.history1);
                TextView history2 = (TextView) dialogView.findViewById(R.id.history2);
                TextView history3 = (TextView) dialogView.findViewById(R.id.history3);
                TextView history4 = (TextView) dialogView.findViewById(R.id.history4);
                TextView history5 = (TextView) dialogView.findViewById(R.id.history5);
                TextView history6 = (TextView) dialogView.findViewById(R.id.history6);
                TextView history7 = (TextView) dialogView.findViewById(R.id.history7);

                Typeface font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/BMJUA_ttf.ttf");

                history0.setTypeface(font);
                history1.setTypeface(font);
                history2.setTypeface(font);
                history3.setTypeface(font);
                history4.setTypeface(font);
                history5.setTypeface(font);
                history6.setTypeface(font);
                history7.setTypeface(font);


            }
        });


        //점자세상
        btn_Braillesite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View)View.inflate(MainActivity.this,R.layout.braillesite,null);
                AlertDialog.Builder dlg= new AlertDialog.Builder(MainActivity.this);
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

                TextView site0 = (TextView) dialogView.findViewById(R.id.site0);
                TextView site1 = (TextView) dialogView.findViewById(R.id.site1);
                TextView site2 = (TextView) dialogView.findViewById(R.id.site2);

                Typeface font = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/BMJUA_ttf.ttf");

                site0.setTypeface(font);
                site1.setTypeface(font);
                site2.setTypeface(font);

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
