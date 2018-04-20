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
public class EventCollapsed extends Event {

    public EventCollapsed(GameData gameData) {
        super(
                "Collapsed!",
                new ArrayList<>(Arrays.asList("Siege Tower removed from grame if on starting space")),
                2,
                new ArrayList<>(Arrays.asList(new LaddersMovement(gameData), new BatteringRamMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        if (getGameData().getEnemy().getSiegeTower().getPosition() == 4) {
            getGameData().getEnemy().getSiegeTower().Remove();
        }
    }
}
