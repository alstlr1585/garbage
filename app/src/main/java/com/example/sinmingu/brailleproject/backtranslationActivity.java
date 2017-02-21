package com.example.sinmingu.brailleproject;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class backtranslationActivity extends BaseActivity {

    ImageButton serchpicture;
    ImageView serchpicture1,serchpicture2;
    TextView translation_text;
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

        Glide.with(this).load(R.drawable.serch).into(serchpicture);
        Glide.with(this).load(R.drawable.serchpicture).into(serchpicture1);
        Glide.with(this).load(R.drawable.serchpicture2).into(serchpicture2);

        serchpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choice_translationtext=translation_edit.getText().toString();

                translation_text.setText(choice_translationtext);

            }
        });



    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.not_move_activit,R.anim.rightout_activity);

    }

}