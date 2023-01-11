package entities.layer;

import entities.Input;
import entities.Neuron;

import java.util.ArrayList;
import java.util.List;

public abstract class Layer {

    protected List<Neuron> mData;
    protected Layer mPreLayer;
    protected Layer mSuLayer;
    protected double mAlpha;

    public abstract void forward();
    public abstract void backward();
    public abstract List<Input> getDataWithBias();

    public List<Neuron> getData() {
        return mData;
    }

    public List<Double> getWeights(int index) {
        List<Double> weights = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            weights.add(mData.get(i).getWeight(index));
        }
        return weights;
    }

}
