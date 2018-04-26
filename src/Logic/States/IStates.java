/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.States;

public interface IStates {

    //  AWAIT BEGINIG 
    IStates start();
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

    //AWAIT ARCHERS ATACK ACTION SELECTION
    IStates ArchersAttackTrackSelection(int value);
    
    //AWAIT BOILING WATER  ACTION SELECTION
     IStates BoilingWatterTrackSelection(int value);
     
     /// TUNNEL MOVEMENT WATER  ACTION SELECTION
     IStates TunnelMovementTrackSelection(int value);

    

}
