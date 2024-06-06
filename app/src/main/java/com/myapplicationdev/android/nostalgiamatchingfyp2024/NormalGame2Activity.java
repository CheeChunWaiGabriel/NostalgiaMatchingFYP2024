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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NormalGame2Activity extends AppCompatActivity {

    Button btnEndGame;
    Button btnBack;
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
    GameRun gameRun = new GameRun();
    Drawable redBG = ColorHelper.redBG(20, 10);
    Drawable greenBG = ColorHelper.greenBG(20, 10);
    String goodJob;
    String tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_normal_game2);

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

        goodJob = getString(R.string.goodJob);
        tryAgain = getString(R.string.tryAgain);

        imgBtnCorrect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect1.setBackground(greenBG);
                gameRun.correctOptionFound();
                showCorrect();
                ivCorrect1.setVisibility(View.VISIBLE);
                imgBtnCorrect1.setClickable(false);
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
            }
        });

        imgBtnWrong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong1.setBackground(redBG);
                getGameResult();
                ivWrong1.setVisibility(View.VISIBLE);
            }
        });
        imgBtnWrong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong2.setBackground(redBG);
                getGameResult();
                ivWrong2.setVisibility(View.VISIBLE);
            }
        });
        imgBtnWrong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong3.setBackground(redBG);
                getGameResult();
                ivWrong3.setVisibility(View.VISIBLE);
            }
        });
        imgBtnWrong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong4.setBackground(redBG);
                getGameResult();
                ivWrong4.setVisibility(View.VISIBLE);
            }
        });
        imgBtnWrong5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong5.setBackground(redBG);
                getGameResult();
                ivWrong5.setVisibility(View.VISIBLE);
            }
        });
        imgBtnWrong6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnWrong6.setBackground(redBG);
                getGameResult();
                ivWrong6.setVisibility(View.VISIBLE);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalGame2Activity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

    }
    private void showCorrect(){
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
        } else {
            btnEndGame.setText(tryAgain);
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