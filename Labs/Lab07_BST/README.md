## Lab 07 Binary Search Trees

DUE Tuesday, March 28

In this lab, you will again create the Abstract Data Type List, except this time you will use a Binary Search Tree for implementation. The List will make use of generic types that implement the interface Comparable.

Learning Outcomes:
- Understand the structure of a binary tree.
- Understand the structure of a binary search tree.
- Know how to implement a binary search tree.
- Know how to implement a class that uses the Comparator interface.
- Use iteration to traverse a binary search tree.
- Use recursion to traverse a binary search tree.

> If you are searching for an element based on the ordering of the tree, then you can use binary search. However, if you need to access every element in the tree or perform a "linear" search, you must use recursion. This is the ONLY way to traverse the tree (unless you maintain your own stack, which we will not do until a few weeks from now).


<hr>

### Type Track

Part of this assignment will be to implement Comparators for the class Track. These will be used as orderings for the binary search tree. Track has the following member variables to identify a track/song.

- String title;
- String artist;
- String genre;
- Integer danceability;
- Integer decibels;
- Integer popularity;
- private Integer id;


### General Requirements

Note that in this implementation, you will be using a "dummy" or sentinal node to mark the bottom of the tree. Use the SAME dummy node as both the left and right child of all leaf nodes.

1. Implementation
- `int compareTo(Track other)` in class Track. Use the ID as the basis of comparison.
- `boolean equals(Object other)` in class Track. Use the ID.
- `public static class byTitle` in file Order.
- `public static class byDanceability` in file Order. Use the song title as a tie-breaker.

1. `class Node`. This should have 2 constructors: default and one with a T parameter.

1. Implementation for class List
- `void add(T value)`

- `void toString()` : Create a string of values in order

- `T find(T value)` : Use List ordering to find first match. Note that it will only match on the basis of the ordering. For example, if it is ordered by Artist, then the first element that matches the Artist in value will be returned.

- `T find(T value, Comparator<T> comp)` : use the passed Comparator to find the first element that matches the value. As stated above, this will find the first match (based on the List ordering) that matches on the basis of `comp`.

- `T min()` : based on order of tree

- `T max()` : based on order of tree

- `T[] toArray()` : place elements in the tree into the array IN SORTED ORDER. You cannot use any Java functions to do this for you. You must declare the array, and individually place each element into the array. **This is a challenging method to write! You have to keep track of where the next element is to be added. It will have to be passed around as you traverse the tree (recursively).

1. Javadocs: complete and polished for `class List`.
1. Code is commented in all methods of `class List`.
1. Code is style compliant.
1. Questions answered in report.txt.

It is your responsibility to make sure your code is working.

<hr>

### Answer Questions

1. What is the worst-case scenario of `find(T value)` and of `find(T value, Comparator<T> comp)`? Briefly describe the situations that produces these worst-case scenarios. Would you characterize each as linear, logarithmic, or constant with respect to the size of the collection? 

2. What is the best-case and worst-case scenario for `add(T value)` for a BST? Briefly describe the situations that produces these best- and worst-case scenarios. Would you characterize each as linear, logarithmic, or constant with respect to the size of the collection? 

3. What are the differences in space requirements for a Binary Search Tree implementation of a List versus an array implementation?

4. Imagine you are frequently adding new customers to your dataset. On occasion, you have to print a report of all customers in alphabetical order. What would be the best choice for implementing the List of customers? Would you use an array, alphabetically sorted array, linked list, alphabetically sorted linked list, or a binary search tree? Briefly justify by commenting on each of these implementations and why you think it would or would not be a good implementation.

### Resources 

- https://www.kaggle.com/datasets/leonardopena/top50spotify2019
- https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
- https://www.geeksforgeeks.org/comparator-interface-java/
- https://www.baeldung.com/java-comparator-comparable
- https://www.geeksforgeeks.org/comparator-interface-java/
- zyBooks reading assignment #07










