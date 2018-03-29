/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.util.Random;

/**
 *
 * @author a21220528
 */
public class Dice {

    private final int sidesNumber;

    public Dice(int sides) {
        sidesNumber = sides;
    }

    public Dice() {
        this(6);
    }

    int rollDice() {
        Random random = new Random();
        return random.nextInt(this.sidesNumber) + 1;
    }
}
