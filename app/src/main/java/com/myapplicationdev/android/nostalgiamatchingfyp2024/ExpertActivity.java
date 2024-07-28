package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ExpertActivity extends AppCompatActivity {

    Button btnPuzzle1;
    Button btnPuzzle2;
    Button btnPuzzle3;
    Button btnPuzzle4;
    Button btnPuzzle5;
    Button btnPuzzle6;
    Button btnPuzzle7;
    Button btnPuzzle8;
    Button btnHome;

    private MediaPlayer buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String savedLanguage = LanguageHelper.getLanguage(this);
        LanguageHelper.setLanguage(this, savedLanguage);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_puzzle_expert);

        btnPuzzle1= findViewById(R.id.btnParrot);
        btnPuzzle2= findViewById(R.id.btndimSum);
        btnPuzzle3= findViewById(R.id.btnTingkat);
        btnPuzzle4= findViewById(R.id.btnMahjong);
        btnPuzzle5= findViewById(R.id.btnOrchid);
        btnPuzzle6= findViewById(R.id.btnSatay);
        btnPuzzle7= findViewById(R.id.btnGoldCoins);
        btnPuzzle8= findViewById(R.id.btnWeddingBasket);
        btnHome = findViewById(R.id.buttonHomePage);

        buttonClick = MediaPlayer.create(this, R.raw.buttonclick);

        btnPuzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, ExpertGame1Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, ExpertGame2Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, ExpertGame3Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, ExpertGame4Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, ExpertGame5Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, ExpertGame6Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, ExpertGame7Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnPuzzle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, ExpertGame8Activity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpertActivity.this, MainActivity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });
    }
}