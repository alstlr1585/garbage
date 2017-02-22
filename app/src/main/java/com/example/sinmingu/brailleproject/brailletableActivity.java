package com.example.sinmingu.brailleproject;


import android.graphics.Color;
import android.media.Image;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class brailletableActivity extends BaseActivity {

    Spinner wordmenu;
    ImageView consonant_initial_one, consonant_initial_two, finalconsonant_initial_one,finalconsonant_initial_two,
            vowel_one, vowel_two,vowel_three,number_one,number_two,abbreviation_one,abbreviation_two,abbreviation_three,
            conjunction_one,conjunction_two,alphabet_one,alphabet_two,alphabet_three,alphabet_four;
    TextView viewmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brailletable);

        wordmenu=(Spinner)findViewById(R.id.wordmenu);

        consonant_initial_one=(ImageView)findViewById(R.id.consonant_initial_one);
        consonant_initial_two=(ImageView)findViewById(R.id.consonant_initial_two);
        finalconsonant_initial_one=(ImageView)findViewById(R.id.finalconsonant_ini_one);
        finalconsonant_initial_two=(ImageView)findViewById(R.id.finalconsonant_ini_two);
        vowel_one=(ImageView)findViewById(R.id.vowel_one);
        vowel_two=(ImageView)findViewById(R.id.vowel_two);
        vowel_three=(ImageView)findViewById(R.id.vowel_three);
        number_one=(ImageView)findViewById(R.id.number_one);
        number_two=(ImageView)findViewById(R.id.number_two);
        viewmenu=(TextView)findViewById(R.id.view_menu);
        abbreviation_one=(ImageView)findViewById(R.id.abbreviation_one);
        abbreviation_two=(ImageView)findViewById(R.id.abbreviation_two);
        abbreviation_three=(ImageView)findViewById(R.id.abbreviation_three);
        conjunction_one=(ImageView)findViewById(R.id.conjunction_one);
        conjunction_two=(ImageView)findViewById(R.id.conjunction_two);
        alphabet_one=(ImageView)findViewById(R.id.alphabet_one);
        alphabet_two=(ImageView)findViewById(R.id.alphabet_two);
        alphabet_three=(ImageView)findViewById(R.id.alphabet_three);
        alphabet_four=(ImageView)findViewById(R.id.alphabet_four);

        /////////////////////////////////////////////////////////////////////////////////////

        Glide.with(this).load(R.drawable.consonant_initial_one).into(consonant_initial_one);
        Glide.with(this).load(R.drawable.consonant_initial_two).into(consonant_initial_two);
        Glide.with(this).load(R.drawable.finalconsonant_ini_one).into(finalconsonant_initial_one);
        Glide.with(this).load(R.drawable.finalconsonant_ini_two).into(finalconsonant_initial_two);
        Glide.with(this).load(R.drawable.vowel_one).into(vowel_one);
        Glide.with(this).load(R.drawable.vowel_two).into(vowel_two);
        Glide.with(this).load(R.drawable.vowel_three).into(vowel_three);
        Glide.with(this).load(R.drawable.number_1).into(number_one);
        Glide.with(this).load(R.drawable.number_2).into(number_two);
        Glide.with(this).load(R.drawable.abbreviation_1).into(abbreviation_one);
        Glide.with(this).load(R.drawable.abbreviation_2).into(abbreviation_two);
        Glide.with(this).load(R.drawable.abbreviation_3).into(abbreviation_three);
        Glide.with(this).load(R.drawable.conjunction_1).into(conjunction_one);
        Glide.with(this).load(R.drawable.conjunction_2).into(conjunction_two);
        Glide.with(this).load(R.drawable.alphabet_1).into(alphabet_one);
        Glide.with(this).load(R.drawable.alphabet_2).into(alphabet_two);
        Glide.with(this).load(R.drawable.alphabet_3).into(alphabet_three);
        Glide.with(this).load(R.drawable.alphabet_4).into(alphabet_four);


        final ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.word,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        wordmenu.setAdapter(adapter);


        wordmenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?>  parent, View view, int position, long id) {

                //  Toast.makeText(brailletableActivity.this,
                //          adapter.getItem(position) + "을 선택 했습니다.", Toast.LENGTH_SHORT).show();

                if(adapter.getItem(position).equals("초성 자음")){

                    consonant_initial_one.setVisibility((View.VISIBLE));
                    consonant_initial_two.setVisibility((View.VISIBLE));
                    finalconsonant_initial_one.setVisibility((View.GONE));
                    finalconsonant_initial_two.setVisibility((View.GONE));
                    vowel_one.setVisibility((View.GONE));
                    vowel_two.setVisibility((View.GONE));
                    vowel_three.setVisibility((View.GONE));
                    number_one.setVisibility(View.GONE);
                    number_two.setVisibility(View.GONE);
                    abbreviation_one.setVisibility(View.GONE);
                    abbreviation_two.setVisibility(View.GONE);
                    abbreviation_three.setVisibility(View.GONE);
                    conjunction_one.setVisibility(View.GONE);
                    conjunction_two.setVisibility(View.GONE);
                    alphabet_one.setVisibility(View.GONE);
                    alphabet_two.setVisibility(View.GONE);
                    alphabet_three.setVisibility(View.GONE);
                    alphabet_four.setVisibility(View.GONE);

                    viewmenu.setText("초성 자음");


                }
                else if(adapter.getItem(position).equals("종성 자음")){

                    consonant_initial_one.setVisibility((View.GONE));
                    consonant_initial_two.setVisibility((View.GONE));
                    finalconsonant_initial_one.setVisibility((View.VISIBLE));
                    finalconsonant_initial_two.setVisibility((View.VISIBLE));
                    vowel_one.setVisibility((View.GONE));
                    vowel_two.setVisibility((View.GONE));
                    vowel_three.setVisibility((View.GONE));
                    number_one.setVisibility(View.GONE);
                    number_two.setVisibility(View.GONE);
                    abbreviation_one.setVisibility(View.GONE);
                    abbreviation_two.setVisibility(View.GONE);
                    abbreviation_three.setVisibility(View.GONE);
                    conjunction_one.setVisibility(View.GONE);
                    conjunction_two.setVisibility(View.GONE);
                    alphabet_one.setVisibility(View.GONE);
                    alphabet_two.setVisibility(View.GONE);
                    alphabet_three.setVisibility(View.GONE);
                    alphabet_four.setVisibility(View.GONE);

                    viewmenu.setText("종성 자음");

                }
                else if(adapter.getItem(position).equals("모음")){

                    consonant_initial_one.setVisibility((View.GONE));
                    consonant_initial_two.setVisibility((View.GONE));
                    finalconsonant_initial_one.setVisibility((View.GONE));
                    finalconsonant_initial_two.setVisibility((View.GONE));
                    vowel_one.setVisibility((View.VISIBLE));
                    vowel_two.setVisibility((View.VISIBLE));
                    vowel_three.setVisibility((View.VISIBLE));
                    number_one.setVisibility(View.GONE);
                    number_two.setVisibility(View.GONE);
                    abbreviation_one.setVisibility(View.GONE);
                    abbreviation_two.setVisibility(View.GONE);
                    abbreviation_three.setVisibility(View.GONE);
                    conjunction_one.setVisibility(View.GONE);
                    conjunction_two.setVisibility(View.GONE);
                    alphabet_one.setVisibility(View.GONE);
                    alphabet_two.setVisibility(View.GONE);
                    alphabet_three.setVisibility(View.GONE);
                    alphabet_four.setVisibility(View.GONE);

                    viewmenu.setText("모음");

                }
                else if(adapter.getItem(position).equals("알파벳")){

                    consonant_initial_one.setVisibility((View.GONE));
                    consonant_initial_two.setVisibility((View.GONE));
                    finalconsonant_initial_one.setVisibility((View.GONE));
                    finalconsonant_initial_two.setVisibility((View.GONE));
                    vowel_one.setVisibility((View.GONE));
                    vowel_two.setVisibility((View.GONE));
                    vowel_three.setVisibility((View.GONE));
                    number_one.setVisibility(View.GONE);
                    number_two.setVisibility(View.GONE);
                    abbreviation_one.setVisibility(View.GONE);
                    abbreviation_two.setVisibility(View.GONE);
                    abbreviation_three.setVisibility(View.GONE);
                    conjunction_one.setVisibility(View.GONE);
                    conjunction_two.setVisibility(View.GONE);
                    alphabet_one.setVisibility(View.VISIBLE);
                    alphabet_two.setVisibility(View.VISIBLE);
                    alphabet_three.setVisibility(View.VISIBLE);
                    alphabet_four.setVisibility(View.VISIBLE);

                    viewmenu.setText("알파벳");

                }
                else if(adapter.getItem(position).equals("숫자")){

                    consonant_initial_one.setVisibility((View.GONE));
                    consonant_initial_two.setVisibility((View.GONE));
                    finalconsonant_initial_one.setVisibility((View.GONE));
                    finalconsonant_initial_two.setVisibility((View.GONE));
                    vowel_one.setVisibility((View.GONE));
                    vowel_two.setVisibility((View.GONE));
                    vowel_three.setVisibility((View.GONE));
                    number_one.setVisibility(View.VISIBLE);
                    number_two.setVisibility(View.VISIBLE);
                    abbreviation_one.setVisibility(View.GONE);
                    abbreviation_two.setVisibility(View.GONE);
                    abbreviation_three.setVisibility(View.GONE);
                    conjunction_one.setVisibility(View.GONE);
                    conjunction_two.setVisibility(View.GONE);
                    alphabet_one.setVisibility(View.GONE);
                    alphabet_two.setVisibility(View.GONE);
                    alphabet_three.setVisibility(View.GONE);
                    alphabet_four.setVisibility(View.GONE);

                    viewmenu.setText("숫자");

                }
                else if(adapter.getItem(position).equals("접속사")){

                    consonant_initial_one.setVisibility((View.GONE));
                    consonant_initial_two.setVisibility((View.GONE));
                    finalconsonant_initial_one.setVisibility((View.GONE));
                    finalconsonant_initial_two.setVisibility((View.GONE));
                    vowel_one.setVisibility((View.GONE));
                    vowel_two.setVisibility((View.GONE));
                    vowel_three.setVisibility((View.GONE));
                    number_one.setVisibility(View.GONE);
                    number_two.setVisibility(View.GONE);
                    abbreviation_one.setVisibility(View.GONE);
                    abbreviation_two.setVisibility(View.GONE);
                    abbreviation_three.setVisibility(View.GONE);
                    conjunction_one.setVisibility(View.VISIBLE);
                    conjunction_two.setVisibility(View.VISIBLE);
                    alphabet_one.setVisibility(View.GONE);
                    alphabet_two.setVisibility(View.GONE);
                    alphabet_three.setVisibility(View.GONE);
                    alphabet_four.setVisibility(View.GONE);

                    viewmenu.setText("접속사");

                }
                else if(adapter.getItem(position).equals("약자")){

                    consonant_initial_one.setVisibility((View.GONE));
                    consonant_initial_two.setVisibility((View.GONE));
                    finalconsonant_initial_one.setVisibility((View.GONE));
                    finalconsonant_initial_two.setVisibility((View.GONE));
                    vowel_one.setVisibility((View.GONE));
                    vowel_two.setVisibility((View.GONE));
                    vowel_three.setVisibility((View.GONE));
                    number_one.setVisibility(View.GONE);
                    number_two.setVisibility(View.GONE);
                    abbreviation_one.setVisibility(View.VISIBLE);
                    abbreviation_two.setVisibility(View.VISIBLE);
                    abbreviation_three.setVisibility(View.VISIBLE);
                    conjunction_one.setVisibility(View.GONE);
                    conjunction_two.setVisibility(View.GONE);
                    alphabet_one.setVisibility(View.GONE);
                    alphabet_two.setVisibility(View.GONE);
                    alphabet_three.setVisibility(View.GONE);
                    alphabet_four.setVisibility(View.GONE);

                    viewmenu.setText("약자");

                }
            }
            public void onNothingSelected(AdapterView<?>  parent) {


            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.not_move_activit,R.anim.leftout_activity);

    }
}





