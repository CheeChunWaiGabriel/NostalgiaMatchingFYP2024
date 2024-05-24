package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnKYDZweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://kydz.com.sg/"));
                startActivity(intent);
            }
        });

        btnlangEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageHelper.setLanguage(SettingActivity.this, "en");
                // Refresh activity to apply changes
                recreate();
            }
        });
        btnlangCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageHelper.setLanguage(SettingActivity.this, "zh");
                // Refresh activity to apply changes
                recreate();
            }
        });
    }

}