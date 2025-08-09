package com.tictactoe;

import com.tictactoe.controller.GameController;
import com.tictactoe.model.User;
import com.tictactoe.model.player.BotDifficultyLevel;
import com.tictactoe.model.player.BotPlayer;
import com.tictactoe.model.player.HumanPlayer;
import com.tictactoe.model.player.Player;
import com.tictactoe.strategy.ColWinningStrategy;
import com.tictactoe.strategy.RowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Game Mode");
        System.out.println("1.multiplayer" +
                "2.computer");
        int n = s.nextInt();
        Player aarunPlayer = null;
        User edwin = new User("Edwin", "edwin@xyz");
        Player edwinPlayer = new HumanPlayer(edwin, 'X');
        switch (n) {
            case 1 -> {

                User aarun = new User("Aarun", "ajk@xyz.com");
                aarunPlayer = new HumanPlayer(aarun, 'O');
            }
            case 2 -> {

                User bot = new User("Bot", "bot@xyz.com");
                aarunPlayer = new BotPlayer(bot, 'O', BotDifficultyLevel.EASY);
            }
        }


            new GameController(3,
                    List.of(edwinPlayer, aarunPlayer),
                    List.of(new ColWinningStrategy(), new RowWinningStrategy())
            ).playGame();
        }

    }
