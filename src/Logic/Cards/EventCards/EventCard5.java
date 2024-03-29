/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards;

import Logic.Cards.EventCards.Events.Event;
import Logic.Cards.EventCards.Events.EventCollapsed;
import Logic.Cards.EventCards.Events.EventRepairedTrebuchet;
import Logic.Cards.EventCards.Events.EventVolleyArrows;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventCard5 extends BaseEventCard {

    public EventCard5(GameData gameData) {
        super(new ArrayList<Event>(Arrays.asList(
                new EventVolleyArrows(gameData),
                new EventCollapsed(gameData),
                new EventRepairedTrebuchet(gameData)
        )), gameData);
    }

    @Override
    public String getImageName() {
        return "Card4.png";
    }
}
