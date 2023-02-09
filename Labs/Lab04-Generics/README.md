### Lab 4 : Generics and Comparables

Due: Monday, February 13 end-of-day

In this lab, you will transform your FaceList class to the List<T Comparable<T>> class that uses _generics_. There are also enhancements to the functionality that you will implement. And you will create a class that implements the `Comparable` interface and overrides the `equals()` method. Finally, you will look closely at your code style and ensure that it meets the Google Style Guide: https://google.github.io/styleguide/javaguide.html.

There are not any questions for this lab specifically. Instead, there is a separate substantial written homework with questions about ADTs, Lists, and Java Objects that is due Friday, February 10 end-of-day.

<hr>

This is an overview of the changes or new requirements:

##### New Methods

- `List(List<T> toCopy)`
- `increaseCapacity(int size)`
- `removeEach(T item)`
- `List(T[] toAdd)`
- `min()`
- `max()`
- change `pubic boolean full()` to `private boolean full()`.
- change any add methods so that if capacity is reached, the size is increased.
- use `equals()` for any method that is searching for an item. Do not use `==`.


#### New Class

Implement `class Simple implements Comparable<Simple>`
- `public int compareTo(Simple other)`
- `@Override public boolean equals(Object other)` 

<hr>

### Getting Started

Make a new folder for Lab 4. Copy your FaceList.java file from Lab 3 into Lab 4.

<hr>

#### STYLE REQUIREMENTS

One common style guide is Google's <a href="https://google.github.io/styleguide/javaguide.html" target="_blank">https://google.github.io/styleguide/javaguide.html</a>. Here are some rules for you to follow for this project along with a few examples.

- variable names use lower case (camel case for multiple words). Example: `studentName`
- method names use lower case (camel case for multiple words). Example: `helperFunction`
- class names use upper case with camel case (although try to avoid camel).
- constants, including enum values, are all capital
- curly brace opening is on the same line as start of the block 
- curly brace closing is on its own line or part of the else
- keep spacing clean - no extra blank lines unless better for readability
- clean "trash" from code (e.g. "TODO" when done, old debugging statements, etc.)
- place error checking code at the top of the method and return immediately without using an else. 
- use `@Override` whenever overriding a method.
- "new methods are not just habitually added to the end of the class" - group methods in some logical ordering
- "never split overloads", including constructors. Methods that share the same name appear in a single contiguous group 

```Java
    // Example of correct placement of curly braces
    if (x==0) {
        y=0;
    } else if (z<0>) {
        x=1;
    } else {
        System.out.println("silliness");
    }
```

```Java
    // Example of correct logic for handling error or special cases
    if (full() || !valid(index)) {
        return;
    }
    for (int i=length; i>index; i--) ...
```
<hr>

##### Documentation

As always, every member variable and class method should have accompanying Javadoc comments. Javadoc comments should be professional without reference to specific implementation.

As always, code should be well documented with comments so that programmers (including your future self) can easily understand the logic of the code. 

As always, use good naming conventions and good style, so that the code becomes "self-documented". 

<hr>

#### LIST IMPLEMENTATION

Each section below defines the requirements of this lab. There are many methods listed that you have already implemented, and the only change for this lab is to make it usable with a generic type (described below). There are some new requirements that have been summarized above.

##### Define Comparable Class

When a new class is defined, the relational operators (e.g. ==, <, >) will not work on that class, because the compiler does not know how to compare or order these objects. The Comparable interface allows the programmer to specify an ordering of class objects. Similarly, a class can override the `equals(Object)` method to test for equality. The equals method is typically based on comparing member variable values, as opposed to the `==` operator that compares the references to those objects.

For testing purposes and for practice with implementing Comparable, define `class Simiple implements <Comparable<Simple>>` in the file `Simple.java`.
- Simple has 2 member variables `Integer number` and `String alpha`.
- Write a constructor that has 2 parameters that are the alpha and number.
- Write the `@Override boolean equals(Object)`. It will be true if both the number and alpha are `equals()`.
- `comparaTo()` should order Simple objects by their _alpha_ value, but if the alpha is the same, it should use the number as the tie-breaker. For example, `A1 < A2`.
- `toString()` should print the number and alpha with no spaces, for example "A1".

##### GENERICS

All of the code that was written for FaceList uses logic that can be applied to any type of object. Rather than copying and pasting to create a new class, we can "reuse" the code by creating a variable for the type. This is referred to as _generics_. The type variable is used in the class name surrounded by less than and greater than, for example `public class List<T>`. Because we will want a way to specify an ordering within the List, the only allowable types must be comparable. So it isn't that the List is Comparable, rather it is the elements of the List. Therefore, we get this declaration of the class: `public class List<T extends Comparable<T>>`.

**Convert the FaceList class to the `List<T extends Comparable<T>>` class**. Remove all references to Face or face or faces. Instead use something like `item` or `elements` or `collection`. Make sure the comments are not refering to faces. **Use the `equals()` method for any comparisons of equality. Do not use `==`.**

You have to jump through a hoop to convince Java to create a generic array. It makes sense because it is typically not a good thing to do and you should use ArrayList<> in any other situation. However, we are learning how ArrayList is implemented, so we have to reassure the compiler we know what we are doing. It looks like this:

```Java
T[] items;

@SuppressWarnings("unchecked")
T[] temp = (T[]) new Comparable[size];
items = temp;
```

Every compiler issues warnings and errors. Warnings are given about things in the code that look not quite right and might indicate an error in the logic. Errors are syntax errors and the compiler cannot understand the code. The warning "unchecked" above pertains to the cast `(T[])`, which the compiler thinks is not a great idea, but we are saying to "suppress" or ignore that issue during compilation.


##### Helper Functions

> Always use your helper functions instead of copying and pasting the same code. For example, in a method other than `valid(index)`, do not test if an index is valid with `0 <= index && index < length`, use `valid(index)`.

- `private boolean full()` : **change from public to private**.
- `public boolean empty()` determines whether or not there are any items in the List.
- `public boolean valid(int index)` determines if an item is stored at that index (based on the length).
- `@Override public String toString()` overrides Object method for printing.
- `private void increaseCapacity(int size)` increases the capacity of the List by amount `size`. A new array
will need to be created and all elements copied over. **NEW METHOD**

##### Constructors

- Change DEFAULT_CAPACITY to 20
- `public List()` default constructor <del>with `this(DEFAULT_CAPACITY)` in the body</del>.
- <del>`public List(int size)` creates a new array with `size` capacity.</del>. **No longer relevant.**
- `public List(T[] toAdd)` create a new T[] array that is size 2*toAdd.length or DEFAULT_CAPACITY, whichever is larger. **NEW CONSTRUCTOR**
- `public List(List<T> toCopy)` creates a copy of the "this" object (sometimes referred to as a copy constructor). Copy all elements from `toCopy` into `this`. Be sure the count and capacity are also copied. **NEW CONSTRUCTOR**

##### Find Methods

> Use the `equals` method to check for equality. **CHANGE from earlier versions.**

- `public int locate(T item)` returns index of the first element that equals item or return -1 if not in List.
- `public T get(int index)` returns array element at that index or null if index is not valid.
- `public int findLast(T item)` returns index of the specified item, and if there is more than one, returns the last one (i.e. the one with the larger index).

##### Add and Set Methods

> For all add methods, resize the array if it is filled to capacity. Add 10 to the capacity, unless stated otherwise below.

- `public void add(T item)` adds that item to the end. **Resizes the array if it is full.**
- `public void add(T item, int index)` adds that item at the stated index or ignores the request if the index is not valid. Items must be shifted to make room. **Resize if array is full.**
- <del>public boolean</del> `public void addAll(T[] items)` adds all elements in the array passed in the method <del>BUT only if they can ALL fit. Return true if they were added, else false</del>. **Resize to accomodate all items in the _addAll_ array + 10 more. For example, if length = 5, capacity = 10, and items.length = 12, new capacity = 10 + (12-5) + 10**
- `public void set(T item, int index)` changes the element at index to the passed item or ignores the request
if the index is not valid. This will overwrite the element.

##### Remove Methods

- `public boolean remove(T item)` Removes the first occurence that is equal to face (use the `equals` method or better yet, use your `locate` method). Returns true if it was successfully removed, otherwise false.
- `public T remove(int index)` Removes the element at that index (if the index is valid). Returns the element that was removed or null if nothing was removed.
- `public void removeAll()` "removes" all elements from the list by setting the length to 0. If you want to, you can set your items array to a new empty array.
- `public in removeEach(T item)` Remove each occurence of item. **Do NOT iterate over the List repeatedly to find and remove an item until the item is no longer found.** This is very inefficient. On the other hand, do be careful removing items from a List that you are actively iterating over! **NEW METHOD**

##### Conversion Methods

- `T[] toArray()` returns a new array that is the size of the number of elements in the List. All elements are copied into the array in the order they appear in the List.

- `int toArray(T[] array)` copies as many elements in the "this" array that will fit into the passed array. Returns the number of elements added to `array`.

- `List<T> sublist(List<T> toCopy, int start, int end)` creates a new Sublist that contains a range of elements from the toCopy List.

##### Ordering Methods

- `T min()` returns the minimum element in the List or null if it is empty. Use `compareTo`. **NEW METHOD**
- `T max()` returns the maximum element in the List or null if it is empty. Use `compareTo`. **NEW METHOD**

<hr>

> Do not forget to print and sign the CS Lab Submission Form. Bring it to class to turn in.
