package com.example.myapplication;

import org.jetbrains.annotations.NotNull;

public class BmiCalculator {

    public static String calculateBMI(@NotNull Integer userHeightCm, @NotNull Integer userWeight) {
        double userHeightMeters = userHeightCm / 100.0;
        Double userHeightMetersSquare = Math.pow(userHeightMeters, 2);

        Double bmiValue = userWeight / userHeightMetersSquare;
        return String.format("%.1f", bmiValue);
    }
}
