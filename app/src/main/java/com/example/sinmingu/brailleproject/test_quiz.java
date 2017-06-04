package com.example.sinmingu.brailleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class test_quiz extends BaseActivity {

    //o,x 이미지 버튼 클릭
    ImageButton click_o, click_x;
    //o,x 상태변화 변수
    int o_status=0, x_status=0;
    //확인버튼
    Button test_result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_quiz);

        test_result=(Button)findViewById(R.id.test_result);

        click_o=(ImageButton)findViewById(R.id.click_o);
        click_x=(ImageButton)findViewById(R.id.click_x);

        Glide.with(this).load(R.drawable.o_uncheck).fitCenter().fitCenter().into(click_o);
        Glide.with(this).load(R.drawable.x_uncheck).fitCenter().fitCenter().into(click_x);

        click_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(o_status%2==0){
                    Glide.with(test_quiz.this).load(R.drawable.o_check).fitCenter().into(click_o);
                    o_status++;
                }
                else{
                    Glide.with(test_quiz.this).load(R.drawable.o_uncheck).fitCenter().into(click_o);
                    o_status++;
                }


            }
        });

        click_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(x_status%2==0){
                    Glide.with(test_quiz.this).load(R.drawable.x_check).fitCenter().into(click_x);
                    x_status++;
                }
                else{
                    Glide.with(test_quiz.this).load(R.drawable.x_uncheck).fitCenter().into(click_x);
                    x_status++;
                }
            }
        });
    }

}
