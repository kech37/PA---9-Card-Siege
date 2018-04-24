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
public class AwaitTopCardToBeDrawn extends StateAdapter  implements IStates   {

    public AwaitTopCardToBeDrawn(GameData g) {
        super(g);
    }

    @Override
    public IStates start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates CheckEnemyLines() {
        if(getGame().getStatus().getTunnel() != 0)
        {
            //if(getGame().getDeck().Shuffle())
            return null;
        }
        else
          //  DrawnTopCard();
            return null;
    }
    
}
