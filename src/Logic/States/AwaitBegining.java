/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

import Logic.FileManager;
import Logic.GameData;
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
        try {
            FileManager fileManager = new FileManager();
            setDataGame(fileManager.GetGameDataFromFile());
            return new AwaitTopCardToBeDrawn(getDataGame());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AwaitBegining.class.getName()).log(Level.SEVERE, null, ex);
            return this;
        }
    }

    @Override
    public IStates finish() {
        return new LeaveGame(getDataGame());
    }

}
