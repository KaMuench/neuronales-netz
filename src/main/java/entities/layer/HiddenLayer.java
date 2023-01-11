package entities.layer;

import entities.Input;

import java.util.ArrayList;
import java.util.List;

public class HiddenLayer extends Layer{

    private Input mBias;


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
        mSuLayer.backward();
    }

    @Override
    public List<Input> getDataWithBias() {
        List<Input> data = new ArrayList<>(mData);
        data.add(mBias);
        return data;
    }
}
