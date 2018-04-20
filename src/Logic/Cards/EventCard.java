/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards;


import Logic.Cards.EventCards.Events.Event;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a21220528
 */
public class EventCard {

    //Irá guardar os eventos que esta carta de eventos tem. É obrigatorio ter 3.
    private final List<Event> events;

    public EventCard() {
        this.events = new ArrayList<>();
    }

    public EventCard(Event day1, Event day2, Event day3) {
        this();
        this.events.add(day1);
        this.events.add(day2);
        this.events.add(day3);
    }

    public boolean setEvents(Event eventInput) {
        if (this.events.size() < 3) {
            this.events.add(eventInput);
            return true;
        }
        return false;
    }

}
