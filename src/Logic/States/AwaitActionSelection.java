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

        return new AwaitEnemyTrackSelectionForArchersAttack(getDataGame());
    }

    @Override
    public IStates VerifyGameOver() {
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
        return this;
    }

    @Override
    public IStates SabotageAttack() {
        if (getDataGame().getStatus().getTunnel() != 4) {
            return this;
        } else {
            int dice = getDataGame().getDice().rollDice() + getDataGame().getDRM().getSabotageAction();
            dice = (dice > 6) ? 6 : dice;
            dice = (dice <= 0) ? 1 : dice;

            if (dice == 5 || dice == 6) {
                getDataGame().getEnemy().getTrebuchet().removeOne();
            } else {
                if (dice == 1) {
                    getDataGame().getStatus().setTunnel(0);
                    getDataGame().getStatus().setSuppliesLevel(0);
                    getDataGame().getStatus().ModifyMorale(-1);
                }
            }
            return this;
        }
    }

    @Override
    public IStates SupplieRaidAttack() {
        int dice = getDataGame().getDice().rollDice() + getDataGame().getDRM().getRaid();
        dice = (dice > 6) ? 6 : dice;
        dice = (dice <= 0) ? 1 : dice;
        if (dice >= 3 && dice <= 5) {
            if (getDataGame().getStatus().getSuppliesLevel() < 2) {
                getDataGame().getStatus().ModifySuppliesLevel(+1);
            }
        } else {
            if (dice == 6) {
                getDataGame().getStatus().setSuppliesLevel(2);
            } else {
                if (dice == 2) {
                } else {
                    getDataGame().getStatus().setTunnel(0);
                    getDataGame().getStatus().setSuppliesLevel(0);
                    getDataGame().getStatus().ModifyMorale(-1);
                }
            }
        }
        return this;
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
        int dice = getDataGame().getDice().rollDice() + getDataGame().getDRM().getCoupure();
        dice = (dice > 6) ? 6 : dice;
        dice = (dice <= 0) ? 1 : dice;

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
        int dice = getDataGame().getDice().rollDice() + getDataGame().getDRM().getCloseCombat();
        dice = (dice > 6) ? 6 : dice;
        dice = (dice <= 0) ? 1 : dice;

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
        if (getDataGame().getEnemy().isCardsOnCircle()) {
            return this;
        }
        return new AwaitBoilingWaterTrackSelection(getDataGame());

    }

    @Override
    public IStates TunnelMovement() {
        if (!getDataGame().isFreeMovement()) {
            if (getDataGame().getStatus().getTunnel() == 0) {
                getDataGame().getStatus().ModifyTunnel(+1);
                return this;
            } else {
                return new AwaitOptionMovementSelection(getDataGame());
            }
        } else {
            return this;
        }
    }

    @Override
    public IStates CheckActionPoints() {
        if (getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).getActionPointAllowance() > 0) {
            getDataGame().getDeck().getOnUseEventCard().getEvents().get(getDataGame().getDay()).modifyActionPointAllowance(-1);
            return this;
        } else {
            return new AwaitTopCardToBeDrawn(getDataGame());
        }
    }

}
