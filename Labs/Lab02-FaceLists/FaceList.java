/** A collection of Face objects listed in no particular order. */
public class FaceList {

    /** Primary structure for storing the collection of Faces*/
    protected Face[] faces;

    /** Default for maximum number of faces that can be stored */
    protected static final int DEFAULT_CAPACITY = 100;

    /** The number of faces stored in the array. */
    private int length = 0;

    // ____________________________________________________
    //              CONSTRUCTORS
    // ____________________________________________________

    /** Constructor creates List with user-specified capacity
     * @param size The capacity of the list (i.e. max number of elements)
     */
    public FaceList(int capacity) {
        faces = new Face[capacity];
    }

    /** Default Constructor */
    public FaceList() {
        this(DEFAULT_CAPACITY);
    }

    // ____________________________________________________

    @Override
    public String toString() {
        // Create numbered list of Faces in the collection
        String printedList = "";
        for (int i = 0; i < length; i++) {
            printedList += (i + 1) + ". " + faces[i].toString() + "\n";
        }
        return printedList;
    } // end toString()
    

    // ____________________________________________________
    //              LIST STATUS METHODS
    // ____________________________________________________

    /**
     * 
     */
    public boolean full() {
        /** TODO: fix this (can be 1 line of code) */
        return true;
    }

    /**
     * 
     */
    public boolean empty() {
        /** TODO: fix this (can be 1 line of code) */
        return true;
    }

    /**
     * 
     */
    private Boolean valid(int index) {
        /** TODO: fix this (a few lines of code) */
        return true;
    }


    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

    /**
    */
    public void add(Face face) {
        // Default location for adding a face is at the end of the array
        // Add only if it is not full

    } // end add(Face)

    /**
    */
    public void add(int index, Face face) {
        /** TODO: write this */
        // Add at index only if it is a valid index AND the array isn't full.
        // All elements must be shifted to make room for the new item.
        // HINT: start shifting at the end until you get to where you want to add

    } // end add(index,face)

    // ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

    /**
    */
    public int locate(Face face) {
        /** TODO: write this */
        // Determine the location of the specified face (its index)
        // Use the isEquals to match faces.
        // Return -1 if it is not in the List

        return -1;

    } // end locate()

    /**
    */
    public Face get(int index) {
        /** TODO: write this */        
        // Return the face at the given index, if index is valid
        // Return null if index invalid
        // Do not remove the Face, just return it

        return null;

    } // end get()

    // ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________

    /**
    */
    public Face[] toArray() {
        // TODO: write this
        // create a new array and copy the contents of the list into the array
        // if the list is empty, return null;
        // else return an array of the exact length as the List

        return null;

    } // end toArray()

    // ____________________________________________________
    //                   SETTERS AND GETTERS
    // ____________________________________________________

        public int length() {
            return length;
        }
    
        public int capacity() {
            return faces.length;
        }

} // end class List
