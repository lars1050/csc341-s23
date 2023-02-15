### Lab 4 : Binary Search with Sorted List

Due: Thursday, February 23 end-of-day

In this lab, you will modify your Lab 4 List class to one that maintains a sorted list and uses binary search. There are questions for this lab that you will find at the bottom of this document.

<hr>
To get started, create a Lab 5 folder and copy over your List.java file. If you have any test files or a main, that might also be useful.

If your Lab 4 is not working, please come to office hours so that we can fix it and get you ready for Lab 5.

### Implementation Requirements of Lab 5

The compiler needs to know what is meant by "sorted" for a user-defined class. This can be established by implementing the Comparable or Comparator interfaces. For the List class, the order of the elements will be determined by the Comparator `orderBy`. If it is not defined, then the comparator is set to the type T's compareTo method. In other words, the default ordering is established by the `compareTo()` method of the type being stored in the List.

Add this member variable and initialize as shown.

```Java
/** Comparator for ordering array. Uses compareTo of T by default */
private Comparator<T> orderBy = new Comparator<T>() {
    @Override
    public int compare(T object1, T object2) {
        return object1.compareTo(object2);
    }
};
```

#### REMOVE THESE METHODS from Lab 4

- `public void add(int index, T item)`. The list must maintain order, so we cannot allow users to insert at specific locations.

- `public void set(int index, T item)`. The list must maintain order, so we cannot allow users to set a value at a specific location.

- `public int removeEach(T item)`. You may remove this or leave it in if you like. I will not run any tests on this one.


#### ADD THESE METHODS

- Constructor `public List(Comparator<T> order)`. Set the orderBy member variable to this comparator.

- Add `public int locateIterative(T item)`. It uses using binary search based on the orderBy member variable. **Note** that you cannot use `equals` to locate the item, because you are using a different ordering. Instead, check if the compare() method returns 0.

- Add `public int locateRecursive(T item)`. This is the same as locate, but it uses a recursive version of binary search. It does not make sense to have multiple implementations for the same functionality, but I want you to have experience with all approaches.

- Add `public T min(Comparator<T> order)`. Find the minimum value based on the given comparator. **Note** this is essentially the `min()` of Lab 4 using a different method of comparison.

- Add `public T max(Comparator<T> order)`. Find the maximum value based on the given comparator. **Note** this is essentially the `max()` of Lab 4 using a different method of comparison.

- Add `public T[] toArray(Comparator<T> order)`. Return an array with the values of List, ordered by the passed Comparator. **NOTE** that you need to sort the array.

- Add `public void setOrder(Comparator<T> order)`. This will set the `orderBy` member variable. It then needs to sort the list based on this new comparator.

#### MODIFY THESE METHODS from Lab 4

- Modify `public void add(T item)` so that it maintains the order based on the Comparator `orderBy`.

- Modify `public T min()` so that it is based on how the list is sorted. HINT: no need to iterate.

- Modify `public T max()` so that it is based on the list is sorted. HINT: no need to iterate.

<hr>

### Other Requirements

Keep your code style compliant. Clean. Organized.

Document your code with Javadocs and code comments.

<hr>

### QUESTIONS for Lab 5

1. If the List is {2,2,5,8,10,11,15,18,22,45,60}:
  a. The call `locate(12)` using binary search will compare 2 to which values?
  b. The call `locate(25)` using binary search will compare 25 to which values?

1. If the List has 50,000 elements and you are looking for -3, which is not in the list, approximately how many elements will you compare to -3 if you are using binary search? How many elements will you compare to -3 if you are using linear search?

1. The worst-case runtime bound for `locate()` using linear search is O(n). The worst-case runtime bound for `locate()` using binary search is O(lg n), which is waaay better than O(n). Under what situation would you use linear search over binary search, despite the runtime bound?

1. Why is it necessary to use a linear search when searching for an item based on the comparator passed to `locate()` even though the List is sorted (as opposed to using the binary search)?

<hr>

> Do not forget to print and sign the CS Lab Submission Form. Bring it to class to turn in.
