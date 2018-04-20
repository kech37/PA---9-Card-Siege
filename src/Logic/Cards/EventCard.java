/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards;

import Logic.Event;
import java.util.ArrayList;
import java.util.List;
import Logic.Constants;

/**
 *
 * @author a21220528
 */
public class EventCard {

    /*
        Irá guardar os eventos que esta carta de eventos tem. É obrigatorio ter 3.
     */
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

    /*
        Permite adicionar eventos até 3
     */
    public boolean setEvents(Event eventInput) {
        if (this.events.size() < 3) {
            this.events.add(eventInput);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String toPrint = "";
        for (Event event : events) {
            toPrint += "----------\nName: " + event.getName() + "\nDescription: ";
            for (int i = 0; i < event.getDescription().size(); i++) {
                toPrint += event.getDescription().get(i) + "\n";
            }
            toPrint += "Movement:";
            if (!event.getMovement().isEmpty()) {
                for (int i = 0; i < event.getMovement().size(); i++) {
                    switch (event.getMovement().get(i)) {
                        case Constants.MOVEMENT_LADDERS:
                            toPrint += " Ladders";
                            break;
                        case Constants.MOVEMENT_BATTERING_RAM:
                            toPrint += " Battering Ram";
                            break;
                        case Constants.MOVEMENT_SIEGE_TOWER:
                            toPrint += " Siege Tower";
                            break;
                        case Constants.MOVEMENT_SWORD:
                            toPrint += " Sword";
                            break;
                    }
                }
            } else {
                toPrint += " None";
            }
            toPrint += "\nAction Point Allowance: " + event.getActionPointAllowance() + "\n----------\n";
        }
        return toPrint;
    }

}
