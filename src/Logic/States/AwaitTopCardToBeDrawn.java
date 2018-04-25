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
                return new Victory(getDataGame());
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
        } else {
            getDataGame().getDeck().removeOneCard();
            getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).applyEffect();
            return this;
        }
    }

    @Override
    public IStates AdvanceEnemies() {
        getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).applyEffect();

        int nEnemy = 0;
        if (getDataGame().getEnemy().getBatteringRam().getPosition() == 0) {
            nEnemy++;
        }
        if (getDataGame().getEnemy().getLadders().getPosition() == 0) {
            nEnemy++;
        }
        if (getDataGame().getEnemy().getSiegeTower().getPosition() == 0) {
            nEnemy++;
        }
        
        if(nEnemy >= 2)
        {
            return new GameOver(getDataGame());
        }
        
        
        if(getDataGame().getStatus().getMorale() == 0 || getDataGame().getStatus().getSupplies() == 0 || getDataGame().getStatus().getWallStrenght() == 0)
        {
            return new GameOver(getDataGame());
        }
        
        getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).modifyActionPointAllowance(-1);
        return new AwaitActionSelection(getDataGame());
    }

}
