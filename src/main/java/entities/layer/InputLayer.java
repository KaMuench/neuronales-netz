package entities.layer;

import entities.input.Input;
import entities.input.Neuron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputLayer extends Layer{

    private Input mBias = new Input();
    private List<Input> mXValues;

    //amountInput means the x values from the trainings data
    public InputLayer(int amountInput) {
        mXValues = new ArrayList<>();
        for (int i = 0; i < amountInput; i++) {
            mXValues.add(new Input());
        }
    }

    @Override
    public void forward() {}

    public void forward(double[] xValues) {
        for (int i = 0; i < xValues.length; i++) {
            mXValues.get(i).setValue(xValues[i]);
        }
        mSuLayer.forward();
    }

    @Override
    public void backward() {}

    @Override
    public List<Input> getDataWithBias() {
        List<Input> data = new ArrayList<>();
        data.add(mBias);
        data.addAll(mXValues);
        return data;
    }

    @Override
    public int getDataWithBiasSize() {
        return mXValues.size() + 1;
    }
}
