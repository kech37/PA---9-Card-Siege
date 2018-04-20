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
public abstract class Event {

    // Nome do Evento
    private final String eventName;

    //Descrição do evento. Utilizamos uma List<String> pq pode haver duas descrições.
    private final List<String> eventDescription;

    //Quantas ações é possivel fazer neste evento (turno)
    private final int actionPointAllowance;

    //Que tipo de movimentos pode efetuar
    private final List<Movement> enemyAdvancementOrders;

    private GameData gameData;

    public Event(String eventName, List<String> eventDescription, int actionPointAllowance, List<Movement> enemyAdvancementOrders, GameData gameData) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.actionPointAllowance = actionPointAllowance;
        this.enemyAdvancementOrders = enemyAdvancementOrders;
        this.gameData = gameData;
    }

    public List<Movement> getEnemyAdvancementOrders() {
        return enemyAdvancementOrders;
    }

    public GameData getGameData() {
        return this.gameData;
    }

    public String getEventName() {
        return eventName;
    }

    public List<String> getEventDescription() {
        return eventDescription;
    }

    public int getActionPointAllowance() {
        return actionPointAllowance;
    }

    public abstract void applyEffect();
}
