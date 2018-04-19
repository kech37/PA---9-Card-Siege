/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cards.Status;
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
            case 0:
                g.getStatus().ModifyMorale(effectValue);
                g.getStatus().ModifySupplies(effectValue);
                break;
            case 1:
                g.getStatus().ModifyWallStrenght(effectValue);//VAI TER UM VALOR TEMPORARIO DEPENDENDO DO D6
                effectValue = 0;
                break;
            case 2:
                g.getDRM().setSabotageAction(effectValue);
                g.getDRM().setMoraleAction(effectValue);
                break;
            case 3:
                g.getStatus().ModifySupplies(effectValue);
                break;
            case 4:
                g.setJustRaidSabotage(true);
                break;
            case 5:
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
            case 6:
                g.getStatus().ModifyMorale(effectValue);
                break;
            case 7:
                g.getDRM().setSiegeTower(effectValue);
                g.getDRM().setLadders(effectValue);
                g.getDRM().setBatteringRam(effectValue);
                break;
            case 8:
                g.getDRM().setRaid(effectValue);
                g.getDRM().setSabotageAction(effectValue);
                break;
            case 9:
                 g.getDRM().setBatteringRam(effectValue);
                break;
            case 10:
                if (g.getEnemy().getSiegeTower().getPosition() == 4) {
                    g.getEnemy().getSiegeTower().Remove();
                }
                break;
            case 11:
                g.getDRM().setRaid(effectValue);
                g.getDRM().setSabotageAction(effectValue);
                g.getDRM().setCoupure(effectValue);
                break;
            case 12:
                //TODO
                break;
            case 13:
                g.getEnemy().getTrebuchet().Forward();
                g.getDRM().setCoupure(effectValue);
                break;
            case 14:
                g.getDRM().setCloseCombat(effectValue);
                g.getDRM().setCircleSpaces(effectValue);
                break;
            case 15:
                g.getDRM().setBatteringRam(effectValue);
                break;
            case 16:
                g.getDRM().setSiegeTower(effectValue);
                break;
            case 17:
                g.getDRM().setBatteringRam(effectValue);
                g.getDRM().setLadders(effectValue);
                g.getDRM().setMoraleAction(effectValue);
                break;

        }
        return g;
    }
}
