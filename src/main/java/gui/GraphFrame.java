package gui;

import javax.swing.*;
import java.awt.*;

public class GraphFrame extends JFrame {

    private JPanel zeichenflaeche = new Canvas();

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
        zeichenflaeche.setBounds(7, 2, 500, 500);
        zeichenflaeche.setBackground(Color.WHITE);
        cp.add(zeichenflaeche);
        // Ende Komponenten

        setResizable(false);
        setVisible(true);
    }
}
