/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards.Movement;

import Logic.GameData;

/**
 *
 * @author a21220528
 */
public abstract class Movement {
 
    private GameData gameData;
    private String name;

    public Movement(String name, GameData gameData) {
        this.gameData = gameData;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public GameData getGameData() {
        return gameData;
    }
    
    public abstract void applyMovement();
    
}