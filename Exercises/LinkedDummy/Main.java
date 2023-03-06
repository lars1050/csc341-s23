public class Main {
    public static void main(String[] args) {
        testLinkedDummy();
        testLinkedCircular();
    }
    public static void testLinkedDummy() {
        Linked linked = new Linked();
        linked.add(0);  // {0}
        linked.add(1);  // {1,0}
        linked.append(2);   // {1,0,2}
        linked.append(3);   // {1,0,2,3}
        System.out.println(linked);

        linked.remove(); // {0,2,3}
        linked.pop();   // {0,2}
    }

    public static void testLinkedCircular() {
        LinkedCircular linked = new LinkedCircular();
        linked.add(0);  // {0}
        linked.add(1);  // {1,0}
        linked.append(2);   // {1,0,2}
        linked.append(3);   // {1,0,2,3}
        System.out.println(linked);

        linked.remove(); // {0,2,3}
        linked.pop();   // {0,2}
    }
}