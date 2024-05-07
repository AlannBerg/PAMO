package com.example.myapplication;

import static com.example.myapplication.BmiCalculator.calculateBMI;
import static com.example.myapplication.Utils.getInteger;
import static java.util.Objects.nonNull;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


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

        return inflater.inflate(R.layout.fragment_bmi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView userWeightInput = (TextView) getView().findViewById(R.id.weightEditText);
        final TextView userHeightInput = (TextView) getView().findViewById(R.id.heightEditText);
        final TextView userBMIOutput = (TextView) getView().findViewById(R.id.BMIValueText);
        final Button calculateButton = (Button) getView().findViewById(R.id.calculateBMIButton);
        final GraphView graphView = (GraphView) getView().findViewById(R.id.Graph);
        mockGraphValues(graphView);
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

    private void mockGraphValues(@NonNull GraphView graphView) {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                // on below line we are adding
                // each point on our x and y axis.
                new DataPoint(1, 22),
                new DataPoint(1.5, 21.5),
                new DataPoint(2, 22.2),
                new DataPoint(2.5, 21.7),
                new DataPoint(3, 22.7)
        });

        // after adding data to our line graph series.
        // on below line we are setting
        // title for our graph view.
        graphView.setTitle("Your BMI in time");

        // on below line we are setting
        // text color to our graph view.
//        graphView.setTitleColor(R.color.);

        // on below line we are setting
        // our title text size.
        graphView.setTitleTextSize(12);

        // on below line we are adding
        // data series to our graph view.
        graphView.addSeries(series);

    }
}