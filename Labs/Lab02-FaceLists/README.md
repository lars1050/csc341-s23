### Lab 2 : Building a LIST Abstract Data Type
#### Due Thursday, January 26 end-of-day
#### Submit a single zipped file to Moodle

In this lab, you will again be working with a database of cartoon faces that can be used for facial recognition.
In Lab01, the _database_ was a basic array with a fixed size. After the initial filling of the array to construct
the database, there were no modifications to the array. This is not a reasonable assumption, and you need
to create a data structure that is easy to access and modify. 

In this initial work on data structures, you will create an abstract data type (ADT) *List*, similar to 
the `ArrayList<>` in the Java collections, but it will exclusively store *Face* objects. In subsequent labs, you
will enhance functionality of the *List* class, and eventually create a generic ADT class that is capable of storing any type of object.

Look for "TODO" in the code, which highlights what you need to implement.

Learning Outcomes:

- Understand and implement the primary operations that add and find elements in a _List_ implemented with an array.
- Understand the practice of _Test-Driven Development_.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

### Getting Started

General Requirements:

1. Complete the methods that perform the primary operations of adding and finding elements in the List.
2. Write tests to verify code.
3. Document all code with Javadocs.

<hr>

### LISTS

The Abstract Data Type (ADT) **_List_** refers to a collection of elements, which is maintained with primary operators that add, remove, find, and sort elements. In your reading, they distinguish between a list, bag, and set. I make no such distinctions and refer to all of them as a List, but I will be specific in whether or not those elements are unique (i.e. a set) or in a sorted order. The operators applied to a list must be specified by the user, unlike with queues in which elements are added and removed from specific locations.

It is important to have a shared understanding of the list qualities and how the operators modify the list. For this lab:
- The list may have duplicate elements. 
- The list is not sorted.
- If positional information is not provided, the `add()` method will add after the last element in the list, as long as the list is not full.
- If positional information is provided, the `add()` method will add at the INDEX indicated, shifting elements to make room, as long as the index is valid.

#### Javadocs Documentation

4. AS you are coding, add javadocs comments where appropriate. Documentation for javadocs can be found here:
    - [https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html]
    - [https://www.tutorialspoint.com/java/java_documentation.htm]

    _Where Appropriate_ means that ...
    - all classes have a javadoc comment above its definition
    - all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    - most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.

5. When complete, generate javadocs and inspect your work. To generate javadocs from the command line, create a `docs` folder inside the Lab02 folder. Compile javadoc comments from within that folder. This will generate a collection of web pages. At the command prompt, it looks like this:
  ```
  mkdir docs
  cd docs
  javadoc ../*.java
  ```
  You can view the results by opening the index.html file in your browser.

#### MISCELLANEOUS

Implement the following ...

6. `Boolean full()` determines whether or not there is capacity for more faces.
7. `Boolean empty()` determines whether or not there are any faces in the List.
8. `Boolean valid(int index)` determines if the given index corresponds to an element stored in the List.

#### GET Method

9. Implement the `get(int index)` method.
    - If the index is valid, return the element at that index. It should not be removed, just returned.
    - If the index is not valid, <del>print an error message and</del> return null.

#### ADD Methods

10. Implement the add method `add(Face face)`.
    - If the structure is not full, add to the end of the list. (The _end_ of the list refers to the last element in the list.)
    - If the structure is full, ignore the request. Do not add anything to the list.
    - Maintain the count.

11. Implement the add method `add(int index, Face face)`.
    - If the index is invalid (i.e. there is not a current element at the specified index), ignore it. Do not add the face to the list.
    - If the structure is not full and the index is valid, add the element at the index indicated.
    - Shift all elements as appropriate BEFORE adding the element to make space for it.
    - If the structure is full, ignore the request. Do not add anything to the list.
    - Maintain the count.

> Note that ignoring the request without providing feedback to the user is not good practice. Typically, we would throw an exception, but we might work on that later in the semester.

<hr>


#### LOCATE Methods

15. Implement the `locate(Face face)` method.
    - If the face is in the list, return its index.
    - If the face is not in the list, return -1 (no error message required).

<hr>

#### CONVERT Methods

16. Implement `Face[] toArray()`. It creates an array of the size of the number of elements stored. All elements are copied into the 
array in the order they appear in the List.



#### QUESTIONS

1. What is the best- and worst-case scenarios with respect to time for `add(int,Face)` and how do they compare with respect to the number of elements that are in the list?
In other words, where in the array is it most efficient to add and where in the array is it least efficient to add; and how would you **quantify** the best and worst?

2. Consider a data structure that is like a list, but that there is no expectation that an element stays in the same order. Then, in the remove operation elements would not have to be shifted to close the gaps. Instead, the location of the removed element would be set to null. Write the algorithm* for the add(Face f) method that adds that face to the first open slot. For example, if the array had the values {3,4,null,5,7,1,null,null,2,3}, an element would be added to the right of 4 (at index 2).

* Write the algorithm using pseudocode to demonstrate the logic. You can use Java if you like, but I am only interested in the logic, not the syntax.

3. Consider a REMOVE algorithm that specifies the index of the element to be removed applied to the scenario described in #2. State why this remove method can be much less efficient than the remove method for when elments must be shifted. CLUE: Consider an array with these values: {null,null,null,null,null,2,3}
