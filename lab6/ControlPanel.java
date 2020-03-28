package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("SAVE");
    JButton loadBtn = new JButton("LOAD");
    JButton resetBtn = new JButton("RESET");
    JButton exitBtn = new JButton("EXIT");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new FileOutputStream("D:/Code/Java/img.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        try {
            frame.canvas.image = ImageIO.read(new File("D:/Code/Java/img.png"));
            frame.canvas.repaint();
            frame.canvas.graphics = frame.canvas.image.createGraphics();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    private void reset(ActionEvent e) {
        frame.setVisible( false );
    	MainFrame frame= new MainFrame();
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }

}