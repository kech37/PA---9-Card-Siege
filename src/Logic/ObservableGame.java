/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cards.EnemyTrackCard;
import Logic.Cards.EventCards.BaseEventCard;
import Logic.Cards.StatusTrackCard;
import Logic.States.AwaitTopCardToBeDrawn;
import Logic.States.IStates;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ObservableGame extends java.util.Observable {

    private Game game;

    public ObservableGame(Game game) {
        this.game = game;
    }

    public void StartGame() {
        game.start();

        setChanged();
        notifyObservers();
    }

    public int getDay() {
        return game.getGame().getDay();
    }

    public EnemyTrackCard getEnemyCard() {
        return game.getGame().getEnemy();
    }

    public StatusTrackCard getStatusCard() {
        return game.getGame().getStatus();
    }

    public void AwaitTopCardToBeDrawnAction() {
        game.CheckingEnemyLines();
        game.CheckExistingCards();

        if (game.getGame().getDeck().getOnUseEventCard() != null) {
            game.AdvanceEnemies();
        }
        game.ActionSelection();
        setChanged();
        notifyObservers();
    }

    public int getActionPoint() {
        return getAtualCard().getEvents().get(getDay()).getActionPointAllowance() + 1;
    }

    public int getDiceNumber() {
        return game.getGame().getDice().getValue();
    }

    public void ActionSelection() {
        game.ActionSelection();
    }

    public void ArchersAttack() {
        game.ArchersAttack();
        setChanged();
        notifyObservers();
    }
    
    public void BoilingWaterAttackTrackSelection(int value) {
        game.BoilingWaterAttackTrackSelection(value);
        setChanged();
        notifyObservers();
    }

    public void BoilingWaterAttack() {
        game.BoilingWaterAttack();
        setChanged();
        notifyObservers();
    }

    public void CloseCombatAreaAtack() {
        game.CloseCombatAreaAtack();
        System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getCloseCombat());
        setChanged();
        notifyObservers();
    }

    public void Coupure() {
        game.Coupure();
        System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getCoupure());
        setChanged();
        notifyObservers();
    }

    public void RallyTroops() {
        game.RallyTroops();
        setChanged();
        notifyObservers();
    }

    public void TunnelMovement() {
        game.TunnelMovement();
        setChanged();
        notifyObservers();
    }

    public void SupplyRaid() {
        game.SupplyRaid();
        System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getRaid());
        setChanged();
        notifyObservers();
    }

    public void Sabotage() {
        game.Sabotage();
        System.out.println("Dado: " + game.getGame().getDice().getValue() + " + " + game.getGame().getDRM().getSabotageAction());
        setChanged();
        notifyObservers();
    }

    public IStates getState() {
        return game.getState();
    }

    public void SetUpdate() {
        setChanged();
        notifyObservers();
    }

    public int getNCards() {
        return game.getGame().getDeck().getNCards();
    }

    public BaseEventCard getAtualCard() {
        return game.getGame().getDeck().getOnUseEventCard();
    }

    public void saveGame() {
        game.saveGame();
    }

    public void saveGameWithName(String fileName) {
        game.saveGameWithName(fileName);
    }

    public void loadGame() throws IOException, FileNotFoundException, ClassNotFoundException {
        FileManager f = new FileManager();
        game = f.GetGameDataFromFile();
    }

    public void ArchersAttackTrackSelection(int value) {
        game.ArchersAttackTrackSelection(value);
        checkActionPoints();
    }

    public void checkActionPoints() {
        game.CheckActionPoints();
        if (game.getState() instanceof AwaitTopCardToBeDrawn) {
            game.NextTurn();
            setChanged();
            notifyObservers();
        }
    }

    public void loadGameWithName(String fileName) throws IOException, FileNotFoundException, ClassNotFoundException {
        FileManager f = new FileManager(fileName);
        game = f.GetGameDataFromFile();
    }

    public void tradeActionPoint() {
        game.AddAnotherActionPoint();
    }

    public void NextTurn() {
        game.NextTurn();
        game.getGame().getDice().setValue(0);
        
        setChanged();
        notifyObservers();
    }

    public void leaveGame() {
        game.leaveGame();
        setChanged();
        notifyObservers();
    }
    
    public boolean isJustRaidSabotage()
    {
        return game.getGame().isJustRaidSabotage();
    }

}
