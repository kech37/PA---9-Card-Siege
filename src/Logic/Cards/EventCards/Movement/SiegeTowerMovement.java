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
public class SiegeTowerMovement extends Movement {

    public SiegeTowerMovement(GameData gameData) {
        super("Siege Tower movement", gameData);
    }

    @Override
    public void applyMovement() {
        if (getGameData().getEnemy().getSiegeTower().getPosition() != -1) {
            getGameData().getEnemy().getSiegeTower().Forward();
        }
    }

}
