/** Typical 2d Point Class with x- and y-coordinates.
 *
 * @author amylarson
 */
public class Point {
    
    public double x;
    public double y;
    
    public Point() {
        x = 0.0;
        y = 0.0;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "["+x+","+y+"]";
    }
    
    public double x() { return x; }
    public void x(double val) { x=val; }
    
    public double y() { return y; }
    public void y(double val) { y=val; }
}
