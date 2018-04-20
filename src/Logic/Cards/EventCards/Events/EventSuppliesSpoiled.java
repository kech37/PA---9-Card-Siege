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
public class EventSuppliesSpoiled extends RegularEvents {

    public EventSuppliesSpoiled(GameData gameData) {
        super(
                "Supplies Spoiled",
                new ArrayList<>(Arrays.asList("Reduce supplies by 1")),
                2,
                new ArrayList<>(Arrays.asList(new LaddersMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getStatus().ModifySupplies(1);
    }
}
