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
public class EventBoilingOil extends Event {

    public EventBoilingOil(GameData gameData) {
        super(
                "Boiling Oil",
                new ArrayList<>(Arrays.asList("+2 to attacks on enemy units in circle spaces")),
                2,
                new ArrayList<>(Arrays.asList(new LaddersMovement(gameData), new BatteringRamMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        if (getGameData().getEnemy().getBatteringRam().CircleSpace()) {
            getGameData().getDRM().setBatteringRam(2);
        }
        if (getGameData().getEnemy().getLadders().CircleSpace()) {
            getGameData().getDRM().setLadders(2);
        }
        if (getGameData().getEnemy().getSiegeTower().CircleSpace()) {
            getGameData().getDRM().setSiegeTower(2);
        }
    }
}
