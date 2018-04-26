package Logic.Cards;

import java.io.Serializable;

public class StatusTrackCard implements Serializable {

    private int SuppliesLevel;
    private int WallStrenght, Morale, Supplies;
    private int Tunnel;

    public StatusTrackCard() {
        WallStrenght = 4;
        Morale = 4;
        Supplies = 4;
        Tunnel = 0;
        SuppliesLevel = 0;
    }

    public int getSuppliesLevel() {
        return SuppliesLevel;
    }

    public int getWallStrenght() {
        return WallStrenght;
    }

    public int getMorale() {
        return Morale;
    }

    public int getSupplies() {
        return Supplies;
    }

    public int getTunnel() {
        return Tunnel;
    }

    public void setSuppliesLevel(int SuppliesLevel) {
        this.SuppliesLevel = SuppliesLevel;
    }

    public void setWallStrenght(int WallStrenght) {
        this.WallStrenght = WallStrenght;
    }

    public void setMorale(int Morale) {
        this.Morale = Morale;
    }

    public void setSupplies(int Supplies) {
        this.Supplies = Supplies;
    }

    public void setTunnel(int Tunnel) {
        this.Tunnel = Tunnel;
    }

    public void ModifySuppliesLevel(int SuppliesLevel) {
        this.SuppliesLevel += SuppliesLevel;
    }

    public void ModifyWallStrenght(int WallStrenght) {
        this.WallStrenght += WallStrenght;
    }

    public void ModifyMorale(int Morale) {
        this.Morale += Morale;
    }

    public void ModifySupplies(int Supplies) {
        this.Supplies += Supplies;
    }

    public void ModifyTunnel(int Tunnel) {
        this.Tunnel += Tunnel;
    }

    public boolean isOnEnemyLines() {
        return Tunnel == 3;
    }

}
