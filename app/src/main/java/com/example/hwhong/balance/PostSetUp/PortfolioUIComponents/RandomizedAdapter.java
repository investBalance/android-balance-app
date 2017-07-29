package com.example.hwhong.balance.PostSetUp.PortfolioUIComponents;

import com.robinhood.spark.SparkAdapter;

import java.util.Random;

/**
 * Created by hwhong on 7/14/17.
 */

public class RandomizedAdapter extends SparkAdapter {
    private final float[] yData;
    private final Random random;

    public RandomizedAdapter() {
        random = new Random();
        yData = new float[10];
        randomize();
    }

    public void randomize() {
        for (int i = 0, count = yData.length; i < count; i++) {
            yData[i] = random.nextFloat();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return yData.length;
    }

    @Override
    public Object getItem(int index) {
        return yData[index];
    }

    @Override
    public float getY(int index) {
        return yData[index];
    }
}
