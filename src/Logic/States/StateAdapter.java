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

    private GameData game;

    public StateAdapter(GameData g) {
        this.game = g;
    }

    public GameData getGame() {
        return game;
    }

    public void setGame(GameData game) {
        this.game = game;
    }

    @Override
    public IStates start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates CheckEnemyLines() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
