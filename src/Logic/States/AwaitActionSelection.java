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
public class AwaitActionSelection extends StateAdapter{
    
    public AwaitActionSelection(GameData dataGame) {
        super(dataGame);
    }

    @Override
    public IStates ArcherAttack() {
       return new AwaitEnemyTrackSelectionForArchersAttack(getDataGame());
    }
    
    
    
}
