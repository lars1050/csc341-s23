public class Circle {

    /* Center point of circle */
    Point center = new Point(0,0);
    
    /* Radius of circle */
    int radius = 1;

    /** Default constructor creating unit circle at origin */
    public Circle() {
        // Create a default unit circle (i.e. 1 unit radius) centered at the origin
        this(new Point(0,0), 1);
    }

    /** Constructor with specified information
     * @param center Point x,y of the circle center
     * @param radius Radius in non-specified units
     */
    public Circle(Point c, int r) {
        center = c;
        radius = r;
    }

    /** Determine if specified circle overlaps or touches this circle
     * @param other Circle to test for overlap
     * @return If overlapping or touching, return true
     */
    public boolean overlaps(Circle other) {
        // Determine distance between centers
        double hypSquared = Math.pow((center.x - other.center.x),2.0) + Math.pow((center.y - other.center.y),2.0);
        double distance = Math.pow(hypSquared,0.5);

        // Overlaps when the radii of the 2 circles is less than the distance between
        return (distance < radius + other.radius);
    }
    
}
