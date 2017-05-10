package com.example.sinmingu.brailleproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.media.Image;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static android.view.KeyCharacterMap.load;
import static com.example.sinmingu.brailleproject.R.id.btn_Translation;
import static com.example.sinmingu.brailleproject.R.id.translation_edit;

public class backtranslationActivity extends BaseActivity {

    ///////////////////////////////////////////////////////////////////////
    private static final char[] CHO =
      /*ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅅ ㅆ ㅇ ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ ㅎ */
            {0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
                    0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
    private static final char[] JUN =
      /*ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ*/
            {0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158,
                    0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160,   0x3161,   0x3162,
                    0x3163};
    /*X ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ*/
    private static final char[] JON =
            {0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a,
                    0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145,
                    0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
    //private static final String[] CHO = {"ㄱ" ,"ㄲ" ,"ㄴ" ,"ㄷ" ,"ㄸ" ,"ㄹ" ,"ㅁ" ,"ㅂ" ,"ㅃ" ,"ㅅ" ,"ㅆ" ,"ㅇ" ,"ㅈ" ,"ㅉ" ,"ㅊ" ,"ㅋ" ,"ㅌ" ,"ㅍ" ,"ㅎ"};
    ////////////////////////////////////////////////////////////////////

    ImageView[] point;
    int[] point_id = {R.id.p1_1, R.id.p1_2, R.id.p1_3, R.id.p1_4, R.id.p1_5, R.id.p1_6,
            R.id.p2_1, R.id.p2_2, R.id.p2_3, R.id.p2_4, R.id.p2_5, R.id.p2_6,
            R.id.p3_1, R.id.p3_2, R.id.p3_3, R.id.p3_4, R.id.p3_5, R.id.p3_6,
            R.id.p4_1, R.id.p4_2, R.id.p4_3, R.id.p4_4, R.id.p4_5, R.id.p4_6,
            R.id.p5_1, R.id.p5_2, R.id.p5_3, R.id.p5_4, R.id.p5_5, R.id.p5_6,
            R.id.p6_1, R.id.p6_2, R.id.p6_3, R.id.p6_4, R.id.p6_5, R.id.p6_6,
            R.id.p7_1, R.id.p7_2, R.id.p7_3, R.id.p7_4, R.id.p7_5, R.id.p7_6,
            R.id.p8_1, R.id.p8_2, R.id.p8_3, R.id.p8_4, R.id.p8_5, R.id.p8_6,
            R.id.p9_1, R.id.p9_2, R.id.p9_3, R.id.p9_4, R.id.p9_5, R.id.p9_6,
            R.id.p10_1, R.id.p10_2, R.id.p10_3, R.id.p10_4, R.id.p10_5, R.id.p10_6,
            R.id.p11_1, R.id.p11_2, R.id.p11_3, R.id.p11_4, R.id.p11_5, R.id.p11_6,
            R.id.p12_1, R.id.p12_2, R.id.p12_3, R.id.p12_4, R.id.p12_5, R.id.p12_6,
            R.id.p13_1, R.id.p13_2, R.id.p13_3, R.id.p13_4, R.id.p13_5, R.id.p13_6,
            R.id.p14_1, R.id.p14_2, R.id.p14_3, R.id.p14_4, R.id.p14_5, R.id.p14_6,
            R.id.p15_1, R.id.p15_2, R.id.p15_3, R.id.p15_4, R.id.p15_5, R.id.p15_6,
            R.id.p16_1, R.id.p16_2, R.id.p16_3, R.id.p16_4, R.id.p16_5, R.id.p16_6,
            R.id.p17_1, R.id.p17_2, R.id.p17_3, R.id.p17_4, R.id.p17_5, R.id.p17_6,
            R.id.p18_1, R.id.p18_2, R.id.p18_3, R.id.p18_4, R.id.p18_5, R.id.p18_6,
            R.id.p19_1, R.id.p19_2, R.id.p19_3, R.id.p19_4, R.id.p19_5, R.id.p19_6,
            R.id.p20_1, R.id.p20_2, R.id.p20_3, R.id.p20_4, R.id.p20_5, R.id.p20_6,
            R.id.p21_1, R.id.p21_2, R.id.p21_3, R.id.p21_4, R.id.p21_5, R.id.p21_6,
            R.id.p22_1, R.id.p22_2, R.id.p22_3, R.id.p22_4, R.id.p22_5, R.id.p22_6,
            R.id.p23_1, R.id.p23_2, R.id.p23_3, R.id.p23_4, R.id.p23_5, R.id.p23_6,
            R.id.p24_1, R.id.p24_2, R.id.p24_3, R.id.p24_4, R.id.p24_5, R.id.p24_6,
            R.id.p25_1, R.id.p25_2, R.id.p25_3, R.id.p25_4, R.id.p25_5, R.id.p25_6,
            R.id.p26_1, R.id.p26_2, R.id.p26_3, R.id.p26_4, R.id.p26_5, R.id.p26_6,
            R.id.p27_1, R.id.p27_2, R.id.p27_3, R.id.p27_4, R.id.p27_5, R.id.p27_6,
            R.id.p28_1, R.id.p28_2, R.id.p28_3, R.id.p28_4, R.id.p28_5, R.id.p28_6,
            R.id.p29_1, R.id.p29_2, R.id.p29_3, R.id.p29_4, R.id.p29_5, R.id.p29_6,
            R.id.p30_1, R.id.p30_2, R.id.p30_3, R.id.p30_4, R.id.p30_5, R.id.p30_6
    };

    ImageButton serchpicture;
    ImageView serchpicture1,serchpicture2;
    TextView translation_text;
    DB braille;
    SQLiteDatabase db;
    Cursor cursor;
    String result="";
    String resultTemp="";
    String br_result="";
    ////
    EditText translation_edit;
    String choice_translationtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backtranslation);

        serchpicture=(ImageButton) findViewById(R.id.serchpicture);
        serchpicture1=(ImageView) findViewById(R.id.serchpicture1);
        serchpicture2=(ImageView) findViewById(R.id.serchpicture2);
        translation_text=(TextView)findViewById(R.id.translation_text);
        translation_edit=(EditText)findViewById(R.id.translation_edit);

        point = new ImageView[point_id.length];

        for(int i=0; i<point_id.length; i++){
            point[i] = (ImageView) findViewById(point_id[i]);
        }

        braille = new DB(this);    // DB 객체

        try {
            db = braille.getWritableDatabase();
        } catch (SQLiteException ex){
            db = braille.getReadableDatabase();
        }

        ////
        Glide.with(this).load(R.drawable.serch).into(serchpicture);
        Glide.with(this).load(R.drawable.serchpicture).into(serchpicture1);
        Glide.with(this).load(R.drawable.serchpicture2).into(serchpicture2);

        serchpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cho, jun, jon;
                char key[]={0,0,0};

                result = "";
                resultTemp = "";    // 초기화

                reflash();

                choice_translationtext=translation_edit.getText().toString();
                translation_text.setText(choice_translationtext);
                if (choice_translationtext.equals("")) {
                    Toast.makeText(backtranslationActivity.this, "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                }

                // 완성형 문자가 아닌 경우 팅기는 문제 해결 필요!/////////////////////////////////////////////////////

                else if ((choice_translationtext.charAt(0) > 64 && choice_translationtext.charAt(0) <= 90) || (choice_translationtext.charAt(0) > 96 && choice_translationtext.charAt(0) <= 122)){
                    char tmp;
                    for (int j = 0; j < choice_translationtext.length(); j++) {
                        if (choice_translationtext.charAt(j) == ' ') {
                            resultTemp += " ";
                            continue;
                        }
                        tmp = choice_translationtext.charAt(j);
                        if (tmp != ' ' &&!((tmp > 64 && tmp <= 90) || (tmp > 96 && tmp <= 122))) {
                            Toast.makeText(backtranslationActivity.this, "종류가 다른 문자끼리 혼합할 수 없습니다.", Toast.LENGTH_SHORT).show();
                            resultTemp = "";
                            break;
                        }
                        if (tmp > 64 && tmp <= 90) {    // 이번건 대문자!
                            if (j == 0 || !(choice_translationtext.charAt(j-1) > 64 && choice_translationtext.charAt(j-1) <= 90)) {   // 전에는 대문자가 아니였나요?
                                resultTemp += "000001";
                                if (j < choice_translationtext.length()-1 && (choice_translationtext.charAt(j + 1) > 64 && choice_translationtext.charAt(j + 1) <= 90))  // 이번 글자에 이은 다음 글자도 대문자인가요?
                                    resultTemp += "000001";
                            }

                            Toast.makeText(getApplicationContext(),"대문자"+resultTemp.length(),Toast.LENGTH_SHORT).show();
                            tmp += 32;
                        }
/////////////////////////////
                        ////////////////////////////
                        cursor = db.rawQuery("SELECT keyword, point, flag FROM braille WHERE keyword='" + tmp + "' and flag=" + 4 + ";", null);
                        //cursor = db.rawQuery("SELECT keyword, point, flag FROM braille WHERE flag=" + 4 + ";", null);
                        //Toast.makeText(backtranslationActivity.this, ""+cursor.getCount(), Toast.LENGTH_SHORT).show();

                        while (cursor.moveToNext()) {

                            result = cursor.getString(1);
                            resultTemp = resultTemp + result;
                        }
                        // 영어의 경우
                    }
                    br_result = resultTemp;

                    int j = 0;  // 띄워쓰기 횟수

                    int num = 0;
                    for(int i=0; i<br_result.length(); i++){
                        if(br_result.charAt(i) == ' ')
                            num++;
                    }

                    if ((br_result.replaceAll(" ", "").length() + (num*6)) > 180){
                        Toast.makeText(backtranslationActivity.this, "글자가 너무 깁니다.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        for (int i = 0; i < br_result.length(); i++) {
                            if (br_result.charAt(i) == ' ') {
                                j += 5;
                            } else if (br_result.charAt(i) == '0') {
                                point[i + j].setImageResource(R.drawable.braille_zero);
                                point[i + j].setVisibility(View.INVISIBLE);
                            } else if (br_result.charAt(i) == '1') {
                                point[i + j].setImageResource(R.drawable.braille_one);
                                point[i + j].setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }

                else {      // 그 외의 경우 (한글)
                    for (int j = 0; j < choice_translationtext.length(); j++) {
                        if (choice_translationtext.charAt(j) == ' ') {
                            resultTemp += " ";
                            continue;
                        }

                        cho = ((((choice_translationtext.charAt(j) - 0xAC00) - (choice_translationtext.charAt(j) - 0xAC00) % 28)) / 28) / 21;
                        if (cho < 0) {              // 완성형 글자가 아닌 경우 Toast를 출력하고 번역중지
                            Toast.makeText(backtranslationActivity.this, "완성형 글자를 입력하세요.", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        key[0] = CHO[cho];

                        jun = ((((choice_translationtext.charAt(j) - 0xAC00) - (choice_translationtext.charAt(j) - 0xAC00) % 28)) / 28) % 21;
                        key[1] = JUN[jun];

                        jon = (choice_translationtext.charAt(j) - 0xAC00) % 28;
                        key[2] = JON[jon];

                        if (key[0] == 0x3132 || key[0] == 0x3138 || key[0] == 0x3143 || key[0] == 0x3146 || key[0] == 0x3149)     // 된소리 전처리
                            key[0] -= 0x0001;
                        if (key[1] == 0x3153 && key[2] == 0x3147 && (key[0] == 0x3145 || key[0] == 0x3146 || key[0] == 0x3148 || key[0] == 0x3149 || key[0] == 0x314a))   // 엉 -> 영 처리
                            key[1] += 0x0002;


                        for (int k = 1; (k < 4 && key[k - 1] != 0x0000); k++) {
                            cursor = db.rawQuery("SELECT keyword, point, flag FROM braille WHERE keyword='" + key[k - 1] + "' and flag=" + k + ";", null);
                            while (cursor.moveToNext()) {
                                result = cursor.getString(1);

                                if ((k == 1) && (CHO[cho] == 0x3132 || CHO[cho] == 0x3138 || CHO[cho] == 0x3143 || CHO[cho] == 0x3146 || CHO[cho] == 0x3149))   // 된소리 후처리
                                    resultTemp = resultTemp + " " + "000001";

                                if ((k == 2) && j + 1 < choice_translationtext.length() && key[2] == 0x0000 && (key[1] == 0x3151 || key[1] == 0x3158 || key[1] == 0x315c || key[1] == 0x315d)) {   // 붙임표 2번 파트
                                        // 현재 번역중인 글자에 받침이 없고, 이번에 번역한 것이 모음[ㅑ ㅘ ㅜ ㅝ]이며, 다음 글자가 존재할 경우.
                                    if (choice_translationtext.charAt(j+1) != ' '&&
                                            CHO[(((((choice_translationtext.charAt(j + 1) - 0xAC00) - (choice_translationtext.charAt(j + 1) - 0xAC00) % 28)) / 28) / 21)] == 0x3147 &&
                                            JUN[(((((choice_translationtext.charAt(j + 1) - 0xAC00) - (choice_translationtext.charAt(j + 1) - 0xAC00) % 28)) / 28) % 21)] == 0x3150)
                                        result = result + " " + "001001";

                                }

                                resultTemp = resultTemp + " " + result;
                            }
                        }
                        resultTemp = AbbrShortProc(resultTemp);
                        br_result = resultTemp;
                    }

                    br_result = AddrLongProc(br_result);

                    int j = 0;  // 띄워쓰기 횟수

                    int num = 0;
                    for(int i=0; i<br_result.length(); i++){
                        if(br_result.charAt(i) == ' ')
                            num++;
                    }

                    if ((br_result.replaceAll(" ", "").length() + (num*6)) > 180){
                        Toast.makeText(backtranslationActivity.this, "글자가 너무 깁니다.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        for (int i = 0; i < br_result.length(); i++) {

                            if (br_result.charAt(i) == ' ') {
                                j += 5;
                            } else if (br_result.charAt(i) == '0') {
                                point[i + j].setImageResource(R.drawable.braille_zero);
                                point[i + j].setVisibility(View.INVISIBLE);
                            } else if (br_result.charAt(i) == '1') {
                                point[i + j].setImageResource(R.drawable.braille_one);
                                point[i + j].setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }

            }
            ////////////////////////////////////////////




        });

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.not_move_activit,R.anim.rightout_activity);

    }

    String AbbrShortProc(String past) {   // 약자 처리.
        past = past.replaceAll("000100 110001", "110101");                  // 가
        past = past.replaceAll("000001 110001", "111000");                  // 사
        past = past.replaceAll("000100 011100 001000", "000111 011100");   // 것
        past = past.replaceAll("011100 100000", "100111");                  // 억
        past = past.replaceAll("011100 010010", "011111");                  // 언
        past = past.replaceAll("011100 010000", "011110");                  // 얼
        past = past.replaceAll("100011 010010", "100001");                  // 연
        past = past.replaceAll("100011 010000", "110011");                  // 열
        past = past.replaceAll("100011 011011", "110111");                  // 영
        past = past.replaceAll("101001 100000", "101101");                  // 옥
        past = past.replaceAll("101001 010010", "111011");                  // 온
        past = past.replaceAll("101001 011011", "111111");                  // 옹
        past = past.replaceAll("101100 010010", "110110");                  // 운
        past = past.replaceAll("101100 010000", "111101");                  // 울
        past = past.replaceAll("010101 010010", "101011");                  // 은
        past = past.replaceAll("010101 010000", "011101");                  // 을
        past = past.replaceAll("101010 010010", "111110");                  // 인

        return past;
    }

    String AddrLongProc(String past){

        String[] proc_A = {"100100", "010100", "100010", "000110", "000101", "110100", "110010", "100110", "010110"};   // ~ㅏ 형 줄임말
        String[] proc_MO = {"100111", "011111", "011110", "100001", "110011", "110111", "101101", "111011", "111111", "110110", "111101", "101011", "011101", "111110"};    // 위에서 쓴 short형 모음 줄임말 (운,인 등)

        int cnt, i;
        String sub;

        past = past.replaceAll("000100 010101 000010 111010 000001 011100", "100000 011100"); // 그래서
        past = past.replaceAll("000100 010101 000010 011100 100100 110001", "100000 100100"); // 그러나
        past = past.replaceAll("000100 010101 000010 011100 100010 100011 010010", "100000 010010"); // 그러면
        past = past.replaceAll("000100 010101 000010 011100 100010 010101 000010 101001", "100000 010001"); // 그러므로
        past = past.replaceAll("000100 010101 000010 011100 010010 010100 101110 ", "100000 101110"); // 그런데
        past = past.replaceAll("000100 010101 000010 101010 000100 101001", "100000 101001"); // 그리고
        past = past.replaceAll("000100 010101 000010 101010 010110 110001 100011 ", "100000 100011"); // 그리하여

        /*  다음 글자가 모음부터 시작할 경우엔 ㄱ,ㅅ를 제외한 다른 글자는 'ㅏ' 생략을 하면 안됨. 이는 아직 처리하지 않은 상태이다.

        past = past.replaceAll("100100 110001", "100100"); // 나 // 아마 이런건 마지막에 긴 약어 처리할떄 같이 해줘야할듯.
        past = past.replaceAll("010100 110001", "010100"); // 다
        past = past.replaceAll("100010 110001", "100010"); // 마
        past = past.replaceAll("000110 110001", "000110"); // 바
        past = past.replaceAll("000101 110001", "000101"); // 자
        past = past.replaceAll("110100 110001", "111000"); // 카
        past = past.replaceAll("110010 110001", "110010"); // 타
        past = past.replaceAll("100110 110001", "100110"); // 파
        past = past.replaceAll("010110 110001", "010110"); // 하

        */


        for(int x=0;x<proc_A.length;x++) {  // ㅏ 생략 파트
            // 뒤에 글자가 없다면? : 생략
            // 뒤에 글자가 있는데 '자음'이라면? : 생략
            // 뒤에 글자가 있는데 '모음'이라면? : 생략불가

            cnt = 1;
            i=0;
            if (!(past.indexOf(proc_A[x]+ " 110001") == -1)) {
                while (true) {
                    cnt = past.indexOf(proc_A[x]+ " 110001", cnt);

                    if (cnt == -1)
                        break;
                    i++;
                    if (past.length() == past.indexOf(proc_A[x]+ " 110001") + 13)
                        past = past.replaceFirst(proc_A[x]+ " 110001", proc_A[x]);
                    else {
                        sub = past.substring(cnt + 14, cnt + 20);
                        //Toast.makeText(this, "" + sub, Toast.LENGTH_SHORT).show();
                        for (int z=0; z<proc_MO.length;z++) {
                            if (sub.equals(proc_MO[z])) {
                                //Toast.makeText(this, "모음이다!", Toast.LENGTH_SHORT).show();
                                cnt += 13;
                                past = past.replaceFirst(proc_A[x] + " 110001", proc_A[x] + " 220002");
                            }
                        }
                        cursor = db.rawQuery("SELECT keyword, point, flag FROM braille WHERE point='" + sub + "' and flag=" + 2 + ";", null);   // 검색

                        if (cursor.getCount() == 0) {

                            //Toast.makeText(this, "자음이다!", Toast.LENGTH_SHORT).show();
                            cnt += 6;
                            past = past.replaceFirst(proc_A[x] + " 110001", proc_A[x]);
                        } else {
                            //Toast.makeText(this, "모음이다!", Toast.LENGTH_SHORT).show();
                            cnt += 13;
                            past = past.replaceFirst(proc_A[x] + " 110001", proc_A[x] + " 220002");
                        }
                    }
                }
            }
            //Toast.makeText(this, "" + i + "개의 결과 찾음", Toast.LENGTH_SHORT).show();
        }

        while(true) {   // 붙임표 파트 1번 - 모음 뒤에 ㅖ가 오면 붙임표를 붙인다.
            if (past.indexOf("001100") == -1) break;
            else if (past.indexOf("001100") > 7) {
                sub = past.substring(past.indexOf("001100") - 7, past.indexOf("001100") - 1);
                cursor = db.rawQuery("SELECT keyword, point, flag FROM braille WHERE point='" + sub + "' and flag=" + 2 + ";", null);   // 검색
                if (cursor.getCount() == 0)
                    past = past.replaceFirst("001100", "002200");
                else
                    past = past.replaceFirst("001100", "002002 002200");
            }
        }

        past = past.replaceAll("2", "1");
        past = past.replaceAll("  ", "◆");
        past = past.replaceAll(" ", "");
        past = past.replaceAll("◆", " ");
        return past;
    }

    //초기화 함수
    public void reflash(){

        for(int i=0;i<180;i++){
            point[i].setVisibility(View.INVISIBLE);
        }


    }


}
