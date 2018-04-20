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
public class EventRally extends Event {

    public EventRally(GameData gameData) {
        super(
                "Rally!",
                new ArrayList<>(Arrays.asList("+1 to attacks on Close Combat or Circle Spaces")),
                3,
                new ArrayList<>(Arrays.asList(new BatteringRamMovement(gameData), new SiegeTowerMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getDRM().setCloseCombat(1);
        getGameData().getDRM().setCircleSpaces(1);
    }
}
