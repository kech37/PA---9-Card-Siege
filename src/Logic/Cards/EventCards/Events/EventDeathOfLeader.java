/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards.Events;

import Logic.Cards.EventCards.Movement.SwordMovement;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventDeathOfLeader extends RegularEvents {

    public EventDeathOfLeader(GameData gameData) {
        super(
                "Death of a Leader",
                new ArrayList<>(Arrays.asList("Reduce morale by 1")),
                2,
                new ArrayList<>(Arrays.asList(new SwordMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getStatus().ModifyMorale(-1);
    }

}
