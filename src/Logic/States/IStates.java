/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

import Logic.Game;
import View.TextUI;

public interface IStates {
    
    ///
    IStates exitGame();

    //  AWAIT BEGINIG 
    IStates start();
    IStates loadGame();
    IStates finish();

    //AWAIT TOP CARD TO BE DOWN
    IStates CheckingEnemyLines();
    IStates CheckExistingCards();
    IStates AdvanceEnemies();

    //AWAIT ACTION SELECTION
    IStates ArcherAttack();
    IStates CloseCombatAttack();
    IStates Coupure();
    IStates RallyTroops();
    IStates SupplieRaidAttack();
    IStates SabotageAttack();
    IStates BoilingWaterAttack();
    IStates CheckActionPoints();
    IStates TunnelMovement();
    IStates VerifyGameOver();
    IStates NextTurn();
    IStates saveGame(Game game);
    IStates AddAnotherActionPoint();

    //AWAIT ARCHERS ATACK ACTION SELECTION
    IStates ArchersAttackTrackSelection(int value);

    //AWAIT BOILING WATER  ACTION SELECTION
    IStates BoilingWatterTrackSelection(int value);

    /// TUNNEL MOVEMENT SELECTION
    IStates TunnelMovementOptionSelection(int value);
    
    ///AWAIT SUPPLIES REDUCE CHOICE
    IStates SuppliesReduceChoice(int value);
    
    ///AWAIT ENCOURAGEMENT
    IStates SelectSuppliesOrMorale(int value);
 
}
