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
        Indica o alvo a afetar
     */
    private final int effectTarget;

    /*
        Indica qual é o valor a afetar
     */
    private int effectValue;

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

    public GameData setEffect(GameData g) {
        switch (effectTarget) {
            case Constants.EFFECT_ILLESS:
                g.getStatus().ModifyMorale(effectValue);
                g.getStatus().ModifySupplies(effectValue);
                break;
            case Constants.EFFECT_TREBUCHET_ATTACK:
                g.getStatus().ModifyWallStrenght(effectValue);//VAI TER UM VALOR TEMPORARIO DEPENDENDO DO D6
                effectValue = 0;
                break;
            case Constants.EFFECT_GUARDS_DISTRACTED:
                g.getDRM().setSabotageAction(effectValue);
                g.getDRM().setMoraleAction(effectValue);
                break;
            case Constants.EFFECT_SUPPLIES_SPOILED:
                g.getStatus().ModifySupplies(effectValue);
                break;
            case Constants.EFFECT_BAD_WEATHER:
                g.setJustRaidSabotage(true);
                break;
            case Constants.EFFECT_BOILING_OIL:
                if (g.getEnemy().getBatteringRam().CircleSpace()) {
                    g.getDRM().setBatteringRam(effectValue);
                }
                if (g.getEnemy().getLadders().CircleSpace()) {
                    g.getDRM().setLadders(effectValue);
                }
                if (g.getEnemy().getSiegeTower().CircleSpace()) {
                    g.getDRM().setSiegeTower(effectValue);
                }
                break;
            case Constants.EFFECT_DEATH_OF_A_LEADER:
                g.getStatus().ModifyMorale(effectValue);
                break;
            case Constants.EFFECT_VOLLEY_OF_ARROWS:
                g.getDRM().setSiegeTower(effectValue);
                g.getDRM().setLadders(effectValue);
                g.getDRM().setBatteringRam(effectValue);
                break;
            case Constants.EFFECT_CORVER_OF_DARKNESS:
                g.getDRM().setRaid(effectValue);
                g.getDRM().setSabotageAction(effectValue);
                break;
            case Constants.EFFECT_GATE_FORTIDIED:
                g.getDRM().setBatteringRam(effectValue);
                break;
            case Constants.EFFECT_COLLAPSED:
                if (g.getEnemy().getSiegeTower().getPosition() == 4) {
                    g.getEnemy().getSiegeTower().Remove();
                }
                break;
            case Constants.EFFECT_ENEMY_FATIGUE:
                g.getDRM().setRaid(effectValue);
                g.getDRM().setSabotageAction(effectValue);
                g.getDRM().setCoupure(effectValue);
                break;
            case Constants.EFFECT_FLAMING_ARROWS:
                //TODO
                break;
            case Constants.EFFECT_REPAIRED_TREBUCHET:
                g.getEnemy().getTrebuchet().Forward();
                g.getDRM().setCoupure(effectValue);
                break;
            case Constants.EFFECT_RALLY:
                g.getDRM().setCloseCombat(effectValue);
                g.getDRM().setCircleSpaces(effectValue);
                break;
            case Constants.EFFECT_DETERMINED_ENEMY:
                g.getDRM().setBatteringRam(effectValue);
                break;
            case Constants.EFFECT_IRON_SHIELDS:
                g.getDRM().setSiegeTower(effectValue);
                break;
            case Constants.EFFECT_FAITH:
                g.getDRM().setBatteringRam(effectValue);
                g.getDRM().setLadders(effectValue);
                g.getDRM().setMoraleAction(effectValue);
                break;

        }
        return g;
    }
}
