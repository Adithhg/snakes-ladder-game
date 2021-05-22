package com.game.models;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 12:08 PM
 */
public class Snake {

    private int headCell;
    private int tailCell;

    public Snake(int startCell, int endCell) {
        this.headCell = startCell;
        this.tailCell = endCell;
    }
    public int getHeadCell() {
        return headCell;
    }

    public void setHeadCell(int headCell) {
        this.headCell = headCell;
    }

    public int getTailCell() {
        return tailCell;
    }

    public void setTailCell(int tailCell) {
        this.tailCell = tailCell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snake snake = (Snake) o;
        return headCell == snake.headCell && tailCell == snake.tailCell;
    }

    @Override
    public int hashCode() {
        return Objects.hash(headCell, tailCell);
    }

    @Override
    public String toString() {
        return "Snake{" +
                "startCell=" + headCell +
                ", endCell=" + tailCell +
                '}';
    }
}
