package com.example.sinmingu.brailleproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Quiz_character extends Fragment{

    ImageView move_character,quiz_state_char;
    Button btn_char;

    public Quiz_character(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_second, container, false);
        //return layout;

        View view = inflater.inflate(R.layout.activity_quiz_character,container,false);

        move_character = (ImageView) view.findViewById(R.id.move_character);
        quiz_state_char = (ImageView) view.findViewById(R.id.quiz_state_char);

        Glide.with(this).load(R.drawable.quiz_char).into(move_character);
        Glide.with(this).load(R.drawable.quiz_status).into(quiz_state_char);

        btn_char=(Button)view.findViewById(R.id.btn_char);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/BMJUA_ttf.ttf");
        btn_char.setTypeface(font);

        btn_char.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),QuizActivity.class);
                startActivity(intent);

            }
        });

        return view;

    }

}


