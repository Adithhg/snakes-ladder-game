package com.game.models;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 3:36 PM
 *
 * this interface provides the basic actions required for the game to run
 */
public interface SnakesAndLadderGameRunner {

    boolean startGame();
    int diceThrow();
    void movePlayer(int diceValue);
    boolean isGameOver();

}
