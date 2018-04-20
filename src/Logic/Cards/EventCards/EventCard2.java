/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards;

import Logic.Cards.EventCards.Events.EventGuardsDistracted;
import Logic.Cards.EventCards.Events.EventIllness;
import Logic.Cards.EventCards.Events.TrebuchetAttackEvent;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventCard2 extends BaseEventCard{
    
    public EventCard2(GameData gameData) {
        super(new ArrayList<>(Arrays.asList(
                new EventIllness(gameData),
                new EventGuardsDistracted(gameData),
                new TrebuchetAttackEvent(1, gameData)
        )));
    }
    
}
