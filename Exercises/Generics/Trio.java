/** A set of 3 integers */
public class Trio {
    int first;
    int second;
    int third;

    /** Default constructor */
    public Trio() {
    }

    /** Constructor assigning all 3 elements
     * @param f first in the tuple
     * @param s second in the tuple
     * @param t third in the tuple
     */
    public Trio(int f, int s, int t) {
        first = f;
        second = s;
        third = t;
    }

    /** Copy constructor creating new tuple based on input parameter
     * @param toCopy Trio values to copy into new Trio
     */
    public Trio(Trio toCopy) {
        first = toCopy.first;
        second = toCopy.second;
        third = toCopy.third;
    }

    @Override
    public String toString() {
        return "["+first+", "+second+", "+third+"]";
    }

    /** Place the 3 elements in increasing order from first to third. */
    public void order() {
        int temp = second;
        if (second<first) {
            second = first;
            first = temp;
        }
        temp = third;
        if (third<second && third<first) {
            third = second;
            second = first;
            first = temp;
        } else if (third<second) {
            third = second;
            second = temp;
        }
    }

    //_______________________ SETTERS and GETTERS
    public int first() {
        return first;
    }
    public int second() {
        return second;
    }
    public int third() {
        return third;
    }
    public void first(int f) {
        first = f;
    }
    public void second(int s) {
        second = s;
    }
    public void third(int t) {
        third = t;
    }
}