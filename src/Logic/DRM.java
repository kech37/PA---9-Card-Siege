/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author andre
 */
public class DRM {

    private int SiegeTower, BatteringRam, Ladders;
    private int Raid, Coupure, CloseCombat, CircleSpaces, MoraleAction, SabotageAction;

    public DRM() {
        SiegeTower = 0;
        BatteringRam = 0;
        Ladders = 0;
        Raid = 0;
        Coupure = 0;
        CloseCombat = 0;
        CircleSpaces = 0;
        MoraleAction = 0;
        SabotageAction = 0;
    }

    public int getSiegeTower() {
        return SiegeTower;
    }

    public void setSiegeTower(int SiegeTower) {
        this.SiegeTower += SiegeTower;
    }

    public int getBatteringRam() {
        return BatteringRam;
    }

    public void setBatteringRam(int BatteringRam) {
        this.BatteringRam += BatteringRam;
    }

    public int getLadders() {
        return Ladders;
    }

    public void setLadders(int Ladders) {
        this.Ladders += Ladders;
    }

    public int getRaid() {
        return Raid;
    }

    public void setRaid(int Raid) {
        this.Raid += Raid;
    }

    public int getSabotageAction() {
        return SabotageAction;
    }

    public void setSabotageAction(int SabotageAction) {
        this.SabotageAction = SabotageAction;
    }

    

    public int getCoupure() {
        return Coupure;
    }

    public void setCoupure(int Coupure) {
        this.Coupure += Coupure;
    }

    public int getCloseCombat() {
        return CloseCombat;
    }

    public void setCloseCombat(int CloseCombat) {
        this.CloseCombat += CloseCombat;
    }

    public int getCircleSpaces() {
        return CircleSpaces;
    }

    public void setCircleSpaces(int CircleSpaces) {
        this.CircleSpaces += CircleSpaces;
    }

    public int getMoraleAction() {
        return MoraleAction;
    }

    public void setMoraleAction(int MoraleAction) {
        this.MoraleAction += MoraleAction;
    }

}
