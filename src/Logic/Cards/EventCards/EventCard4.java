/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards;

import Logic.Cards.EventCards.Events.EventDeathOfLeader;
import Logic.Cards.EventCards.Events.EventFlamingArrows;
import Logic.Cards.EventCards.Events.EventGateFortified;
import Logic.Cards.EventCards.Events.TrebuchetAttackEvent;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventCard4 extends BaseEventCard{
    
    public EventCard4(GameData gameData) {
        super(new ArrayList<>(Arrays.asList(
                new EventDeathOfLeader(gameData),
                new EventGateFortified(gameData),
                new EventFlamingArrows(gameData)
        )));
    }
    
}
