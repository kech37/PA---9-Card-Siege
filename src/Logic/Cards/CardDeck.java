/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards;

import Logic.Cards.EventCards.*;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author andre
 */
public class CardDeck {

    ArrayList<BaseEventCard> Cards;

    public CardDeck(GameData gameData) {
        this.Cards.add(new EventCard1(gameData));
        this.Cards.add(new EventCard2(gameData));
        this.Cards.add(new EventCard3(gameData));
        this.Cards.add(new EventCard4(gameData));
        this.Cards.add(new EventCard5(gameData));
        this.Cards.add(new EventCard6(gameData));
        this.Cards.add(new EventCard7(gameData));

        Collections.shuffle(Cards);
    }

    public BaseEventCard getOneCard() {
        return this.Cards.remove(0);
    }

}
