/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards;

import Logic.Cards.EventCards.*;
import Logic.GameData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author andre
 */
public final class CardDeck implements Serializable {

    ArrayList<BaseEventCard> Cards;
    private BaseEventCard onUseEventCard;
    GameData gameData;

    public CardDeck(GameData gameData) {
        this.Cards = new ArrayList<>();
        this.reset(gameData);
        onUseEventCard = null;
    }

    public void removeOneCard() {
        onUseEventCard = this.Cards.remove(0);

    }

    public BaseEventCard getOnUseEventCard() {
        return onUseEventCard;
    }

    public boolean isFull() {
        return (Cards.size() == 7);
    }

    public boolean isEmpty() {
        return Cards.isEmpty();
    }

    public void reset(GameData gameData) {
        this.Cards.clear();

        this.Cards.add(new EventCard1(gameData));
        this.Cards.add(new EventCard2(gameData));
        this.Cards.add(new EventCard3(gameData));
        this.Cards.add(new EventCard4(gameData));
        this.Cards.add(new EventCard5(gameData));
        this.Cards.add(new EventCard6(gameData));
        this.Cards.add(new EventCard7(gameData));

        onUseEventCard = null;

        Collections.shuffle(this.Cards);
    }

}
