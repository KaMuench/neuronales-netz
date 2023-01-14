package gui;

import javax.swing.*;
import java.awt.*;

public class GraphFrame extends JFrame {


    private Canvas graphCanvas = new Canvas();
    private InfoPanel infoPanel = new InfoPanel();

    public GraphFrame(String title) {
        // Frame-Initialisierung
        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 520;
        int frameHeight = 543;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Container cp = getContentPane();
        cp.setLayout(null);


        // Anfang Komponenten
        graphCanvas.setBounds(4, 4, getWidth() - 50, getHeight() - 4);
        graphCanvas.setBackground(Color.BLACK);
        cp.add(graphCanvas);
        // Ende Komponenten

        infoPanel.setBounds(getWidth() - 46, 4, 46, getHeight() - 4);
        infoPanel.setBackground(Color.WHITE);
        infoPanel.repaint();
        cp.add(infoPanel);


        setResizable(true);
        setVisible(true);
    }

    public void setValues(int[][] xValues, int[] yValues, int skalierung) {
        graphCanvas.setValues(xValues,yValues, skalierung);
    }

    public void setOutPut(Point[] pointsTrue, Point[] pointsFalse) {
        graphCanvas.setOutPut(pointsTrue, pointsFalse);
    }

    public Canvas getGraphCanvas() {
        return graphCanvas;
    }

    public void setIteration(int iteration) {
        infoPanel.setIteration(iteration);
    }


}
