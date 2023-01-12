package entities.layer;

import entities.input.Input;
import entities.input.Neuron;

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
    public abstract int getDataWithBiasSize();

    public List<Neuron> getData() {
        return mData;
    }

    public List<Double> getWeights(int index) {
        List<Double> weights = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            //index + 1 da das erste Gewicht immer das des BIAS ist
            weights.add(mData.get(i).getWeight(index + 1));
        }
        return weights;
    }

    public void setAlpha(double alpha) {
        mAlpha = alpha;
    }

    public void setPreLayer(Layer preLayer) {
        mPreLayer = preLayer;
    }
    public void setSuLayer(Layer suLayer) {
        mSuLayer = suLayer;
    }
}
