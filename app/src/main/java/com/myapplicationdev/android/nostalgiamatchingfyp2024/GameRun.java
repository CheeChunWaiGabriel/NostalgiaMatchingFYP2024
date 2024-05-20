package com.myapplicationdev.android.nostalgiamatchingfyp2024;

public class GameRun {

    private boolean gameEnded;
    private int correctOption;;

    public GameRun() {
        gameEnded = false;
        correctOption= 0;
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

    public int getCorrectOption() {
        return correctOption;
    }

    public void resetCorrectOption() {
        correctOption = 0;
    }
}
