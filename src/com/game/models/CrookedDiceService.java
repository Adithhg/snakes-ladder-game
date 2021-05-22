package com.game.models;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 12:18 PM
 */
public class CrookedDiceService implements Dice {

    //CONSTANTS
    private static int[] POSSIBLE_DICE_ROLLS = new int[] {2, 4, 6};

    /*
        Returns the even numbered side every time the player uses CrookedDice.
     */
    @Override
    public int roll() {
        return POSSIBLE_DICE_ROLLS[new Random().nextInt(POSSIBLE_DICE_ROLLS.length)];
    }
}
