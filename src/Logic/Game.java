/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.States.AwaitBegining;
import Logic.States.IStates;
import java.io.Serializable;

/**
 *
 * @author andre
 */
public final class Game implements Serializable {

    static final long serialVersionUID = 1010L;

    private final GameData gameData;
    private IStates state;

    public Game() {
        gameData = new GameData();
        state = new AwaitBegining(gameData);
    }

    public GameData getGame() {
        return gameData;
    }

    public IStates getState() {
        return state;
    }

    private void setState(IStates s) {
        state = s;
    }

    public void start() {
        setState(getState().start());
    }

    public void leaveGame() {
        setState(getState().finish());
    }

    public void CheckingEnemyLines() {
        setState(getState().CheckingEnemyLines());
    }

    public void CheckExistingCards() {
        setState(getState().CheckExistingCards());
    }

    public void AdvanceEnemies() {
        setState(getState().AdvanceEnemies());
    }

    public void ActionSelection() {
        setState(getState().ActionSelection());
    }

    public void ArchersAttack() {
        setState(getState().ArcherAttack());
    }

    public void BoilingWaterAttack() {
        if (gameData.getEnemy().isCardsOnCircle()) {
            setState(getState().BoilingWaterAttack());
        }
    }

    public void ArchersAttackTrackSelection(int value) {
        setState(getState().ArchersAttackTrackSelection(value));
    }

    public void BoilingWaterAttackTrackSelection(int value) {
        setState(getState().BoilingWatterTrackSelection(value));
    }

    public void CloseCombatAreaAtack() {
        if (gameData.getEnemy().isCardsOnCircle()) {
            setState(getState().CloseCombatAttack());
        }
    }

    public void Coupure() {
        setState(getState().Coupure());
    }

    public void RallyTroops() {
        setState(getState().RallyTroops());
    }

    public void CheckActionPoints() {
        setState(getState().CheckActionPoints());
    }

    public void TunnelMovement() {
        setState(getState().TunnelMovement());
    }

    public void VerifyGameOver() {
        setState(getState().VerifyGameOver());
    }

    public void TunnelMovementOptionSelection(int value) {
        setState(getState().TunnelMovementOptionSelection(value));
    }

    public void ReduceSuppliesChoice(int value) {
        setState(getState().SuppliesReduceChoice(value));
    }

    public void SupplyRaid() {
        setState(getState().SupplieRaidAttack());
    }

    public void Sabotage() {
        setState(getState().SabotageAttack());
    }

    public void saveGame() {
        setState(getState().saveGame(this));
    }

    public void saveGameWithName(String fileName) {
        setState(getState().saveGameWithName(fileName, this));
    }

    public void ExitGame() {
        setState(getState().exitGame());
    }

    public void NextTurn() {
        setState(getState().NextTurn());
    }

    public void AddAnotherActionPoint() {
        setState(getState().AddAnotherActionPoint());
    }

    public void Encouragement(int value) {
        setState(getState().SelectSuppliesOrMorale(value));
    }

}
