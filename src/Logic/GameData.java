package Logic;

//import Logic.Cartas.Carta;
import Logic.Cards.CardDeck;
import Logic.Cards.EnemyTrackCard;
import Logic.Cards.StatusTrackCard;
import java.io.Serializable;

public class GameData implements Serializable {

    private CardDeck deck;
    private final EnemyTrackCard enemy;
    private final StatusTrackCard status;
    private final DRM drm;
    private int day;
    private boolean justRaidSabotage;

    public GameData() {
        deck = new CardDeck(this);
        enemy = new EnemyTrackCard();
        status = new StatusTrackCard();
        drm = new DRM();
        justRaidSabotage = false;
        day = 1;
    }

    public int getDay() {
        return day;
    }

    public boolean nextDay() {
        if(day < 3){
            day++;
            deck.reset(this);          
            return true;
        }else{
            return false;
        }
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

    public EnemyTrackCard getEnemy() {
        return enemy;
    }

    public StatusTrackCard getStatus() {
        return status;
    }
       
}
