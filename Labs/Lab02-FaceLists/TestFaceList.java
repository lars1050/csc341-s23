import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestFaceList {

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
		Assert.assertEquals(1,faceDB.length(),"First Add (length)");
		Assert.assertEquals(f1,faceDB.get(0),"First Add (f1)");
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
	} // end main

	/* __________________________________________________________________ */
	public static void testConstructorGetters() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing FaceList constructor ...");

		FaceList faces;

		// Test default constructor and getters
		faces = new FaceList();
		Assert.assertEquals(100, faces.capacity(), "FaceList() capacity");
		Assert.assertEquals(0, faces.length(), "FaceList() length");
		Assert.assertEquals(true, faces.empty(), "FaceList() isEmpty");

		// Test constructor with size parameter
		faces = new FaceList(5);
		Assert.assertEquals(0, faces.length(), "FaceList(5) length");
		Assert.assertEquals(5, faces.capacity(), "FaceList(5) capacity");
		Assert.assertEquals(true, faces.empty(), "FaceList(5) isEmpty");

		// Test length getter (tested at 0 above)
		faces.add(f1);
		Assert.assertEquals(1,faces.length(),"length()");
		faces.add(f2);
		Assert.assertEquals(2,faces.length(),"length()");

		// Test empty and null.
		faces = new FaceList(3);
		Assert.assertEquals(false, faces.full(), "test full when empty");
		Assert.assertEquals(true, faces.empty(), "test empty when empty");

		faces.add(f1);
		Assert.assertEquals(false, faces.full(), "test full - 1 of 3");
		Assert.assertEquals(false, faces.empty(), "test empty - 1 of 3");

		faces.add(f1);
		faces.add(f1);
		Assert.assertEquals(true, faces.full(), "test full - 3 of 3");
		Assert.assertEquals(false, faces.empty(), "test empty - 3 of 3");

		// test length getter when full
		Assert.assertEquals(3,faces.length(),"length()");

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
		Assert.assertEquals(f0,faces.get(0),"get at index 0");
		Assert.assertEquals(f1,faces.get(1),"get at index 1");
		Assert.assertEquals(f2,faces.get(2),"get at index 2");
		Assert.assertEquals(null,faces.get(3), "get invalid >count");
		Assert.assertEquals(null,faces.get(5), "get invalid >length");
		Assert.assertEquals(null,faces.get(-1), "get invalid -1");

		System.out.println("------------Testing locate()");
		Assert.assertEquals(0, faces.locate(f0), "locate first");
		Assert.assertEquals(1, faces.locate(f1), "locate middle");
		Assert.assertEquals(2, faces.locate(f2), "locate last");
		Assert.assertEquals(-1, faces.locate(f), "locate but not in FaceList");

	} // end testSearches

	/* __________________________________________________________________ */
	public static void testAdds() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing FaceList add methods ...");

		FaceList faces;

		System.out.println("--------------add(Face)");
		faces = new FaceList(3);

		// 0 of 3 added
		Assert.assertEquals(0,faces.length(),"pre-add (length)");
		// adding 1 of 3
		faces.add(f0);
		Assert.assertEquals(1,faces.length(),"add first (length)");
		Assert.assertEquals(f0,faces.get(0),"add first (value)");
		// adding 2 of 3
		faces.add(f1);
		Assert.assertEquals(2,faces.length(),"add 2nd (length)");
		Assert.assertEquals(f1,faces.get(1),"add 2nd (value)");
		// adding 3 of 3
		faces.add(f2);
		Assert.assertEquals(3,faces.length(),"add to capacity (length)");
		Assert.assertEquals(f2,faces.get(2),"add to capacity (value)");
		// attempt add 4 of 3
		faces.add(f3);
		Assert.assertEquals(3,faces.length(),"add attempt over capacity (length)");
		Assert.assertEquals(f2,faces.get(2),"add attempt over capacity (value)");


		System.out.println("--------------add(index,face)");
		faces = new FaceList(6);

		// attempt to add at 0 in empty array
		faces.add(0,f0);
		Assert.assertEquals(0,faces.length(),"attempt add to empty (length)");

		// add 2 of 6
		faces.add(f0);
		faces.add(0,f1);	// order is now f1,f0
		Assert.assertEquals(2,faces.length(),"add at 0 (length)");
		Assert.assertEquals(f1,faces.get(0),"add at 0 (value)");
		Assert.assertEquals(f0,faces.get(1),"add at 0 (2nd song)");

		faces.add(2,f2);	// order is now f1, f0, f2
		Assert.assertEquals(3,faces.length(),"add at end (length)");
		Assert.assertEquals(f2,faces.get(2),"add at end (value)");
		Assert.assertEquals(f1,faces.get(0),"add at end (1st)");
		Assert.assertEquals(f0,faces.get(1),"add at end (2nd)");

		// test invalid indices
		faces.add(-1,f4);
		Assert.assertEquals(4,faces.length(),"add at -1 (length)");
		faces.add(5,f4);
		Assert.assertEquals(4,faces.length(),"add beyond last (length)");
	}

	/* __________________________________________________________________ */
	public static void testRemoves() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing FaceList remove methods ...");

		// This is assuming add, length, contains is working.

		FaceList faces;

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
			Assert.assertEquals(1,array.length,"toArray 1 element (length)");
			Assert.assertEquals(array[0], f0, "toArray 1 element (value)");
		}

		faces.add(f1);
		array = faces.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 2 elements. Returns null.");
		} else {
			Assert.assertEquals(2,array.length,"toArray 2 elements (length)");
			Assert.assertEquals(array[0], f0, "toArray 2 elements (face 0)");
			Assert.assertEquals(array[1], f1, "toArray 2 elements (face 1)");
		}
	} // end testConvert
} // end class Main
