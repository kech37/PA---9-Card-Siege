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
public class AwaitBegining extends StateAdapter {

    public AwaitBegining(GameData gameData) {
        super(gameData);
    }

    @Override
    public IStates start() {
        return new AwaitTopCardToBeDrawn(getDataGame());

    }

    @Override
    public IStates loadGame() {
        return this;
    }

    @Override
    public IStates finish() {
        return new LeaveGame(getDataGame());
    }

}
