/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logic.Dice;
import Logic.Game;
import Logic.States.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TextUI {

    private final Game game;
    private final Scanner scan;

    public TextUI(Game g) {
        this.game = g;
        this.scan = new Scanner(System.in);
    }

    public void run() {
        while (!(game.getState() instanceof GameOver) && !(game.getState() instanceof LeaveGame)) {
            if (game.getState() instanceof AwaitBegining) {
                getUserInputWhileAwaitingBegining();
            } else if (game.getState() instanceof AwaitTopCardToBeDrawn) {
                getUserInputWhileAwaitTopCardToBeDraw();
            }
        }
    }

    private void iuAwaitTopCardToBeDrawn() {
        System.out.println("A verificar linhas Inimigas...");
    }

    private void getUserInputWhileAwaitingBegining() {
        int value;

        System.out.println("----> 9CardSiege <----");
        System.out.println("0 - Sair");
        System.out.println("1 - Começar novo jogo");
        System.out.println("2 - Continuar antigo jogo");

        while (!scan.hasNextInt()) {
            scan.next();
        }
        value = scan.nextInt();

        switch (value) {
            case 0:
                game.leaveGame();
                break;
            case 1:
                game.start();
                break;
        }
    }

    private void getUserInputWhileAwaitTopCardToBeDraw() {  
        game.CheckingEnemyLines();
        game.CheckExistingCards();
        System.out.println(game.getGame().getDeck().getOnUseEventCard().getEvents().get(game.getGame().getDay()-1).getEventName());
        
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

}
