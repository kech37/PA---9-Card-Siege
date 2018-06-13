/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Logic.FileManager;
import Logic.Game;
import Logic.GameData;
import Logic.ObservableGame;
import View.TextUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Gui.InicialMenuJFrame;

/**
 *
 * @author a21220528
 */
public class Main {

    public static void main(String[] args) {

       // TextUI textUI = new TextUI(new Game());

       //textUI.run();
        
         InicialMenuJFrame menu = new InicialMenuJFrame(new ObservableGame(new Game()),1,1);

    }
}
