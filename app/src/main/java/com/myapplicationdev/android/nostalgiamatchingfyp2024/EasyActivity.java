package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EasyActivity extends AppCompatActivity {
    Button btnHome;
    Button btnPuzzle1;
    Button btnPuzzle2;
    Button btnPuzzle3;
    Button btnPuzzle4;
    Button btnPuzzle5;
    Button btnPuzzle6;
    Button btnPuzzle7;
    Button btnPuzzle8;

    private MediaPlayer buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String savedLanguage = LanguageHelper.getLanguage(this);
        LanguageHelper.setLanguage(this, savedLanguage);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_puzzle_easy);

        btnHome = findViewById(R.id.buttonHomePage);
        btnPuzzle1 = findViewById(R.id.btnFlask);
        btnPuzzle2 = findViewById(R.id.btnLaska);
        btnPuzzle3 = findViewById(R.id.btnRose);
        btnPuzzle4 = findViewById(R.id.btnDog);
        btnPuzzle5 = findViewById(R.id.btnClogs);
        btnPuzzle6 = findViewById(R.id.btnSpoon);
        btnPuzzle7 = findViewById(R.id.btnArmchair);
        btnPuzzle8 = findViewById(R.id.btnBirdCage);

        buttonClick = MediaPlayer.create(this, R.raw.buttonclick);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, MainActivity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, EasyGame1Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, EasyGame2Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, EasyGame3Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, EasyGame4Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, EasyGame5Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, EasyGame6Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, EasyGame7Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, EasyGame8Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });
    }
}