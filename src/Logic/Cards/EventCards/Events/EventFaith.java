    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards.Events;

import Logic.Cards.EventCards.Movement.*;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventFaith extends RegularEvents{
    
    public EventFaith(GameData gameData) {
        super(
                "Faith",
                new ArrayList<>(Arrays.asList("+1 to attacks on the Battering Ram, Ladders, and Morale action")),
                3,
                new ArrayList<>(Arrays.asList(new LaddersMovement(gameData), new BatteringRamMovement(gameData), new SiegeTowerMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getDRM().setLadders(-1);
        getGameData().getDRM().setMoraleAction(-1);
        getGameData().getDRM().setBatteringRam(-1);
    }
}
