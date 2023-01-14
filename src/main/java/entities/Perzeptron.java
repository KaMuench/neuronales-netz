package entities;

import entities.layer.HiddenLayer;
import entities.layer.InputLayer;
import entities.layer.OutputLayer;
import gui.IterationListener;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Perzeptron {

    InputLayer mInputLayer;
    OutputLayer mOutputLayer;
    ArrayList<HiddenLayer> mLayer;

    IterationListener mListener;

    double[][] mTraits;
    int[] mYValues;
    int[] mOrder;

    public Perzeptron(double[][] traits, int[] y, int[] amountNeuronPerHiddenLayer) {
        mTraits = traits;
        mYValues = y;
        mOrder = new int[traits.length];

        IntStream.range(0, traits.length).forEach(i -> mOrder[i] = i);


        ArrayList<HiddenLayer> layer = new ArrayList<>();
        //Add Input Layer which is actually the first hidden layer itself
        mInputLayer = new InputLayer(traits[0].length);

        //Add the other hidden layer
        layer.add(new HiddenLayer(amountNeuronPerHiddenLayer[0], mInputLayer));
        mInputLayer.setSuLayer(layer.get(0));

        int i = 1;
        while ( i < amountNeuronPerHiddenLayer.length) {
            layer.add(new HiddenLayer(amountNeuronPerHiddenLayer[i], layer.get(i - 1)));
            layer.get(i - 1).setSuLayer(layer.get(i));
            i++;
        }

        //Add the output layer
        mOutputLayer = new OutputLayer(layer.get(i - 1));
        layer.get(i - 1).setSuLayer(mOutputLayer);

        mLayer = layer;
    }


    public void exercise(double alpha, int iterations) {
        mInputLayer.setAlpha(alpha);
        mOutputLayer.setAlpha(alpha);
        mLayer.forEach(n -> n.setAlpha(alpha));

        for (int i = 0; i < iterations; i++) {
            chooseRandomOrder();
            int amountMistakes = 0;
            for (int j = 0; j < mOrder.length; j++) {
                mInputLayer.forward(mTraits[mOrder[j]]);
                mOutputLayer.backward(mYValues[mOrder[j]]);
            }
            if(i%4 == 0) {
                System.out.printf("Epoche: %d%-10s%10f%n%n", i,"Delta: ", mOutputLayer.getDelta());
            }
            if(i%50 == 0) mListener.iterationFinished(i);
        }
    }

    public void chooseRandomOrder() {
        for(int i=0;i<mOrder.length;i++) {
            int j = (int)(mOrder.length*Math.random());
            int a = mOrder[i];
            int b = mOrder[j];
            mOrder[i] = b;
            mOrder[j] = a;
        }
    }

    public void evaluate() {
        double[] x = new double[2];
        int richtig = 0;
        System.out.printf("%-6s%-6s%-5s%-10s%-10s%n%n", "X1", "X2", "Y", "Delta", "Out");
        for (int i = 0; i < mTraits.length; i++) {
            mInputLayer.forward(mTraits[i]);
            if(mOutputLayer.aktivierungsFunktionSchwellwert() == mYValues[i] ) richtig++;
            System.out.printf("%-6.2f%-6.2f%-5d%-10f%-10f%b%n%n", mTraits[i][0], mTraits[i][1], mYValues[i], mOutputLayer.getDelta(), mOutputLayer.getOut(), mOutputLayer.aktivierungsFunktionSchwellwert() == mYValues[i]);
        }

        System.out.printf("Richtig: %d von %d%n%n", richtig, mYValues.length);

        for(int x2=100;x2>=0;x2--) {
            for(int x1=0;x1<=100;x1++) {
                x[0] = (double)(x1/100.);
                x[1] = (double)(x2/100.);
                mInputLayer.forward(x);

                System.out.print(mOutputLayer.aktivierungsFunktionSchwellwert());
            }
            System.out.println();
        }
    }

    public void setIteratorListener(IterationListener iteratorListener) {
        mListener = iteratorListener;
    }

    public InputLayer getInputLayer() {
        return mInputLayer;
    }

    public OutputLayer getOutputLayer() {
        return mOutputLayer;
    }

    public ArrayList<HiddenLayer> getLayer() {
        return mLayer;
    }

    public IterationListener getListener() {
        return mListener;
    }

    public double[][] getTraits() {
        return mTraits;
    }

    public int[] getYValues() {
        return mYValues;
    }

    public int[] getOrder() {
        return mOrder;
    }
}
