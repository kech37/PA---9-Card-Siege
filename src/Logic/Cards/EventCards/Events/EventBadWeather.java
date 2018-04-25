/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards.Events;

import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventBadWeather extends RegularEvents {

    public EventBadWeather(GameData gameData) {
        super(
                "Bad Weather",
                new ArrayList<>(Arrays.asList("Only raid and sabatoge actions allowed this turn")),
                2,
                new ArrayList<>(),
                gameData);
    }

    @Override
    public void applyEffect() {
        getGameData().setJustRaidSabotage(true);
    }

}
