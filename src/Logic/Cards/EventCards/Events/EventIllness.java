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
public class EventIllness extends Event {

    public EventIllness(GameData gameData) {
        super(
                "Illness",
                new ArrayList<>(Arrays.asList("Reduce morale by 1\nReduce supplies by 1")),
                2,
                new ArrayList<>(Arrays.asList(new SiegeTowerMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getStatus().ModifyMorale(1);
        getGameData().getStatus().ModifySupplies(1);
    }
}
