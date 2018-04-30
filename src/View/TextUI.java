/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logic.Cards.EventCards.Events.RegularEvents;
import Logic.FileManager;
import Logic.Game;
import Logic.States.*;
import java.util.Scanner;

public class TextUI {

    private final Game game;
    private final Scanner scan;
    private boolean firstTime;

    public TextUI(Game g) {
        this.game = g;
        this.scan = new Scanner(System.in);
        firstTime = true;
    }

    public void run() {
        while (!(game.getState() instanceof GameOver) && !(game.getState() instanceof LeaveGame) && !(game.getState() instanceof Victory)) {
            if (game.getState() instanceof AwaitBegining) {
                getUserInputWhileAwaitingBegining();
            } else {
                if (game.getState() instanceof AwaitTopCardToBeDrawn) {
                    game.VerifyGameOver();
                    if (!(game.getState() instanceof GameOver)) {
                        getUserInputWhileAwaitTopCardToBeDraw();
                    }
                } else if (game.getState() instanceof AwaitActionSelection) {
                    game.VerifyGameOver();
                    if (!(game.getState() instanceof GameOver)) {
                        getUserInputWhileAwaitActionSelection();
                    }
                } else if (game.getState() instanceof AwaitEnemyTrackSelectionForArchersAttack) {
                    getUserInputWhileAwaitEnemyTrackSelectionForArchersAttack();
                } else if (game.getState() instanceof AwaitBoilingWaterTrackSelection) {
                    getUserInputWhileAwaitBoilingWaterTrackSelection();
                } else if (game.getState() instanceof AwaitOptionMovementSelection) {
                    getUserInputWhileAwaitOptionMovementSelection();
                } else if (game.getState() instanceof Victory) {
                    break;
                }
            }
        }
        if (game.getState() instanceof Victory) {
            uiVictory();
        } else if (game.getState() instanceof GameOver) {
            uiGameOver();
        }
    }

    private void getUserInputWhileAwaitingBegining() {
        int value;
        FileManager fileManager = new FileManager();

        System.out.println("----> 9CardSiege <----");
        System.out.println("0 - Sair");
        System.out.println("1 - Começar novo jogo");
        if (fileManager.checkSavegameFile()) {
            System.out.println("2 - Continuar antigo jogo");
        }

        value = readNumber();

        switch (value) {
            case 0:
                game.leaveGame();
                break;
            case 1:
                game.start();
                break;
            case 2:
                if (fileManager.checkSavegameFile()) {
                    game.loadGame();
                }
                break;
        }

    }

    private void getUserInputWhileAwaitTopCardToBeDraw() {

        if (!firstTime) {
            System.out.println("----------------------> Fim <------------------------------\n");
        }

        if (game.getGame().getDeck().isFull()) {
            System.out.println("--------------------------------------------> Dia " + (game.getGame().getDay() + 1) + " <----------------------------------------------------\n");
        }
        firstTime = false;
        System.out.println("\n\n----------------------> Nova Volta <-------------------------\n");
        game.CheckingEnemyLines();
        game.CheckExistingCards();
        if (game.getGame().getDeck().getOnUseEventCard() != null) {
            System.out.println(game.getGame().getDeck().getOnUseEventCard().getEvents().get(game.getGame().getDay()).getEventName());
            game.AdvanceEnemies();
            if (game.getGame().getDeck().getOnUseEventCard().getEvents().get(game.getGame().getDay()) instanceof RegularEvents) {
                System.out.println(game.getGame().getDeck().getOnUseEventCard().getEvents().get(game.getGame().getDay()).toString());
            }

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
        System.out.print("9 - Save game");
        System.out.println("            -1 - Exit game");

        value = readNumber();

        switch (value) {
            case -1:
                System.out.println("TODO: EXIT GAME!!");
                break;
            case 1:
                game.ArchersAttack();
                break;
            case 2:
                game.BoilingWaterAttack();
                break;
            case 3:
                game.CloseCombatAreaAtack();
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getCloseCombat());
                break;
            case 4:
                game.Coupure();
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getCoupure());
                break;
            case 5:
                game.RallyTroops();
                System.out.println("Dado: " + game.getGame().getDice().getValue());
                break;
            case 6:
                game.TunnelMovement();
                break;
            case 7:
                game.SupplyRaid();
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getRaid());
            case 8:
                game.Sabotage();
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getSabotageAction());
                break;
            case 9:
                game.saveGame();
                System.out.println(">>>>> Game saved! <<<<<");
                break;

        }

    }

    private void getUserInputWhileAwaitEnemyTrackSelectionForArchersAttack() {
        int value;

        System.out.println("----> Archers Attack <----");
        System.out.println("1 - Battering Ram");
        System.out.println("2 - Ladders Track");
        System.out.println("3 - Siege Tower");

        value = readNumber();

        game.ArchersAttackTrackSelection(value);
        switch (value) {
            case 1:
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getBatteringRam());
                break;
            case 2:
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getLadders());
                break;
            default:
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getSiegeTower());
                break;
        }

    }

    private void getUserInputWhileAwaitBoilingWaterTrackSelection() {
        int value;

        System.out.println("----> Boiling Water <----");
        System.out.println("1 - Battering Ram");
        System.out.println("2 - Ladders Track");
        System.out.println("3 - Siege Tower");

        value = readNumber();

        game.ArchersAttackTrackSelection(value);
        switch (value) {
            case 1:
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getBatteringRam());
                break;
            case 2:
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getLadders());
                break;
            default:
                System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getSiegeTower());
                break;
        }
    }

    private void getUserInputWhileAwaitOptionMovementSelection() {
        int value;

        System.out.println("----> Movement Selection <----");
        System.out.println("1 - Movimento Rapido");
        System.out.println("2 - Movimento Gratuito");

        value = readNumber();

        game.TunnelMovementOptionSelection(value);
    }

    private void showEnemyStatus() {
        System.out.println("\n---------> Informçoes <----------");
        System.out.println("Pontos de ação: " + (game.getGame().getDeck().getOnUseEventCard().getEvents().get(game.getGame().getDay()).getActionPointAllowance() + 1));
        System.out.println("");
        System.out.print("        --> Carta Inimiga <--");
        System.out.println("                                --> Carta Estados <--");
        System.out.print("Battering:" + game.getGame().getEnemy().getBatteringRam().getPosition() + " S" + game.getGame().getEnemy().getBatteringRamStrength());
        System.out.print("  Ladders:" + game.getGame().getEnemy().getLadders().getPosition() + " S" + game.getGame().getEnemy().getLaddersStrength());
        System.out.print("  Siege Tower:" + game.getGame().getEnemy().getSiegeTower().getPosition() + " S" + game.getGame().getEnemy().getSiegeTowerStrength());
        System.out.print("      Moral:" + game.getGame().getStatus().getMorale());
        System.out.print("  Força Muralha:" + game.getGame().getStatus().getWallStrenght());
        System.out.println("  Supplies:" + game.getGame().getStatus().getSupplies() + "\n");
        System.out.print("Threbuchet: " + game.getGame().getEnemy().getTrebuchet().getHowMany());
        System.out.print("                                       Tunel: " + game.getGame().getStatus().getTunnel());
        System.out.println("   Supplies Carregados: " + game.getGame().getStatus().getSuppliesLevel());
        System.out.println("---------------------------------\n");

    }

    private void uiVictory() {
        System.out.println("____________________________");
        System.out.println("          VITORIA!          ");
        System.out.println("____________________________");
    }

    private void uiGameOver() {
        System.out.println("____________________________");
        System.out.println("          PERDEU!          \n\n");
        showEnemyStatus();
        System.out.println("____________________________");
    }

    private int readNumber() {
        while (!scan.hasNextInt()) {
            scan.next();
        }
        return scan.nextInt();
    }
}
