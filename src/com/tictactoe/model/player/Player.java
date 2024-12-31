package com.tictactoe.model.player;

import com.tictactoe.model.Board;
import com.tictactoe.model.Move;
import com.tictactoe.model.Symbol;

public abstract class Player {
    private Symbol symbol;
    protected PlayerType playerType;

    public Player(PlayerType playerType, Symbol symbol) {
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public abstract Move makeMove(Board board);
}