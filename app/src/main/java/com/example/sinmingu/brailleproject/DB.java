package com.example.sinmingu.brailleproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by minsik on 2017-02-17.
 */

public class DB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mybraille.db";
    private static final int DATABASE_VERSION = 2;

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE braille ( id INTEGER PRIMARY KEY AUTOINCREMENT, keyword TEXT, point TEXT , flag INTEGER );");
        // flag 자음 초성 = 1, 모음 = 2, 자음 종성 = 3, 약자 = 4.
        insertData(db);
    }

//dd
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS braille");
        onCreate(db);
    }

    public void insertData(SQLiteDatabase db){
        String firstJa[] = {"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", "된"};
        String firstJaPoint[] = {"000100", "100100", "010100", "000010", "100010", "000110", "000001",
            "000101", "000011", "110100", "110010", "100110", "010110", "000001"};
        for(int i=0; i<firstJa.length; i++){
            db.execSQL("INSERT INTO braille VALUES (null, '" + firstJa[i] + "', '" + firstJaPoint[i] + "', 1);");
        }


        String secondJa[] = {"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ","ㄳ" ,"ㄵ" ,"ㄶ" ,"ㄺ" ,"ㄻ" ,"ㄼ" ,"ㄽ" ,"ㄾ" ,"ㄿ" ,"ㅀ" ,"ㅄ", "ㄲ", "ㄸ", "ㅃ", "ㅆ", "ㅉ" };
        String secondJaPoint[] = {"100000", "010010", "001010", "010000", "010001", "110000", "001000",
            "011011", "101000", "011000", "011010", "011001", "010011", "001011",
                "100000 001000", "010010 101000", "010010 001011", "010000 100000", "010000 010001", "010000 110000", "010000 001000", "010000 011001", "010000 010011", "010000 001011", "110000 001000",
                "100000 100000", "001010 001010", "110000 110000", "001100", "101000 101000"};
        for(int i=0; i<secondJa.length; i++){
            db.execSQL("INSERT INTO braille VALUES (null, '" + secondJa[i] + "', '" + secondJaPoint[i] + "', 3);");
        }


        String Mo[] = {"ㅏ", "ㅑ", "ㅓ", "ㅕ", "ㅗ", "ㅛ", "ㅜ", "ㅠ", "ㅡ", "ㅣ",
        "ㅐ", "ㅔ", "ㅚ", "ㅘ", "ㅝ", "ㅢ", "ㅖ", "ㅟ", "ㅟ", "ㅒ", "ㅙ", "ㅙ", "ㅞ", "ㅞ"};
        String MoPoint[] = {"110001", "001110", "011100", "100011", "101001", "001101", "101100",
            "100101", "010101", "101010", "111010", "101110", "101111", "111001", "111100",
            "010111", "001100", "101100", "111010", "111010", "111001", "111010",
            "111100", "111010"};
        for(int i=0; i<Mo.length; i++){
            db.execSQL("INSERT INTO braille VALUES (null, '" + Mo[i] + "', '" + MoPoint[i] + "', 2);");
        }

/*
        String Yak[] = {"가", "나", "다", "마", "바", "사", "자", "카", "타", "파", "하", "것", "ㅆ", "억", "언", "얼", "연", "열", "영", "옥", "온", "옹", "운", "울", "은", "을", "인", "그래서", "그러나", "그러면", "그러므로", "그런데", "그리고", "그리하여"};
        String YakPoint[] = {"110101", "100100", "010100", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
*/
    }
}