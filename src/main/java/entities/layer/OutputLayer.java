package entities.layer;

import entities.Input;

import java.util.List;

public class OutputLayer extends Layer{

    private int mYValue;

    @Override
    public void forward() {
        mData.forEach(n -> n.generateOut(mPreLayer.getDataWithBias()));
        mSuLayer.forward();
    }

    @Override
    public void backward() {
        for (int i = 0; i < mData.size(); i++) {
            mData.get(i).adjustWeights(mPreLayer.getDataWithBias(), mAlpha, mYValue);
        }
    }

    @Override
    public List<Input> getDataWithBias() {
        return null;
    }

    public void setYValue(int y) {
        this.mYValue = y;
    }
}
