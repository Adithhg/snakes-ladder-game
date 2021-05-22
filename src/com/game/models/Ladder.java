package com.game.models;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 12:09 PM
 */
public class Ladder {

    private int bottomCell;
    private int topCell;

    public Ladder(int bottomCell, int topCell) {
        this.bottomCell = bottomCell;
        this.topCell = topCell;
    }
    public int getBottomCell() {
        return bottomCell;
    }

    public void setBottomCell(int bottomCell) {
        this.bottomCell = bottomCell;
    }

    public int getTopCell() {
        return topCell;
    }

    public void setTopCell(int topCell) {
        this.topCell = topCell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return bottomCell == ladder.bottomCell && topCell == ladder.topCell;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottomCell, topCell);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "startCell=" + bottomCell +
                ", endCell=" + topCell +
                '}';
    }
}
