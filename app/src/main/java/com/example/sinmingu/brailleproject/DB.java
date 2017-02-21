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
        // flag 자음 초성 = 1, 자음 종성 = 3, 모음 = 2.
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


        String secondJa[] = {"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
        String secondJaPoint[] = {"100000", "010010", "001010", "010000", "010001", "110000", "001000",
        "011011", "101000", "011000", "011010", "011001", "010011", "001011"};
        for(int i=0; i<secondJa.length; i++){
        db.execSQL("INSERT INTO braille VALUES (null, '" + secondJa[i] + "', '" + secondJaPoint[i] + "', 3);");
        }


        String Mo[] = {"ㅏ", "ㅑ", "ㅓ", "ㅕ", "ㅗ", "ㅛ", "ㅜ", "ㅠ", "ㅡ", "ㅣ",
        "ㅐ", "ㅔ", "ㅚ", "ㅘ", "ㅝ", "ㅢ", "ㅖ", "ㅟ", "ㅟ", "ㅒ", "ㅒ", "ㅙ", "ㅙ", "ㅞ", "ㅞ"};
        String MoPoint[] = {"110001", "001110", "011100", "100011", "101001", "001101", "101100",
        "100101", "010101", "101010", "111010", "101110", "101111", "111001", "111100",
        "010111", "001100", "101100", "111010", "001110", "111010", "111001", "111010",
        "111100", "111010"};
        for(int i=0; i<Mo.length; i++){
        db.execSQL("INSERT INTO braille VALUES (null, '" + Mo[i] + "', '" + MoPoint[i] + "', 2);");
        }
        }
        }