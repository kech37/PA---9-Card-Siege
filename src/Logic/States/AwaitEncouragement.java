/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

import Logic.GameData;

/**
 *
 * @author andre
 */
public class AwaitEncouragement extends StateAdapter{
    
    public AwaitEncouragement(GameData dataGame) {
        super(dataGame);
    }

    @Override
    public IStates SelectSuppliesOrMorale(int value) {
        switch(value)
        {
            case 1:
                getDataGame().getStatus().ModifyMorale(-1);
                getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).modifyActionPointAllowance(+1);
                break;
            case 2:
                getDataGame().getStatus().ModifySupplies(-1);
                getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).modifyActionPointAllowance(+1);
                break;
        }
        return new AwaitActionSelection(getDataGame());
    }


    
    
}
