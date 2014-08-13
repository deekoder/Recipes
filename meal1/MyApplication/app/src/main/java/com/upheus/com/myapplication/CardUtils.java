package com.upheus.com.myapplication;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Zoey on 8/6/14.
 */
public class CardUtils {

    ArrayList <CardModel> cardsArrayList;

    ArrayList <CardModel> pile1ArrayList;
    ArrayList <CardModel> pile2ArrayList;
    ArrayList <CardModel> pile3ArrayList;

    ArrayList <CardModel> playingCardsArrayList;



    ArrayList <CardModel> finalAnswer;
    CardModel[] cards = new CardModel[52];

    static int set1=0, set2=0, set3=0;

    int playCount[] = new int[52];



    public CardUtils() {

        playingCardsArrayList = new ArrayList<CardModel>();
        cardsArrayList = new ArrayList<CardModel>();
        pile1ArrayList = new ArrayList<CardModel>();
        pile2ArrayList = new ArrayList<CardModel>();
        pile3ArrayList = new ArrayList<CardModel>();

        loadCards();
        loadPlayingCards();

    }

    public void deal() {

        int index1=0, index2=0, index3=0;

        for (int i=0; i<21; i+=3)
        {

                pile1ArrayList.add(index1, playingCardsArrayList.get(i));
                pile2ArrayList.add(index2,playingCardsArrayList.get(i+1));
                pile3ArrayList.add(index3,playingCardsArrayList.get(i+2));
                index1++; index2++; index3++;


        }


    }



    public void play() {


        if(set1==1) {

            int index=0;
            playingCardsArrayList.clear();

            for(int i=0; i<7; i++) {

                playingCardsArrayList.add(i, pile2ArrayList.get(i));


            }
            index = 0;
            for(int j=7; j<14; j++) {
                playingCardsArrayList.add(j, pile1ArrayList.get(index));

                index++;
            }
            index = 0;
            for(int k=14;k<21;k++) {

                playingCardsArrayList.add(k, pile3ArrayList.get(index));
                index++;

            }

            set1=0;
            set2=0;
            set3=0;

        }
        if(set2==1){

            int index=0;
            for(int i=0; i<7; i++) {

                playingCardsArrayList.add(i, pile1ArrayList.get(i));

            }
            index = 0;
            for(int j=7; j<14; j++) {
                playingCardsArrayList.add(j, pile2ArrayList.get(index));

                index++;
            }
            index = 0;
            for(int k=14;k<21;k++) {

                playingCardsArrayList.add(k, pile3ArrayList.get(index));

                index++;

            }
            set1=0;
            set2=0;
            set3=0;

        }
        if(set3==1) {

            int index=0;
            for(int i=0; i<7; i++) {

                playingCardsArrayList.add(i, pile2ArrayList.get(i));


            }
            index = 0;
            for(int j=7; j<14; j++) {

                playingCardsArrayList.add(j, pile3ArrayList.get(index));

                index++;
            }
            index = 0;
            for(int k=14;k<21;k++) {
                playingCardsArrayList.add(k, pile1ArrayList.get(index));

                index++;

            }
            set1=0;
            set2=0;
            set3=0;


        }

    }

    public void loadPlayingCards() {

        //--START the Shuffler using Fisher-Yates Algo ---

        for (int j=0; j<51; j++) {
            playCount[j] = j;
        }

        int index, ndex;
        Random random = new Random();
        for (int i = playCount.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                playCount[index] ^= playCount[i];
                playCount[i] ^= playCount[index];
                playCount[index] ^= playCount[i];
            }
        }

         // -- END Of Shuffling ----



        for (int i=0; i<21; i++) {

            //assign 21 random cards from cardsArrayList to playingCardsArrayList
            ndex = playCount[i];
            playingCardsArrayList.add(i,cardsArrayList.get(ndex));
        }


    }

    public void printCards() {

        Log.v("======Begin=====", "Shuffler Produces :");

        for (int j=0; j<51; j++) {
            Log.v("PlayCount - ", String.valueOf(playCount[j]));
        }

        Log.v("======End=====", "Shuffler");

        for (int i=0; i<52; i++) {


            Log.v("Position"+String.valueOf(i),String.valueOf(cardsArrayList.get(i).cardText));
        }


        Log.v("======Begin=====", "Playing Cards");
        for(int i=0;i<21;i++) {

            Log.v("Cards :", playingCardsArrayList.get(i).cardText);

        }

        Log.v("======End=====", "Playing Cards");




    }

    public void printArrays() {

        for(int i=0;i<7;i++) {

            Log.v("Pile 1 :"+ String.valueOf(i), pile1ArrayList.get(i).cardText);

        }

        for(int i=0;i<7;i++) {

            Log.v("Pile 2 :"+ String.valueOf(i), pile2ArrayList.get(i).cardText);

        }
        for(int i=0;i<7;i++) {

            Log.v("Pile 3 :"+ String.valueOf(i), pile3ArrayList.get(i).cardText);

        }

        for(int i=0;i<21;i++)
            Log.v("Play Array has ::", playingCardsArrayList.get(i).cardText);



    }

    public void loadCards() {

        //CardModel[] cards;
        for (int i=0;i<52;i++)
            cards[i] = new CardModel();


        //This can be compacted later on.

        cards[0].cardFace = R.drawable.c1;  cards[0].cardText = "A's Clover";
        cardsArrayList.add(0,cards[0]);

        cards[1].cardFace = R.drawable.c2;  cards[1].cardText = "2 Clover";
        cardsArrayList.add(1,cards[1]);

        cards[2].cardFace = R.drawable.c3;  cards[2].cardText = "3 Clover";
        cardsArrayList.add(2,cards[2]);

        cards[3].cardFace = R.drawable.c4;  cards[3].cardText = "4 Clover";
        cardsArrayList.add(3,cards[3]);

        cards[4].cardFace = R.drawable.c5;  cards[4].cardText = "5 Clover";
        cardsArrayList.add(4,cards[4]);

        cards[5].cardFace = R.drawable.c6;  cards[5].cardText = "6 Clover";
        cardsArrayList.add(5,cards[5]);

        cards[6].cardFace = R.drawable.c7;  cards[6].cardText = "7 Clover";
        cardsArrayList.add(6,cards[6]);

        cards[7].cardFace = R.drawable.c8;  cards[7].cardText = "8 Clover";
        cardsArrayList.add(7,cards[7]);

        cards[8].cardFace = R.drawable.c9;  cards[8].cardText = "9 Clover";
        cardsArrayList.add(8,cards[8]);

        cards[9].cardFace = R.drawable.c10; cards[9].cardText = "10 Clover";
        cardsArrayList.add(9,cards[9]);

        cards[10].cardFace = R.drawable.cj; cards[10].cardText = "J Clover";
        cardsArrayList.add(10,cards[10]);

        cards[11].cardFace = R.drawable.ck; cards[11].cardText = "K Clover";
        cardsArrayList.add(11,cards[11]);

        cards[12].cardFace = R.drawable.cq; cards[12].cardText = "Q Clover";
        cardsArrayList.add(12,cards[12]);

        cards[13].cardFace =  R.drawable.d1;  cards[13].cardText = "A's Dice";
        cardsArrayList.add(13,cards[13]);

        cards[14].cardFace =  R.drawable.d2;  cards[14].cardText = "2 Dice";
        cardsArrayList.add(14,cards[14]);

        cards[15].cardFace =  R.drawable.d3;  cards[15].cardText = "3 Dice";
        cardsArrayList.add(15,cards[15]);

        cards[16].cardFace =  R.drawable.d4;  cards[16].cardText = "4 Dice";
        cardsArrayList.add(16,cards[16]);

        cards[17].cardFace =  R.drawable.d5;  cards[17].cardText = "5 Dice";
        cardsArrayList.add(17,cards[17]);

        cards[18].cardFace =  R.drawable.d6;  cards[18].cardText = "6 Dice";
        cardsArrayList.add(18,cards[18]);

        cards[19].cardFace =  R.drawable.d7;  cards[19].cardText = "7 Dice";
        cardsArrayList.add(19,cards[19]);

        cards[20].cardFace =  R.drawable.d8;  cards[20].cardText = "8 Dice";
        cardsArrayList.add(20,cards[20]);

        cards[21].cardFace =  R.drawable.d9;  cards[21].cardText = "9 Dice";
        cardsArrayList.add(21,cards[21]);

        cards[22].cardFace =  R.drawable.d10; cards[22].cardText = "10 Dice";
        cardsArrayList.add(22,cards[22]);

        cards[23].cardFace =  R.drawable.dj; cards[23].cardText = "J Dice";
        cardsArrayList.add(23,cards[23]);

        cards[24].cardFace =  R.drawable.dk; cards[24].cardText = "K Dice";
        cardsArrayList.add(24,cards[24]);

        cards[25].cardFace =  R.drawable.dq; cards[25].cardText = "Q Dice";
        cardsArrayList.add(25,cards[25]);

        cards[26].cardFace =  R.drawable.s1;  cards[26].cardText = "A's Spade";
        cardsArrayList.add(26,cards[26]);

        cards[27].cardFace =  R.drawable.s2;  cards[27].cardText = "2 Spade";
        cardsArrayList.add(27,cards[27]);

        cards[28].cardFace =  R.drawable.s3;  cards[28].cardText = "3 Spade";
        cardsArrayList.add(28,cards[28]);

        cards[29].cardFace =  R.drawable.s4;  cards[29].cardText = "4 Spade";
        cardsArrayList.add(29,cards[29]);

        cards[30].cardFace =  R.drawable.s5;  cards[30].cardText = "5 Spade";
        cardsArrayList.add(30,cards[30]);

        cards[31].cardFace =  R.drawable.s6;  cards[31].cardText = "6 Spade";
        cardsArrayList.add(31,cards[31]);

        cards[32].cardFace =  R.drawable.s7;  cards[32].cardText = "7 Spade";
        cardsArrayList.add(32,cards[32]);

        cards[33].cardFace =  R.drawable.s8;  cards[33].cardText = "8 Spade";
        cardsArrayList.add(33,cards[33]);

        cards[34].cardFace = R.drawable.s9;  cards[34].cardText = "9 Spade";
        cardsArrayList.add(34,cards[34]);

        cards[35].cardFace =  R.drawable.s10; cards[35].cardText = "10 Spade";
        cardsArrayList.add(35,cards[35]);

        cards[36].cardFace =  R.drawable.sj; cards[36].cardText = "J Spade";
        cardsArrayList.add(36,cards[36]);

        cards[37].cardFace =  R.drawable.sk; cards[37].cardText = "K Spade";
        cardsArrayList.add(37,cards[37]);

        cards[38].cardFace =  R.drawable.sq; cards[38].cardText = "Q Spade";
        cardsArrayList.add(38,cards[38]);

        cards[39].cardFace =  R.drawable.h1;  cards[39].cardText = "A's Hearts";
        cardsArrayList.add(39,cards[39]);

        cards[40].cardFace =  R.drawable.h2;  cards[40].cardText = "2 Hearts";
        cardsArrayList.add(40,cards[40]);

        cards[41].cardFace =  R.drawable.h3;  cards[41].cardText = "3 Hearts";
        cardsArrayList.add(41,cards[41]);

        cards[42].cardFace =  R.drawable.h4;  cards[42].cardText = "4 Hearts";
        cardsArrayList.add(42,cards[42]);

        cards[43].cardFace =  R.drawable.h5;  cards[43].cardText = "5 Hearts";
        cardsArrayList.add(43,cards[43]);

        cards[44].cardFace =  R.drawable.h6;  cards[44].cardText = "6 Hearts";
        cardsArrayList.add(44,cards[44]);

        cards[45].cardFace =  R.drawable.h7;  cards[45].cardText = "7 Hearts";
        cardsArrayList.add(45,cards[45]);

        cards[46].cardFace =  R.drawable.h8;  cards[46].cardText = "8 Hearts";
        cardsArrayList.add(46,cards[46]);

        cards[47].cardFace =  R.drawable.h9;  cards[47].cardText = "9 Hearts";
        cardsArrayList.add(47,cards[47]);

        cards[48].cardFace =  R.drawable.h10; cards[48].cardText = "10 Hearts";
        cardsArrayList.add(48,cards[48]);

        cards[49].cardFace =  R.drawable.hj; cards[49].cardText = "J Hearts";
        cardsArrayList.add(49,cards[49]);

        cards[50].cardFace =  R.drawable.hk; cards[50].cardText = "K Hearts";
        cardsArrayList.add(50,cards[50]);

        cards[51].cardFace =  R.drawable.hq; cards[51].cardText = "Q Hearts";
        cardsArrayList.add(51,cards[51]);
    }
}
