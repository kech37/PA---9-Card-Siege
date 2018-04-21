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
public class EventCoverDarkness extends RegularEvents {

    public EventCoverDarkness(GameData gameData) {
        super(
                "Cover of Darkness",
                new ArrayList<>(Arrays.asList("+1 to Raid and Sabotage actions")),
                3,
                new ArrayList<>(Arrays.asList(new SwordMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getDRM().setRaid(1);
        getGameData().getDRM().setSabotageAction(1);
    }
}
