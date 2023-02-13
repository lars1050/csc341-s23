public class UnitTestCircle extends UnitTest {

    int MyVar = 0;
    int This = 5;

    public static void main(String[] args) {
        testOverlaps();
        testAngle();
    }

    // ____________________________________________________________
    // ____________________________________________________________

    public static void testOverlaps() {
        System.out.println("_________________ TESTING Overlaps()");

        Circle circle = new Circle(new Point(10, 10), 1);
        Circle other = new Circle(new Point(20, 10), 1);

        // Testing no overlap between circles
        test(false, circle.overlaps(other), "Non-overlapping circles.");

        test(true,circle.overlaps(circle),"Same circle.");

        circle = new Circle(new Point(0,0),10);
        other = new Circle(new Point(5,0),10);
        test(true,circle.overlaps(other), "Overlapping circles at the x-axis.");

    }

    public static void testAngle() {
        System.out.println("_________________ TESTING angleBetween()");

        Circle circle = new Circle(new Point(),);
        Circle other = new Circle(new Point(),1);
                

    }
}