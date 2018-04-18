package Logic;

//import Logic.Cartas.Carta;
import Logic.Cards.Enemy;
import Logic.Cards.Status;
import java.util.ArrayList;
import java.io.Serializable;

public class GameData implements  Serializable {

    CardDeck deck;
    Enemy enemy;
    Status status;
    
    
    public GameData() {
        deck = new CardDeck();
        enemy = new Enemy();
        status = new Status();      
    }
    
    
   
}
