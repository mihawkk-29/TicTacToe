package com.tictactoe.model;

public class Board {
    int size;
    Cell[][] cells;

    public Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
    }

    public int getSize() {
        return size;
    }

    public Cell[][] getCells() {
        return cells;
    }
}