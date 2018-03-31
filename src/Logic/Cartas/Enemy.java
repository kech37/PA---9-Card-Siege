package Logic.Cartas;

import Logic.Track;


public class Enemy {
    
    private Track Trebuchet, SiegeTower, BatteringRam; 
    private Track TrebuchetCount;

    public Enemy() {
        Trebuchet = new Track();
        SiegeTower = new Track();
        BatteringRam = new Track();
        TrebuchetCount = new Track();
    }

    public Track getTrebuchet() {
        return Trebuchet;
    }

    public void setTrebuchet(Track Trebuchet) {
        this.Trebuchet = Trebuchet;
    }

    public Track getSiegeTower() {
        return SiegeTower;
    }

    public void setSiegeTower(Track SiegeTower) {
        this.SiegeTower = SiegeTower;
    }

    public Track getBatteringRam() {
        return BatteringRam;
    }

    public void setBatteringRam(Track BatteringRam) {
        this.BatteringRam = BatteringRam;
    }

    public Track getTrebuchetCount() {
        return TrebuchetCount;
    }

    public void setTrebuchetCount(Track TrebuchetCount) {
        this.TrebuchetCount = TrebuchetCount;
    }
    
    
    
    
    
}
