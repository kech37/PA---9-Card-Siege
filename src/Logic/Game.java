/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.States.IStates;
import java.io.Serializable;

/**
 *
 * @author andre
 */
public class Game implements Serializable {

    private GameData gameData;
    private IStates state;
    
    
       public Game() {
        gameData = new GameData();
        //setState(new AwaitBegining(gameData));
    }

}
