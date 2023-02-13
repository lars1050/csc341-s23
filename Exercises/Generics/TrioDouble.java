/** A set of 3 doubleegers */
public class TrioDouble {
    double first;
    double second;
    double third;

    /** Default constructor */
    public TrioDouble() {
    }

    /** Constructor assigning all 3 elements
     * @param f first in the tuple
     * @param s second in the tuple
     * @param t third in the tuple
     */
    public TrioDouble(double f, double s, double t) {
        first = f;
        second = s;
        third = t;
    }

    /** Copy constructor creating new tuple based on input parameter
     * @param toCopy Trio values to copy doubleo new Trio
     */
    public TrioDouble(TrioDouble toCopy) {
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
        double temp = second;
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
    public double first() {
        return first;
    }
    public double second() {
        return second;
    }
    public double third() {
        return third;
    }
    public void first(double f) {
        first = f;
    }
    public void second(double s) {
        second = s;
    }
    public void third(double t) {
        third = t;
    }
}