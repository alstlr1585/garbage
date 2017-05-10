package com.example.sinmingu.brailleproject;

/**
 * Created by sinmingu on 2017-04-12.
 */

import android.content.Context;
import android.graphics.Color;
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
            imageView.setImageResource(R.drawable.alphabet_2);
        } else {
            imageView.setImageResource(R.drawable.alphabet_2);
        }

        convertView.setBackgroundColor(Color.parseColor("#ffffff"));
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
        if (positionName == "pitcher") {
            if (child == "1") {
                img.setImageResource(R.drawable.test_1);

            }
            else if (child == "2"){
                img.setImageResource(R.drawable.test_2);
            }
            else if (child == "3"){
                img.setImageResource(R.drawable.test_3);
            }
        } else if (positionName == "infield") {
            //if (child == "문규현") {
                img.setImageResource(R.drawable.study_deepen_1);
            //}
        } else if (positionName == "catcher") {
            //if (child == "강민호") {
                img.setImageResource(R.drawable.study_deepen_2);
            //}
        } else if (positionName == "outfield") {
            //if (child == "Jim Adduci") {
                img.setImageResource(R.drawable.study_deepen_3);
            //}
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
