package entities;

import entities.input.Input;
import entities.layer.HiddenLayer;
import entities.layer.InputLayer;
import entities.layer.Layer;
import entities.layer.OutputLayer;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Perzeptron {

    InputLayer mInputLayer;
    OutputLayer mOutputLayer;
    ArrayList<HiddenLayer> mLayer;
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
            System.out.println("Epoche: " + i + " Fehler: " + mOutputLayer.getDeltaOut());
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
        for(int z=100;z>=0;z=z-1) {
            for(int s=0;s<=100;s=s+1) {
                x[0] = (double)(s/100.);
                x[1] = (double)(z/100.);
                mInputLayer.forward(x);
                //if(z==90 && s==20)
                System.out.print(mOutputLayer.aktivierungsFunktionSchwellwert());
            }
            System.out.println();
        }
    }

}
