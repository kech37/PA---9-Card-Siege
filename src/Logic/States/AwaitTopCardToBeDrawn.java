/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

import Logic.Dice;
import Logic.GameData;

/**
 *
 * @author a21220528
 */
public class AwaitTopCardToBeDrawn extends StateAdapter {

    public AwaitTopCardToBeDrawn(GameData dataGame) {
        super(dataGame);
    }

    @Override
    public IStates finish() {
        return new GameOver(getDataGame());
    }

    @Override
    public IStates CheckingEnemyLines() {

        if (new Dice(6).rollDice() == 1 && getDataGame().getStatus().getTunnel() > 0) {
            getDataGame().getStatus().setTunnel(0); ///SOLDADOS NO CASTELO
            getDataGame().getStatus().setSuppliesLevel(0);
            getDataGame().getStatus().ModifyMorale(-1);///REDUZ MORAL EM 1
        } 
        return this;
    }

}
