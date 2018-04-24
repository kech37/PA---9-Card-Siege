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
        if (new Dice(6).rollDice() == 1 && getDataGame().getStatus().isOnEnemyLines()) {
            getDataGame().getStatus().setTunnel(0); ///SOLDADOS NO CASTELO
            getDataGame().getStatus().setSuppliesLevel(0);
            getDataGame().getStatus().ModifyMorale(-1);///REDUZ MORAL EM 1
        }
        return this;
    }

    @Override
    public IStates CheckExistingCards() {
        if (getDataGame().getDeck().isEmpty()) {
            if (!getDataGame().nextDay()) {
                return new GameOver(getDataGame()); //TODO: Estado Ganhar  
            } else {
                getDataGame().getStatus().ModifySupplies(-1);
                if (!getDataGame().getStatus().isOnEnemyLines()) {
                    getDataGame().getStatus().setTunnel(0);
                    return this;
                } else {
                    getDataGame().getStatus().ModifySupplies(getDataGame().getStatus().getSuppliesLevel());
                    return this;//
                }
            }
        }
        else
        {
           getDataGame().getDeck().removeOneCard();
           getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay() - 1).applyEffect();
           return this; 
        }
    }

}
