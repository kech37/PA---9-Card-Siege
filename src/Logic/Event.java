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
        Flags que servirão para melhor indentificar o algo de efeito a aplicar.
     */
    public static final int TARGET_EFFECT_TREBUCHET_ATTACK = 0;
    public static final int TARGET_EFFECT_MORALE = 1;
    public static final int TARGET_EFFECT_SUPPLIES = 2;
    public static final int TARGET_EFFECT_SABOTAGE_ACTION = 3;
    public static final int TARGET_EFFECT_ATTACK_ALL_CIRCLE = 4;
    public static final int TARGET_EFFECT_ATTACK_ALL = 5;
    public static final int TARGET_EFFECT_RAID_SABOTAGE = 6;
    public static final int TARGET_EFFECT_BATTERING_RAM = 7;
    public static final int TARGET_EFFECT_SIEGE_TOWER_REMOVED = 8;
    public static final int TARGET_EFFECT_COUPUTE_RAID_SABOTAGE = 9;
    public static final int TARGET_EFFECT_SIEGE_ENGINE = 10;
    public static final int TARGET_EFFECT_TREBUCHET = 11;
    public static final int TARGET_EFFECT_COUPURE = 12;
    public static final int TARGET_EFFECT_CLOSE_OR_CIRCLE = 13;
    public static final int TARGET_EFFECT_SIEGE_TOWER = 14;
    public static final int TARGET_EFFECT_LADDERS = 15;

    /*
        Indica o alvo a afetar
     */
    private final int effectTarget;
    
    /*
        Indica qual é o valor a afetar
     */
    private final int effectValue;

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

    public Event(int actionPoints, ArrayList<Integer> movementOrders, String name, ArrayList<String> description, int effectTarget, int effectValue) {
        this.eventName = name;
        this.eventDescription = new ArrayList<>(description);
        this.actionPointAllowance = actionPoints;
        this.enemyAdvancementOrders = new ArrayList<>(movementOrders);
        this.effectTarget = effectTarget;
        this.effectValue = effectValue;
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

    public int getEffectTarget() {
        return this.effectTarget;
    }

    public int getEffectValue() {
        return this.effectValue;
    }
}
