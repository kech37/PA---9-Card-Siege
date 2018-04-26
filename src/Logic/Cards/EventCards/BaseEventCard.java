/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards;

import Logic.Cards.EventCards.Events.Event;
import Logic.GameData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a21220528
 */
public abstract class BaseEventCard {

    //Irá guardar os eventos que esta carta de eventos tem. É obrigatorio ter 3.
    private final List<Event> events;

    public BaseEventCard(ArrayList<Event> eventsInput, GameData g) {
        this.events = new ArrayList<>(eventsInput);
    }

    public List<Event> getEvents() {
        return events;
    }

}
