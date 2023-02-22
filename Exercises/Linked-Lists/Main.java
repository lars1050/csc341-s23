public class Main {

    public static void main(String[] args) {

        Linked<String> list = new Linked<>();
        
        list.addFront("A");
        list.addEnd("B");
        list.addFront("C");
        list.addEnd("D");

        System.out.println("The linked list (in order) is:");
        System.out.println(list);
    }
}