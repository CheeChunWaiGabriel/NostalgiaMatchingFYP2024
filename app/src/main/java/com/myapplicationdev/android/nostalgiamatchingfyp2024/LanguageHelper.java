package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

public class LanguageHelper {
    private static final String LANGUAGE_PREF_KEY = "language";

    public static void setLanguage(Context context, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());

        // Save language preference
        SharedPreferences.Editor editor = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit();
        editor.putString(LANGUAGE_PREF_KEY, languageCode);
        editor.apply();
    }

    public static String getLanguage(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return prefs.getString(LANGUAGE_PREF_KEY, Locale.getDefault().getLanguage());
    }
}
