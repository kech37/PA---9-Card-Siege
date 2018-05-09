/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

import Logic.FileManager;
import Logic.Game;
import Logic.GameData;
import View.TextUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
