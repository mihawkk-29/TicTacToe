package com.tictactoe.model;

public class Cell {
    private final int row;
    private final int col;
    private CellState cellState;
    private Symbol symbol;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
        this.symbol = null;
    }

    public void display() {
        if (cellState.equals(CellState.EMPTY)) {
            System.out.print("|   |");
        } else {
            System.out.print("| " + symbol.symbol() + " |");
        }
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}