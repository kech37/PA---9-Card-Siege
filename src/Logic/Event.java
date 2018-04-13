/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a21220528
 */
public class Event {
    /*
      Flags que servirão para melhor indentificar o movimento que o evento terá.
    */
    public static final int LADDERS_MOVEMENT = 1;
    public static final int BATTERING_RAM_MOVEMENT = 2;
    public static final int SIEGE_TOWER_MOVEMENT = 3;
    public static final int SWORD_MOVEMENT = 4;

    /*
        Nome do Evento
    */
    private final String eventName;
    /*
        Descrição do evento. Utilizamos uma List<String> pq pode haver
        duas descrições.
    */
    private final List<String> eventDescription;

    /*
        Quantas ações é possivel fazer neste evento (turno)
    */
    private final int actionPointAllowance;
    /*
        Que tipo de movimento as tropas inimigas puderão fazer.
        Utilizamos uma list, pq cada evento tem um numero variados de tipos
        de movimentos.
    */
    private final List<Integer> enemyAdvancementOrders;

    public Event(String name, ArrayList<String> description, int actionPoints, ArrayList<Integer> movementOrders) {
        this.eventName = name;
        this.eventDescription = new ArrayList<>(description);
        this.actionPointAllowance = actionPoints;
        this.enemyAdvancementOrders = new ArrayList<>(movementOrders);
    }

    public String getName() {
        return this.eventName;
    }

    public List<String> getDescription() {
        return this.eventDescription;
    }

    public int getActionPointAllowance() {
        return this.actionPointAllowance;
    }

    public List<Integer> getMovement() {
        if (this.enemyAdvancementOrders.isEmpty()) {
            return null;
        } else {
            return this.enemyAdvancementOrders;
        }
    }
}
