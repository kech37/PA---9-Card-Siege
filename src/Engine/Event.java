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
public class Event {

    static final int LADDERS_MOVEMENT = 1;
    static final int BATTERING_RAM_MOVEMENT = 2;
    static final int SIEGE_TOWER_MOVEMENT = 3;
    static final int SWORD_MOVEMENT = 4;

    private final String eventName;
    private final List<String> eventDescription;

    private final int actionPointAllowance;
    private final List<Integer> enemyAdvancementOrders;

    Event(String name, ArrayList<String> description, int actionPoints, ArrayList<Integer> movementOrders) {
        this.eventName = name;
        this.eventDescription = new ArrayList<>(description);
        this.actionPointAllowance = actionPoints;
        this.enemyAdvancementOrders = new ArrayList<>(movementOrders);
    }

    String getName() {
        return this.eventName;
    }

    List<String> getDescription() {
        return this.eventDescription;
    }

    int getActionPointAllowance() {
        return this.actionPointAllowance;
    }

    List<Integer> getMovement() {
        if (this.enemyAdvancementOrders.isEmpty()) {
            return null;
        } else {
            return this.enemyAdvancementOrders;
        }
    }
}
