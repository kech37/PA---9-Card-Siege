package Logic.Cards;

import Logic.Cards.Tracks.Track;
import Logic.Cards.Tracks.TrebuchetTrack;
import java.io.Serializable;

public class EnemyTrackCard implements Serializable {

    private final Track SiegeTower;

    private final Track BatteringRam;
    private final Track Ladders;
    private final TrebuchetTrack Trebuchet;
    private int SiegeTowerStrength, BatteringRamStrength, LaddersStrength;

    public EnemyTrackCard() {
        Trebuchet = new TrebuchetTrack();
        Ladders = new Track();
        SiegeTower = new Track();
        BatteringRam = new Track();
        SiegeTowerStrength = 4;
        BatteringRamStrength = 3;
        LaddersStrength = 2;
    }

    public Track getSiegeTower() {
        return this.SiegeTower;
    }

    public Track getBatteringRam() {
        return this.BatteringRam;
    }

    public Track getLadders() {
        return this.Ladders;
    }

    public TrebuchetTrack getTrebuchet() {
        return this.Trebuchet;
    }

    public int getSiegeTowerStrength() {
        return this.SiegeTowerStrength;
    }

    public int getBatteringRamStrength() {
        return this.BatteringRamStrength;
    }

    public int getLaddersStrength() {
        return this.LaddersStrength;
    }

    public void ModifySiegeTowerStrength(int c) {
        if ((SiegeTowerStrength + c) > 0) {
            SiegeTowerStrength += c;
        } else {
            SiegeTowerStrength = 0;
        }
    }

    public void ModifyBatteringRamStrength(int c) {
        if ((BatteringRamStrength + c) > 0) {
            BatteringRamStrength += c;
        } else {
            BatteringRamStrength = 0;
        }
    }

    public void ModifyLaddersStrength(int c) {
        if ((LaddersStrength + c) > 0) {
            LaddersStrength += c;
        } else {
            LaddersStrength = 0;
        }
    }

    public boolean isCardsOnCircle() {
        if (BatteringRam.getPosition() == 1 || SiegeTower.getPosition() == 1 || Ladders.getPosition() == 1) {
            return true;
        }
        return false;
    }

    public int isJustOneEnemyOnCircle() {
        int nEnemy = 0, enemy=0;
        if (BatteringRam.getPosition() == 1) {
            nEnemy++;
            enemy=1;
            
        }
        if (SiegeTower.getPosition() == 1) {
            nEnemy++;
            enemy = 2;
        }
        if (Ladders.getPosition() == 1) {
            nEnemy++;
            enemy = 3;
        }
        
       if(nEnemy == 1)
       {
           return enemy;
       }
       else 
           return -1;
    }
    
    public boolean isCloseCombat()
    {
        int nEnemy=0;
        
       nEnemy += (Ladders.getPosition() == 0) ? 1:0;
       nEnemy += (SiegeTower.getPosition() == 0) ? 1:0;
       nEnemy += (BatteringRam.getPosition() == 0) ? 1:0;
       
       return (nEnemy >= 2);
    }

}
