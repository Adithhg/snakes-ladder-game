package com.game.models;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 12:11 PM
 *
 * This interface provides the roll action on the Dice, whichever class implements this, must provide the implementation details
 *
 */
public interface Dice {

    //CONSTANTS
    int DICE_SIDES = 6;

    int roll();
}
