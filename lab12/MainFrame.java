package lab12;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int W = 1200, H = 800;
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame() {
        super("Dynamic Swing Designer");
        this.setLayout(new BorderLayout());
        rootPane.setPreferredSize(new Dimension(W, H));
        pack();
        init();
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(designPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.controlPanel = new ControlPanel(this);
        this.designPanel = new DesignPanel(this);
    }

}