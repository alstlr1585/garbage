package com.example.sinmingu.brailleproject;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static android.R.attr.key;
import static java.lang.String.valueOf;

public class translationActivity extends BaseActivity {

    private static final char[] CHOHAN =
		/*ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅅ ㅆ ㅇ ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ ㅎ */
            {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ',
                    'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
    ///////////////////////////////////////////////////////////////////////
    private static final char[] CHO =
		/*ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅅ ㅆ ㅇ ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ ㅎ */
            {0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
                    0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
    private static final char[] JUN =
		/*ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ*/
            {0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158,
                    0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160,	0x3161,	0x3162,
                    0x3163};
    /*X ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ*/
    private static final char[] JON =
            {0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a,
                    0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145,
                    0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
    //private static final String[] CHO = {"ㄱ" ,"ㄲ" ,"ㄴ" ,"ㄷ" ,"ㄸ" ,"ㄹ" ,"ㅁ" ,"ㅂ" ,"ㅃ" ,"ㅅ" ,"ㅆ" ,"ㅇ" ,"ㅈ" ,"ㅉ" ,"ㅊ" ,"ㅋ" ,"ㅌ" ,"ㅍ" ,"ㅎ"};
    ////////////////////////////////////////////////////////////////////


    DB braille;
    SQLiteDatabase db;

    ImageButton translation_braillebtn1, translation_braillebtn2, translation_braillebtn3, translation_braillebtn4,
            translation_braillebtn5,translation_braillebtn6;
    //이미지뷰
    ImageView pencil_picture;
    Button quiz_result_back, quiz_result_send;

    TextView text_braille;

    int translation_btnstatus1, translation_btnstatus2, translation_btnstatus3, translation_btnstatus4, translation_btnstatus5, translation_btnstatus6;

    String result_trans = "";       // 번역될 최종 문자
    String temp_trans ="";   // 임시 저장공간
    int    temp_flag = 0;   // 임시 flag
    int    prev_flag = 0;
    int    start = 0;       // 맨 처음 쓴건지 아닌지
    int    index = 0;       // 최종 글자에서 맨 마지막 인덱스가 몇인지 알기 위해
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        // 점자 DB
        braille = new DB(this);

        try{
            db = braille.getWritableDatabase();
        }
        catch (SQLiteException ex){
            db = braille.getReadableDatabase();
        }


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

        text_braille = (TextView) findViewById(R.id.text_braille);

        quiz_result_back = (Button) findViewById(R.id.quiz_result_back);
        quiz_result_send = (Button) findViewById(R.id.quiz_result_send);

        pencil_picture=(ImageView)findViewById(R.id.pencil_pucture);

        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn1);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn2);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn3);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn4);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn5);
        Glide.with(this).load(R.drawable.braillebtn_false).into(translation_braillebtn6);

        Glide.with(this).load(R.drawable.pencil).into(pencil_picture);

        // 지우기
        quiz_result_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_braille.setText("");
                result_trans = "";
                start = 0;
                prev_flag = 0;
                index = 0;

                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn1);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn2);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn3);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn4);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn5);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn6);

                translation_btnstatus1=0;
                translation_btnstatus2=0;
                translation_btnstatus3=0;
                translation_btnstatus4=0;
                translation_btnstatus5=0;
                translation_btnstatus6=0;
            }
        });

        // 입력 -> 이전 문자랑 추가되어 나옴
        quiz_result_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String braille_point = String.valueOf(translation_btnstatus1) + valueOf(translation_btnstatus2) + valueOf(translation_btnstatus3)
                        + valueOf(translation_btnstatus4) + valueOf(translation_btnstatus5) + valueOf(translation_btnstatus6);

                temp_trans = Trans(braille_point);

                result_trans = Trans_Fusion(temp_trans, temp_flag);

                text_braille.setText(result_trans);

                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn1);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn2);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn3);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn4);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn5);
                Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn6);

                translation_btnstatus1=0;
                translation_btnstatus2=0;
                translation_btnstatus3=0;
                translation_btnstatus4=0;
                translation_btnstatus5=0;
                translation_btnstatus6=0;

            }
        });

        // 점자 1~6까지
        translation_braillebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus1==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn1);
                    translation_btnstatus1 = 1;
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn1);
                    translation_btnstatus1 = 0;
                }


            }
        });

        translation_braillebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus2==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn2);
                    translation_btnstatus2 = 1;
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn2);
                    translation_btnstatus1 = 0;
                }

            }
        });

        translation_braillebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus3==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn3);
                    translation_btnstatus3 = 1;
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn3);
                    translation_btnstatus3 = 0;
                }

            }
        });

        translation_braillebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus4==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn4);
                    translation_btnstatus4 = 1;
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn4);
                    translation_btnstatus4 = 0;
                }

            }
        });

        translation_braillebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus5==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn5);
                    translation_btnstatus5 = 1;
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn5);
                    translation_btnstatus5 = 0;
                }

            }
        });

        translation_braillebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(translation_btnstatus6==0){
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_true).into(translation_braillebtn6);
                    translation_btnstatus6 = 1;
                }
                else {
                    Glide.with(translationActivity.this).load(R.drawable.braillebtn_false).into(translation_braillebtn6);
                    translation_btnstatus6 = 0;
                }

            }
        });

    }

    // 해당 점자에 대응되는 문자 구성요소를 문자열로 반환
    public String Trans(String braille_point){
        String result="";
        Cursor cursor = db.rawQuery("SELECT keyword, flag FROM braille WHERE point = '" + braille_point + "';", null);

        while(cursor.moveToNext()){
            result = cursor.getString(0);
            temp_flag = cursor.getInt(1);
        }

        return result;
    }

    // 기존 문자와 최근 입력 문자 합성
    public String Trans_Fusion(String recent_trans, int flag){

        int number_cho = 0;
        int number_jun = 0;
        int number_jon = 0;

        if(start == 0){
            result_trans = recent_trans;
            if(flag != 1)
                index++;
        }
        else{
            // 자음 초성
            if(flag == 1){
                result_trans = result_trans + recent_trans;
                prev_flag = 1;
            }
            // 모음
            else if(flag == 2){
                // 모음이기 때문에 마지막에 온 글자가 모음이거나 자음 종성일경우 바로 이어줌
                if(prev_flag == 2 || prev_flag == 3){
                    result_trans = result_trans + recent_trans;
                }
                else {
                    for (int i = 0; i < 19; i++) {
                        if (result_trans.charAt(index) == CHOHAN[i]) {
                            number_cho = i;
                            break;
                        }
                    }

                    for (int i = 0; i < 21; i++) {
                        if (recent_trans.equals(JUN[i] + "")) {
                            number_jun = i;
                            break;
                        }
                    }

                    char key = (char)(0xAC00 + 28*21*(number_cho)+28*(number_jun));
                    result_trans = result_trans.substring(0,result_trans.length()-1);
                    result_trans = result_trans.concat(String.valueOf(key));
                }

                prev_flag = 2;
                index++;
            }
            // 자음 종성
            else if(flag == 3){
                index--;

                number_cho = ((((result_trans.charAt(index) - 0xAC00) - (result_trans.charAt(index) - 0xAC00) % 28 ) ) / 28 ) / 21;
                number_jun = ((((result_trans.charAt(index) - 0xAC00) - (result_trans.charAt(index) - 0xAC00) % 28 ) ) / 28 ) % 21;

                for (int i = 0; i < 28; i++) {
                    if (recent_trans.equals(JON[i] + "")) {
                        number_jon = i;
                        break;
                    }
                }

                char key = (char)(0xAC00 + 28*21*(number_cho)+28*(number_jun) + (number_jon));

                result_trans = result_trans.substring(0,result_trans.length()-1);
                result_trans = result_trans.concat(String.valueOf(key));

                prev_flag = 3;
                index++;
            }
        }
        start++;
        return result_trans;
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.not_move_activit,R.anim.leftout_activity);

    }

}
