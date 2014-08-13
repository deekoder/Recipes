package com.upheus.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;


public class SplitActivity extends Activity {


    GridView g4,g2,g3;
    Button blueButton, violetButton, yellowButton;
    int playCount=0;
    private ImageAdapter a1, a2, a3;
    Intent doneIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dealt_layout);


        g2 = (GridView) findViewById(R.id.gridView2);
        g3 = (GridView) findViewById(R.id.gridView3);
        g4 = (GridView) findViewById(R.id.gridView4);

        blueButton = (Button) findViewById(R.id.button1);
        violetButton = (Button) findViewById(R.id.button2);
        yellowButton = (Button) findViewById(R.id.button3);

        Log.v("Before Dealing", "Piles are not set");

        MyActivity.cutil.deal();



        g2.setAdapter(a1 = new ImageAdapter(this, MyActivity.cutil.pile1ArrayList,7));
        g3.setAdapter(a2 = new ImageAdapter(this, MyActivity.cutil.pile2ArrayList,7));
        g4.setAdapter(a3 = new ImageAdapter(this, MyActivity.cutil.pile3ArrayList,7));


        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (playCount < 4) {
                    CardUtils.set1 = 1;
                    Log.v("Blue Button", "Pressed");

                   // MyActivity.cutil.refresh();


                    MyActivity.cutil.play();
                    playCount++;

                    g2.setAdapter(a1 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile1ArrayList, 7));

                    g3.setAdapter(a2 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile2ArrayList, 7));

                    g4.setAdapter(a3 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile3ArrayList, 7));

                    a1.notifyDataSetChanged();
                    a2.notifyDataSetChanged();
                    a3.notifyDataSetChanged();

                    MyActivity.cutil.deal();


                    g2.setAdapter(a1 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile1ArrayList, 7));

                    g3.setAdapter(a2 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile2ArrayList, 7));

                    g4.setAdapter(a3 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile3ArrayList, 7));

                    a1.notifyDataSetChanged();
                    a2.notifyDataSetChanged();
                    a3.notifyDataSetChanged();

                   // MyActivity.cutil.printArrays();
                    if (playCount == 3) {

                        MyActivity.cutil.play();

                        Log.v("DOne playing 3 times", MyActivity.cutil.playingCardsArrayList.get(10).cardText);
                        doneIntent = new Intent(getApplicationContext(),DoneActivity.class);
                        startActivity(doneIntent);
                        //Intent revealIntent = new Intent(getApplicationContext(), RevealActivity.class);

                    }

                }
            }
        });

        violetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(playCount < 4) {
                    CardUtils.set2 = 1;
                    Log.v("Violet Button", "Pressed");
                  //  MyActivity.cutil.refresh();


                    MyActivity.cutil.play();

                    g2.setAdapter(a1 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile1ArrayList, 7));

                    g3.setAdapter(a2 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile2ArrayList, 7));

                    g4.setAdapter(a3 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile3ArrayList, 7));

                    playCount++;

                    a1.notifyDataSetChanged();
                    a2.notifyDataSetChanged();
                    a3.notifyDataSetChanged();

                    MyActivity.cutil.deal();

                    g2.setAdapter(a1 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile1ArrayList, 7));

                    g3.setAdapter(a2 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile2ArrayList, 7));

                    g4.setAdapter(a3 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile3ArrayList, 7));
                    a1.notifyDataSetChanged();
                    a2.notifyDataSetChanged();
                    a3.notifyDataSetChanged();
                    //MyActivity.cutil.printArrays();
                    if (playCount == 3) {

                        MyActivity.cutil.play();
                        Log.v("DOne playing 3 times", MyActivity.cutil.playingCardsArrayList.get(10).cardText);
                        doneIntent = new Intent(getApplicationContext(),DoneActivity.class);
                        startActivity(doneIntent);
                        //Intent revealIntent = new Intent(getApplicationContext(), RevealActivity.class);

                    }
                }
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (playCount < 4) {
                    CardUtils.set3 = 1;
                    Log.v("Yellow Button", "Pressed");

                  //  MyActivity.cutil.refresh();

                    a1.notifyDataSetChanged();
                    a2.notifyDataSetChanged();
                    a3.notifyDataSetChanged();
                    MyActivity.cutil.play();
                    playCount++;

                    g2.setAdapter(a1 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile1ArrayList, 7));

                    g3.setAdapter(a2 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile2ArrayList, 7));

                    g4.setAdapter(a3 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile3ArrayList, 7));
                    a1.notifyDataSetChanged();
                    a2.notifyDataSetChanged();
                    a3.notifyDataSetChanged();

                    MyActivity.cutil.deal();
                    g2.setAdapter(a1 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile1ArrayList, 7));

                    g3.setAdapter(a2 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile2ArrayList, 7));

                    g4.setAdapter(a3 = new ImageAdapter(getApplicationContext(), MyActivity.cutil.pile3ArrayList, 7));
                    a1.notifyDataSetChanged();
                    a2.notifyDataSetChanged();
                    a3.notifyDataSetChanged();
                    //MyActivity.cutil.printArrays();
                    if (playCount == 3) {

                        MyActivity.cutil.play();
                        Log.v("DOne playing 3 times", MyActivity.cutil.playingCardsArrayList.get(10).cardText);
                        doneIntent = new Intent(getApplicationContext(),DoneActivity.class);
                        startActivity(doneIntent);
                        //Intent revealIntent = new Intent(getApplicationContext(), RevealActivity.class);

                    }
                }
            }
        });

        if(playCount==3) {

            MyActivity.cutil.play();
            Log.v("DOne playing 3 times",MyActivity.cutil.playingCardsArrayList.get(10).cardText);
            //Intent revealIntent = new Intent(getApplicationContext(), RevealActivity.class);
            doneIntent = new Intent(getApplicationContext(),DoneActivity.class);
            startActivity(doneIntent);

        }


        //.setAdapter(new ImageAdapter(this, playingCards));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.split, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
