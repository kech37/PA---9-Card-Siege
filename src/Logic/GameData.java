package Logic;

//import Logic.Cartas.Carta;
import Logic.Cards.Enemy;
import Logic.Cards.Status;
import java.io.Serializable;

public class GameData implements  Serializable {

    private final CardDeck deck;
    private final Enemy enemy;
    private final Status status;
    private final DRM drm;
    private boolean  justRaidSabotage;
    
    
    
    public GameData() {
        deck = new CardDeck();
        enemy = new Enemy();
        status = new Status();     
        drm = new DRM();
        justRaidSabotage = false;
    }

    public boolean isJustRaidSabotage() {
        return justRaidSabotage;
    }

    public void setJustRaidSabotage(boolean justRaidSabotage) {
        this.justRaidSabotage = justRaidSabotage;
    }

    public DRM getDRM() {
        
        return drm;
    }


    public CardDeck getDeck() {
        return deck;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Status getStatus() {
        return status;
    }
    
    
    
   
}
