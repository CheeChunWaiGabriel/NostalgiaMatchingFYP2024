package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        View easyButton = findViewById(R.id.easyBtn);
        View mediumButton = findViewById(R.id.normalBtn);
        View hardButton = findViewById(R.id.expertBtn);
        Button settingsButton = findViewById(R.id.settingsButton);
        Button howToPlayButton = findViewById(R.id.howToPlayButton);

        // Set click listeners for buttons
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EasyActivity.class);
                startActivity(intent);
            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle medium difficulty selection
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle hard difficulty selection
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        howToPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open how-to-play activity
            }
        });
    }
}
