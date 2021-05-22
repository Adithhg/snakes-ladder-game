package com.game.models;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 12:15 PM
 */
public class DiceService implements Dice{

    @Override
    public int roll() {
        return new Random().nextInt(DICE_SIDES) + 1;
    }
}
