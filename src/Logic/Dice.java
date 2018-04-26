/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author a21220528
 */
public class Dice implements Serializable {

    private final int sidesNumber;
    private int value;

    public Dice(int sides) {
        sidesNumber = sides;
        value = -1;
    }

    public int getValue() {
        return value;
    }

    public Dice() {
        this(6);
    }

    public int rollDice() {
        Random random = new Random();
        value = random.nextInt(this.sidesNumber) + 1;
        return value;
    }
}
