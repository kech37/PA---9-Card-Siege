/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

import Logic.GameData;

/**
 *
 * @author a21220528
 */
public class AwaitTopCardToBeDraw extends StateAdapter {

    public AwaitTopCardToBeDraw(GameData dataGame) {
        super(dataGame);
    }


    @Override
    public IStates finish() {
        return new GameOver(getDataGame());
    }
    
}
