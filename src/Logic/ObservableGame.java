/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cards.CardDeck;
import Logic.Cards.EventCards.BaseEventCard;
import Logic.Cards.EventCards.EventCard1;
import Logic.Cards.EventCards.Events.RegularEvents;
import Logic.States.IStates;

public class ObservableGame extends java.util.Observable {

    private Game game;

    public ObservableGame(Game game) {
        this.game = game;
    }

    public void StartGame() {
        game.start();
       
        AwaitTopCardToBeDrawnAction();
        
        setChanged();
        notifyObservers();
    }
    
    public void  AwaitTopCardToBeDrawnAction()
    {
        game.CheckingEnemyLines();
        game.CheckExistingCards();
        
        /*if (game.getGame().getDeck().getOnUseEventCard() != null) {
            game.AdvanceEnemies();
        }*/
    }

    public IStates getState() {
        return game.getState();
    }
    
    public void SetUpdate()
    {
        setChanged();
        notifyObservers();
    }

    public int getNCards() {
        return game.getGame().getDeck().getNCards();
    }

    public BaseEventCard getAtualCard() {
        return game.getGame().getDeck().getOnUseEventCard();
    }

}
