/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.EventCards.Movement;

import Logic.GameData;

/**
 *
 * @author a21220528
 */
public class SwordMovement extends Movement {

    public SwordMovement(GameData gameData) {
        super("Sword Movement", gameData);
    }

    @Override
    public void applyMovement() {
        int ladders = getGameData().getEnemy().getLadders().getPosition();
        int battering = getGameData().getEnemy().getBatteringRam().getPosition();
        int siege = getGameData().getEnemy().getSiegeTower().getPosition();

        if (ladders == battering && battering == siege) {
            getGameData().getEnemy().getLadders().Forward();
            getGameData().getEnemy().getBatteringRam().Forward();
            getGameData().getEnemy().getSiegeTower().Forward();
        } else if (ladders < battering && ladders < siege) {
            getGameData().getEnemy().getLadders().Forward();
        } else if (battering < ladders && battering < siege) {
            getGameData().getEnemy().getBatteringRam().Forward();
        } else if (siege < ladders && siege < battering) {
            getGameData().getEnemy().getSiegeTower().Forward();
        } else if (ladders == battering && battering < siege && ladders < siege) {
            getGameData().getEnemy().getLadders().Forward();
            getGameData().getEnemy().getBatteringRam().Forward();
        } else if (ladders == siege && siege < battering && ladders < battering) {
            getGameData().getEnemy().getLadders().Forward();
            getGameData().getEnemy().getSiegeTower().Forward();
        } else if (siege == battering && battering < ladders && battering < ladders) {
            getGameData().getEnemy().getBatteringRam().Forward();
            getGameData().getEnemy().getSiegeTower().Forward();
        }

    }

}
