package com.tictactoe.strategy;

import com.tictactoe.model.player.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficulty) {
        if (BotDifficultyLevel.EASY.equals(difficulty)) {
            return new EasyBotPlayingStrategy();
        } else if (BotDifficultyLevel.MEDIUM.equals(difficulty)) {
            return new MediumBotPlayingStrategy();
        }

        throw new RuntimeException("Invalid Difficulty level");
    }
}