package Logic;

//import Logic.Cartas.Carta;
import Logic.Cards.Enemy;
import Logic.Cards.EventCard;
import Logic.Cards.Status;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameData implements  Serializable {

    private CardDeck deck;
    private Enemy enemy;
    private Status status;
    private DRM drm;
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
