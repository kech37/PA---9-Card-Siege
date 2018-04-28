package Logic;

//import Logic.Cartas.Carta;
import Logic.Cards.CardDeck;
import Logic.Cards.EnemyTrackCard;
import Logic.Cards.StatusTrackCard;
import java.io.Serializable;

public class GameData implements Serializable {

    private final CardDeck deck;
    private final EnemyTrackCard enemy;
    private final StatusTrackCard status;
    private final DRM drm;
    private int day;
    private final Dice dice;
    private boolean justRaidSabotage;
    private boolean freeMovement;

    public GameData() {
        deck = new CardDeck(this);
        enemy = new EnemyTrackCard();
        status = new StatusTrackCard();
        drm = new DRM();
        dice = new Dice();
        justRaidSabotage = false;
        day = 0;
        freeMovement = false;
    }

    public boolean isFreeMovement() {
        return freeMovement;
    }

    public void setFreeMovement(boolean freeMovement) {
        this.freeMovement = freeMovement;
    }

    public Dice getDice() {
        return dice;
    }

    public int getDay() {
        return day;
    }

    public boolean nextDay() {
        if (day < 2) {
            day++;
            deck.reset(this);
            return true;
        } else {
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
