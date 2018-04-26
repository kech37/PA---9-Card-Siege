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
public class AwaitOptionMovementSelection extends StateAdapter {

    public AwaitOptionMovementSelection(GameData dataGame) {
        super(dataGame);
    }

    @Override
    public IStates TunnelMovementOptionSelection(int value) {
        if (value == 1) {
            getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).modifyActionPointAllowance(1);
            if (getDataGame().getStatus().getSuppliesLevel() == 0) {
                getDataGame().getStatus().ModifyTunnel(1);
            } else {
                if (getDataGame().getStatus().getSuppliesLevel() > 0) {
                    getDataGame().getStatus().ModifyTunnel(-1);
                    if (getDataGame().getStatus().getTunnel() == 0) {
                        getDataGame().getStatus().ModifySupplies(getDataGame().getStatus().getSuppliesLevel());
                        getDataGame().getStatus().setSuppliesLevel(0);
                    }
                }
            }
            return new AwaitActionSelection(getDataGame());
        } else {
            if (getDataGame().getStatus().getSuppliesLevel() == 0) {
                getDataGame().getStatus().setTunnel(4);
            }
            return new AwaitActionSelection(getDataGame());
        }
    }

}
