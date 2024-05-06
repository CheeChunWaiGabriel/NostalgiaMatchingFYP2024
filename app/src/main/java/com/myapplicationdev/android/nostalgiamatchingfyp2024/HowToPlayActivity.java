package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
public class HowToPlayActivity extends AppCompatActivity {
    Button btnHomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtoplay);

        btnHomePage = findViewById(R.id.htpHomeButton);

        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HowToPlayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}