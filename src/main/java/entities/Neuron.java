package entities;

import java.util.ArrayList;
import java.util.List;

public class Neuron extends Input {

    private List<Double> mWeights;
    double mOut;
    double mIn;
    double mDelta;

    Neuron(int amountInputs) {
        //Initialisierung der Gewichte
        mWeights = new ArrayList<>();
        double d = 0.;
        for (int i = 0; i < amountInputs; i++) {
            d = Math.random();
            if (Math.random() < 0.5) d *= -1.0;
            mWeights.add(d);
        }
    }

    public void calcSkalar(List<Input> predecessors) {
        double in = 0.;
        for (int i = 0; i < predecessors.size(); i++) {
            in += predecessors.get(i).getOut() * mWeights.get(i);
        }
        mIn = in;
    }

    public double calcSig(double value) {
        return 1 / (1+Math.exp(-value));
    }

    public double calcSigAbl(double value) {
        return calcSig(value) * (1 - calcSig(value));
    }

    public void calcDelta(int y) {
        mDelta = (y - mOut) * calcSigAbl(mIn);
    }

    public void calcDelta(List<Neuron> successors, List<Double> successorWeights) {
        double sum = 0.;
        for (int i = 0; i < successors.size(); i++) {
            sum += successorWeights.get(i) * successors.get(i).getDelta();
        }
        mDelta = sum * calcSigAbl(mIn);
    }

    public void calcWeight(List<Input> predecessor, double alpha) {
        double weight = 0.;
        for (int i = 0; i < predecessor.size(); i++) {
            weight = mWeights.get(i);
            weight += alpha * predecessor.get(i).getOut() * mDelta;
            mWeights.set(i, weight);
        }
    }


    public void generateOut(List<Input> predecessors) {
        calcSkalar(predecessors);
        mOut = calcSig(mIn);
    }

    public void adjustWeights(List<Input> predecessor, double alpha , int y) {
        calcDelta(y);
        calcWeight(predecessor, alpha);
    }

    public void adjustWeights(List<Input> predecessor, double alpha , List<Neuron> successor, List<Double> successorWeights) {
        calcDelta(successor, successorWeights);
        calcWeight(predecessor, alpha);
    }

    @Override
    public double getOut() {
        return mOut;
    }

    public double getDelta() {
        return mDelta;
    }

    public double getWeight(int index) {
        return mWeights.get(index);
    }
}
