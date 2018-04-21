/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards.Events;

import Logic.GameData;

/**
 *
 * @author a21220528
 */
public abstract class Event {

    // Nome do Evento
    private final String eventName;

    //Quantas ações é possivel fazer neste evento (turno)
    private final int actionPointAllowance;

    private GameData gameData;

    public Event(String eventName, int actionPointAllowance, GameData gameData) {
        this.eventName = eventName;
        this.actionPointAllowance = actionPointAllowance;
        this.gameData = gameData;
    }

    public GameData getGameData() {
        return this.gameData;
    }

    public String getEventName() {
        return eventName;
    }

    public int getActionPointAllowance() {
        return actionPointAllowance;
    }

    public abstract void applyEffect();
}
