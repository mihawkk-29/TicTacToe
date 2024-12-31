package com.tictactoe.model.player;

import com.tictactoe.model.Board;
import com.tictactoe.model.Move;
import com.tictactoe.model.Symbol;
import com.tictactoe.strategy.BotPlayingStrategy;
import com.tictactoe.strategy.BotPlayingStrategyFactory;

public class BotPlayer extends Player {
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy strategy;

    public BotPlayer(Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(PlayerType.COMPUTER, symbol);
        this.difficultyLevel = difficultyLevel;
        strategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        return strategy.makeMove(board);
    }
}