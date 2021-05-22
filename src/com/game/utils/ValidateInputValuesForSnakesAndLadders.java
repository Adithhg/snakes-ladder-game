package com.game.utils;

import com.game.models.Ladder;
import com.game.models.Snake;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 5:17 PM
 */
public class ValidateInputValuesForSnakesAndLadders {


     public static boolean validateSnakeInput(int head, int tail, List<Snake> snakesAdded) {

        if (head == tail) {
            System.out.println("Index for Tail cannot be equals to Head, re-enter.");
            return false;
        }

        if (head < tail) {
            System.out.println("Index for Tail cannot be greater than Head, re-enter.");
            return false;
        }

        if (head >= 100) {
            System.out.println("Index for Head cannot be equal to or greater than 100, re-enter.");
            return false;
        }

        if (head <=0) {
            System.out.println("Index for Head cannot be equal to or lesser than 0, re-enter.");
            return false;
        }

        if (tail < 0) {
            System.out.println("Index for Head cannot be equal to or lesser than 0, re-enter.");
            return false;
        }

        Snake newSnake = new Snake(head, tail);
        if (snakesAdded.contains(newSnake)) {
            System.out.println("Snake with the entered values is already present on the board. re-enter.");
            return false;
        }

        return true;
    }

    public static boolean validateLadderInput(int start, int end, List<Ladder> ladders, List<Snake> snakes) {

        if (start == end) {
            System.out.println("Index for start cannot be equals to end, re-enter.");
            return false;
        }

        if (start > end) {
            System.out.println("Index for start cannot be greater than end, re-enter.");
            return false;
        }

        if (start >= 100 || start < 0) {
            System.out.println("Valid Index for start is between 0 to 99, re-enter.");
            return false;
        }

        if (end > 100) {
            System.out.println("Valid Index for end is between 1 to 100, re-enter.");
            return false;
        }

        Ladder ladder = new Ladder(start, end);
        if (ladders.contains(ladder)) {
            System.out.println("Ladder with the entered values is already present on the board. re-enter.");
            return false;
        }

        for (Snake snake : snakes) {
            if (snake.getHeadCell() == ladder.getTopCell() && snake.getTailCell() == ladder.getBottomCell()) {
                //Infinite loop
                return false;
            }
        }

        return true;
    }
}
