public class Main {

    public static void main(String[] args) {
        Trio<Integer> trio = new Trio<>(3,2,1);
        System.out.println(trio);
        trio.order();
        System.out.println(trio);

        Trio<MyClass> triomc = new Trio<>(new MyClass(0,1), new MyClass(2,3), new MyClass(4,5));
        System.out.println(triomc);

        TrioDouble triod = new TrioDouble(3.5,2.7,1.2);
        System.out.println(triod);
        triod.order();
        System.out.println(triod);
    }
}