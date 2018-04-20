/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards;

import Logic.Cards.EventCards.*;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author andre
 */
public class CardDeck {

    ArrayList<BaseEventCard> Cards;
    ArrayList<BaseEventCard> UsedCards;

    public CardDeck(GameData gameData) {
        this.Cards.add(new EventCard1(gameData));
        this.Cards.add(new EventCard2(gameData));
        this.Cards.add(new EventCard3(gameData));
        this.Cards.add(new EventCard4(gameData));
        this.Cards.add(new EventCard5(gameData));
        this.Cards.add(new EventCard6(gameData));
        this.Cards.add(new EventCard7(gameData));
    }

    public void Shuffle() {
        UsedCards.clear();
        ArrayList<BaseEventCard> temp = Cards;

        Cards.clear();
        Random r = new Random();

        while (!temp.isEmpty()) {
            int x = r.nextInt(temp.size());

            Cards.add(temp.get(x));
            temp.remove(x);
        }
    }

}
