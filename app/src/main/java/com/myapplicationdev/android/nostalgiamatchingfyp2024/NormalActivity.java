package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NormalActivity extends AppCompatActivity {
    Button btnPuzzle1;
    Button btnHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_puzzle_normal);

        btnPuzzle1 = findViewById(R.id.btnCutlery);
        btnHome = findViewById(R.id.buttonHomePage);
        btnPuzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, NormalGame1Activity.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}