package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Cell;
import com.tictactoe.model.Move;

import java.util.Random;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    Random random;

    EasyBotPlayingStrategy() {
        random = new Random();
    }

    @Override
    public Move makeMove(Board board) {
        Cell[][] cells = board.getCells();

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if(cell!=null){
                    return new Move(null, new Cell());
                }
            }
        }
    }
}
