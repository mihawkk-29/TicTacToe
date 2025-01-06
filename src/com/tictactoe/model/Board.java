package com.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> cells;

    public Board(int size) {
        this.size = size;
        cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell(i, j));
            }
            cells.add(row);
        }
    }

    public int getSize() {
        return size;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void display() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                cell.display();
            }
            System.out.println();
        }
    }
}