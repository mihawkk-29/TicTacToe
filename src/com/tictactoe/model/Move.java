package com.tictactoe.model;

import com.tictactoe.model.player.Player;

public class Move {
    Player player;
    Cell cell;

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public Cell getCell() {
        return cell;
    }
}