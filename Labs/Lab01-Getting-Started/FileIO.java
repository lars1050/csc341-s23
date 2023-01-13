import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIO {

    /** Read all the faces in the file
     * 
     * @param filename comma-separated values representing a face
     * @return String array - each element is facial features of one face
     */
    public static String[] readFile(String filename) {
        // passing null for size to indicate read all in the file
        return readFile(filename, null);
    }

    /** Read as many faces in the file as indicated by size.
     * 
     * @param filename comma-separated values representing a face
     * @param size The number of lines to read from the file
     * 
     * @return String array - each element is facial features of one face
     */    
    public static String[] readFile(String filename, Integer size) {
        
        String[] lines;
        
        // a null size means to read all faces in the file
        if (size == null) {
            // assumuing there are not more than 10000 faces in file
            size = 10000;
        }
        
        // create array to hold each line from file (as String)
        lines = new String[size];
        
        // track where to insert into lines
        int index = 0;

        // Read file using "try with resources"
        // When try-ing with resources, the system will manage the
        // closing of the file if anything goes wrong.
        try ( Scanner scanner = new Scanner(new File(filename))) {
            // Read first line of column headings
            scanner.nextLine();
            while (scanner.hasNextLine() && index < size) {
                // add line to array (used to instantiate a face later)
                lines[index] = scanner.nextLine();
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
        // We want the array to be full - no empty spaces
        if (index < size) {
            // resize the array so it is exactly the right size
            lines = resizeArray(lines,index);
        }
        System.out.println("Successfully read "+lines.length+ " lines from "+filename);
        return lines;
    }

    /** Create a file of random faces. It will have "size" lines, each representing a face.
     * 
     * @param filename File to write to -- this OVERWRITES the file!
     * @param size Number of random faces to store.
    */
    public static void makeFile(String filename, Integer size) {
        
        // Write file using "try with resources"
        // When try-ing with resources, the system will manage the
        // closing of the file if anything goes wrong.
        try ( FileWriter writer = new FileWriter(new File(filename))) {
            Face f;
            String toWrite;
            writer.write("width,height,eye_delta,eye_length,nose_length,nose_width,mouth_delta,mouth_length\n");

            for (int i=0; i<size; i++) {
                // add line to array (used to instantiate a face later)
                f = new Face();
                toWrite = f.width()+","+f.height()+","+f.eyeDelta()+",";
                toWrite += +f.noseLength()+","+","+f.mouthDelta()+"\n";
                writer.write(toWrite);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
    
    /** Resize the array so that every array element has a face in it.
     * 
     * @param array Each element is a face or null
     * @param size Copy over only "size" faces into the new array
     * @return New array that is full (no null elements)
     */
    public static String[] resizeArray(String[] array, int size) {
        String[] newArray = new String[size];
        for (int i=0; i<size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
