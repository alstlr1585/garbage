package com.example.sinmingu.brailleproject;

/**
 * Created by sinmingu on 2017-04-12.
 */
import java.util.ArrayList;

public class position {

    public String position;
    public String image;
    public ArrayList<String> players = new ArrayList<String>();

    public position(String position){
        this.position = position;
    }

    public String toString () {
        return position;
    }

}
