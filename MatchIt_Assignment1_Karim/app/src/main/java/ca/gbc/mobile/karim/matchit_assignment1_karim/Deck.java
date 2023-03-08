package ca.gbc.mobile.karim.matchit_assignment1_karim;

import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

/***************************************************************************************************
 * KARIM KHOJA
 * 100874100
 * Created on October 12, 2014
 * Last Modified on October 24, 2014
 **************************************************************************************************/

public class Deck implements View.OnClickListener
{
    ArrayList<Integer> ListOfCards = new ArrayList<Integer>();
    ArrayList<Integer> DeckOfPairs = new ArrayList<Integer>();
    ArrayList<CardView> FinalDeck = new ArrayList<CardView>();
    int[][] FlippedCards = new int[2][3];
    int CardsMatched = 0;
    GameActivity activity;
    int counter = 0;

    Deck(ArrayList<CardView> listOfCards, GameActivity activity) {
        this.activity = activity;
        FinalDeck = listOfCards;
        getCards();
        makePairsOfCards();
        finalizeCards();
    }

    public void makePairsOfCards() {
        Shuffle(ListOfCards);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++){
        temp.add(ListOfCards.get(i));}
        DeckOfPairs.addAll(temp);
        DeckOfPairs.addAll(temp);
        Shuffle(DeckOfPairs);
    }

    private void finalizeCards() {
        for (int i = 0; i < 12; i++)
        {
            CardView card = FinalDeck.get(i);
            Integer front = getNextCard();
            Integer back = R.drawable.b1fv;
            card.setBacksrc(back);
            card.setFrontsrc(front);
            enableAll();
        }
    }

    private void getCards() {
        ListOfCards.add(R.drawable.c1);
        ListOfCards.add(R.drawable.c2);
        ListOfCards.add(R.drawable.c3);
        ListOfCards.add(R.drawable.c4);
        ListOfCards.add(R.drawable.c5);
        ListOfCards.add(R.drawable.c6);
        ListOfCards.add(R.drawable.c7);
        ListOfCards.add(R.drawable.c8);
        ListOfCards.add(R.drawable.c9);
        ListOfCards.add(R.drawable.c10);
        ListOfCards.add(R.drawable.cj);
        ListOfCards.add(R.drawable.ck);
        ListOfCards.add(R.drawable.cq);
        ListOfCards.add(R.drawable.d1);
        ListOfCards.add(R.drawable.d2);
        ListOfCards.add(R.drawable.d3);
        ListOfCards.add(R.drawable.d4);
        ListOfCards.add(R.drawable.d5);
        ListOfCards.add(R.drawable.d6);
        ListOfCards.add(R.drawable.d7);
        ListOfCards.add(R.drawable.d8);
        ListOfCards.add(R.drawable.d9);
        ListOfCards.add(R.drawable.d10);
        ListOfCards.add(R.drawable.dj);
        ListOfCards.add(R.drawable.dk);
        ListOfCards.add(R.drawable.dq);
        ListOfCards.add(R.drawable.ec);
        ListOfCards.add(R.drawable.h1);
        ListOfCards.add(R.drawable.h2);
        ListOfCards.add(R.drawable.h3);
        ListOfCards.add(R.drawable.h4);
        ListOfCards.add(R.drawable.h5);
        ListOfCards.add(R.drawable.h6);
        ListOfCards.add(R.drawable.h7);
        ListOfCards.add(R.drawable.h8);
        ListOfCards.add(R.drawable.h9);
        ListOfCards.add(R.drawable.h10);
        ListOfCards.add(R.drawable.hj);
        ListOfCards.add(R.drawable.hk);
        ListOfCards.add(R.drawable.hq);
        ListOfCards.add(R.drawable.jb);
        ListOfCards.add(R.drawable.jr);
        ListOfCards.add(R.drawable.s1);
        ListOfCards.add(R.drawable.s2);
        ListOfCards.add(R.drawable.s3);
        ListOfCards.add(R.drawable.s4);
        ListOfCards.add(R.drawable.s5);
        ListOfCards.add(R.drawable.s6);
        ListOfCards.add(R.drawable.s7);
        ListOfCards.add(R.drawable.s8);
        ListOfCards.add(R.drawable.s9);
        ListOfCards.add(R.drawable.s10);
        ListOfCards.add(R.drawable.sj);
        ListOfCards.add(R.drawable.sk);
        ListOfCards.add(R.drawable.sq);
    }

    private boolean match() {
        boolean response;
        if (FlippedCards[0][1] == FlippedCards[1][1])
            response = true;
        else
            response = false;
        return response;
    }

    private void disable(int num) {
            FinalDeck.get(num).setOnClickListener(null);
            FinalDeck.get(num).enabled = false;
    }

    private void enableAll() {
        for(int i = 0; i < 12; i++)
        {
            FinalDeck.get(i).setOnClickListener(this);
            FinalDeck.get(i).enabled = true;
        }
    }

    public void Shuffle(ArrayList<Integer> cards){
        Collections.shuffle(cards);
    }

    public int getNextCard() {
        int card = DeckOfPairs.get(counter);
        if (counter >= DeckOfPairs.size())
            counter = 0;
        else
            counter++;
        return card;
    }

    @Override
    public void onClick(View v) {
        if ((FlippedCards[1][0] != 0) && (!match()))
        {
            FinalDeck.get(FlippedCards[1][0] - 1).switchFlipped();
            FinalDeck.get(FlippedCards[0][0] - 1).switchFlipped();
            enableAll();
            FlippedCards[0][0] = 0;
            FlippedCards[1][0] = 0;
            FlippedCards[0][1] = 0;
            FlippedCards[1][1] = 0;
        }
        if ((FlippedCards[1][0] != 0) && (match()))
        {
//            FinalDeck.get(FlippedCards[1][0] - 1).switchFlipped();
//            FinalDeck.get(FlippedCards[0][0] - 1).switchFlipped();
            FinalDeck.get(FlippedCards[0][0] - 1).setVisibility(View.INVISIBLE);
            FinalDeck.get(FlippedCards[1][0] - 1).setVisibility(View.INVISIBLE);
            enableAll();
            FlippedCards[0][0] = 0;
            FlippedCards[1][0] = 0;
            FlippedCards[0][1] = 0;
            FlippedCards[1][1] = 0;
        }
        if (FlippedCards[1][0] == 0)
        {
            int selected = 0;

            for (int i = 0; i < 12; i++)
            {
                if (FinalDeck.get(i).getId() == v.getId())
                {
                    selected = i;
                    break;
                }
            }
            if(!FinalDeck.get(selected).matched)
            {
                if (FlippedCards[0][0] == 0)
                {
                    FlippedCards[0][0] = selected + 1;
                    FlippedCards[0][1] = FinalDeck.get(selected).getFrontsrc();
                    FinalDeck.get(selected).switchFlipped();
                    disable(selected);
                }
                else
                {
                    FlippedCards[1][0] = selected + 1;
                    FlippedCards[1][1] = FinalDeck.get(selected).getFrontsrc();
                    FinalDeck.get(selected).switchFlipped();
                }

            }
            if (FlippedCards[1][0] != 0)
            {
                if (match())
                {
                    FinalDeck.get(FlippedCards[0][0] - 1).takeOut();
                    FinalDeck.get(FlippedCards[1][0] - 1).takeOut();
                    CardsMatched += 2;
                }
//                else
//                {
//                    FinalDeck.get(FlippedCards[1][0] - 1).switchFlipped();
//                    FinalDeck.get(FlippedCards[0][0] - 1).switchFlipped();
//                }

//                FlippedCards[0][0] = 0;
//                FlippedCards[1][0] = 0;
//                FlippedCards[0][1] = 0;
//                FlippedCards[1][1] = 0;

                if(CardsMatched == 12) {
                    activity.EndGame();
                }
                enableAll();
            }
        }
//        else if (FlippedCards[1][0] != 0)
//        {
//            if (match())
//            {
//                FinalDeck.get(FlippedCards[0][0] - 1).takeOut();
//                FinalDeck.get(FlippedCards[1][0] - 1).takeOut();
//                CardsMatched += 2;
//            }
//            else
//            {
//                FinalDeck.get(FlippedCards[1][0] - 1).switchFlipped();
//                FinalDeck.get(FlippedCards[0][0] - 1).switchFlipped();
//            }
//
//            FlippedCards[0][0] = 0;
//            FlippedCards[1][0] = 0;
//            FlippedCards[0][1] = 0;
//            FlippedCards[1][1] = 0;
//
//            if(CardsMatched == 12) {
//                activity.EndGame();
//            }
//            enableAll();
//        }

    }
}
