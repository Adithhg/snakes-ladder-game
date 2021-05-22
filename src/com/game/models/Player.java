package com.game.models;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 12:05 PM
 */
public class Player {

    String playerId;
    String playerName;

    public Player(String playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
