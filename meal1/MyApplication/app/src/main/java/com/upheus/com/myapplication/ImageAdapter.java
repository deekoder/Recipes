package com.upheus.com.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.upheus.com.myapplication.CardModel;
import com.upheus.com.myapplication.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Zoey on 8/6/14.
 */
public class ImageAdapter extends BaseAdapter {

        private Context context;

        private ArrayList<CardModel> pCards = new ArrayList<CardModel>();

        int len;

        public ImageAdapter(Context context, ArrayList<CardModel> p1Cards, int length) {
            this.context = context;
           // pCards = new CardModel[length];
            len = length;
           // Log.v("Constructor", String.valueOf(length));

            for (int i=0; i<len; i++) {
                //pCards[i] = new CardModel();

                pCards.add(i, p1Cards.get(i));
                //Log.v("Constructor:-->", pCards[i].cardText);
               // pCards[i].cardFace = p1Cards[i].cardFace;

            }



        }

    public View getView(int position, View convertView, ViewGroup parent) {


        View gridView;


        if (convertView == null) {
            gridView = new View(context);



        } else {

            gridView = (View) convertView;
        }


        // get layout from mobile.xml
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        gridView = inflater.inflate(R.layout.deal_layout, null);

        CardModel itemCard = getItem(position);
        // set value into textview
        TextView textView = (TextView) gridView
            .findViewById(R.id.textView);
        textView.setText(itemCard.cardText);

        // set image based on selected text
        ImageView imageView = (ImageView) gridView
            .findViewById(R.id.imageView);


        imageView.setImageResource(itemCard.cardFace);
        return gridView;
    }

    @Override
    public int getCount() {
       // Log.v("Calling size :", String.valueOf(len));
        return len;
    }

    @Override
    public CardModel getItem(int position) {
        return pCards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
