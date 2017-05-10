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
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Quiz_word extends Fragment {

    ImageView move_word,quiz_state_word;
    Button btn_word;

    public Quiz_word(){

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

        View view = inflater.inflate(R.layout.activity_quiz_word,container,false);

        move_word = (ImageView) view.findViewById(R.id.move_word);
        quiz_state_word = (ImageView) view.findViewById(R.id.quiz_state_word);

        Glide.with(this).load(R.drawable.quiz_word).into(move_word);
        Glide.with(this).load(R.drawable.quiz_state_word).into(quiz_state_word);

        btn_word=(Button)view.findViewById(R.id.btn_word);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/BMJUA_ttf.ttf");
        btn_word.setTypeface(font);

        btn_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),word_quiz.class);
                startActivity(intent);

            }
        });



        return view;

    }

}
