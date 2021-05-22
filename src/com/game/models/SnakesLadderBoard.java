package com.game.models;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 3:13 PM
 */
public class SnakesLadderBoard {

    Player player;
    List<Snake> snakeList;
    List<Ladder> ladders;
    Dice dice;

    public SnakesLadderBoard(Player player, List<Snake> snakeList, List<Ladder> ladders, Dice dice) {
        this.player = player;
        this.snakeList = snakeList;
        this.ladders = ladders;
        this.dice = dice;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Snake> getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(List<Snake> snakeList) {
        this.snakeList = snakeList;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
