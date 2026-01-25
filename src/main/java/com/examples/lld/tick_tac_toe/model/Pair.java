package com.examples.lld.tick_tac_toe.model;

public class Pair<I extends Number, I1 extends Number> {
    private final Integer row;
    private final Integer col;
    public Pair(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }
    public Integer getRow() {
        return row;
    }
    public Integer getCol() {
        return col;
    }

}
