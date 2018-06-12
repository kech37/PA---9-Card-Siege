/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards;

import Logic.Cards.EventCards.Events.Event;
import Logic.Cards.EventCards.Events.EventBadWeather;
import Logic.Cards.EventCards.Events.EventBoilingOil;
import Logic.Cards.EventCards.Events.EventSuppliesSpoiled;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class EventCard3 extends BaseEventCard {

    public EventCard3(GameData gameData) {
        super(new ArrayList<Event>(Arrays.asList(
                new EventSuppliesSpoiled(gameData),
                new EventBadWeather(gameData),
                new EventBoilingOil(gameData)
        )), gameData);
    }

    @Override
    public String getImageName() {
        return "Card2.png";
    }
}
