package com.example.sinmingu.brailleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class deepen_study extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deepen_study);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.not_move_activit,R.anim.leftout_activity);

    }
}
