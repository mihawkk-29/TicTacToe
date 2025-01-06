package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.CellState;
import com.tictactoe.model.Move;

import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy {
    Random random;

    public MediumBotPlayingStrategy() {
        random = new Random();
    }

    @Override
    public Move makeMove(Board board) {
        while (true) {
            int row = random.nextInt(board.getSize());
            int col = random.nextInt(board.getSize());
            if (board.getCells().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
                return new Move(null, new Cell(row, col));
            }
        }
    }
}