package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    private final Map<Integer, Map<Character, Integer>> rowToSymCnt = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Map<Character, Integer> symCount = rowToSymCnt.computeIfAbsent(row, rowNo -> new HashMap<>());

        char symbol = move.getPlayer().getSymbol().symbol();
        int freq = symCount.getOrDefault(symbol, 0);
        symCount.put(symbol, ++freq);

        return freq == board.getSize();
    }

    @Override
    public void undo(Board board, Move move) {
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol().symbol();

        Map<Character, Integer> symCount = rowToSymCnt.get(row);

        symCount.put(symbol, symCount.get(symbol) - 1);
    }


}