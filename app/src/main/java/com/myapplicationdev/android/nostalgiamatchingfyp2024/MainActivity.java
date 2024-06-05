package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String savedLanguage = LanguageHelper.getLanguage(this);
        LanguageHelper.setLanguage(this, savedLanguage);

        setContentView(R.layout.activity_main);

        // Initialize buttons
        View easyButton = findViewById(R.id.easyBtn);
        View mediumButton = findViewById(R.id.normalBtn);
        View hardButton = findViewById(R.id.expertBtn);
        Button settingsButton = findViewById(R.id.settingsButton);
        Button howToPlayButton = findViewById(R.id.howToPlayButton);

        buttonClick = MediaPlayer.create(this, R.raw.buttonclick);

        // Set click listeners for buttons
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EasyActivity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExpertActivity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        howToPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HowToPlayActivity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });
    }
}
