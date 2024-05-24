package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ExpertGame1Activity extends AppCompatActivity {

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
    GameRun gameRun = new GameRun();
    Drawable redBG = BGcolor.redBG(20, 10);
    Drawable greenBG = BGcolor.greenBG(20, 10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expert_game1);

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

        imgBtnCorrect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect1.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
            }
        });
        imgBtnCorrect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect2.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
            }
        });
        imgBtnCorrect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect3.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
            }
        });
        imgBtnWrong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong1.setBackground(redBG);
                showWrong();
            }
        });
        imgBtnWrong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong2.setBackground(redBG);
                showWrong();
            }
        });
        imgBtnWrong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong3.setBackground(redBG);
                showWrong();
            }
        });
        imgBtnWrong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong4.setBackground(redBG);
                showWrong();
            }
        });
        imgBtnWrong5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong5.setBackground(redBG);
                showWrong();
            }
        });
        imgBtnWrong6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong6.setBackground(redBG);
                showWrong();
            }
        });

    }
    private void showCorrect(){
        gameRun.endGameEasy();
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
            btnEndGame.setText("Good Job!");
            btnEndGame.setClickable(false);
        } else {
            btnEndGame.setText("Try Again");
            btnEndGame.setClickable(true);
            btnEndGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reloadActivity();
                }
            });
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