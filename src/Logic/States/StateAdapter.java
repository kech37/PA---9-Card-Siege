/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

import Logic.Game;
import Logic.GameData;
import java.io.Serializable;

/**
 *
 * @author andre
 */
public class StateAdapter implements IStates,Serializable {

    static final long serialVersionUID = 1010L;
    
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
    public IStates SuppliesReduceChoice(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates exitGame() {
       return new LeaveGame(getDataGame());
    }

    @Override
    public IStates NextTurn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates saveGame(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates loadGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates AddAnotherActionPoint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates SelectSuppliesOrMorale(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates ActionSelection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
