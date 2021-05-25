package com.game.runner;

import com.game.models.Ladder;
import com.game.models.Snake;
import com.game.models.SnakesAndLadderGameRunner;
import com.game.models.SnakesLadderBoard;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 3:33 PM
 *
 * This class is created for implementing the snakes and ladder game for a single player
 */
public class SinglePlayerSnakesAndLaddersGameRunner implements SnakesAndLadderGameRunner {

    //Constants
    private static int NUMBER_OF_ROLLS = 10; //only allowed to roll 10 times
    private static int BOARD_SIZE = 100;     //goal

    private SnakesLadderBoard snakesLadderBoard;
    private int currentRollCounter = 0;
    private int currentPosition = 0;

    public SinglePlayerSnakesAndLaddersGameRunner(SnakesLadderBoard snakesLadderBoard) {
        this.snakesLadderBoard = snakesLadderBoard;
    }

    @Override
    public boolean startGame() {

        while (!isGameOver()) {

            int diceThrowValue = diceThrow();
            System.out.println("Currrent Dice throw value for the turn: "+currentRollCounter+ "  :::  "+diceThrowValue);
            movePlayer(diceThrowValue);
            currentRollCounter++;
        }
        if (gameWon()) {
            return true;
        }
        return false;
    }

    @Override
    public int diceThrow() {
        return snakesLadderBoard.getDice().diceThrow();
    }

    @Override
    public void movePlayer(int diceValue) {

        int oldPosition = currentPosition;
        int newPosition = oldPosition + diceValue;

        if (newPosition > BOARD_SIZE) {
            newPosition = oldPosition;
        }
        else {
            //check for the snakes and ladders in the new position
            int prevPosition;
            do {
                prevPosition = newPosition;
                for (Snake snake : snakesLadderBoard.getSnakeList()) {

                    if (newPosition == snake.getHeadCell()) {
                        System.out.println("Down :: Snake present at  : "+newPosition+ ". New position will be : "+snake.getTailCell());
                        newPosition = snake.getTailCell(); //come down to tail cell
                    }

                }
                for (Ladder ladder : snakesLadderBoard.getLadders()) {
                    if (newPosition == ladder.getBottomCell()) {
                        System.out.println("Climb Up :: Ladder present at  : "+newPosition+ ". New position will be : "+ladder.getTopCell());
                        newPosition = ladder.getTopCell(); //climb up
                    }
                }
            }
            /*
             there could be a ladder at the end of snake(tail) or snake head at the top of ladder
             */
            while (prevPosition != newPosition);

        }
        currentPosition = newPosition; //my new current position.
        System.out.println("Position moved from : "+oldPosition+ " to : "+currentPosition);
    }

    /*
    Game is over under 2 conditions:
        Checks whether the current roll counter has reached its maxcounter or
        if the player has reached the end of the board (won)
     */
    @Override
    public boolean isGameOver() {

        if (currentRollCounter == NUMBER_OF_ROLLS || currentPosition == BOARD_SIZE) {
            return true;
        }

        return false;
    }

    public boolean gameWon() {
        return currentPosition == BOARD_SIZE;
    }

    public int getCurrentRollCounter() {
        return currentRollCounter;
    }

    public void setCurrentRollCounter(int currentRollCounter) {
        this.currentRollCounter = currentRollCounter;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public SnakesLadderBoard getSnakesLadderBoard() {
        return snakesLadderBoard;
    }

    public void setSnakesLadderBoard(SnakesLadderBoard snakesLadderBoard) {
        this.snakesLadderBoard = snakesLadderBoard;
    }
}
