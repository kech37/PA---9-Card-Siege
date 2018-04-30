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
public class AwaitEnemyTrackSelectionForArchersAttack extends StateAdapter {

    public AwaitEnemyTrackSelectionForArchersAttack(GameData dataGame) {
        super(dataGame);
    }

    @Override
    public IStates ArchersAttackTrackSelection(int value) {
        int dice = getDataGame().getDice().rollDice();
        try {
            switch (value) {
                case 2:
                    dice += (getDataGame().getEnemy().getLadders().CircleSpace()) ? getDataGame().getDRM().getCircleSpaces():0;
                    if ((dice + getDataGame().getDRM().getLadders()) > getDataGame().getEnemy().getLaddersStrength()) {
                        getDataGame().getEnemy().getLadders().Backward();
                    }
                    break;

                case 1:
                    dice += (getDataGame().getEnemy().getBatteringRam().CircleSpace()) ? getDataGame().getDRM().getCircleSpaces():0;
                    if ((dice + getDataGame().getDRM().getBatteringRam()) > getDataGame().getEnemy().getBatteringRamStrength()) {
                        getDataGame().getEnemy().getBatteringRam().Backward();
                    }
                    break;
                case 3:
                    dice += (getDataGame().getEnemy().getSiegeTower().CircleSpace()) ? getDataGame().getDRM().getCircleSpaces():0;
                    if ((dice + getDataGame().getDRM().getSiegeTower()) > getDataGame().getEnemy().getSiegeTowerStrength()) {
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
