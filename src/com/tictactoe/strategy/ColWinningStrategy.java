package com.tictactoe.strategy;

import com.tictactoe.model.Board;
import com.tictactoe.model.Move;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy {
    private final Map<Integer, Map<Character, Integer>> colToSymCnt = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Map<Character, Integer> symCount = colToSymCnt.computeIfAbsent(col, colNo -> new HashMap<>());

        char symbol = move.getPlayer().getSymbol().symbol();
        int freq = symCount.getOrDefault(symbol, 0);
        symCount.put(symbol, ++freq);

        return freq == board.getSize();
    }

    @Override
    public void undo(Board board, Move move) {
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol().symbol();

        Map<Character, Integer> symCount = colToSymCnt.get(col);

        symCount.put(symbol, symCount.get(symbol) - 1);
    }
}
