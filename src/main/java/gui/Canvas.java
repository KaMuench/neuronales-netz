package gui;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    public Canvas() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // meine Zeichnung
        g.fillRect(100, 100, 150, 250);
    }
}
