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

import java.util.Stack;

public class ExpertGame3Activity extends AppCompatActivity {

    ImageButton imgBtnCorrect1;
    ImageButton imgBtnCorrect2;
    ImageButton imgBtnCorrect3;
    ImageButton imgBtnWrong1;
    ImageButton imgBtnWrong2;
    ImageButton imgBtnWrong3;
    ImageButton imgBtnWrong4;
    ImageButton imgBtnWrong5;
    ImageButton imgBtnWrong6;
    ImageView correctImg1;
    ImageView correctImg2;
    ImageView correctImg3;
    ImageView wrongImg1;
    ImageView wrongImg2;
    ImageView wrongImg3;
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

    private Stack<ExpertGame3Activity.Action> actionStack = new Stack<>();

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

        String savedLanguage = LanguageHelper.getLanguage(this);
        LanguageHelper.setLanguage(this, savedLanguage);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expert_game3);

        imgBtnCorrect1 = findViewById(R.id.imageButtonExpertCorrect1);
        imgBtnCorrect2 = findViewById(R.id.imageButtonCorrect2);
        imgBtnCorrect3 = findViewById(R.id.imageButtonCorrect3);
        imgBtnWrong1 = findViewById(R.id.imageButtonExpertWrong1);
        imgBtnWrong2 = findViewById(R.id.imageButtonExpertWrong2);
        imgBtnWrong3 = findViewById(R.id.imageButtonWrong3);
        imgBtnWrong4 = findViewById(R.id.imageButtonWrong4);
        imgBtnWrong5 = findViewById(R.id.imageButtonWrong5);
        imgBtnWrong6 = findViewById(R.id.imageButtonWrong6);

        correctImg1 = findViewById(R.id.correctImg1);
        correctImg2 = findViewById(R.id.correctImg2);
        correctImg3 = findViewById(R.id.correctImg3);
        wrongImg1 = findViewById(R.id.wrongImg1);
        wrongImg2 = findViewById(R.id.wrongImg2);
        wrongImg3 = findViewById(R.id.wrongImg3);

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
                imgBtnCorrect1.setClickable(false);
                actionStack.push(new ExpertGame3Activity.Action(1, true));
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
                actionStack.push(new ExpertGame3Activity.Action(2, true));
                correct2 = true;
            }
        });
        imgBtnCorrect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect3.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
                imgBtnCorrect3.setClickable(false);
                actionStack.push(new ExpertGame3Activity.Action(3, true));
                correct3 = true;
            }
        });
        imgBtnWrong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong1.setBackground(redBG);
                showWrong();
                actionStack.push(new ExpertGame3Activity.Action(-1, false));
            }
        });
        imgBtnWrong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong2.setBackground(redBG);
                showWrong();
                actionStack.push(new ExpertGame3Activity.Action(-2, false));
            }
        });
        imgBtnWrong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong3.setBackground(redBG);
                showWrong();
                actionStack.push(new ExpertGame3Activity.Action(-3, false));
            }
        });
        imgBtnWrong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong4.setBackground(redBG);
                showWrong();
                actionStack.push(new ExpertGame3Activity.Action(-4, false));
            }
        });
        imgBtnWrong5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong5.setBackground(redBG);
                showWrong();
                actionStack.push(new ExpertGame3Activity.Action(-5, false));
            }
        });
        imgBtnWrong6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong6.setBackground(redBG);
                showWrong();
                actionStack.push(new ExpertGame3Activity.Action(-6, false));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertGame3Activity.this, ExpertActivity.class);
                startActivity(intent);
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
                    wrongImg3.setVisibility(View.INVISIBLE);
                    undoClickable();
                }
            }
        });

    }

    private void undoLastAction() {
        ExpertGame3Activity.Action lastAction = actionStack.pop();
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
        gameRun.endGameExpert();
        correct.start();
        if (gameRun.getCorrectOption() == 1) {
            correctImg1.setVisibility(View.VISIBLE);
        }else if (gameRun.getCorrectOption() == 2) {
            correctImg2.setVisibility(View.VISIBLE);
        }else if (gameRun.getGameWin()) {
            correctImg3.setVisibility(View.VISIBLE);
            getGameResult();
        }
    }
    private  void showWrong(){
        wrong.start();
        if (gameRun.getCorrectOption() == 1){
            wrongImg2.setVisibility(View.VISIBLE);
        } else if (gameRun.getCorrectOption() == 2){
            wrongImg3.setVisibility(View.VISIBLE);
        } else{
            wrongImg1.setVisibility(View.VISIBLE);
        }
        getGameResult();
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