import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Text that can be drawn in the graphics window.
 *
 * @author amylarson
 */
public class Text implements DrawingObject {
    
    private String text = " ";
    private Point location;
    
    /** Constructor specifying text and location in window
     * 
     * @param s text to be displayed
     * @param loc x-y location in the graphics window (left edge)
     */
    public Text(String s, Point loc) {
        text = s;
        location = loc;
    }
    
    @Override
    /** Draws text in specified graphics window.
     * 
     * @param g2d graphics window to draw in
     */
    public void draw(Graphics2D g2d) {
        g2d.drawString(text, (int) location.x(), (int) location.y());
    }
    
    // setters and getters
    public void text(String s) {
        text = s;
    }
    public void location(Point p) {
        location = p;
    }
    public Point location() {
        return location;
    }
}
