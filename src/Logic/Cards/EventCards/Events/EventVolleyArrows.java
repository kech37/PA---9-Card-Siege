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
public class EventVolleyArrows extends Event {

    public EventVolleyArrows(GameData gameData) {
        super(
                "Volley of Arrows",
                new ArrayList<>(Arrays.asList("+1 to all attacks")),
                3,
                new ArrayList<>(Arrays.asList(new BatteringRamMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getDRM().setSiegeTower(1);
        getGameData().getDRM().setLadders(1);
        getGameData().getDRM().setBatteringRam(1);
    }
}
