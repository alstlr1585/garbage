package com.example.sinmingu.brailleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class deepen_study_screen extends BaseActivity {

    ImageView deepen_study_top;
    Button deepen_study_screen_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deepen_study_screen);

        deepen_study_top=(ImageView)findViewById(R.id.deepen_study_top);
        deepen_study_screen_move=(Button)findViewById(R.id.deepen_study_screen_move);

        Glide.with(this).load(R.drawable.deepen_study_top).into(deepen_study_top);

        deepen_study_screen_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(deepen_study_screen.this,deepen_study.class);
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
