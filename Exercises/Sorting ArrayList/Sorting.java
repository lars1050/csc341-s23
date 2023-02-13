import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        char first = 'z';
        char last = 'a';
        for (int i=0; i<20; i++) {
            list.add(new Student(String.valueOf(first),String.valueOf(last),i));
            first = (char)((int)first - 1);
            last = (char)((int)last + 1);

        }
        for (Student s: list) {
            System.out.println(s);
        }
    }
}