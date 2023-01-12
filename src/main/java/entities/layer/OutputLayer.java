package entities.layer;

import entities.input.Input;
import entities.input.Neuron;

import java.util.ArrayList;
import java.util.List;

public class OutputLayer extends Layer{

    public OutputLayer(Layer preLayer) {
        mData = new ArrayList<>();
        mData.add(new Neuron(preLayer.getDataWithBiasSize()));
        mPreLayer = preLayer;
    }

    @Override
    public void forward() {
        mData.forEach(n -> n.generateOut(mPreLayer.getDataWithBias()));
    }

    @Override
    public void backward() {

    }

    public void backward(int y) {
        for (int i = 0; i < mData.size(); i++) {
            mData.get(i).adjustWeights(mPreLayer.getDataWithBias(), mAlpha, y);
        }
        mPreLayer.backward();
    }

    public double getDeltaOut() {
        return mData.get(0).getDelta();
    }

    @Override
    public List<Input> getDataWithBias() {
        return null;
    }

    @Override
    public int getDataWithBiasSize() {
        return 0;
    }

    public int aktivierungsFunktionSchwellwert() {
        if(mData.get(0).getOut()<0.5)return 0;
        else   return 1;
    }
}
