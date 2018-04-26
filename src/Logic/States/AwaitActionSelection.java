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
public class AwaitActionSelection extends StateAdapter {

    public AwaitActionSelection(GameData dataGame) {
        super(dataGame);
    }

    @Override
    public IStates ArcherAttack() {

        if (verifyGameOver() == null) {
            return new AwaitEnemyTrackSelectionForArchersAttack(getDataGame());
        } else {
            return verifyGameOver();
        }
    }

    public IStates verifyGameOver() {
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

        if (nEnemy >= 2) {
            return new GameOver(getDataGame());
        }
        if (getDataGame().getStatus().getMorale() == 0 || getDataGame().getStatus().getSupplies() == 0 || getDataGame().getStatus().getWallStrenght() == 0) {
            return new GameOver(getDataGame());
        }
        return null;
    }

    @Override
    public IStates SabotageAttack() {
        return super.SabotageAttack(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates SupplieRaidAttack() {
        return super.SupplieRaidAttack(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates RallyTroops() {
        int dice = getDataGame().getDice().rollDice();

        getDataGame().getStatus().ModifySupplies(-1);
        try {
            if (dice > 4) {
                getDataGame().getStatus().ModifyMorale(+1);
            } else {
                return new AwaitActionSelection(getDataGame());
            }
        } catch (IndexOutOfBoundsException e) {

        }
        return new AwaitActionSelection(getDataGame());
    }

    @Override
    public IStates Coupure() {
        int dice = getDataGame().getDice().rollDice();
        dice += getDataGame().getDRM().getCoupure();

        try {
            if (dice > 4) {
                getDataGame().getStatus().ModifyWallStrenght(+1);
            } else {
                return new AwaitActionSelection(getDataGame());
            }
        } catch (IndexOutOfBoundsException e) {

        }
        return new AwaitActionSelection(getDataGame());

    }

    @Override
    public IStates CloseCombatAttack() {
        int dice = getDataGame().getDice().rollDice();
        dice += getDataGame().getDRM().getCloseCombat();
        try {
            if (dice == 1) {
                getDataGame().getStatus().ModifyMorale(-1);
            } else if (dice > 4) {
                if (getDataGame().getEnemy().isCardsOnCircle()) {
                    if (getDataGame().getEnemy().getBatteringRam().getPosition() == 0) {
                        getDataGame().getEnemy().getBatteringRam().Backward();
                    }
                    if (getDataGame().getEnemy().getLadders().getPosition() == 0) {
                        getDataGame().getEnemy().getLadders().Backward();
                    }
                    if (getDataGame().getEnemy().getSiegeTower().getPosition() == 0) {
                        getDataGame().getEnemy().getSiegeTower().Backward();
                    }
                }
            }

            return new AwaitActionSelection(getDataGame());
        } catch (IndexOutOfBoundsException e) {

        }
        return new AwaitActionSelection(getDataGame());
    }

    @Override
    public IStates BoilingWaterAttack() {
        if (verifyGameOver() == null) {
            if (getDataGame().getEnemy().isCardsOnCircle()) {
                return this;
            }
            return new AwaitBoilingWaterTrackSelection(getDataGame());
        } else {
            return verifyGameOver();
        }
    }

    @Override
    public IStates CheckActionPoints() {
        if (getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).getActionPointAllowance() != 0) {
            getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).modifyActionPointAllowance(-1);
            return this;
        } else {
            return new AwaitTopCardToBeDrawn(getDataGame());
        }
    }

}
