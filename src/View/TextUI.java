/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logic.Game;
import Logic.States.AwaitBegining;
import Logic.States.IStates;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TextUI {

    private Game game;
    private boolean exit;

    public TextUI(Game g) {
        this.game = g;
        exit = false;
    }

    public void uiAwaitBeggining() {
        String op1;
        char c;

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

    /////// GRAVA JOGO NUM FICHEIRO
    private void SaveGameToFile(String fileName) throws IOException {
        ObjectOutputStream oout = null;

        try {
            oout = new ObjectOutputStream(new FileOutputStream(fileName));

            oout.writeObject(game);

        } finally {

            if (oout != null) {
                oout.close();
            }
        }
    }

    ////// DEVOLVE O JOGO QUE ESTÁ GUARDADO NO FICHEIRO
    private Game GetGameFromFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream oin = null;

        try {

            oin = new ObjectInputStream(new FileInputStream(fileName));

            return (Game) oin.readObject();

        } finally {
            if (oin != null) {
                oin.close();
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
