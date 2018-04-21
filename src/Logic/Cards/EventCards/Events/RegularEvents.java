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

}
