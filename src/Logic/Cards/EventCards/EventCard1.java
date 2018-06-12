/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards;

import Logic.Cards.EventCards.Events.Event;
import Logic.Cards.EventCards.Events.TrebuchetAttackEvent;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventCard1 extends BaseEventCard {

    public EventCard1(GameData gameData) {
        super(new ArrayList<Event>(Arrays.asList(
                new TrebuchetAttackEvent(3, gameData),
                new TrebuchetAttackEvent(2, gameData),
                new TrebuchetAttackEvent(1, gameData)
        )), gameData);

    }

    @Override
    public String getImageName() {
        return "TrebuchetCard.png";
    }

}
