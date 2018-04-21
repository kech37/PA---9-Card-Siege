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
public class EventIronShields extends RegularEvents {

    public EventIronShields(GameData gameData) {
        super(
                "Iron Shields",
                new ArrayList<>(Arrays.asList("-1 to attacks on the Siege Tower")),
                2,
                new ArrayList<>(Arrays.asList(new SiegeTowerMovement(gameData))),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().getDRM().setSiegeTower(-1);
    }
}
