/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards.Events;

import Logic.Dice;
import Logic.GameData;

/**
 *
 * @author a21220528
 */
public class TrebuchetAttackEvent extends Event {

    public TrebuchetAttackEvent(int actionPointAllowance, GameData gameData) {
        super("Trebuchet Attack", actionPointAllowance, gameData);
    }

    @Override
    public void applyEffect() {
        switch (getGameData().getEnemy().getTrebuchet().getHowMany()) {
            case 3:
                getGameData().getStatus().ModifyWallStrenght(-2);
                break;
            case 2:
                getGameData().getStatus().ModifyWallStrenght(-1);
                break;
            case 1:
                int roll = new Dice(6).rollDice();
                if (roll >= 4) {
                    getGameData().getStatus().ModifyWallStrenght(-1);
                }
                break;
        }
    }

}
