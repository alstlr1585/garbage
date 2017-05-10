package com.example.sinmingu.brailleproject;

import android.graphics.Color;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizSelect extends BaseActivity {

    ViewPager vp;
    TextView text_select_char, text_select_word, text_select_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_select);

        vp = (ViewPager) findViewById(R.id.vp);
        //Button btn_first = (Button) findViewById(R.id.btn1);
        //Button btn_second = (Button) findViewById(R.id.btn2);

        text_select_char=(TextView)findViewById(R.id.text_selelt_char);
        text_select_word=(TextView)findViewById(R.id.text_selelt_word);
        text_select_test=(TextView)findViewById(R.id.text_selelt_char);


        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

/*
        btn_first.setOnClickListener(movePageListener);
        btn_first.setTag(0);
        btn_second.setOnClickListener(movePageListener);
        btn_second.setTag(1);
*/

    }

    View.OnClickListener movePageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = (int) v.getTag();
            vp.setCurrentItem(tag);

        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:

                    return new Quiz_character();
                case 1:

                    return new Quiz_word();
                case 2:

                    return new Quiz_test();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }


    }
}
