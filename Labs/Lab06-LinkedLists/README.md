## Lab 6 : Linked Lists with Generics

Due: Thursday, March 9 end-of-day

In this lab, you will again be creating the ADT List, except this time you will be implementing it using a linked list.


### GENERAL REQUIREMENTS

It is important that you comment your code. The Javadocs has been completed for you.

Keep your code style compliant.

Answer the questions at the bottom of the requirements.

It is your responsibility to test your code. The provided `Main` tests much of the code, but not all the special circumstances.

<mark>**Special Constraints**:

  - You may not use for loops. Only while loops.

  - You may not keep a count of the elements in the list.

</mark>


#### LIST IMPLEMENTATION

Any method of a List should have the same behavior, regardless if implemented using an array or a linked list.

##### Helper Functions

- `public boolean empty()` determines whether or not there are any items in the List.

- `@Override public String toString()` overrides Object method for printing.

##### Constructors

- `public List()` default constructor.

- `public List(T[] toAdd)` create a new list and all the elements in the passed array to the List.


##### Find Methods

> Use the `equals` method to check for equality.
> Index 0 is the first element in the List.

- `public int locate(T item)` returns index of the first element that equals item or return -1 if not in List.

- `public T get(int index)` returns array element at that index or null if index is not valid.


##### Add and Set Methods

- `public void add(T item)` adds that item to the end.

- `public void add(int index, T item)` adds that item at the stated index or ignores the request if the index is not valid. The index is valid if there is currently an element at that index.


##### Remove Methods

- `public boolean remove(T item)` Removes the first occurrence that is equal to item (use the `equals` method). Returns true if it was successfully removed, otherwise false.

- `public T remove(int index)` Removes the element at that index (if the index is valid). Returns the element that was removed or null if nothing was removed.


##### Conversion Methods

- `ArrayList<T> toArrayList()` returns a new ArrayList that contains the List elements. If the list is empty, return an EMPTY ArrayList.

- `Object[] toArray()` returns an array that contains the List elements. If the list is empty, return an EMPTY array. NOTE: Use toArrayList and the built-in Java function `.toArray` of ArrayList. The return type must be Object because of the use of generics.


<hr>

> Do not forget to print and sign the CS Lab Submission Form. Bring it to class to turn in.

<hr>

#### Questions

1. Why is `class Node` private to the List?

2. The ADT _FIFO Queue_ adds elements to the end of the list and removes elements from the front of the list. The ADT _LIFO Stack_ adds and removes elements from the end of the list.

  a. Justify why a linked list is a better way to implement an FIFO Queue, rather than using an array. Consider all aspects including time and space efficiency and ease of implementation.

  b. Justify why an array is a better way to implement an LIFO Stack, rather than using a linked list. Consider all aspects including time and space efficiency and ease of implementation.
