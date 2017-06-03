package com.example.sinmingu.brailleproject;

/**
 * Created by sinmingu on 2017-04-12.
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class deepenAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private ArrayList<position> position;
    private LayoutInflater inflater;

    //class Constructor
    public deepenAdapter (Context mContext, ArrayList<position> position) {

        this.mContext = mContext;
        this.position = position;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getGroupCount() {
        return position.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return position.get(groupPosition).players.size();
    }

    //get position
    @Override
    public Object getGroup(int groupPosition) {
        return position.get(groupPosition);
    }

    //this is where we get the information of player
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return position.get(groupPosition).players.get(childPosition);
    }

    //position ID
    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    //where to get player's id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //get parent row
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.deepen_parent, null);
        }

        //get position
        position position = (position) getGroup(groupPosition);

        //set positionName
        String positionName = position.position;

        TextView textView = (TextView) convertView.findViewById(R.id.position_tv);
        textView.setText(positionName);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.indicator);
        if(isExpanded){
            imageView.setImageResource(R.drawable.up_arrow);
        } else {
            imageView.setImageResource(R.drawable.down_arrow);
        }

        convertView.setBackgroundColor(Color.parseColor("#F6F6F6"));
        return convertView;
    }

    //get child_list.xml (View)
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        //inflate the layout
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.deepen_child, null);
        }

        String child = (String) getChild(groupPosition, childPosition);

        //set the child name
        TextView name = (TextView) convertView.findViewById(R.id.name_tv);
        //get the imageView
        ImageView img = (ImageView) convertView.findViewById(R.id.playerpic);

        name.setText(child);

        //get position name
        String positionName = (String) getGroup(groupPosition).toString();
        if (positionName == "첫소리 자리에 쓰인 자음자") {
            if (child == "1") {
                img.setImageResource(R.drawable.test_1);

            }
            else if (child == "2"){
                img.setImageResource(R.drawable.test_2);
            }
            else if (child == "3"){
                img.setImageResource(R.drawable.test_3);
            }
        } else if (positionName == "받침으로 쓰인 자음자") {
            if (child == "4") {
                img.setImageResource(R.drawable.study_deepen_4);
            }
            else if(child =="5") {
                img.setImageResource(R.drawable.study_deepen_5);
            }
            else if(child =="6"){
                img.setImageResource(R.drawable.study_deepen_6);
            }
        } else if (positionName == "모 음 자") {
            if (child == "7") {
                img.setImageResource(R.drawable.study_deepen_7);
            }
            else if(child=="8"){
                img.setImageResource(R.drawable.study_deepen_8);
            }
        } else if (positionName == "단독으로 쓰인 자모") {
            if (child == "9") {
                img.setImageResource(R.drawable.study_deepen_9);
            }
        } else if(positionName == "모음 연쇄"){
            if(child=="10"){
                img.setImageResource(R.drawable.study_deepen_10);
            }
            else if(child=="11"){
                img.setImageResource(R.drawable.study_deepen_11);
            }

        } else if(positionName == "약 자"){
            if(child=="12"){
                img.setImageResource(R.drawable.deppen_abbreviation1);
            }
            else if(child=="13"){
                img.setImageResource(R.drawable.deppen_abbreviation2);
            }
            else if(child=="14"){
                img.setImageResource(R.drawable.deppen_abbreviation3);
            }
        } else if(positionName == "약 어"){
            if(child=="15"){
                img.setImageResource(R.drawable.deppen_abb1);
            }
            else if(child=="16"){
                img.setImageResource(R.drawable.deppen_abb2);
            }
            else if(child=="17"){
                img.setImageResource(R.drawable.deppen_abb3);
            }
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
