package com.example.myapplication;

import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class Utils {
    public static Integer getInteger(@NotNull TextView textView) {
        try {
            return Integer.valueOf(textView.getText().toString());
        } catch (Exception e) {
            return null;
        }
    }
}
