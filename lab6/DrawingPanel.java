package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    public BufferedImage image; 
    public Graphics2D graphics; 
    final static int W = 1000, H = 800;
    
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); 
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(50);
        int sides = (int) frame.configPanel.sidesField.getValue();
        JComboBox colour = (JComboBox) frame.configPanel.getColor();
        System.out.println(colour.getSelectedIndex());
        //Fixed the color selection. JComboBox was created wrong in ConfigPanel before.
        if(colour.getSelectedIndex()==0){
        	Color color = new Color(rand.nextInt(0xFFFFFF)); 
        	graphics.setColor(color);
        }
        else{
        	graphics.setColor(Color.black);
        }
        
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}