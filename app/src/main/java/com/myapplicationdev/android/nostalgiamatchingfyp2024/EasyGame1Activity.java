package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class EasyGame1Activity extends AppCompatActivity {
    private MediaPlayer buttonClick;
    private MediaPlayer correct;
    private MediaPlayer wrong;
    ImageButton imgBtnCorrect1;
    ImageButton imgBtnCorrect2;
    ImageButton imgBtnWrong1;
    ImageButton imgBtnWrong2;
    ImageView correctImg1;
    ImageView correctImg2;
    ImageView wrongImg1;
    ImageView wrongImg2;
    Button btnEndGame;
    Button btnBack;
    ImageButton btnUndo;
    GameRun gameRun = new GameRun();
    Drawable redBG = ColorHelper.redBG(20, 10);
    Drawable greenBG = ColorHelper.greenBG(20, 10);
    String goodJob;
    String tryAgain;
    Boolean correct1;
    Boolean correct2;

    private Stack<Action> actionStack = new Stack<>();

    // Action class to encapsulate user actions
    private static class Action {
        int optionClicked; // 1 for correct1, 2 for correct2, -1 for wrong1, -2 for wrong2
        boolean wasCorrect;

        Action(int optionClicked, boolean wasCorrect) {
            this.optionClicked = optionClicked;
            this.wasCorrect = wasCorrect;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_easy_game1);

        imgBtnCorrect1 = findViewById(R.id.imageButtonCorrect1);
        imgBtnCorrect2 = findViewById(R.id.imageButtonCorrect2);
        imgBtnWrong1 = findViewById(R.id.imageButtonWrong1);
        imgBtnWrong2 = findViewById(R.id.imageButtonWrong2);

        correctImg1 = findViewById(R.id.correctImg1);
        correctImg2 = findViewById(R.id.correctImg2);
        wrongImg1 = findViewById(R.id.wrongImg1);
        wrongImg2 = findViewById(R.id.wrongImg2);

        btnEndGame = findViewById(R.id.buttonResult);
        btnBack = findViewById(R.id.buttonBack);
        btnUndo = findViewById(R.id.buttonUndo);

        goodJob = getString(R.string.goodJob);
        tryAgain = getString(R.string.tryAgain);

        correct1 = false;
        correct2 = false;

        buttonClick = MediaPlayer.create(this, R.raw.buttonclick);
        correct = MediaPlayer.create(this, R.raw.correct);
        wrong = MediaPlayer.create(this, R.raw.wrong);

        imgBtnCorrect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect1.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
                imgBtnCorrect1.setClickable(false);
                actionStack.push(new Action(1, true));
                correct1 = true;
            }
        });
        imgBtnCorrect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect2.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
                imgBtnCorrect2.setClickable(false);
                actionStack.push(new Action(2, true));
                correct2 = true;
            }
        });
        imgBtnWrong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong1.setBackground(redBG);
                showWrong();
                actionStack.push(new Action(-1, false));
            }
        });
        imgBtnWrong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong2.setBackground(redBG);
                showWrong();
                actionStack.push(new Action(-2, false));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyGame1Activity.this, EasyActivity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!actionStack.isEmpty()) {
                    undoLastAction();
                    btnEndGame.setVisibility(View.INVISIBLE);
                    btnUndo.setVisibility(View.INVISIBLE);
                    wrongImg1.setVisibility(View.INVISIBLE);
                    wrongImg2.setVisibility(View.INVISIBLE);
                    undoClickable();
                }
            }
        });

    }

    private void undoLastAction() {
        Action lastAction = actionStack.pop();
        if (lastAction != null) {
            if (lastAction.optionClicked == -1) {
                imgBtnWrong1.setBackground(null);
                imgBtnWrong1.setClickable(true);
            } else if (lastAction.optionClicked == -2) {
                imgBtnWrong2.setBackground(null);
                imgBtnWrong2.setClickable(true);
            }
        }
    }

    private void undoClickable() {
        if (correct1 == true) {
            imgBtnCorrect2.setClickable(true);
            imgBtnWrong1.setClickable(true);
            imgBtnWrong2.setClickable(true);
        } else if (correct2 == true) {
            imgBtnCorrect1.setClickable(true);
            imgBtnWrong1.setClickable(true);
            imgBtnWrong2.setClickable(true);
        } else {
            imgBtnCorrect1.setClickable(true);
            imgBtnCorrect2.setClickable(true);
            imgBtnWrong1.setClickable(true);
            imgBtnWrong2.setClickable(true);
        }
    }

    private void showCorrect() {
        gameRun.endGameEasy();
        correct.start();
        if (gameRun.getCorrectOption() == 1) {
            correctImg1.setVisibility(View.VISIBLE);
        } else if (gameRun.getGameWin()) {
            correctImg2.setVisibility(View.VISIBLE);
            getGameResult();
        }
    }

    private void showWrong() {
        wrong.start();
        if (gameRun.getCorrectOption() == 1) {
            wrongImg2.setVisibility(View.VISIBLE);
        } else {
            wrongImg1.setVisibility(View.VISIBLE);
        }
        getGameResult();
    }

    private void getGameResult() {
        if (gameRun.getGameWin()) {
            btnEndGame.setText(goodJob);
            btnEndGame.setClickable(false);
            imgBtnCorrect1.setClickable(false);
            imgBtnCorrect2.setClickable(false);
            imgBtnWrong1.setClickable(false);
            imgBtnWrong2.setClickable(false);
            btnUndo.setVisibility(View.GONE);
        } else {
            imgBtnCorrect1.setClickable(false);
            imgBtnCorrect2.setClickable(false);
            imgBtnWrong1.setClickable(false);
            imgBtnWrong2.setClickable(false);
            btnEndGame.setText(tryAgain);
            btnEndGame.setClickable(true);
            btnEndGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClick.start();
                    reloadActivity();
                }
            });
            btnUndo.setClickable(true);
            btnUndo.setVisibility(View.VISIBLE);
        }

        btnEndGame.setVisibility(View.VISIBLE);
    }

    private void reloadActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}