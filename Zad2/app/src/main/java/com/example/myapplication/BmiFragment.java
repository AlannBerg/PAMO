
package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BmiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BmiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BmiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BmiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BmiFragment newInstance(String param1, String param2) {
        BmiFragment fragment = new BmiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bmi, container, false);
    }
}


/**
 *   private TextView userWeightInput;
 *     private TextView userHeightInput;
 *     private TextView userBMIOutput;
 *
 *     private Button calculateButton;
 *
 *     private Integer bmiValue;
 *
 *     @Override
 *     protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *         EdgeToEdge.enable(this);
 *         setContentView(R.layout.activity_main);
 *
 *         userWeightInput = (TextView) findViewById(R.id.weightEditText);
 *         userHeightInput = (TextView) findViewById(R.id.heightEditText);
 *         userBMIOutput = (TextView) findViewById(R.id.BMIValueText);
 *
 *         calculateButton = (Button) findViewById(R.id.calculateBMIButton);
 *         calculateButton.setOnClickListener(summitButtonListener);
 *
 *         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
 *             Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
 *             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
 *             return insets;
 *         });
 *     }
 *
 *     private final View.OnClickListener summitButtonListener =
 *             new View.OnClickListener() {
 *                 @Override
 *                 public void onClick(View v) {
 *                     Integer userHeight = getInteger(userHeightInput);
 *                     Integer userWeight = getInteger(userWeightInput);
 *                     if (nonNull(userWeight) && nonNull(userHeight)) {
 *                         calculateBMI(userHeight, userWeight);
 *                     }
 *                 }
 *             };
 *
 *     private void calculateBMI(@NotNull Integer userHeightCm, @NotNull Integer userWeight) {
 *         double userHeightMeters = userHeightCm / 100.0;
 *         Double userHeightMetersSquare = Math.pow(userHeightMeters,2);
 *
 *         Double bmiValue = userWeight / userHeightMetersSquare;
 *         String bmiValueString = String.format("%.1f", bmiValue);
 *         userBMIOutput.setText(bmiValueString);
 *     }
 *
 *     private Integer getInteger(@NotNull TextView textView) {
 *         try {
 *             return Integer.valueOf(textView.getText().toString());
 *         } catch (Exception e) {
 *             return null;
 *         }
 *     }
 * }
 */