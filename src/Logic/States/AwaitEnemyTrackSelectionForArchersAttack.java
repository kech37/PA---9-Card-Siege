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
public class AwaitEnemyTrackSelectionForArchersAttack extends StateAdapter {

    public AwaitEnemyTrackSelectionForArchersAttack(GameData dataGame) {
        super(dataGame);
    }

    @Override
    public IStates ArchersAttackTrackSelection(int value) {
        try {
            switch (value) {
                case 1:
                    if ((getDataGame().getDice().rollDice() + getDataGame().getDRM().getLadders()) > getDataGame().getEnemy().getLaddersStrength()) {
                        getDataGame().getEnemy().getLadders().Backward();
                    }
                    break;

                case 2:
                    if ((getDataGame().getDice().rollDice() + getDataGame().getDRM().getBatteringRam()) > getDataGame().getEnemy().getBatteringRamStrength()) {
                        getDataGame().getEnemy().getBatteringRam().Backward();
                    }
                    break;
                case 3:
                    if ((getDataGame().getDice().rollDice() + getDataGame().getDRM().getSiegeTower()) > getDataGame().getEnemy().getSiegeTowerStrength()) {
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
