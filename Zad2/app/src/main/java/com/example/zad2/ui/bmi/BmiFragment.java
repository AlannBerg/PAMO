package com.example.zad2.ui.bmi;

import static java.util.Objects.nonNull;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.zad2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;


public class BmiFragment extends Fragment {

    private static final String ARG_PARAM_WEIGHT = "weightParam";
    private static final String ARG_PARAM_HEIGHT = "heightParam";

    private String weightParam;
    private String heightParam;

    public BmiFragment() {
        // Required empty public constructor
    }

    public static BmiFragment newInstance(String weightParam, String heightParam) {
        BmiFragment fragment = new BmiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_WEIGHT, weightParam);
        args.putString(ARG_PARAM_HEIGHT, heightParam);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            weightParam = getArguments().getString(ARG_PARAM_WEIGHT);
            heightParam = getArguments().getString(ARG_PARAM_HEIGHT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bmi, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView userWeightInput = (TextView) view.findViewById(R.id.weightEditText);
        final TextView userHeightInput = (TextView) view.findViewById(R.id.heightEditText);
        final TextView userBMIOutput = (TextView) view.findViewById(R.id.BMIValueText);
        final Button calculateButton = (Button) view.findViewById(R.id.calculateBMIButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer userHeight = getInteger(userHeightInput);
                Integer userWeight = getInteger(userWeightInput);
                if (nonNull(userWeight) && nonNull(userHeight)) {
                    String bmiResult = calculateBMI(userHeight, userWeight);
                    userBMIOutput.setText(bmiResult);
                }
            }
        });
    }

    private String calculateBMI(@NotNull Integer userHeightCm, @NotNull Integer userWeight) {
        double userHeightMeters = userHeightCm / 100.0;
        Double userHeightMetersSquare = Math.pow(userHeightMeters, 2);

        Double bmiValue = userWeight / userHeightMetersSquare;
        return String.format("%.1f", bmiValue);
    }

    private Integer getInteger(@NotNull TextView textView) {
        try {
            return Integer.valueOf(textView.getText().toString());
        } catch (Exception e) {
            return null;
        }
    }
}