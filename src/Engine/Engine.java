/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author a21220528
 */
public class Engine {
    public static void main(String[] args) {
        List<EventCard> cards = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            cards.add(new EventCard());
        }
        
        cards.get(0).addEvent(new Event("Death of a Leader", new ArrayList<>(Arrays.asList("Reduce morale by 1")), 2, new ArrayList<>(Arrays.asList(Event.LADDERS_MOVEMENT, Event.SIEGE_TOWER_MOVEMENT))));
        cards.get(0).addEvent(new Event("Gate Fortified", new ArrayList<>(Arrays.asList("+1 to attacks on the Battering Ram")), 2, new ArrayList<>(Arrays.asList(Event.LADDERS_MOVEMENT, Event.BATTERING_RAM_MOVEMENT))));
        cards.get(0).addEvent(new Event("Flaming Arrows", new ArrayList<>(Arrays.asList("+1 to attacks on the Siege Engine")), 3, new ArrayList<>(Arrays.asList(Event.SIEGE_TOWER_MOVEMENT))));
        
        System.out.println(cards.get(0));
       
    }
}
