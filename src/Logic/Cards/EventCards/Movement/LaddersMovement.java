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
public class LaddersMovement extends Movement{

    public LaddersMovement(GameData gameData) {
        super("Ladders movement", gameData);
    }

    @Override
    public void applyMovement() {
        getGameData().getEnemy().getLadders().Forward();
    }
    
}
