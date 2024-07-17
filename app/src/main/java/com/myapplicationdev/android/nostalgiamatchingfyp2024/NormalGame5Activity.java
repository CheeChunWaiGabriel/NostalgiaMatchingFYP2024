package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Stack;

public class NormalGame5Activity extends AppCompatActivity {

    ImageButton imgBtnCorrect1;
    ImageButton imgBtnCorrect2;
    ImageButton imgBtnCorrect3;
    ImageButton imgBtnWrong1;
    ImageButton imgBtnWrong2;
    ImageButton imgBtnWrong3;
    ImageButton imgBtnWrong4;
    ImageButton imgBtnWrong5;
    ImageButton imgBtnWrong6;
    ImageView ivCorrect1;
    ImageView ivCorrect2;
    ImageView ivCorrect3;
    ImageView ivWrong1;
    ImageView ivWrong2;
    ImageView ivWrong3;
    ImageView ivWrong4;
    ImageView ivWrong5;
    ImageView ivWrong6;

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
    Boolean correct3;

    private MediaPlayer buttonClick;
    private MediaPlayer correct;
    private MediaPlayer wrong;

    private Stack<NormalGame5Activity.Action> actionStack = new Stack<>();

    // Action class to encapsulate user actions
    private static class Action {
        int optionClicked;
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
        setContentView(R.layout.activity_normal_game5);

        imgBtnCorrect1 = findViewById(R.id.imageButtonNormalCorrect1);
        imgBtnCorrect2 = findViewById(R.id.imageButtonNormalCorrect2);
        imgBtnCorrect3 = findViewById(R.id.imageButtonNormalCorrect3);
        imgBtnWrong1 = findViewById(R.id.imageButtonNormalWrong1);
        imgBtnWrong2 = findViewById(R.id.imageButtonNormalWrong2);
        imgBtnWrong3 = findViewById(R.id.imageButtonNormalWrong3);
        imgBtnWrong4 = findViewById(R.id.imageButtonNormalWrong4);
        imgBtnWrong5 = findViewById(R.id.imageButtonNormalWrong5);
        imgBtnWrong6 = findViewById(R.id.imageButtonNormalWrong6);

        ivCorrect1 = findViewById(R.id.correctImg1);
        ivCorrect2 = findViewById(R.id.correctImg2);
        ivCorrect3 = findViewById(R.id.correctImg3);
        ivWrong1 = findViewById(R.id.wrongImg1);
        ivWrong2 = findViewById(R.id.wrongImg2);
        ivWrong3 = findViewById(R.id.wrongImg3);
        ivWrong4 = findViewById(R.id.wrongImg4);
        ivWrong5 = findViewById(R.id.wrongImg5);
        ivWrong6 = findViewById(R.id.wrongImg6);

        btnEndGame = findViewById(R.id.buttonResult);
        btnBack = findViewById(R.id.buttonBack);
        btnUndo = findViewById(R.id.buttonUndo);

        goodJob = getString(R.string.goodJob);
        tryAgain = getString(R.string.tryAgain);

        correct1 = false;
        correct2 = false;
        correct3 = false;

        buttonClick = MediaPlayer.create(this, R.raw.buttonclick);
        correct = MediaPlayer.create(this, R.raw.correct);
        wrong = MediaPlayer.create(this, R.raw.wrong);

        imgBtnCorrect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect1.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
                ivCorrect1.setVisibility(View.VISIBLE);
                imgBtnCorrect1.setClickable(false);
                actionStack.push(new NormalGame5Activity.Action(1, true));
                correct1 = true;
            }
        });
        imgBtnCorrect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect2.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
                ivCorrect2.setVisibility(View.VISIBLE);
                imgBtnCorrect2.setClickable(false);
                actionStack.push(new NormalGame5Activity.Action(2, true));
                correct2 = true;
            }
        });
        imgBtnCorrect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect3.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
                ivCorrect3.setVisibility(View.VISIBLE);
                imgBtnCorrect3.setClickable(false);
                actionStack.push(new NormalGame5Activity.Action(3, true));
                correct3 = true;
            }
        });

        imgBtnWrong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong1.setBackground(redBG);
                getGameResult();
                ivWrong1.setVisibility(View.VISIBLE);
                actionStack.push(new NormalGame5Activity.Action(-1, false));
                wrong.start();
            }
        });
        imgBtnWrong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong2.setBackground(redBG);
                getGameResult();
                ivWrong2.setVisibility(View.VISIBLE);
                actionStack.push(new NormalGame5Activity.Action(-2, false));
                wrong.start();
            }
        });
        imgBtnWrong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong3.setBackground(redBG);
                getGameResult();
                ivWrong3.setVisibility(View.VISIBLE);
                actionStack.push(new NormalGame5Activity.Action(-3, false));
                wrong.start();
            }
        });
        imgBtnWrong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong4.setBackground(redBG);
                getGameResult();
                ivWrong4.setVisibility(View.VISIBLE);
                actionStack.push(new NormalGame5Activity.Action(-4, false));
                wrong.start();
            }
        });
        imgBtnWrong5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong5.setBackground(redBG);
                getGameResult();
                ivWrong5.setVisibility(View.VISIBLE);
                actionStack.push(new NormalGame5Activity.Action(-5, false));
                wrong.start();
            }
        });
        imgBtnWrong6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong6.setBackground(redBG);
                getGameResult();
                ivWrong6.setVisibility(View.VISIBLE);
                actionStack.push(new NormalGame5Activity.Action(-6, false));
                wrong.start();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalGame5Activity.this, NormalActivity.class);
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
                    ivWrong1.setVisibility(View.INVISIBLE);
                    ivWrong2.setVisibility(View.INVISIBLE);
                    ivWrong3.setVisibility(View.INVISIBLE);
                    ivWrong4.setVisibility(View.INVISIBLE);
                    ivWrong5.setVisibility(View.INVISIBLE);
                    ivWrong6.setVisibility(View.INVISIBLE);
                    undoClickable();
                    buttonClick.start();
                }
            }
        });

    }

    private void undoLastAction() {
        NormalGame5Activity.Action lastAction = actionStack.pop();
        if (lastAction != null) {
            if (lastAction.optionClicked == -1) {
                imgBtnWrong1.setBackground(null);
                imgBtnWrong1.setClickable(true);
            }else if (lastAction.optionClicked == -2) {
                imgBtnWrong2.setBackground(null);
                imgBtnWrong2.setClickable(true);
            }else if (lastAction.optionClicked == -3) {
                imgBtnWrong3.setBackground(null);
                imgBtnWrong3.setClickable(true);
            }else if (lastAction.optionClicked == -4) {
                imgBtnWrong4.setBackground(null);
                imgBtnWrong4.setClickable(true);
            }else if (lastAction.optionClicked == -5) {
                imgBtnWrong5.setBackground(null);
                imgBtnWrong5.setClickable(true);
            }else if (lastAction.optionClicked == -6) {
                imgBtnWrong6.setBackground(null);
                imgBtnWrong6.setClickable(true);
            }
        }
    }

    private void undoClickable() {
        imgBtnWrong1.setClickable(true);
        imgBtnWrong2.setClickable(true);
        imgBtnWrong3.setClickable(true);
        imgBtnWrong4.setClickable(true);
        imgBtnWrong5.setClickable(true);
        imgBtnWrong6.setClickable(true);

        if (!correct1) imgBtnCorrect1.setClickable(true);
        if (!correct2) imgBtnCorrect2.setClickable(true);
        if (!correct3) imgBtnCorrect3.setClickable(true);
    }

    private void showCorrect(){
        correct.start();
        gameRun.endGameExpert();
        if (gameRun.getGameWin()) {
            getGameResult();
        }
    }
    private void getGameResult() {
        falseBtn();
        if (gameRun.getGameWin()) {
            btnEndGame.setText(goodJob);
            btnEndGame.setClickable(false);
            btnUndo.setVisibility(View.GONE);
        } else {
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
    private void falseBtn(){
        imgBtnCorrect1.setClickable(false);
        imgBtnCorrect2.setClickable(false);
        imgBtnCorrect3.setClickable(false);
        imgBtnWrong1.setClickable(false);
        imgBtnWrong2.setClickable(false);
        imgBtnWrong3.setClickable(false);
        imgBtnWrong4.setClickable(false);
        imgBtnWrong5.setClickable(false);
        imgBtnWrong6.setClickable(false);
    }
    private void reloadActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}