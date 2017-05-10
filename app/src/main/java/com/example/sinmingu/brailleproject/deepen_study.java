package com.example.sinmingu.brailleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class deepen_study extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deepen_study);

        ExpandableListView elv = (ExpandableListView) findViewById(R.id.deepen_list);

        final ArrayList<position> position = getData();

        //create and bind to adatper
        deepenAdapter adapter = new deepenAdapter(this, position);
        elv.setAdapter(adapter);

        //set onclick listener
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), position.get(groupPosition).players.get(childPosition), Toast.LENGTH_LONG).show();
                return false;
            }
        });



    }
    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.not_move_activit,R.anim.leftout_activity);

    }


    private ArrayList<position> getData() {

        position p1 = new position("첫소리 자리에 쓰인 자음자");
        p1.players.add("1");
        p1.players.add("2");
        p1.players.add("3");

        position p2 = new position("받침으로 쓰인 자음자");
        p2.players.add("4");
        p2.players.add("5");
        p2.players.add("6");

        position p3 = new position("모 음 자");
        p3.players.add("7");
        p3.players.add("8");

        position p4 = new position("단독으로 쓰인 자모");
        p4.players.add("9");

        position p5 = new position("모음 연쇄");
        p5.players.add("10");
        p5.players.add("11");


        ArrayList<position> allposition = new ArrayList<>();
        allposition.add(p1);
        allposition.add(p2);
        allposition.add(p3);
        allposition.add(p4);
        allposition.add(p5);

        return allposition;
    }


}
