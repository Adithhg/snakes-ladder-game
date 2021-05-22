package com.game.runner;

import com.game.models.*;
import com.game.utils.DiceFactory;
import com.game.utils.ValidateInputValuesForSnakesAndLadders;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameRunner {


    private SnakesLadderBoard validateInputAndGetSnakeBoard() {

        Scanner scanner;
        System.out.println("Please enter the Player's details");
        Player player;
        while (true) {
            try {
                System.out.print("Player's Id :");
                scanner = new Scanner(System.in);
                String playerId = scanner.next().trim();
                System.out.print("Player's Name :");
                String playerName = scanner.next().trim();
                player = new Player(playerId, playerName);
                break;
            } catch (InputMismatchException ne) {
                System.out.println("Please enter the String values");
            }
        }
        System.out.println("Please select the Dice for the game");
        Dice dice;
        while (true) {
            try {
                System.out.print("Enter 1 for Normal Dice. or 2 for Crooked Dice.");
                scanner = new Scanner(System.in);
                int diceId = scanner.nextInt();
                if (diceId != 1 && diceId != 2) {
                    continue;
                }
                dice = DiceFactory.getDice(diceId);
                break;
            } catch (InputMismatchException ne) {
                System.out.println("Please enter the integer numbers 1 or 2");
            }
        }

        System.out.println("Please enter the number of snakes in the board");
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
                    if (!ValidateInputValuesForSnakesAndLadders.validateSnakeInput(head, tail, snakes)) {
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
        System.out.println("Entered number of ladders : " + numOfLadders);

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
                    if (!ValidateInputValuesForSnakesAndLadders.validateLadderInput(start, end, ladders, snakes)) {
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

        SnakesLadderBoard snakesLadderBoard = new SnakesLadderBoard(player, snakes, ladders, dice);

        if (snakesLadderBoard == null) {
            System.out.println("Restart the game");
            System.exit(-1);
        }

        return snakesLadderBoard;
    }


    public static void main(String[] args) {

        GameRunner gameRunner = new GameRunner();

        SinglePlayerSnakesAndLaddersGameRunner game = new SinglePlayerSnakesAndLaddersGameRunner(gameRunner.validateInputAndGetSnakeBoard());
        if (game.startGame()) {
            System.out.println("Game won!!!");
        }
        else {
            System.out.println("Game lost!!!");
        }
    }
}
