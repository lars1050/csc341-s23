
/**
 *
 * @author larson amy c
 */
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class FaceDrawing implements DrawingObject {

    private static final Point DEFAULT_LOCATION = new Point(320, 100);

    /** Count instantiations to generate unique id **/
    private Face face;

    /** x,y-coordinate of upper left corner of bounding box **/
    private Point location = DEFAULT_LOCATION;

    /** Midpoint of the face. Calculated using location. **/
    private Point midpoint;

    private Random rand = new Random();

    public FaceDrawing(Face f) {
        face = f;
    }
    
    /**
     * Draw eyes at midline of face using facial feature information.
     *
     * @param g2d graphics window on which to draw
     */
    public void draw_eyes(Graphics2D g2d) {
        // eyes
        // When drawing left eye, shift x position to the left-most edge of the eye

        // Randomly choose how open the eyes are
        int openness = rand.nextInt(5) + 4;

        // Left and right eye sockets, drawn in the middle of the face
        // Left edge of left eye socket is delta+length away from midline.
        // Left edge of right eye socket is delta away from midline.
        Ellipse2D.Double left
                = new Ellipse2D.Double(midpoint.x - face.eyeDelta() - face.eyeDelta()*2, midpoint.y, face.eyeDelta()*2, openness);
        Ellipse2D.Double right
                = new Ellipse2D.Double(midpoint.x + face.eyeDelta(), midpoint.y, face.eyeDelta()*2, openness);
        g2d.setColor(new Color(255, 255, 255));
        g2d.fill(left);
        g2d.fill(right);

        // left and right eyeballs. Order matters so must do eyeball after socket.
        Ellipse2D.Double left_eyeball = new Ellipse2D.Double(midpoint.x - face.eyeDelta() - (3 * face.eyeDelta() / 2), midpoint.y, face.eyeDelta(), openness);
        Ellipse2D.Double right_eyeball = new Ellipse2D.Double(midpoint.x + face.eyeDelta() + (face.eyeDelta() / 2), midpoint.y, face.eyeDelta(), openness);
        g2d.setColor(new Color(88, 33, 24));
        g2d.fill(left_eyeball);
        g2d.fill(right_eyeball);

    }

    /**
     * 
     */
    public void draw_nose(Graphics2D g2d) {
        // Create a half triangle for the nose
        Path2D.Double nose = new Path2D.Double();
        nose.moveTo(midpoint.x, midpoint.y - 2);
        nose.lineTo(midpoint.x - face.noseLength()/2, midpoint.y + face.noseLength());
        nose.lineTo(midpoint.x, midpoint.y + face.noseLength());
        // Draw on the face
        g2d.setColor(new Color(0, 89, 179));
        g2d.draw(nose);
    }

    /**
     * 
     */
    public void draw_mouth(Graphics2D g2d) {
        // Create a slight curve for the mouth
        Path2D.Double curve = new Path2D.Double();
        // Determine vertical position on the face (i.e. y-value)
        double ypos = midpoint.y + face.noseLength() + face.mouthDelta();
        // Start at the left corner of the mouth
        curve.moveTo(midpoint.x - 20, ypos);
        // 2 bezier points then end point - determines curvature
        curve.curveTo(midpoint.x - 18, ypos + 2, midpoint.x + 18,
                ypos + 2, midpoint.x + 20, ypos);
        // Draw on the face
        g2d.setColor(new Color(179, 0, 0));
        g2d.draw(curve);
    }

    @Override
    /**
     * 
     */
    public void draw(Graphics2D g2d) {

        // draw the head. 
        // order matters - must draw head first, then features on top of face.
        // The x-y location of an ellipse is the upper left corner of the bounding box
        Ellipse2D.Double f = new Ellipse2D.Double(location.x, location.y, face.width(), face.height());
        g2d.setColor(new Color(153, 204, 255));
        g2d.fill(f);

        // exact center of face with respect to drawing window
        // used to determine placement of eyes, nose and mouth within face
        midpoint = new Point(location.x() + face.width() / 2, location.y() + face.height() / 2);

        // draw components of face
        draw_eyes(g2d);
        draw_nose(g2d);
        draw_mouth(g2d);
    }

    // all setters and getters from here ------------------------------------
    // It is NOT necessary to document setters and getters.
    
    public Point location() {
        return location;
    }

    public void location(Point p) {
        location = p;
    }

    public Point midpoint() {
        return midpoint;
    }

    public void midpoint(Point p) {
        midpoint = p;
    }

}