/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards;

import Logic.Cards.EventCards.Events.EventDeterminedEnemy;
import Logic.Cards.EventCards.Events.EventFaith;
import Logic.Cards.EventCards.Events.EventIronShields;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventCard7 extends BaseEventCard{
    
    public EventCard7(GameData gameData) {
        super(new ArrayList<>(Arrays.asList(
                new EventDeterminedEnemy(gameData),
                new EventIronShields(gameData),
                new EventFaith(gameData)
        )));
    }
    
}
