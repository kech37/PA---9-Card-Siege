/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards.Events;

import Logic.Cards.EventCards.Movement.LaddersMovement;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventRepairedTrebuchet extends RegularEvents {

    public EventRepairedTrebuchet(GameData gameData) {
        super(
                "Repaired Trebuchet",
                new ArrayList<>(Arrays.asList("Add 1 trebuchet (max 3)", "+1 to Coupure action")),
                2,
                new ArrayList<>(Arrays.asList(new LaddersMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getEnemy().getTrebuchet().addOne();
        getGameData().getDRM().setCoupure(1);
    }
}
