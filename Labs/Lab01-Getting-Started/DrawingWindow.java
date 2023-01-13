/*
 * Inspired by https://www.youtube.com/watch?v=zCiMlbu1-aQ&ab_channel=choobtorials
 * 
 * AUTHOR: Amy C. Larson, Ph.D.
 * copyrighted 2022
 */

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class DrawingWindow extends JComponent {

    private int width;
    private int height;
    
    private ArrayList<DrawingObject> objects;

    public DrawingWindow(int w, int h) {
        width = w;
        height = h;
        objects = new ArrayList<DrawingObject>();
    }
    
    public void addObject(DrawingObject obj) {
        objects.add(obj);
    }

    public void updateObjects(DrawingObject[] objArray) {
        objects = new ArrayList<DrawingObject>();
        for (DrawingObject obj : objArray) {
            objects.add(obj);
        }
    }
    
    public void redraw() {
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.PINK);
        g2d.fillRect(0+10,0+10,width-20,height-20);
        g2d.setColor(Color.BLACK);

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        for (DrawingObject obj : objects) {
            if (obj != null) {
                obj.draw(g2d);
            }
        }
    }
}
