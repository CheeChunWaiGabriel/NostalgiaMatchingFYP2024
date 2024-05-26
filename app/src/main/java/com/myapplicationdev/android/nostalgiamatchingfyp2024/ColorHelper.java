package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;

public class ColorHelper {
    public static Drawable redBG(int innerPadding, int outerPadding) {
        // Create the inner rectangle with solid white color
        GradientDrawable innerRect = new GradientDrawable();
        innerRect.setShape(GradientDrawable.RECTANGLE);
        innerRect.setColor(Color.WHITE);

        GradientDrawable outerRect = new GradientDrawable();
        outerRect.setShape(GradientDrawable.RECTANGLE);
        outerRect.setColor(Color.RED);

        Drawable[] layers = {outerRect, innerRect}; // Outer rectangle should be at index 0 to be drawn below the inner rectangle
        LayerDrawable layerDrawable = new LayerDrawable(layers);

        // Set the bounds of the layers (adjust as needed)
        layerDrawable.setLayerInset(1, innerPadding, innerPadding, innerPadding, innerPadding); // Set the inset for the inner rectangle

        return layerDrawable;
    }

    public static Drawable greenBG(int innerPadding, int outerPadding) {
        // Create the inner rectangle with solid white color
        GradientDrawable innerRect = new GradientDrawable();
        innerRect.setShape(GradientDrawable.RECTANGLE);
        innerRect.setColor(Color.WHITE);

        GradientDrawable outerRect = new GradientDrawable();
        outerRect.setShape(GradientDrawable.RECTANGLE);
        outerRect.setColor(Color.GREEN);

        Drawable[] layers = {outerRect, innerRect}; // Outer rectangle should be at index 0 to be drawn below the inner rectangle
        LayerDrawable layerDrawable = new LayerDrawable(layers);

        // Set the bounds of the layers (adjust as needed)
        layerDrawable.setLayerInset(1, innerPadding, innerPadding, innerPadding, innerPadding); // Set the inset for the inner rectangle

        return layerDrawable;
    }
}
