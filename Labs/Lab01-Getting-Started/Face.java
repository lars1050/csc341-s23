
/**
 *
 * @author larson amy c
 */
import java.util.Random;

public class Face {

    /** Count instantiations to generate unique id **/
    private static Integer faceCount = 0;

    /** Unique ID per face. Set by instantiation **/
    private Integer id;

    /*** Face height in pixels **/
    private int height;

    /*** Face width in pixels **/
    private int width;

    /** distance from midline to edge of eye **/
    private int eyeDelta;

    /** length of nose along vertical center of face **/
    private int noseLength;

    /** distance from end of nose to top of mouth **/
    private int mouthDelta;

    private Random rand = new Random();

    /**
     * Provide id based on instantiations.
     *
     * @return current faceCount (then increment count)
     */
    public static Integer getID() {
        return faceCount++;
    }

    /**
     * 
     */
    public Face() {
        id = getID();

        // head dimensions
        width = rand.nextInt(100) + 100;
        height = rand.nextInt(100) + 110;
        eyeDelta = rand.nextInt(25 - 7) + 7;
        noseLength = rand.nextInt(45 - 20) + 20;
        mouthDelta = rand.nextInt(13 - 3) + 3;
    }

    /**
     * 
     */
    public Face(int h, int w) {
        id = getID();
        height = h;
        width = w;
    }

    /**
     * 
     */
    public Face(String dims) {
        id = getID();
        String[] values = dims.split(",");
        width = Integer.valueOf(values[0]);
        height = Integer.valueOf(values[1]);
        eyeDelta = Integer.valueOf(values[2]);
        noseLength = Integer.valueOf(values[4]);
        mouthDelta = Integer.valueOf(values[6]);
    }

    /** Copy constructor - creates new based on another
     * @param toCopy is face to copy (creating a new object)
     */
    public Face(Face toCopy) {
        id = toCopy.id;
        width = toCopy.width;
        height = toCopy.height;
        eyeDelta = toCopy.eyeDelta;
        noseLength = toCopy.noseLength;
        mouthDelta = toCopy.mouthDelta;
    }
    
    @Override
    public String toString() {
        String toPrint = super.toString() + " = " + id+" [";
        toPrint += width+", "+height+", "+eyeDelta+", "+noseLength+", "+mouthDelta;
        toPrint += "]";
        return toPrint;
    }
    

    // ============================ vvvvvvvvvvvvv COMPLETE THIS vvvvvvvvvvv
    /**
     *
     */
    public double compare(Face other) {
        /*
        RATIOS to calculate:
        a. face width / face height
        b. Distance between two eyes (eye_delta*2) / face width
        c. nose length / face height
        d. Distance between nose and mouth (mouth_delta) / face height. 
         */

        // TODO: Complete this class method. MAKE SURE YOUR TYPE IS CONSISTENT!!

        return 0;
    }
    // ============================ ^^^^^^^^^^^^^^ COMPLETE THIS ^^^^^^^^^^^^^




    //___________________________________________________________________________________-
    // Getters and Setters below.
    // These do not need Javadocs documentation.

    public int height() {
        return height;
    }

    public void height(int height) {
        this.height = height;
    }

    public int width() {
        return width;
    }

    public void width(int width) {
        this.width = width;
    }

    public int eyeDelta() {
        return eyeDelta;
    }

    public void eyeDelta(int eye_delta) {
        this.eyeDelta = eye_delta;
    }

    public int noseLength() {
        return noseLength;
    }

    public void noseLength(int nose_length) {
        this.noseLength = nose_length;
    }

    public void mouthDelta(int value) {
        mouthDelta = value;
    }

    public int mouthDelta() {
        return mouthDelta;
    }

    public Integer id() {
        return id;
    }
}
