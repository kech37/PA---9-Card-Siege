/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards.Events;

import Logic.Cards.EventCards.Movement.Movement;
import Logic.GameData;
import java.util.List;

/**
 *
 * @author a21220528
 */
public abstract class RegularEvents extends Event {
    //Descrição do evento. Utilizamos uma List<String> pq pode haver duas descrições.

    private final List<String> eventDescription;

    //Que tipo de movimentos pode efetuar
    private final List<Movement> enemyAdvancementOrders;

    public RegularEvents(String eventName, List<String> eventDescription, int actionPointAllowance, List<Movement> enemyAdvancementOrders, GameData gameData) {
        super(eventName, actionPointAllowance, gameData);
        this.enemyAdvancementOrders = enemyAdvancementOrders;
        this.eventDescription = eventDescription;
    }

    public List<Movement> getEnemyAdvancementOrders() {
        return enemyAdvancementOrders;
    }

    @Override
    public void applyMovements() {
        for (Movement m : getEnemyAdvancementOrders()) {
            m.applyMovement();
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for (String s : eventDescription) {
            temp += s + "\n";
        }
        temp += "--------\n";
        for(Movement s: enemyAdvancementOrders)
        {
            temp+= s.getName();
        }
        
        
        return temp;
    }

    @Override
    public boolean hasEnemyAdvancementOrders() {
        if (enemyAdvancementOrders.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
