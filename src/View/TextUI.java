/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
        while (!(game.getState() instanceof GameOver) && !(game.getState() instanceof LeaveGame) && !(game.getState() instanceof Victory)) {
            if (game.getState() instanceof AwaitBegining) {
                getUserInputWhileAwaitingBegining();
            } else if (game.getState() instanceof AwaitTopCardToBeDrawn) {
                getUserInputWhileAwaitTopCardToBeDraw();
            } else if (game.getState() instanceof AwaitActionSelection) {
                getUserInputWhileAwaitActionSelection();
            } else if (game.getState() instanceof AwaitEnemyTrackSelectionForArchersAttack) {
                getUserInputWhileAwaitEnemyTrackSelectionForArchersAttack();
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
        if (game.getGame().getDeck().getOnUseEventCard() != null) {
            System.out.println(game.getGame().getDeck().getOnUseEventCard().getEvents().get(game.getGame().getDay()).getEventName());
            game.AdvanceEnemies();
        }
    }

    private void showEnemyCard() {
        System.out.println("--> Carta Inimiga\n <--");
        System.out.println("-> Battering: " + game.getGame().getEnemy().getBatteringRam().getPosition());
        System.out.println("-> Ladders: " + game.getGame().getEnemy().getLadders().getPosition());
        System.out.println("-> Siege Tower: " + game.getGame().getEnemy().getSiegeTower().getPosition());
    }

    private void getUserInputWhileAwaitActionSelection() {
        int value;

        System.out.println("----> Ação do Jogador <----");
        System.out.println("1 - Archers Attack");
        System.out.println("2 - Boling Water Attack");
        System.out.println("3 - Close Combat Attack");
        System.out.println("4 - Coupure");
        System.out.println("3 - Rally Troops");
        System.out.println("3 - Tunel Movement");
        System.out.println("3 - Supply Raid");
        System.out.println("3 - Sabotage");

        while (!scan.hasNextInt()) {
            scan.next();
        }
        value = scan.nextInt();

        switch (value) {
            case 1:
                game.ArchersAttack();
                break;
        }

    }

    private void getUserInputWhileAwaitEnemyTrackSelectionForArchersAttack() {
        int value;

        System.out.println("----> Archers Attack <----");
        System.out.println("1 - Ladders Track");
        System.out.println("2 - Battering Ram");
        System.out.println("3 - Siege Tower");

        while (!scan.hasNextInt()) {
            scan.next();
        }
        value = scan.nextInt();

        game.ArchersAttackTrackSelection(value);

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
