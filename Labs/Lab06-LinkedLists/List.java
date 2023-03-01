import java.util.ArrayList;

/**
ADT List using Generics maintains a List of elements. Order of the elements is preserved with respect to where they were added to the List.
 */
public class List<T> {

  /** Reference to first element of the list. */
  private Node head = null;

  /** Reference to last element of the list. */
  private Node tail = null;


  /** Default constructor */
  public List() {

  }

  /** Constructor to add multiple elements at initialization.
  * @param toAdd array of elements added in order to the List.
  */
  public List(T[] toAdd) {

  }

  // ____________________ HELPERS

  /** Reports status of List. */
  public boolean empty() {
    return true;
  }

  @Override
  public String toString() {
    return null;
  }

  // ____________________ FIND

  /** Determine location of specified item (0-based indexing).
  * @param item searching for in List.
  * @return if item in List, return location, else return -1
  */
  public int locate(T item) {
    return -1;
  }

  /** Retrieve element at specified index, without removing it.
  @param index Location within the list (0-based indexing)
  @return if index valid, return element at that position, else null
  */
  public T get(int index) {
    return null;
  }

  // ____________________ ADD

  /** Add specified item to the end of the List.
  * @param item added to the List.
  */
  public void add(T item) {

  }

  /** Add specified item to the List at specified location (if index valid)
  @param index Location within the List (0-based indexing)
  @param item added to the List
  @return if item added, returns true, else false.
  */
  public boolean add(int index, T item) {

    return false;
  }


  // ____________________ REMOVE

  /** Remove specified item if in the List
  * @param item Removed from the List (if in the List)
  * @return if item removed, return true, else false
  */
  public boolean remove(T item) {
    return false;
  }

  /** Remove item at specified index (if index valid)
  @param index Location with List (0-based indexing)
  @return if index valid, return element at that index.
  */
  public T remove(int index) {
    return null;
  }


  // ____________________ CONVERT

  /** Place List items into a new ArrayList.
  * @return ArrayList with List items
  */
  public ArrayList<T> toArrayList() {
    return null;
  }

  /** Place List items into a new array.
  * @return array of List items of the same length as elements in the array
  */
  public Object[] toArray() {
    return null;
  }

  // ____________________ NODE class _______________________
  // _______________________________________________________

  /** Node for a singly linked list */
  private class Node {
    // Hold a List item
    T value;
    // Reference to the next element in the list.
    Node next;

    // Only constructor for a new Node
    Node(T v) {
      value = v;
    }
  }
}
