package com.game.utils;

import com.game.models.CrookedDiceService;
import com.game.models.Dice;
import com.game.models.DiceService;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 3:17 PM
 *
 * This class is for instantiating the required Dice for the game, whether it is normal 1-6 faced dice or 2/4/6 faced crooked Dice.
 */
public class DiceFactory {

    public static Dice dice;

    public static Dice getDice(int selectedDice) {

        switch(selectedDice) {

            case 2:
                dice = new CrookedDiceService();
                break;
            default:
                dice = new DiceService();
        }

        return dice;
    }
}
