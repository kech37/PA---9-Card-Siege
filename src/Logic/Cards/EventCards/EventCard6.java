/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards;

import Logic.Cards.EventCards.Events.Event;
import Logic.Cards.EventCards.Events.EventCoverDarkness;
import Logic.Cards.EventCards.Events.EventEnemyFatigue;
import Logic.Cards.EventCards.Events.EventRally;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventCard6 extends BaseEventCard {

    public EventCard6(GameData gameData) {
        super(new ArrayList<Event>(Arrays.asList(
                new EventCoverDarkness(gameData),
                new EventEnemyFatigue(gameData),
                new EventRally(gameData)
        )), gameData);
    }

    @Override
    public String getImageName() {
        return "Card5.png";
    }
}
