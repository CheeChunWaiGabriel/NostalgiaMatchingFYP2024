package com.myapplicationdev.android.nostalgiamatchingfyp2024;

public class GameRun {

    private boolean gameEnded;
    private int correctOption;
    private int wrongOption;

    public GameRun() {
        gameEnded = false;
        correctOption= 0;
        wrongOption= 0;
    }

    public void endGameEasy() {
        if (correctOption == 2) {
            gameEnded = true;
        }
    }

    public boolean getGameEnded() {
        return gameEnded;
    }

    public void correctOptionFound() {
        correctOption++;
    }

    public void wrongOptionFound() {
        correctOption++;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void resetCorrectOption() {
        correctOption = 0;
    }
    public void resetWrongOption() {
        wrongOption = 0;
    }
}
