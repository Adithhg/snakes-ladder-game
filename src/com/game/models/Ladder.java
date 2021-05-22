package com.game.models;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 12:09 PM
 */
public class Ladder {

    private int startCell;
    private int endCell;

    public Ladder(int startCell, int endCell) {
        this.startCell = startCell;
        this.endCell = endCell;
    }
    public int getStartCell() {
        return startCell;
    }

    public void setStartCell(int startCell) {
        this.startCell = startCell;
    }

    public int getEndCell() {
        return endCell;
    }

    public void setEndCell(int endCell) {
        this.endCell = endCell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return startCell == ladder.startCell && endCell == ladder.endCell;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startCell, endCell);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "startCell=" + startCell +
                ", endCell=" + endCell +
                '}';
    }
}
