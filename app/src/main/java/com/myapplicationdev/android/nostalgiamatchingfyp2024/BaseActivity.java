package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLanguage();
    }

    protected void setLanguage() {
        // Retrieve the language preference from SharedPreferences
        String languageCode = LanguageHelper.getLanguage(this);
        // Set the language for the app
        LanguageHelper.setLanguage(this, languageCode);
    }
}