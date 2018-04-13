/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logic.Game;
import Logic.States.AwaitBegining;
import Logic.States.IStates;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class TextUI {

    private Game game;
    private boolean exit;

    public TextUI(Game g) {
        this.game = g;
        exit = false;
    }

    public void uiAwaitBeggining() {
        String op1, option2;
        char c, d;
        int f;
        Scanner sc = new Scanner(System.in);
        while (true) {
            do {
                System.out.println("\n----> 9CardSiege <----\n");
                System.out.println("0 - Sair");
                System.out.println("1 - Comecar Novo Jogo");
                System.out.println("2 - Continuar Jogo");

                op1 = sc.next();

                if (op1.length() >= 1) {
                    c = op1.charAt(0);
                } else {
                    c = ' ';
                }
            } while (c < '0' || c > '4');

            switch (c) {
                case '0':
                    exit = true;
                    return;
                    
            }

        }

    }

    public void run() {
        while (!exit) {

            IStates state = game.getState();

            if (state instanceof AwaitBegining) {
                uiAwaitBeggining();
            }
        }
    }
}
