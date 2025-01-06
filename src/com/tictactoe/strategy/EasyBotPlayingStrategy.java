package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.CellState;
import com.tictactoe.model.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    EasyBotPlayingStrategy() {
    }

    @Override
    public Move makeMove(Board board) {
        List<List<Cell>> cells = board.getCells();

        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(null, new Cell(cell.getRow(), cell.getCol()));
                }
            }
        }

        return null;
    }
}
