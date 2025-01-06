package com.tictactoe.controller;

import com.tictactoe.model.Board;
import com.tictactoe.model.Game;
import com.tictactoe.model.GameState;
import com.tictactoe.model.player.Player;
import com.tictactoe.strategy.WinningStrategy;

import java.util.List;
import java.util.Scanner;

public class GameController {
    private Game game;
    private Scanner scanner;

    public GameController(int boardSize, List<Player> players, List<WinningStrategy> winningStrategies) {
        game = new Game(new Board(boardSize), players, winningStrategies);
        scanner = new Scanner(System.in);
    }

    public void playGame() {
        while (game.getGameState() == GameState.IN_PROGRESS) {
            game.displayBoard();
            game.makeMove();
            game.displayBoard();

            if (game.checkWinner()) {
                System.out.println("--" + game.getWinner().getName() + " has won!--");
                break;
            } else if (game.getGameState() == GameState.TIED) {
                System.out.println("--Game draw!--");
                break;
            }

            System.out.println("Do you want to undo move? (y/n)");
            String input = scanner.next();
            if (input.equals("y")) {
                game.undoMove();
            }
        }
    }
}