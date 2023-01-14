package gui;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    private int[][] mXValues;

    private int[] mYValues;

    private Point[] mPointsTrue;
    private Point[] mPointsFalse;

    private int mSkalierung;

    private int mTraitsSize = 2;
    private int mBackgrPixelSize = 1;

    public Canvas() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        // meine Zeichnung
        paintPoints(graphics2D);
        paintXCoordinates(graphics2D);
    }

    private void paintXCoordinates(Graphics2D g) {
        for (int i = 0; i < mXValues.length; i++) {
            if(mYValues[i] == 1) g.setColor(Color.blue);
            else g.setColor(Color.RED);
            g.fillOval(mXValues[i][0], mXValues[i][1], mTraitsSize * mSkalierung, mTraitsSize * mSkalierung);
        }
    }

    public void setValues(int[][] xValues, int[] yValues, int dimension) {
        mSkalierung = calcSkalierung(dimension);
        mBackgrPixelSize = mSkalierung-2;

        mXValues = new int[xValues.length][xValues[0].length];
        mYValues = yValues;

        for (int i = 0; i < xValues.length; i++) {
            mXValues[i][0] = xValues[i][0] * mSkalierung;
            mXValues[i][1] = (100 - xValues[i][1]) * mSkalierung;
        }
    }

    public void paintPoints(Graphics2D g) {
        for (Point value : mPointsFalse) {
            g.setColor(Color.ORANGE);
            g.fillRect(value.x * mSkalierung, value.y * mSkalierung, mBackgrPixelSize, mBackgrPixelSize);
        }
        for (Point point : mPointsTrue) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(point.x * mSkalierung, point.y * mSkalierung, mBackgrPixelSize, mBackgrPixelSize);
        }
    }

    public void setOutPut(Point[] pointsTrue, Point[] pointsFalse) {
        mPointsTrue = pointsTrue;
        mPointsFalse = pointsFalse;
    }

    private int calcSkalierung(int dimension) {
        int height = getHeight();
        int width = getWidth() - 50;
        int skalierung = 2;

        while(dimension < height && dimension < width) {
            dimension *= 2;
            skalierung++;
        }

        return --skalierung;
    }
}
