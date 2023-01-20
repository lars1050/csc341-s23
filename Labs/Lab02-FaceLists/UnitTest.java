/**
 *
 * @author amylarson
 */
public class UnitTest {

    public static void test(Object expected, Object results, String msg) {

        // Use a flag to indicate a match between expected and results
        boolean match;

        // Test if either or both are a null object
        if (expected==null && results!=null) {
            match = false;
        } else if (expected==null && results==null) {
            match = true;
        } else if (!expected.equals(results)) {
            match = false;
        } else {
            match = true;
        }

        if (!match) {
            System.out.println("FAIL "+msg); 
            System.out.println("       expected "+expected+", results "+results);
        }        
    }

    public static void test(Double exp, Double res, Double threshold, String msg) {
        // Use a flag to indicate a match between expected and results
        boolean match;

        // Test if either or both are a null object
        if (exp == null && res != null) {
            match = false;
        } else if (exp == null && res == null) {
            match = true;
        } else if (Math.abs(exp-res) > threshold) {
            match = false;
        } else {
            match = true;
        }

        if (!match) {
            System.out.println("FAIL "+msg); 
            System.out.println("       expected "+exp+", results "+res);
        } 
    }
}