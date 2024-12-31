package com.tictactoe.model.player;

import com.tictactoe.model.*;

import java.util.Scanner;

public class HumanPlayer extends Player {
    User user;
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(User user, Symbol symbol) {
        super(PlayerType.HUMAN, symbol);
        this.user = user;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Enter the row position: ");
        int row = scanner.nextInt();
        System.out.println("Enter the column position: ");
        int column = scanner.nextInt();

        return new Move(this, new Cell(row, column));
    }
}
