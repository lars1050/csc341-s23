public class Linked<T extends Comparable<T>> {

    /** Reference to the first element of the list */


    /** Reference to the last element of the list */


    /** Default constructor */
    public Linked() {

    }

    /** Empty? */
    public boolean isEmpty() {
        // How to check for emptines??
        
        return true;
    }

    @Override
    public String toString() {

        String list = "";

        return list;
    }

    public void addFront(T item) {

    }

    public void addEnd(T item) {

    }

    private class Node {

        /** Value contained within this */

        /** Node next in the chain of nodes */

        /** Default constructor */
        Node() {

        }
    }
}