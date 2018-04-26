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
 * @author andre
 */
public class AwaitBoilingWaterTrackSelection extends StateAdapter {

    public AwaitBoilingWaterTrackSelection(GameData dataGame) {
        super(dataGame);
    }

    @Override
    public IStates BoilingWatterTrackSelection(int value) {
        int dice = getDataGame().getDice().rollDice();
        try {
            if (dice == 1) {
                getDataGame().getStatus().ModifyMorale(-1);
            }
            switch (value) {
                case 1:
                    if ((dice + getDataGame().getDRM().getLadders() + 1) > getDataGame().getEnemy().getLaddersStrength()) {
                        getDataGame().getEnemy().getLadders().Backward();
                    }
                    break;

                case 2:
                    if ((dice + getDataGame().getDRM().getBatteringRam() + 1) > getDataGame().getEnemy().getBatteringRamStrength()) {
                        getDataGame().getEnemy().getBatteringRam().Backward();
                    }
                    break;
                case 3:
                    if ((dice + getDataGame().getDRM().getSiegeTower() + 1) > getDataGame().getEnemy().getSiegeTowerStrength()) {
                        getDataGame().getEnemy().getSiegeTower().Backward();
                    }
                    break;
            }
            return new AwaitActionSelection(getDataGame());
        } catch (IndexOutOfBoundsException e) {

        }
        return new AwaitActionSelection(getDataGame());
    }

}
