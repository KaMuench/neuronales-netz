package entities.layer;

import entities.Input;

import java.util.ArrayList;
import java.util.List;

public class InputLayer extends Layer{

    private Input mBias;
    private List<Input> mXValues;

    @Override
    public void forward() {
        mData.forEach(n -> n.generateOut(mXValues));
        mSuLayer.forward();
    }

    @Override
    public void backward() {
        for (int i = 0; i < mData.size(); i++) {
            mData.get(i).adjustWeights(mXValues, mAlpha, mSuLayer.getData(), mSuLayer.getWeights(i));
        }
    }

    @Override
    public List<Input> getDataWithBias() {
        List<Input> data = new ArrayList<>(mData);
        data.add(mBias);
        return data;
    }

    public void setXValues(double[] x) {
        for (int i = 1; i < x.length; i++) {
            mXValues.get(i).setValue(x[i]);
        }
    }
}
