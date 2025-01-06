package com.tictactoe.model.player;

import com.tictactoe.model.*;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(User user, char symbol) {
        super(user, PlayerType.HUMAN, new Symbol(symbol));
    }

    @Override
    public Move makeMove(Board board) {
        System.out.print("Enter the row position: ");
        int row = scanner.nextInt();
        System.out.print("Enter the column position: ");
        int column = scanner.nextInt();

        return new Move(this, new Cell(row, column));
    }
}
