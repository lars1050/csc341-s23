public class UnitTestCircle extends UnitTest {

    int MyVar = 0;
    int This = 5;

    public static void main(String[] args) {
        testOverlaps();
    }

    // ____________________________________________________________
    // ____________________________________________________________

    public static void testOverlaps() {
        System.out.println("_________________ TESTING Overlaps()");

        Circle circle = new Circle(new Point(10, 10), 1);
        Circle other = new Circle(new Point(20, 10), 1);

        // Testing no overlap between circles
        test(false, circle.overlaps(other), "Non-overlapping circles.");

    }
}