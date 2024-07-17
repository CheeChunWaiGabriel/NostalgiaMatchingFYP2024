package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class SettingActivity extends AppCompatActivity {

    Button btnHomePage;
    Button btnKYDZweb;
    Button btnlangEN;
    Button btnlangCN;
    Button btnlangBA;
    Button btnlangTA;

    ImageButton btnRefresh;
    Boolean langFour;

    private MediaPlayer buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);

        btnHomePage = findViewById(R.id.buttonHomePage);
        btnKYDZweb = findViewById(R.id.buttonKYDZWeb);

        btnlangEN = findViewById(R.id.buttonLanguageEN);
        btnlangCN = findViewById(R.id.buttonLanguageCN);
        btnlangBA = findViewById(R.id.buttonLanguageBA);
        btnlangTA = findViewById(R.id.buttonLanguageTA);

        btnRefresh = findViewById(R.id.imageButtonRefresh);
        langFour = true;

        buttonClick = MediaPlayer.create(this, R.raw.buttonclick);

        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick.start();
                if (langFour == true){
                    langFour = false;
                    btnlangBA.setVisibility(View.GONE);
                    btnlangTA.setVisibility(View.GONE);
                } else{
                    langFour = true;
                    btnlangBA.setVisibility(View.VISIBLE);
                    btnlangTA.setVisibility(View.VISIBLE);
                }
            }
        });

        btnKYDZweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://kydz.com.sg/"));
                startActivity(intent);
                buttonClick.start();
            }
        });

        btnlangEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageHelper.setLanguage(SettingActivity.this, "en");
                // Refresh activity to apply changes
                recreate();
                buttonClick.start();
            }
        });
        btnlangCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageHelper.setLanguage(SettingActivity.this, "zh");
                // Refresh activity to apply changes
                recreate();
                buttonClick.start();
            }
        });
        btnlangBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageHelper.setLanguage(SettingActivity.this, "in");
                // Refresh activity to apply changes
                recreate();
                buttonClick.start();
            }
        });
        btnlangTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageHelper.setLanguage(SettingActivity.this, "ta");
                // Refresh activity to apply changes
                recreate();
                buttonClick.start();
            }
        });
    }
}