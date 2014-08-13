package com.upheus.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;


public class DoneActivity extends Activity {

    GridView finalGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        MyActivity.cutil.finalAnswer = new ArrayList<CardModel>();
        MyActivity.cutil.finalAnswer.add(0,MyActivity.cutil.playingCardsArrayList.get(10));

        finalGrid = (GridView)findViewById(R.id.finalGrid);
        finalGrid.setAdapter(new ImageAdapter(this, MyActivity.cutil.finalAnswer, 1));

    }



}
