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

public class Main {
    public static void main(String[] args) {
        User edwin = new User("Edwin", "edwin@xyz");
        Player edwinPlayer = new HumanPlayer(edwin, 'X');

        User bot = new User("Bot", "bot@xyz.com");
        Player botPlayer = new BotPlayer(bot, 'O', BotDifficultyLevel.EASY);

        new GameController(3,
                List.of(edwinPlayer, botPlayer),
                List.of(new ColWinningStrategy(), new RowWinningStrategy())
        ).playGame();
    }
}