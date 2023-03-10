import java.util.*;

class List<T extends Comparable<T>> {

    /** Count of elements in the List */
    int count = 0;

    /** Comparator for ordering tree. Uses compareTo of T by default */
    Comparator<T> ordering = new Comparator<T>() {
        @Override
        public int compare(T object1, T object2) {
            return object1.compareTo(object2);
        }
    };

    /** Sentinal for leaf nodes. This node should be both the left and right child of all leaf nodes */
    Node dummy = new Node();

    public List() {
    
    }

    public List(Comparator<T> c) {
        ordering = c;
    }


    public void toString() {

    }
  
    public void add(T item) {
    
    }
    
    public T find(T value) {
        return false;
    }
    
    public T find(T value, Comparator<T> comp) {
        return false;
    }
    
    public T min() {
        return null;
    }

    public T max() {
        return null;
    }

    T[] toArray() {
        return null;
    }

    // if needed, add getters and/or setters

  } // end class List
