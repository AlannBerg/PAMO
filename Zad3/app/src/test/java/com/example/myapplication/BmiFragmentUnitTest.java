package com.example.myapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BmiFragmentUnitTest {

    @Test
    public void bmi_calculator_is_correct() {
        //given
        Integer height = 185;
        Integer weight = 85;
        String expectedBMI = "24.8";

        //when
        String bmi = BmiCalculator.calculateBMI(height, weight);
        //then
        Assert.assertEquals(expectedBMI, bmi);
    }
}