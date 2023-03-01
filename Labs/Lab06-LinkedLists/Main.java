import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    List<String> slist = new List<>();

    String[] contents = {"a","b","c","d","e","f"};

    System.out.println("\n________________ Adding");
    for (int i=0; i<contents.length; i++) {
      slist.add(contents[i]);
    }

    System.out.println("\n________________ toString");
    System.out.println("expecting a b c d e f");
    System.out.println(slist);

    System.out.println("\n________________ Getting");
    System.out.println("expecting a b c d e f");
    for (int i=0; i<6; i++) {
      System.out.print(slist.get(i)+" ");
    }
    System.out.println();

    System.out.println("\n________________ Locating");
    System.out.println("expecting 0 1 2 3 4 5");
    for (int i=0; i<6; i++) {
      System.out.print(slist.locate(contents[i])+" ");
    }
    System.out.println();

    System.out.println("\n________________ Removing at index");
    // in the middle
    slist.remove(2);
    // the first one
    slist.remove(0);
    // the last one
    slist.remove(3);
    // not there
    slist.remove(5);
    System.out.println("expecting b d e");
    System.out.println(slist);

    System.out.println("\n________________ Adding at index");
    // the first one
    slist.add(0,"a");
    // in the middle
    slist.add(2,"c");
    // the last one
    slist.add(5,"f");
    // not there
    slist.add(10,"z");
    System.out.println("expecting a b c d e f");
    System.out.println(slist);

    System.out.println("\n________________ Removing item");
    // in the middle
    slist.remove("c");
    // the first one
    slist.remove("a");
    // the last one
    slist.remove("f");
    // not there
    slist.remove("w");
    System.out.println("expecting b d e");
    System.out.println(slist);

    System.out.println("\n________________ Converting");
    Integer[] numbers = {0,1,2,3,4,5};
    List<Integer> ilist = new List<>(numbers);
    System.out.println(ilist);

    ArrayList<Integer> arrayList = ilist.toArrayList();
    System.out.println("\n___________________ ArrayList");
    System.out.println(arrayList);

    Object[] array = ilist.toArray();
    System.out.println("\n___________________ Object[]");
    for (Object o: array) {
      System.out.print(o+" ");
    }
    System.out.println();
  }
}
