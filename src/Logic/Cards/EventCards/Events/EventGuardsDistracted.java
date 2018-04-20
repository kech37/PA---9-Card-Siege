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
public class EventGuardsDistracted extends RegularEvents {

    public EventGuardsDistracted(GameData gameData) {
        super(
                "Guards Distracted",
                new ArrayList<>(Arrays.asList("+1 to sabotage action\n+1 to morale action")),
                2,
                new ArrayList<>(Arrays.asList(new SwordMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getDRM().setSabotageAction(1);
        getGameData().getDRM().setMoraleAction(1);
    }
}
