package com.myapplicationdev.android.nostalgiamatchingfyp2024;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;

public class ColorHelper {
    public static Drawable redBG(int innerPadding, int outerPadding) {
        // Create the inner rectangle with solid white color
        GradientDrawable innerRect = new GradientDrawable();
        innerRect.setShape(GradientDrawable.RECTANGLE);
        innerRect.setColor(Color.TRANSPARENT);

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
        innerRect.setColor(Color.TRANSPARENT);

        GradientDrawable outerRect = new GradientDrawable();
        outerRect.setShape(GradientDrawable.RECTANGLE);
        outerRect.setColor(Color.GREEN);

        Drawable[] layers = {outerRect, innerRect}; // Outer rectangle should be at index 0 to be drawn below the inner rectangle
        LayerDrawable layerDrawable = new LayerDrawable(layers);

        // Set the bounds of the layers (adjust as needed)
        layerDrawable.setLayerInset(1, innerPadding, innerPadding, innerPadding, innerPadding); // Set the inset for the inner rectangle

        return layerDrawable;
    }

    public static Drawable createGreenRectangleWithTransparentCenter(Context context, int width, int height, int outerPadding, int innerSize) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        // Paint for the outer rectangle
        Paint outerPaint = new Paint();
        outerPaint.setColor(Color.GREEN);
        outerPaint.setStyle(Paint.Style.FILL);

        // Paint for the inner transparent rectangle
        Paint innerPaint = new Paint();
        innerPaint.setColor(Color.TRANSPARENT);

        // Draw outer rectangle
        canvas.drawRect(0, 0, width, height, outerPaint);

        // Draw inner transparent rectangle
        int innerLeft = outerPadding;
        int innerTop = outerPadding;
        int innerRight = width - outerPadding;
        int innerBottom = height - outerPadding;

        canvas.drawRect(innerLeft, innerTop, innerRight, innerBottom, innerPaint);

        return new BitmapDrawable(context.getResources(), bitmap);
    }
}
