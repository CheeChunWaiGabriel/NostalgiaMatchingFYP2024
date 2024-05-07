package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.graphics.Color;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EasyGame1Activity extends AppCompatActivity {

    ImageButton imgBtnCorrect1;
    ImageButton imgBtnCorrect2;
    ImageButton imgBtnWrong1;
    ImageButton imgBtnWrong2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_easy_game1);

        imgBtnCorrect1 = findViewById(R.id.imageButtonCorrect1);
        imgBtnCorrect2 = findViewById(R.id.imageButtonCorrect2);
        imgBtnWrong1 = findViewById(R.id.imageButtonWrong1);
        imgBtnWrong1 = findViewById(R.id.imageButtonWrong1);

        imgBtnCorrect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBtnCorrect1.setBackgroundColor(Color.GREEN);
            }
        });

    }
}