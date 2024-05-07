package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EasyActivity extends AppCompatActivity {
    Button btnPuzzle1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_puzzle_easy);

        btnPuzzle1 = findViewById(R.id.buttonPuzzle1);

        btnPuzzle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EasyActivity.this, EasyGame1Activity.class);
                startActivity(intent);
            }
        });

    }
}

