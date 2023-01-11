package entities;

public class Input{
    private double mValue = 1;

    public Input() {

    }

    public Input(double x){
        mValue = x;
    }

    public void setValue(double x) {
        mValue = x;
    }

    public double getOut() {
        return mValue;
    }
}
