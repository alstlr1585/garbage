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

import com.bumptech.glide.Glide;

public class Quiz_test extends Fragment {

    ImageView move_test,quiz_state_test;
    Button btn_test;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_second, container, false);
        //return layout;

        View view = inflater.inflate(R.layout.activity_quiz_test,container,false);

        move_test = (ImageView) view.findViewById(R.id.move_test);
        quiz_state_test = (ImageView) view.findViewById(R.id.quiz_state_test);

        Glide.with(this).load(R.drawable.quiz_test).into(move_test);
        Glide.with(this).load(R.drawable.quiz_state_test).into(quiz_state_test);

        btn_test=(Button)view.findViewById(R.id.btn_test);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/BMJUA_ttf.ttf");
        btn_test.setTypeface(font);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),test_quiz.class);
                startActivity(intent);


            }
        });



        return view;

    }

}
