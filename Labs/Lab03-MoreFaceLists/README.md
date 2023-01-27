### Lab 3 : Continuing to Building a LIST ADT
#### Due Thursday, February 2 end-of-day
#### Submit a single zipped file to Moodle

In this lab, you will continue your work of Lab 2.

> If your Lab 2 is not functional, please let Dr. Larson know.

Learning Outcomes:

- Understand and implement the primary operations of a _List_ implemented with an array.
- Understand the practice of _Test-Driven Development_.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

### Getting Started

General Requirements:

1. Complete the methods outlined below. These are in addition to those implemented in Lab 1.
2. Write tests for findLast.
3. Document all code with Javadocs and with comments in the code (about every 3-4 lines).

<hr>

#### Javadocs Documentation

1. AS you are coding, add javadocs comments where appropriate. Documentation for javadocs can be found here:
    - [https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html]
    - [https://www.tutorialspoint.com/java/java_documentation.htm]

    _Where Appropriate_ means that ...
    - all classes have a javadoc comment above its definition
    - all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    - most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.

1. When complete, generate javadocs and inspect your work. To generate javadocs from the command line, create a `docs` folder inside the Lab02 folder. Compile javadoc comments from within that folder. This will generate a collection of web pages. At the command prompt, it looks like this:
  ```
  mkdir docs
  cd docs
  javadoc ../*.java
  ```
  You can view the results by opening the index.html file in your browser. Look for any missing or unprofessional looking documentation. Do not include implementation details in the documentation.

<hr>

### IMPLEMENTATION

> If your Lab 2 implementation is not complete, check with Dr. Larson before proceeding. If Lab 2 is not yet complete, you probably do not want to duplicate the Lab 2 folder for Lab 3.

Start the implementation by duplicating the Lab 2 folder in your working directory and renaming it. Pull the course repo to get 2 files: `FaceListContinued.java` and `TestLab3.java`. 

The first file includes stubs of all the methods that are required for Lab 3 (in addition to those in Lab 2). Retype them or copy them into the `FaceList.java` file. Please keep the methods organized, grouping together related behaviors. Setters and getters are typically placed at the bottom of any class file.

Copy over the `TestLab3.java`.

Implement the following methods. As before, the first element is at index 0 and the last is at length-1. When an element is removed, items to the right must be moved over.

#### REMOVE Methods

1. `Face remove(int index)` If index is valid, remove that element from the List and return it.
1. `Boolean remove(Face face)` Return true if the face was found and removed. False otherwise.
1. `void removeAll()` Remove all elements from the List (changing the length will take care of this).

#### SEARCH Methods

1. `int findLast(Face face)` Return the index of the last element that _equals_ the specified face or return -1 if it is not in the List.
 
#### ADD Methods

1. `int addAll(Face[] array)` Add to the List as many elements of the array as possible, starting at index 0 of the passed array. Return the total number added to the List.

#### CONVERT Methods

1. `int toArray(Face[] array)`
    - If all of the elements in the List will fit into the array, then place them all and return the number of elements placed in the array.
    - If they do not all fit, do not place any faces in the array and return 0.
    - Assume that the array is empty and start to fill it at index 0.

1. `FaceList sublist(int start, int end)` 
    - If the start or end are not valid indices, return null.
    - Else, Create a new FaceList that has capacity to hold 2x as many elements as needed to hold the specified sublist. For example, if the user passed 10 and 19 as the start and end indices (which is 10 elements), then create a FaceList with capacity 20. Then add all of the elements from start to end (inclusive) into this new List.

<hr>

### UNIT TESTS

In the file `TestLab3.java` in the method `testLast()` at the bottom of the file, write 4 tests to test the FaceList method `findLast(Face face)`. These should cover the following cases:

- The List contains exactly 1 occurrence of this face and it is the last element in the list.
- The List contains exactly 1 occurrence of this face and it is the first element in the list.
- The List does not contain this face.
- The List contains exactly 2 occurrences of this face and they are located in the middle of the list. Make a test List that has at least 6 faces in it and make sure the 2 identical faces are not next to each other.


#### QUESTIONS

1. Why is it not appropriate to have implementation details in the Javadocs documentation?

2. You were asked to create a test list for getLast that contained duplicates of the face passed to the method. Why is it important to have a test List for this method that has duplicate items?

3. When analyzing the efficiency of an algorithm, we can count the number of times an element in the List is "visited" or "modified", meaning the value is retrieved. For example, when the value is compared to another or it is reassigned to another location. Keep in mind that if an element is both compared to another and moved, this is counted as 2. For any given algorithm, we can consider the worst-case to be the maximum number of elements visited or modified; the best-case is the minimum number of elements visited or modified. For example, for the `add(int index, Face face)`, the best-case is when the index is at length-1, and the worst-case is when the index is 0.

    - Consider the `remove(Face face)` method that finds the face, then removes it. What is the worst-case and best-case scenario (meaning where is this face located) **if the iteration of the array starts at index length-1 and iterates towards index 0?** Briefly justify both cases.

    - Consider the `remove(Face face)` method that finds the face, then removes it. What is the worst-case and best-case scenario (meaning where is this face located) **if the iteration of the array starts at index 0 and iterates towards index length-1?** Briefly justify both cases.
    
     


