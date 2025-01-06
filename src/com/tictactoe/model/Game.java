package com.tictactoe.model;

import com.tictactoe.model.player.Player;
import com.tictactoe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> winningStrategies;
    private int nextPlayerIndex;
    List<Move> moves;
    private GameState gameState;
    private Player winner;


    public Game(Board board, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = board;
        this.players = players;
        this.winningStrategies = winningStrategies;
        nextPlayerIndex = new Random().nextInt(players.size());
        moves = new ArrayList<>();
        gameState = GameState.IN_PROGRESS;
    }

    public void displayBoard() {
        board.display();
    }

    public void makeMove() {
        Player player = players.get(nextPlayerIndex);

        System.out.println("-- Player " + player.getName() + "'s turn --");
        Move move = player.makeMove(board);
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = board.getCells().get(row).get(col);
        cell.setSymbol(player.getSymbol());
        cell.setCellState(CellState.FILLED);

        move.setCell(cell);
        move.setPlayer(player);
        moves.add(move);

        nextPlayerIndex++;
        nextPlayerIndex %= players.size();
    }

    public boolean checkWinner() {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, moves.getLast())) {
                gameState = GameState.SUCCESS;
                winner = moves.getLast().getPlayer();

                return true;
            } else if (moves.size() == board.getSize() * board.getSize()) {
                gameState = GameState.TIED;
            }
        }

        return false;
    }

    public void undoMove() {
        Move lastMove = moves.removeLast();

        for (WinningStrategy winningStrategy : winningStrategies) {
            winningStrategy.undo(board, lastMove);
        }

        lastMove.getCell().setSymbol(null);
        lastMove.getCell().setCellState(CellState.EMPTY);

        nextPlayerIndex--;
        nextPlayerIndex = (nextPlayerIndex + players.size()) % players.size();
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }
}