import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestLab3 extends UnitTest {

	static Face f0 = new Face();
	static Face f1 = new Face();
	static Face f2 = new Face();
	static Face f3 = new Face();
	static Face f4 = new Face();

	public static void main(String[] args) {

		// Initial add() and get() test
		/* It is a bit of a chicken-and-egg problem.
		* To test add(), get() needs to be correct to confirm face was added.
		* To test get(), add() needs to be correct to confirm location of face.
		*/

		System.out.println("\n\nSanity check test of add, length, get.");
		System.out.println("If these initial tests do not pass, the rest of the tests are irrelevant!\n");
		FaceList faceDB = new FaceList(5);
		faceDB.add(f1);
		assertEq(1,faceDB.length(),"First Add (length)");
		assertEq(f1,faceDB.get(0),"First Add (f1)");
		System.out.println("\nSanity Check complete!");
		/* Once the above are confirmed to be working, the rest of the testing can proceed.
		*/

		try {
			testConstructorGetters();
		} catch(Exception e) {
			System.out.println("\n\n*** STOP HERE -- something wrong with constructor!!\n\n");
		}
		try {
			testSearches();
		} catch(Exception e) {
			System.out.println("\n\nSEARCHES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testAdds();
		} catch(Exception e) {
			System.out.println("\n\nADDS THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testRemoves();
		} catch(Exception e) {
			System.out.println("\n\nREMOVES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testConvert();
		} catch(Exception e) {
			System.out.println("\n\nCONVERT THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testLast();
		} catch(Exception e) {
			System.out.println("\n\nFINDLAST THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
	} // end main

	/* __________________________________________________________________ */
	public static void testConstructorGetters() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing FaceList constructor ...");

		FaceList faces;

		// Test default constructor and getters
		faces = new FaceList();
		assertEq(100, faces.capacity(), "FaceList() capacity");
		assertEq(0, faces.length(), "FaceList() length");
		assertEq(true, faces.empty(), "FaceList() isEmpty");

		// Test constructor with size parameter
		faces = new FaceList(5);
		assertEq(0, faces.length(), "FaceList(5) length");
		assertEq(5, faces.capacity(), "FaceList(5) capacity");
		assertEq(true, faces.empty(), "FaceList(5) isEmpty");

		// Test length getter (tested at 0 above)
		faces.add(f1);
		assertEq(1,faces.length(),"length()");
		faces.add(f2);
		assertEq(2,faces.length(),"length()");

		// Test empty and null.
		faces = new FaceList(3);
		assertEq(false, faces.full(), "test full when empty");
		assertEq(true, faces.empty(), "test empty when empty");

		faces.add(f1);
		assertEq(false, faces.full(), "test full - 1 of 3");
		assertEq(false, faces.empty(), "test empty - 1 of 3");

		faces.add(f1);
		faces.add(f1);
		assertEq(true, faces.full(), "test full - 3 of 3");
		assertEq(false, faces.empty(), "test empty - 3 of 3");

		// test length getter when full
		assertEq(3,faces.length(),"length()");

	} // end testConstructorGetters

	/* __________________________________________________________________ */
	public static void testSearches() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing FaceList search methods ...");

		FaceList faces;

		Face f = new Face();

		faces = new FaceList(5);
		faces.add(f0);
		faces.add(f1);
		faces.add(f2);

		System.out.println("------------testing get()");
		assertEq(f0,faces.get(0),"get at index 0");
		assertEq(f1,faces.get(1),"get at index 1");
		assertEq(f2,faces.get(2),"get at index 2");
		assertEq(null,faces.get(3), "get invalid >count");
		assertEq(null,faces.get(5), "get invalid >length");
		assertEq(null,faces.get(-1), "get invalid -1");

		System.out.println("------------Testing locate()");
		assertEq(0, faces.locate(f0), "locate first");
		assertEq(1, faces.locate(f1), "locate middle");
		assertEq(2, faces.locate(f2), "locate last");
		assertEq(-1, faces.locate(f), "locate but not in FaceList");

	} // end testSearches

	/* __________________________________________________________________ */
	public static void testAdds() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing FaceList add methods ...");

		FaceList faces;

		System.out.println("--------------add(Face)");
		faces = new FaceList(3);

		// 0 of 3 added
		assertEq(0,faces.length(),"pre-add (length)");
		// adding 1 of 3
		faces.add(f0);
		assertEq(1,faces.length(),"add first (length)");
		assertEq(f0,faces.get(0),"add first (value)");
		// adding 2 of 3
		faces.add(f1);
		assertEq(2,faces.length(),"add 2nd (length)");
		assertEq(f1,faces.get(1),"add 2nd (value)");
		// adding 3 of 3
		faces.add(f2);
		assertEq(3,faces.length(),"add to capacity (length)");
		assertEq(f2,faces.get(2),"add to capacity (value)");
		// attempt add 4 of 3
		faces.add(f3);
		assertEq(3,faces.length(),"add attempt over capacity (length)");
		assertEq(f2,faces.get(2),"add attempt over capacity (value)");


		System.out.println("--------------add(index,face)");
		faces = new FaceList(6);

		// attempt to add at 0 in empty array
		faces.add(0,f0);
		assertEq(0,faces.length(),"attempt add to empty - invalid index (length)");

		// add 2 of 6
		faces.add(f0);
		faces.add(0,f1);	// order is now f1,f0
		assertEq(2,faces.length(),"add at 0 (length)");
		assertEq(f1,faces.get(0),"add at 0 (value)");
		assertEq(f0,faces.get(1),"add at 0 (2nd song)");

		faces.add(2,f2);	// nothing is added
		assertEq(2,faces.length(),"invalid add at end (length)");
		assertEq(f1,faces.get(0),"add at end (1st)");
		assertEq(f0,faces.get(1),"add at end (2nd)");

		// test invalid indices
		faces.add(-1,f4);
		assertEq(2,faces.length(),"add at -1 (length)");
		faces.add(5,f4);
		assertEq(2,faces.length(),"add beyond last (length)");

		System.out.println("--------------addAll()");
		faces = new FaceList(8);

		Face[] toAdd = {f0,f1,f2};
		int total;

		total = faces.addAll(toAdd);
		assertEq(3,faces.length(),"addAll to empty");
		assertEq(3,total,"addAll added to empty");

		total = faces.addAll(toAdd);
		assertEq(6,faces.length(),"addAll 3 to 3");
		assertEq(3,total,"addAll added 3 of 3");

		// cannot add them all
		total = faces.addAll(toAdd);
		assertEq(8,faces.length(),"addAll 3 to 6");
		assertEq(2,total,"addAll added 2 of 3");

		// cannot add any
		total = faces.addAll(toAdd);
		assertEq(8,faces.length(),"addAll 3 to 8");
		assertEq(0,total,"addAll added 0 of 3");
		
	}

	/* __________________________________________________________________ */
	public static void testRemoves() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing FaceList remove methods ...");

		// This assumes add, length is working.

		FaceList faces;

		System.out.println("--------------remove(index)");
		faces = new FaceList(6);
		faces.add(f0);
		faces.add(f1);
		faces.add(f2);
		faces.add(f3);

		Face removed;

		// attempt remove invalid
		removed = faces.remove(4);
		assertEq(4,faces.length(),"remove invalid (length)");
		assertEq(null,removed,"remove invalid (value)");

		// attempt remove invalid (-1)
		removed = faces.remove(-1);
		assertEq(4,faces.length(),"remove [-1] (length)");
		assertEq(null,removed,"remove [-1] (value)");		

		// remove middle (f1) == {f0,f2,f3}
		removed = faces.remove(1);
		assertEq(3,faces.length(),"remove middle (length)");
		assertEq(f1,removed,"remove middle (value)");
		
		// remove last (f3) == {f0,f2}
		removed = faces.remove(2);
		assertEq(2,faces.length(),"remove last (length)");
		assertEq(f3,removed,"remove last (value)");

		// remove first (f0) == {f2}
		removed = faces.remove(0);
		assertEq(1,faces.length(),"remove first (length)");
		assertEq(f0,removed,"remove first (value)");

		// remove only (f2)
		removed = faces.remove(0);
		assertEq(0,faces.length(),"remove only (length)");
		assertEq(f2,removed,"remove only (value)");
	


		System.out.println("--------------remove(Face)");
		faces = new FaceList(6);
		faces.add(f0);
		faces.add(f1);
		faces.add(f2);
		faces.add(f3);

		Boolean isRemoved;

		// attempt remove not in list
		isRemoved = faces.remove(f4);
		assertEq(4,faces.length(),"remove not in (length)");
		assertEq(false,isRemoved,"remove not in (return)");		

		// remove middle (f1) == {f0,f2,f3}
		isRemoved = faces.remove(f1);
		assertEq(3,faces.length(),"remove middle face (length)");
		assertEq(true,isRemoved,"remove middle face (value)");
		
		// remove last (f3) == {f0,f2}
		isRemoved = faces.remove(f3);
		assertEq(2,faces.length(),"remove last face (length)");
		assertEq(true,isRemoved,"remove last face (value)");

		// remove first (f0) == {f2}
		isRemoved = faces.remove(f0);
		assertEq(1,faces.length(),"remove first face (length)");
		assertEq(true,isRemoved,"remove first face (value)");

		// remove only (f2)
		isRemoved = faces.remove(f2);
		assertEq(0,faces.length(),"remove only face (length)");
		assertEq(true,isRemoved,"remove only face (value)");

		System.out.println("--------------removeAll()");
		faces = new FaceList(6);
		faces.add(f0);
		faces.add(f1);
		faces.add(f2);
		faces.add(f3);	
		
		faces.removeAll();
		assertEq(0,faces.length(),"remove all (length)");
		
		faces.removeAll();
		assertEq(0,faces.length(),"remove all empty (length)");


	}


	/* __________________________________________________________________ */
	public static void testConvert() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing FaceList convert methods ...");

		FaceList faces;
		Face[] array;

		System.out.println("--------------Testing toArray()");
		faces = new FaceList(4);
		if (null!=faces.toArray()) {
			System.out.println(
			"ERROR: toArray empty FaceList. Expect null. Results not null.");
		}

		faces.add(f0);
		array = faces.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 1 element. Returns null.");
		} else {
			assertEq(1,array.length,"toArray 1 element (length)");
			assertEq(array[0], f0, "toArray 1 element (value)");
		}

		faces.add(f1);
		array = faces.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 2 elements. Returns null.");
		} else {
			assertEq(2,array.length,"toArray 2 elements (length)");
			assertEq(array[0], f0, "toArray 2 elements (face 0)");
			assertEq(array[1], f1, "toArray 2 elements (face 1)");
		}

		System.out.println("--------------Testing toArray(array)");
		faces = new FaceList(6);
		Face[] toFill = new Face[4];
		int added;
		
		// List empty. nothing in toArray
		added = faces.toArray(toFill);
		assertEq(0,added,"fill with empty list");

		faces.add(f0);
		faces.add(f1);
		faces.add(f2);

		added = faces.toArray(toFill);
		assertEq(3,added,"fill with 3");

		faces.add(f0);

		added = faces.toArray(toFill);
		assertEq(4,added,"fill with 4 to cap");
		assertEq(f0,toFill[0],"filled f0 at 0");

		faces.add(f1);
		
		added = faces.toArray(toFill);
		assertEq(0,added,"fill array too small");

		System.out.println("--------------Testing sublist()");
		faces = new FaceList(5);
		FaceList result;

		faces.add(f0);
		faces.add(f1);
		faces.add(f2);
		faces.add(f3);

		result = faces.sublist(0,3);
		assertEq(8,result.capacity(),"copy all 4 (length)");
		assertEq(f0,result.get(0),"copy all 4 (value)");

		result = faces.sublist(0,0);
		assertEq(2,result.capacity(),"copy first (length)");
		assertEq(f0,result.get(0),"copy first (value)");

		result = faces.sublist(3,3);
		assertEq(2,result.capacity(),"copy last (length)");
		assertEq(f3,result.get(0),"copy last (value)");

		result = faces.sublist(1,2);
		assertEq(4,result.capacity(),"copy middle (length)");
		assertEq(f1,result.get(0),"copy middle (value)");

	} // end testConvert

	/* __________________________________________________________________ */
	public static void testLast() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing FaceList findLast() ...");

		// STUDENT DEFINED TESTS GO HERE vvvvvvvvvvvvvvvvvvvvvvvvvvv

} // end class Main
