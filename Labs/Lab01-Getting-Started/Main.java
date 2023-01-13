import java.util.Scanner;
import javax.swing.*;

/** Primary driver for facial recognition using DB of faces loaded from a file.
 * Graphics window is created in which to display faces.
 */
public class Main {
    
    /** Graphics window inside JFrame on which to draw components */
    static DrawingWindow window;

    /** Default size for graphics window (within frame) */
    static final Integer WINDOW_WIDTH = 800;
    static final Integer WINDOW_HEIGHT = 480;

    public static void main(String[] args) { 
        
        Face f1 = new Face();
        Face f2 = new Face(f1);
        Face f3 = f1;
    
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        
        // If you want to read in only a few faces for testing purposes ...
        // String[] featureData = readFile('facetest.csv',10);

        // Read in csv file of facial features. 
        // Each face will be 1 line from the file.
        String[] featureData = FileIO.readFile("facetest.csv");
        // Convert the strings from the file into Face objects
        Face[] faces = buildDB(featureData);

        // Compare a randomly generated face to all faces in the DB
        // Find closest match
        Face randomFace = new Face();
        Integer bestIndex = findBestMatch(randomFace,faces);
        Face bestMatchCopy = new Face(faces[bestIndex]);

        // Get the graphics going - a popup window for displaying faces
        createGraphicsWindow();

        // Establishing placement of the 2 faces within the graphics window.

        /* The DrawingWindow draws every item in the array passed through objectsToDraw(). The graphics window uses DrawingObject.location to place the object within the graphics window. Three locations are being defined within the window: center, left of center and right of center.
        */
        Double left = (WINDOW_WIDTH)*.25 - 50;
        Double middle = (WINDOW_WIDTH)*.50 - 50;
        Double right = (WINDOW_WIDTH)*0.75 - 50;
        Double center = (WINDOW_HEIGHT-20)*.5 - 100;    // vertical center
        
        // index 0-1-2 is text. index 3 toMatch, 4 best, 5 worst
        DrawingObject[] objectsToDraw = new DrawingObject[6];

        FaceDrawing randomToDraw = new FaceDrawing(randomFace);
        
        // The random face to match displayed in center of graphics window
        objectsToDraw[1] = new Text("Face To Match",new Point(left,400));
        randomToDraw.location(new Point(left,center));
        objectsToDraw[2] = randomToDraw;

        FaceDrawing matchToDraw = new FaceDrawing(bestMatchCopy);
        // Best match is right of center        
        objectsToDraw[3] = new Text("Best Match",new Point(right,400));
        matchToDraw.location(new Point(right,center));
        objectsToDraw[4] = matchToDraw;

        // send objects to Drawing Window and render
        window.updateObjects(objectsToDraw);
        window.redraw();
    }

    /** Display all faces in graphics window
     * 
     * @param faces Collection of cartoon faces
     */
    public static void displayAll(Face[] faces) {
        // Establishing placement of the face within the graphics window.
        Double middle = (WINDOW_WIDTH)*.50 - 100;
        Double center = (WINDOW_HEIGHT-20)*.5 - 100;
        
        // index 0 is text and index 1 is face
        DrawingObject objectsToDraw[] = new DrawingObject[2];

        for (Face f : faces) {
            FaceDrawing dface = new FaceDrawing(f);
            // locate next face in center of window
            dface.location(new Point(middle,center));
            objectsToDraw[1] = dface;
            // label face with ID
            objectsToDraw[0] = new Text("Face ID#"+f.id(),new Point(middle,400));
            window.updateObjects(objectsToDraw);
            window.redraw(); 
            // pause between renderings. must be in a try to compile.
            try { Thread.sleep(400);
            } catch (Exception e) {}
        }
    }

    /** Finds best match for toMatch in faces using the Face.compare method.
     * The best match is the closest (or minimum) value returned from compare
     * 
     * @param toMatch Face object to which all are compared
     * @param faces Collection of faces
     * 
     * @return INDEX of the face that is closest to toMatch
     */
    public static Integer findBestMatch(Face toMatch, Face[] faces) {
        
        return 0;
    }
    
    /** Create pop-up graphics window in which all things are drawn.
     * 
     */
    public static void createGraphicsWindow() {
        
        JFrame f = new JFrame();
        window = new DrawingWindow(WINDOW_WIDTH, WINDOW_HEIGHT);
        f.setSize(WINDOW_WIDTH+20, WINDOW_HEIGHT+20);
        f.setTitle("Face Recognition");
        f.add(window);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    /** Convert data read from file into a database of faces.
     * The "DB" in this case is simply an array of faces
     * 
     * @param features[] Each element is comma-separated values representing a face
     * @return "DB" array of constructed faces
     */
    public static Face[] buildDB(String[] features) {
        // Initialize empty array of faces
        Face[] faces = new Face[features.length];
        // Convert each string of features into a Face object
        for (int i = 0; i < features.length; i++) {
            faces[i] = new Face(features[i]);
        }
        System.out.println("Built DB of "+faces.length+" faces.");
        return faces;
    }
}
