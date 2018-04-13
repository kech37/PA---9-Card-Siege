package Logic.Cards;

import Logic.Track;


public class Status {
    
    private boolean SupliesLevel;
    private Track WallStrenght, Morale, Supplies;
    private int Tunnel;


    public Status() {
        WallStrenght = new Track();
        Morale = new Track();
        Supplies = new Track();
    }

    public boolean isSupliesLevel() {
        return SupliesLevel;
    }

    public void setSupliesLevel(boolean SupliesLevel) {
        this.SupliesLevel = SupliesLevel;
    }

    public Track getWallStrenght() {
        return WallStrenght;
    }

    public void setWallStrenght(Track WallStrenght) {
        this.WallStrenght = WallStrenght;
    }

    public Track getMorale() {
        return Morale;
    }

    public void setMorale(Track Morale) {
        this.Morale = Morale;
    }

    public Track getSupplies() {
        return Supplies;
    }

    public void setSupplies(Track Supplies) {
        this.Supplies = Supplies;
    }

    public int getTunnel() {
        return Tunnel;
    }

    public void setTunnel(int Tunnel) {
        this.Tunnel = Tunnel;
    }
     
}

