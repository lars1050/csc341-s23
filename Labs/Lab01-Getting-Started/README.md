## Lab 01 Getting Started

<h4>
DUE Friday, January 19 12:30 pm (as class begins)
<br>Zip code and answers to the questions and submit via Moodle.
<br>Print this form, complete it, and bring it to class on Friday: https://docs.google.com/document/d/1ChYBgMLBJKrhFsasovBbDlJM94IccL0sQG1IpvNq3Wg/edit?usp=sharing
</h4>

In this lab, you will complete _cartoon_ facial recognition using a common
machine learning technique. In the process, you will learn about best industry
practices for programming. This includes:

- _Git_, one of the most popular code repositories
- _GitHub_, cloud service with GUI to remotely store your Git repo
- command-line operations in a shell for file management, compilation and execution
- _VS Code_ (or your favorite editor) for source code editing (not an IDE)
- JAVA Style Guide, https://google.github.io/styleguide/javaguide.html
- Unit Testing (an informal homegrown version - not JUnit testing)
- Javadocs for automated documentation
- Debugger (although we will not look at this until later in the semester)

<hr>

### Getting Started

Review the instructions at the top level of this repository to get your system ready.
When you are done, you should have _Java_, _git_ and _VS Code_ installed on your machine.

#### Clone This Repository

Open a terminal. Navigate to where you would like your repo for this course to go and clone it. I would recommend changing the name so that it is clear this is the repo.

Here is an example from Dr. Larson's machine:

```
cd ~/courses
mkdir cs341
cd cs341
git clone https://github.com/lars1050/csc341-f22
mv csc341-f22 csc341-class-repo 
```

In the repo, code for each lab and in-class exercises will be posted.

You do not want to edit inside of this repo because it will interfere with your ability to download future assignments. Instead, create another directory at this location (or elsewhere). I recommend naming it something that makes it clear that this is your working directory. Then copy the lab into your working directory. DO NOT MAKE A COPY of the repo and use that as your working directory because it is tied to that specific repo, and it will interfere with your ability to (potentially) store your work in your own repo.

Here is an example from Dr. Larson's machine:

```
mkdir csc341-working
cd csc341-working
mkdir Labs
mkdir Exercises
```

Personally, I would go to my Finder or Explorer and copy files from there. Place the folder "Lab01-Getting-Started" inside `csc341-working/Labs`.


#### Open in VS Code

If you see the VS Code icon with the .java files in your Finder / Explorer, then you can double-click 
any of the files in Lab01 that you just copied into your working directory and it will open VS Code. 
If there is a different icon, then right-click the file and choose to open it with VS Code.

Once VS Code is open, go to the dropdown "File" menu and choose to open a folder. 
Navigate to the working lab folder and open it. This will create a left sidebar with all files.

Once you have the folder open, select the pulldown menu _Terminal_ and choose "New Terminal".
Now you are ready to compile the code within the terminal. Notice that the path in the Terminal
matches the location of the lab.

<hr>

#### Prepare Your File

At the top of the file `Main.java` in a comment area:
- type your full name
- type the full name if you worked with a classmate on this lab (you have permission to work with 1 person)
- list the resources that you used for this assignment (some examples are zyBook, w3schools, drop-in tutoring, drop-in student hour with Dr. Larson, or with a classmate).

> Note that on this lab you have permission to code together with 1 other person. You also have permission to discuss the assignment with other classmates, but please part ways before you commit to typing code.

### Machine Learning for Facial Recognition

If someone asked you to find the person in the room who is closest in height to yourself,
you would be able to do this, no problem! But what was the ALGORITHM that you used to do that?

If someone asked you to find the person in the room who is closest in build to yourself,
you can still do this, but it is a little trickier! Now you have to look at height, weight and
general body shape. How do you evaluate multiple characteristics to find the closest match?
It might even be subjective (meaning based on a person's opinion). One person might
think that the person who is proportionally similar is closest, regardless of height, 
whereas someone else might think it is most important to match height and use body shape second.

In many machine learning applications, this is precisely what the system is trying to achieve --
find the best match based on multiple criteria (referred to as _features_). A simple technique,
which we are using here, is to take the difference between features and add them up. Here is 
an example:

```
Person1 =   height:65"    weight:120lb    waist:27"   bicep:11"
Person2 =   height:63"    weight:105lb    waist:26"   bicep:11"
Person3 =   height:67"    weight:135lb    waist:28"   bicep:11"

Difference Person1 vs Person2 = 65-63 + 120-105 + 27-26 + 11-11 = 18
Difference Person1 vs Person3 = 65-67 + 120-135 + 27-28 + 11-11 = -18
```

Notice that the difference has the same magnitude, but different signs (one positive, one negative).
Person2 and Person3 are equidistance from Person1, but the values are different.
To fix this, we take the SQUARE of each difference, sum them all, then take 
the square root to make it more in scale with the original values.

```
((65-63)^2 + (120-105)^2 + (27-26)^2 + (11-11)^2) ^ 0.5
```

Once you compare the object to all the rest, the best match is the one with the minimum difference.
That is a pretty simple formula that might not do a great job finding the
subtle differences that make a significant impact. As the designer of the machine learning
system, you might modify this in different ways to improve performance. For example, you might
think one feature is more important than another, therefore you multiply it by a constant.
On the other hand, you might think it is less important and divide it by a constant. 
The weight of a person is on a scale 10x of the bicep measurement. If you want them
to be of equal importance, you might divide the weight by 10.
Applying a constant to a feature to emphasize or de-emphasize its importance
is called *weighting* the feature. Much of machine learning makes use of
sophisticated techniques to measure the distance between objects, as well as
determining which of the features is the most important to consider.

<hr>

## Deliverables

<hr>

### Write Face.compare(Face other)

Your task is to write a function `Face.compare(Face other)` in the Face class
that calculates a difference between "this" object and the other. In facial
recognition, we might have images at different distances, so we want a measure that
is not influenced by this. Therefore, we use ratios that compare facial features 
relative to the width or height of the face. Here are your features to use:

- face width / face height
- (eye delta * 2) / face width
- nose length / face height
- mouth delta / face height

_Eye delta_ is the length from the nose to the edge of the eye. The _mouth delta_
is the length from the bottom of the nose to the top of the mouth.

>Be sure to place comments using `\\` to explain your code. The expectation is that you
have a comment for every 3 or 4 lines of code. Comments go ABOVE the code it is 
explaining. It is not good practice to put the comment on the same line as the code,
except under special circumstances.

<br>

### Unit Tests for the Compare Method

_Test-Driven Developement_ is a technique whereby you first write the tests for your code,
THEN you write the code. It has a lot of benefits, but it is a hard habit to form. In this
code you will see that some tests have bee provided for you. To run the tests on the command
line, type `java UnitTestFace` once the file has been compiled with `javac *.java`.  
You might have passed the tests or they might have failed. If they passed, you will not see
any error messages. But if it does fail, you will see both the expected and acutal values, as shown below. 

```
amylarson@MacBook-Pro-110 ~/C/c/_/Lab01> javac *.java
amylarson@MacBook-Pro-110 ~/C/c/_/Lab01> java UnitTestFace
***** TESTING Face constructor with String
***** TESTING Face compare method
***** TESTING Best Match
FAIL match same value
       expected 1, results 0
FAIL match different value
       expected 4, results 0
```

>If you failed the *compare method* test, be sure to fix the code and pass the tests before moving on.

<br>

### Write Main.findBestMatch(face,faces)

Complete the function that takes a given face and compares it to all others. For _findBestMatch()_, 
it should return the face in _faces_ that has the minimum difference.

Once you have completed `Main.findBestMatch()`, run the unit tests again and see if you have passed. Be sure
to fix the code before moving on.

<br>

### Complete Javadocs

*Complete the Javadocs for th Face class only*. Each method should have a general description that includes a
list of parameters and return value, each with a short description. Please use the `@param` and `@return` tags
within the description. You do NOT have to document the setters and getters.

Compile the javadocs to generate the web pages for the Face class only. You will want to place all the documentation in a separate folder so that it doesn't clutter your source directory. After completing the commands below, open up the index.html page and see how it looks.

```
mkdir docs
cd docs
javadoc ../Face.java
```

> NOTE: If you are on a Windows machine, you might have to add the javadoc command to your path. We will do that together in class before the due date.

<br>

### Answer Questions in report.txt

Create a file `report.txt` and answer the following questions:

<ol>
<li> In the code, you will see 2 different forms of an array. One is an `ArrayList` class that is imported
with `import java.util.ArrayList;` and the other is a built-in data type defined using square brackets.
Consider the following definitions:,

```Java
Face[] facesArray = new Face[10];
ArrayList<Face> facesList = new ArrayList<>();
```
<ul>
<li>Write the syntax to add an element to each of these structures (assume they are both empty).
<li>Briefly describe the difference in how elements are added to each of these data structures, AND compare and contrast the advantages and disadvantages of the different structures.
</ul>

<li>
If you run the following code:

```Java
Face f1 = new Face();
Face f2 = new Face(f1);
Face f3 = f1;

System.out.println(f1.hashCode() + " " + f1);
System.out.println(f2.hashCode() + " " + f2);
System.out.println(f3.hashCode() + " " + f3);
```

This will be the output:

```
Face@6ff3c5b5 = 0 [165, 193, 21, , 20, , 12]
Face@1be6f5c3 = 0 [165, 193, 21, , 20, , 12]
Face@6ff3c5b5 = 0 [165, 193, 21, , 20, , 12]
```

The first number is the reference (address) of the Face object. Why do `f1` and `f3` have the same address, but `f2` has a different one? _Look at the constructor in Face that has an input parameter of type Face to answer this question._
</li>

<li> Look at the Point class definition. This class has 2 member variables x and y. If you declared a 
Point and then wanted to get the x value, you could do this in 2 ways:

```Java
System.out.println(point.x);
System.out.println(point.x())
```

Briefly state how these techniques for getting the value of x are different. Do this by describing what happens as they are executed. 

</ol>

<hr>

### Submit to Moodle

Zip the folder and submit via Moodle. You can zip the folder by right clicking the icon and choosing
to compress it.
       













