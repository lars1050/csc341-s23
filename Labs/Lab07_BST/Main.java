import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

/** Primary driver for facial recognition using DB of faces loaded from a file.
 * Graphics window is created in which to display faces.
 */
public class Main {

    public static void main(String[] args) {

        // Read in csv file of tracks.
        // Each track will be 1 line from the file.
        ArrayList<String> csvData = readFile("top50.csv");

        // Convert the strings from the file into Track objects
        List<Track> tracks = new List<Track>();
        buildDB(tracks,csvData);

        // example
        Order.byArtist byArtist = new Order.byArtist();
    }


    /** Convert data read from file into a database of tracks.
     * The "DB" in this case makes use of the List implemented
     * with a Binary Search Tree (BST)
     *
     * @param lines[] Each element is comma-separated values representing a face
     * @return "DB" array of constructed faces
     */
    public static void buildDB(List<Track> tracks, ArrayList<String> data) {
        // Convert each string of information into a Track object
        for (String s: data) {
            Track t = new Track(s);
            System.out.println("Adding "+t);
            tracks.add(t);
        }
    }

    /** Read as many faces in the file as indicated by size.
     *
     * @param filename comma-separated values representing a face
     * @param size The number of lines to read from the file
     *
     * @return String array - each element is facial features of one face
     */
    public static ArrayList<String> readFile(String filename) {

        ArrayList<String> lines = new ArrayList<>();

        // Read file using "try with resources"
        // When try-ing with resources, the system will manage the
        // closing of the file if anything goes wrong.
        try ( Scanner scanner = new Scanner(new File(filename))) {
            // Read first line of column headings
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                // add line to array (used to instantiate a track later)
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
        return lines;
    }
}
