package com.game;

import com.game.models.Ladder;
import com.game.models.Snake;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameRunner {


    private void validateAndGetCommandLineInput() {

        System.out.println("Please enter the number of snakes in the board");
        Scanner scanner;
        int numOfSnakes;
        while (true) {
            try {
                scanner = new Scanner(System.in);
                numOfSnakes = scanner.nextInt();
                break;
            } catch (InputMismatchException ne) {
                System.out.println("Please enter the integer number greater than 0");
            }
        }
        System.out.println("Entered number of snakes : " + numOfSnakes);

        List<Snake> snakes = new ArrayList<>();
        int i = 0;
        while (i < numOfSnakes) {
            while(true) {
                try {
                    System.out.println("Enter the indexes for head and tail of the snake - "+ (i+1));
                    System.out.print("Head : ");
                    int head = scanner.nextInt();
                    System.out.print("Tail : ");
                    int tail = scanner.nextInt();
                    if (!validateSnakeInput(head, tail, snakes)) {
                        continue;
                    }
                    snakes.add(new Snake(head, tail));
                    i++;
                    break;
                } catch (InputMismatchException ne) {
                    System.out.println("Please enter the integer number greater than 0");
                }
            }

        }

        System.out.println("Please enter the number of ladders in the board");
        int numOfLadders;
        while (true) {
            try {
                scanner = new Scanner(System.in);
                numOfLadders = scanner.nextInt();
                break;
            } catch (InputMismatchException ne) {
                System.out.println("Please enter the integer number greater than 0");
            }
        }
        System.out.println("Entered number of snakes : " + numOfLadders);

        List<Ladder> ladders = new ArrayList<>();
        int j = 0;
        while (j < numOfLadders) {
            while(true) {
                try {
                    System.out.println("Enter the indexes for start and end of the ladder - "+ (j+1));
                    System.out.print("Start : ");
                    int start = scanner.nextInt();
                    System.out.print("End : ");
                    int end = scanner.nextInt();
                    if (!validateLadderInput(start, end, ladders)) {
                        continue;
                    }
                    ladders.add(new Ladder(start, end));
                    j++;
                    break;
                } catch (InputMismatchException ne) {
                    System.out.println("Please enter the integer number greater than 0");
                }
            }

        }

        System.out.println(snakes);
        System.out.println(ladders);

    }

    private boolean validateLadderInput(int start, int end, List<Ladder> ladders) {

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

        return true;
    }

    public boolean validateSnakeInput(int head, int tail, List<Snake> snakesAdded) {

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



    public static void main(String[] args) {

        GameRunner gameRunner = new GameRunner();

        gameRunner.validateAndGetCommandLineInput();


    }
}
