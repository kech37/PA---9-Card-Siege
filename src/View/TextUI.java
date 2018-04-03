/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logic.Game;

/**
 *
 * @author andre
 */
public class TextUI {

    private Game game;
    private boolean exit;

    public void run(Game g) {
        game = g;
        exit = false;
    }
}
