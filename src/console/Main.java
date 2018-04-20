/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import Logic.Game;
import View.TextUI;

/**
 *
 * @author a21220528
 */
public class Main {

    public static void main(String[] args) {

        TextUI textUI = new TextUI(new Game());

        textUI.run();

    }
}
