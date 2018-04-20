/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import Logic.Constants;
import Logic.Event;
import Logic.GameData;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author a21220528
 */
public class Main {

    public static void main(String[] args) {

        /*TextUI textUI = new TextUI(new Game());
        textUI.run();*/
        
        GameData GameData = new GameData();
        
        /* --- Carta 1 --- */
        GameData.getDeck().addCard(
                new Event(
                        3,
                        null,
                        "Trebuchet Attack",
                        null, //TODO Descrição?
                        Constants.EFFECT_TREBUCHET_ATTACK,
                        1 //TODO Trebuchet attack
                ),
                new Event(
                        2,
                        null,
                        "Trebuchet Attack",
                        null, //TODO Descrição?
                        Constants.EFFECT_TREBUCHET_ATTACK,
                        1 //TODO Trebuchet attack
                ),
                new Event(
                        1,
                        null,
                        "Trebuchet Attack",
                        null, //TODO Descrição?
                        Constants.EFFECT_TREBUCHET_ATTACK,
                        1 //TODO Trebuchet attack
                )
        );
        
        /* --- Carta 4 --- */
        GameData.getDeck().addCard(
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_LADDERS, Constants.MOVEMENT_SIEGE_TOWER)),
                        "Death of a Leader",
                        new ArrayList<>(Arrays.asList("Reduce morale by 1")),
                        Constants.EFFECT_DEATH_OF_A_LEADER,
                        -1
                ),
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_LADDERS, Constants.MOVEMENT_BATTERING_RAM)),
                        "Gate Fortified",
                        new ArrayList<>(Arrays.asList("+1 to attacks on the Battering Ram")),
                        Constants.EFFECT_GATE_FORTIDIED,
                        1
                ),
                new Event(
                        3,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_SIEGE_TOWER)),
                        "Flaming Arrows",
                        new ArrayList<>(Arrays.asList("+1 to attacks on the Siege Engine")),
                        Constants.EFFECT_FLAMING_ARROWS,
                        1
                )
        );
        
        /* --- Carta 7 --- */
        GameData.getDeck().addCard(
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_BATTERING_RAM)),
                        "Determined Enemy",
                        new ArrayList<>(Arrays.asList("+1 to attack on the Battering Ram")),
                        Constants.EFFECT_DETERMINED_ENEMY,
                        -1
                ),
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_SIEGE_TOWER)),
                        "Iron Shields",
                        new ArrayList<>(Arrays.asList("-1 to attack on Siege Tower")),
                        Constants.EFFECT_IRON_SHIELDS,
                        -1
                ),
                new Event(
                        3,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_LADDERS, Constants.MOVEMENT_BATTERING_RAM, Constants.MOVEMENT_SIEGE_TOWER)),
                        "Faith",
                        new ArrayList<>(Arrays.asList("+1 to attacks on the Battering Ram, Ladders, and Morale Action")),
                        Constants.EFFECT_FAITH,
                        1
                )
        );
        
        /* --- Carta 2 --- */
        GameData.getDeck().addCard(
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_SIEGE_TOWER)),
                        "Illness",
                        new ArrayList<>(Arrays.asList("Reduce morale by 1\nReduce suplies by 1")),
                        Constants.EFFECT_ILLESS,
                        -1
                ),
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_SWORD)),
                        "Guards Distracted",
                        new ArrayList<>(Arrays.asList("+1 to sabotage action\n+1 to morale action")),
                        Constants.EFFECT_GUARDS_DISTRACTED,
                        1
                ),
                new Event(
                        1,
                        null,
                        "Trebuchet Attack",
                        null, //TODO Descrição?
                        Constants.EFFECT_TREBUCHET_ATTACK,
                        1 //TODO Trebuchet attack
                )
        );
        
        /* --- Carta 5 --- */
        GameData.getDeck().addCard(
                new Event(
                        3,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_BATTERING_RAM)),
                        "Volley of Arrows",
                        new ArrayList<>(Arrays.asList("+1 to all attacks")),
                        Constants.EFFECT_VOLLEY_OF_ARROWS,
                        1
                ),
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_LADDERS, Constants.MOVEMENT_BATTERING_RAM)),
                        "Collapsed",
                        new ArrayList<>(Arrays.asList("Siege Tower removed from game if on starting space")),
                        Constants.EFFECT_COLLAPSED,
                        0 //TODO meto a zero?
                ),
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_LADDERS)),
                        "Repaired Trebuchet",
                        new ArrayList<>(Arrays.asList("Add 1 Trebuchet (max 3)", "+1 to Coupure action")),
                        Constants.EFFECT_REPAIRED_TREBUCHET,
                        1
                )
        );
        
        /* --- Carta 3 --- */
        GameData.getDeck().addCard(
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_LADDERS)),
                        "Supplies Spoiled",
                        new ArrayList<>(Arrays.asList("Reduce supplies by 1")),
                        Constants.EFFECT_SUPPLIES_SPOILED,
                        -1
                ),
                new Event(
                        2,
                        null, //TODO NULL;
                        "Bad Weather",
                        new ArrayList<>(Arrays.asList("Only raid and sabatoge actions allowed this turn")),
                        Constants.EFFECT_BAD_WEATHER,
                        0 //TODO zero?
                ),
                new Event(
                        2,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_LADDERS, Constants.MOVEMENT_BATTERING_RAM)),
                        "Boiling Oil",
                        new ArrayList<>(Arrays.asList("+2 to attacks on enemy units in circles spaces")),
                        Constants.EFFECT_BOILING_OIL,
                        2
                )
        );
        
        /* --- Carta 6 --- */
        GameData.getDeck().addCard(
                new Event(
                        3,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_SWORD)),
                        "Cover of Darkness",
                        new ArrayList<>(Arrays.asList("+1 to Raid and Sabotage actions")),
                        Constants.EFFECT_CORVER_OF_DARKNESS,
                        1
                ),
                new Event(
                        3,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_LADDERS)),
                        "Enemy Fatigue",
                        new ArrayList<>(Arrays.asList("+1 to Coupure, Raid, and Sabotage actions")),
                        Constants.EFFECT_ENEMY_FATIGUE,
                        1
                ),
                new Event(
                        3,
                        new ArrayList<>(Arrays.asList(Constants.MOVEMENT_SIEGE_TOWER, Constants.MOVEMENT_BATTERING_RAM)),
                        "Rally",
                        new ArrayList<>(Arrays.asList("+1 to attacks on Close Combat or Circle Spaces")),
                        Constants.EFFECT_RALLY,
                        1
                )
        );
    }
}
