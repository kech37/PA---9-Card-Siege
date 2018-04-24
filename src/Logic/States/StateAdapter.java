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
public class StateAdapter implements IStates {

    private GameData dataGame;

    public StateAdapter(GameData dataGame) {
        this.dataGame = dataGame;
    }

    public GameData getDataGame() {
        return dataGame;
    }

    public void setDataGame(GameData dataGame) {
        this.dataGame = dataGame;
    }

    @Override
    public IStates start() {
        return this;
    }

    @Override
    public IStates finish() {
        return this;
    }
}
