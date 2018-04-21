/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

import Logic.GameData;
import java.io.Serializable;

/**
 *
 * @author andre
 */
public class AwaitBegining extends StateAdapter implements IStates, Serializable {

    public AwaitBegining(GameData g) {
        super(g);
    }

    @Override
    public IStates start() {
        return super.start(); //To change body of generated methods, choose Tools | Templates.
    }

}
