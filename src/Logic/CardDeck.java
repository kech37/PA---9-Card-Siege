/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cards.EventCard;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * @author andre
 */
public class CardDeck {

    ArrayList<EventCard> Cards;
    ArrayList<EventCard> UsedCards;

    public void Shuffle() {
        //AddCards();
        UsedCards.clear();
        ArrayList<EventCard> temp = Cards;

        Cards.clear();
        Random r = new Random();

        while (!temp.isEmpty()) {
            int x = r.nextInt(temp.size());

            Cards.add(temp.get(x));
            temp.remove(x);
        }
    }

    public boolean addCard(Event day1, Event day2, Event day3) {
        return this.Cards.add(new EventCard(day1, day2, day3));
    }

    /*public EventCard getCard() throws NoSuchElementException {
        if (Cards.isEmpty()) {
            throw new NoSuchElementException();
        }
        UsedCards.add(Cards.get(0));
        Cards.remove(0);
        return UsedCards.get(UsedCards.size() - 1);
    }*/
    

}
