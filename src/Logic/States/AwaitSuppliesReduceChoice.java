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
public class AwaitSuppliesReduceChoice extends StateAdapter {

    public AwaitSuppliesReduceChoice(GameData dataGame) {
        super(dataGame);
    }

    @Override
    public IStates SuppliesReduceChoice(int value) {
        int dice = getDataGame().getDice().rollDice();
        switch (value) {
            case 1:
                getDataGame().getStatus().ModifySupplies(-1);
                dice++;
                break;
            case 2:
                break;
            default:
                break;
        }

        try {
            if (dice > 4) {
                getDataGame().getStatus().ModifyMorale(+1);
            }
        } catch (IndexOutOfBoundsException e) {

        }

        return new AwaitActionSelection(getDataGame());
    }

}
