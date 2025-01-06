package com.tictactoe.model.player;

import com.tictactoe.model.Board;
import com.tictactoe.model.Move;
import com.tictactoe.model.Symbol;
import com.tictactoe.model.User;

public abstract class Player {
    private User user;
    protected PlayerType playerType;
    private Symbol symbol;

    public Player(User user, PlayerType playerType, Symbol symbol) {
        this.user = user;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public String getName() {
        return user.getName();
    }

    public abstract Move makeMove(Board board);
}