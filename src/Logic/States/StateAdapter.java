/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

import Logic.FileManager;
import Logic.GameData;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class StateAdapter implements IStates {

    private GameData dataGame;

    public StateAdapter(GameData dataGame) {
        this.dataGame = dataGame;
    }

    public GameData getDataGame() {
        return dataGame;
    }

    public void setDataGame(GameData dataGame) {
        this.dataGame = dataGame;
    }

    @Override
    public IStates start() {
        return this;
    }

    @Override
    public IStates finish() {
        return this;
    }

    @Override
    public IStates CheckingEnemyLines() {
        return this;
    }

    @Override
    public IStates CheckExistingCards() {
        return this;
    }

    @Override
    public IStates AdvanceEnemies() {
        return this;
    }

    @Override
    public IStates ArcherAttack() {
        return this;
    }

    @Override
    public IStates ArchersAttackTrackSelection(int value) {
        return this;
    }

    @Override
    public IStates CloseCombatAttack() {
        return this;
    }

    @Override
    public IStates Coupure() {
        return this;
    }

    @Override
    public IStates RallyTroops() {
        return this;
    }

    @Override
    public IStates SupplieRaidAttack() {
        return this;
    }

    @Override
    public IStates SabotageAttack() {
        return this;
    }

    @Override
    public IStates BoilingWatterTrackSelection(int value) {
        return this;
    }

    @Override
    public IStates BoilingWaterAttack() {
        return this;
    }

    @Override
    public IStates CheckActionPoints() {
        return this;
    }

    @Override
    public IStates TunnelMovement() {
        return this;
    }

    @Override
    public IStates VerifyGameOver() {
        return this;
    }

    @Override
    public IStates TunnelMovementOptionSelection(int value) {
        return this;
    }

    @Override
    public IStates saveGame() {
        try {
            FileManager fileManager = new FileManager();
            fileManager.SaveGameDataToFile(getDataGame());
        } catch (IOException ex) {
            Logger.getLogger(StateAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public IStates loadGame() {
        return this;
    }
}
