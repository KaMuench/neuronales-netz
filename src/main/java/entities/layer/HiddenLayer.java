package entities.layer;

import entities.input.Input;
import entities.input.Neuron;

import java.util.ArrayList;
import java.util.List;

public class HiddenLayer extends Layer{

    private Input mBias = new Input();

    public HiddenLayer(int amountNeurons, Layer preLayer) {
        mData = new ArrayList<>();
        for (int i = 0; i < amountNeurons; i++) {
            mData.add(new Neuron(preLayer.getDataWithBiasSize()));
        }
        mPreLayer = preLayer;
    }


    @Override
    public void forward() {
        mData.forEach(n -> n.generateOut(mPreLayer.getDataWithBias()));
        mSuLayer.forward();
    }

    @Override
    public void backward() {
        for (int i = 0; i < mData.size(); i++) {
            mData.get(i).adjustWeights(mPreLayer.getDataWithBias(), mAlpha, mSuLayer.getData(), mSuLayer.getWeights(i));
        }
        mPreLayer.backward();
    }

    @Override
    public List<Input> getDataWithBias() {
        List<Input> data = new ArrayList<>();
        data.add(mBias);
        data.addAll(mData);
        return data;
    }

    @Override
    public int getDataWithBiasSize() {
        return mData.size() + 1;
    }
}
