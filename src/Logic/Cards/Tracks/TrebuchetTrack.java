/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cards.Tracks;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class TrebuchetTrack implements Serializable {

    private int count;

    public TrebuchetTrack() {
        count = 3;
    }

    public int getHowMany() {
        return this.count;
    }

    public void addOne() {
        if (count <= 3) {
            count++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeOne() {
        if (count >= 1) {
            count--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void resetHowMany() {
        count = 1;
    }
}
