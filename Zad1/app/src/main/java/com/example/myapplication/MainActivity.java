package com.example.myapplication;

import static java.util.Objects.nonNull;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private TextView userWeightInput;
    private TextView userHeightInput;
    private TextView userBMIOutput;

    private Button calculateButton;

    private Integer bmiValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        userWeightInput = (TextView) findViewById(R.id.weightEditText);
        userHeightInput = (TextView) findViewById(R.id.heightEditText);
        userBMIOutput = (TextView) findViewById(R.id.BMIValueText);

        calculateButton = (Button) findViewById(R.id.calculateBMIButton);
        calculateButton.setOnClickListener(summitButtonListener);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private final View.OnClickListener summitButtonListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer userHeight = getInteger(userHeightInput);
                    Integer userWeight = getInteger(userWeightInput);
                    if (nonNull(userWeight) && nonNull(userHeight)) {
                        calculateBMI(userHeight, userWeight);
                    }
                }
            };

    private void calculateBMI(@NotNull Integer userHeightCm, @NotNull Integer userWeight) {
        double userHeightMeters = userHeightCm / 100.0;
        Double userHeightMetersSquare = Math.pow(userHeightMeters,2);

        Double bmiValue = userWeight / userHeightMetersSquare;
        String bmiValueString = String.format("%.1f", bmiValue);
        userBMIOutput.setText(bmiValueString);
    }

    private Integer getInteger(@NotNull TextView textView) {
        try {
            return Integer.valueOf(textView.getText().toString());
        } catch (Exception e) {
            return null;
        }
    }
}