package gui;

import java.awt.*;

public class InfoPanel extends Panel {

    int iteration;

    @Override
    public void paintComponents(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(String.valueOf(iteration), 5, 5);
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }
}
