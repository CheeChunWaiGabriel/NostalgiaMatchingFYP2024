package com.myapplicationdev.android.nostalgiamatchingfyp2024;

public class GameRun {

    private boolean gameWin;
    private int correctOption;
    private int wrongOption;

    public GameRun() {
        gameWin = false;
        correctOption= 0;
        wrongOption= 0;
    }

    public void endGameEasy() {
        if (correctOption == 2) {
            gameWin = true;
        }
    }

    public void endGameExpert() {
        if (correctOption == 3) {
            gameWin = true;
        }
    }

    public boolean getGameWin() {
        return gameWin;
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
