public class LinkedCircular {
    Node head;
    Node tail;

    public LinkedCircular() {
        // >>>>> FILL THIS IN!!
    }

    @Override 
    public String toString() {
        String results = "";
        Node n=head;
        while (n.next!=head) {
            n = n.next;
            results += n.value;
        }
        return results;
    }

    public void add(Integer v) {
        // add to the front of the list

    }

    public void append(Integer v) {
        // add to the end of the list

    }

    public Integer remove() {
        // remove the first element

        return null;
    }

    public Integer pop() {
        // remove the last element in the list

        return null;

    }

    class Node {
        Integer value = null;
        Node next = null;
        Node() {
        }
        Node(Integer v) {
            value = v;
        }
    }
}