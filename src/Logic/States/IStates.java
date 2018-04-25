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
    IStates ArchersAttackTrackSelection(int value);
    

}
