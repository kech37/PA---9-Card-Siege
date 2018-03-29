/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a21220528
 */
public class EventCard {

    private int id;
    private final List<Event> events;

    EventCard() {
        this.events = new ArrayList<>();
    }

    boolean addEvent(Event eventInput) {
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
                        case Event.LADDERS_MOVEMENT:
                            toPrint += " Ladders";
                            break;
                        case Event.BATTERING_RAM_MOVEMENT:
                            toPrint += " Battering Ram";
                            break;
                        case Event.SIEGE_TOWER_MOVEMENT:
                            toPrint += " Siege Tower";
                            break;
                        case Event.SWORD_MOVEMENT:
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
