import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Student {
    
    static int nextId = 100100;
    static int nextId() {
        ++nextId;
        return nextId;
    }
    int id;
    String first;
    String last;
    Integer credits;

    Student(String f, String l, Integer c) {
        id = nextId();
        first = f;
        last = l;
        credits = c;
    }

    public String toString() {
        return "["+id+"] "+last+", "+first + ". Credits "+credits;
    }

    public String first() {
        return first;
    }
    public String last() {
        return last;
    }        
    public Integer credits() {
        return credits;
    }
}
