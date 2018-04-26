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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            } else {
                if (game.getState() instanceof AwaitTopCardToBeDrawn) {
                    game.VerifyGameOver();
                    getUserInputWhileAwaitTopCardToBeDraw();
                } else if (game.getState() instanceof AwaitActionSelection) {
                    game.VerifyGameOver();
                    getUserInputWhileAwaitActionSelection();
                } else if (game.getState() instanceof AwaitEnemyTrackSelectionForArchersAttack) {
                    getUserInputWhileAwaitEnemyTrackSelectionForArchersAttack();
                } else if (game.getState() instanceof AwaitBoilingWaterTrackSelection) {
                    getUserInputWhileAwaitBoilingWaterTrackSelection();
                } else if(game.getState() instanceof AwaitOptionMovementSelection)
                {
                    getUserInputWhileAwaitOptionMovementSelection();
                }
            }
        }
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
            System.out.println(game.getGame().getDeck().getOnUseEventCard().getEvents().get(game.getGame().getDay()).toString());

        }

    }

    private void getUserInputWhileAwaitActionSelection() {
        int value;

        game.CheckActionPoints();
        if (game.getState() instanceof AwaitTopCardToBeDrawn) {
            return;
        }
        showEnemyStatus();
        System.out.println("      ----> Ação do Jogador <----");
        System.out.print("1 - Archers Attack");
        System.out.println("        5 - Rally Troops");
        System.out.print("2 - Boling Water Attack");
        System.out.println("   6 - Tunel Movement");
        System.out.print("3 - Close Combat Attack");
        System.out.println("   7 - Supply Raid");
        System.out.print("4 - Coupure");
        System.out.println("               8 - Sabotage");

        while (!scan.hasNextInt()) {
            scan.next();
        }
        value = scan.nextInt();

        switch (value) {
            case 1:
                game.ArchersAttack();
                System.out.println("Dado: " + game.getGame().getDice().getValue());
                break;
            case 2:
                game.BoilingWaterAttack();
                System.out.println("Dado: " + game.getGame().getDice().getValue());
                break;
            case 3:
                game.CloseCombatAreaAtack();
                System.out.println("Dado: " + game.getGame().getDice().getValue());
                break;
            case 4:
                game.Coupure();
                System.out.println("Dado: " + game.getGame().getDice().getValue());
                break;
            case 5:
                game.RallyTroops();
                System.out.println("Dado: " + game.getGame().getDice().getValue());
                break;
            case 6:
                game.TunnelMovement();
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

    private void getUserInputWhileAwaitBoilingWaterTrackSelection() {
        int value;

        System.out.println("----> Boiling Water <----");
        System.out.println("1 - Ladders Track");
        System.out.println("2 - Battering Ram");
        System.out.println("3 - Siege Tower");

        while (!scan.hasNextInt()) {
            scan.next();
        }
        value = scan.nextInt();

        game.ArchersAttackTrackSelection(value);
    }

    private void getUserInputWhileAwaitOptionMovementSelection()
    {
         int value;

        System.out.println("----> Movement Selection <----");
        System.out.println("1 - Movimento Rapido");
        System.out.println("2 - Movimento Gratuito");

        while (!scan.hasNextInt()) {
            scan.next();
        }
        value = scan.nextInt();
        game.TunnelMovementOptionSelection(value);
           

    }
    
    private void showEnemyStatus() {
        System.out.println("");
        System.out.print("        --> Carta Inimiga <--");
        System.out.println("                     --> Carta Estados <--");
        System.out.print("Battering:" + game.getGame().getEnemy().getBatteringRam().getPosition());
        System.out.print("  Ladders:" + game.getGame().getEnemy().getLadders().getPosition());
        System.out.print("  Siege Tower:" + game.getGame().getEnemy().getSiegeTower().getPosition());
        System.out.print("      Moral:" + game.getGame().getStatus().getMorale());
        System.out.print("  Força Muralha:" + game.getGame().getStatus().getWallStrenght());
        System.out.println("  Supplies:" + game.getGame().getStatus().getSupplies() + "\n");
        System.out.print("Threbuchet: " + game.getGame().getEnemy().getTrebuchet().getHowMany());
        System.out.print("                              Tunel: " + game.getGame().getStatus().getTunnel());
        System.out.println("   Supplies Carregados: " + game.getGame().getStatus().getSuppliesLevel());
        System.out.println("-----------------------");

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
