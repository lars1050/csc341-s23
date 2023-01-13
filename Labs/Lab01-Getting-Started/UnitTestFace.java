/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amylarson
 */
public class UnitTestFace extends UnitTest {
    
    public static void main(String[] args) {
        testConstructors();
        testCompare();
        testBestMatch();
        testWorstMatch();
    }
    
    
    public static void testConstructors() {
        System.out.println("***** TESTING Face constructor with String");
        
        Face fixed = new Face("100,200,1,2,3,4,5,6");
        
        test(100,fixed.width(),"face width");
        test(200,fixed.height(),"face height");
        test(1,fixed.eyeDelta(),"eye delta");
        test(3,fixed.noseLength(),"nose length");
        test(5,fixed.mouthDelta(),"mouth delta");
    }
    
    public static void testCompare() {
        System.out.println("***** TESTING Face compare method");
        
        Face f1 = new Face("100,200,1,2,3,4,5,6");
        Face f2 = new Face("100,200,1,2,3,4,5,6");
        Face f3 = new Face("200,400,2,4,6,8,10,12");
        Face f4 = new Face("100,100,1,2,3,4,5,6");
        
        test(0.0,f3.compare(f3),0.0,"identical objects");
        test(0.0,f1.compare(f2),0.0,"identical values");
        test(0.0,f1.compare(f3),0.0,"proportional faces");
    }

    public static void testBestMatch() {
        System.out.println("***** TESTING Best Match");
         
        // Convert the strings from the file into Face objects
        Face[] faces = new Face[5];
        faces[0] = new Face("100,100,1,1,1,1,1");
        faces[1] = new Face("100,100,2,2,2,2,2");
        faces[2] = new Face("100,100,3,3,3,3,3");
        faces[3] = new Face("100,100,4,4,4,4,4");
        faces[4] = new Face("100,100,5,5,5,5,5");

        Face f2 = new Face("100,100,2,2,2,2,2");
        Face f6 = new Face("100,100,6,6,6,6,6");

        Integer best;

        // Match the same object
        best = Main.findBestMatch(faces[0], faces);
        test(0,best,"match same object");

        // Match same valued object
        best = Main.findBestMatch(f2,faces);
        test(1,best,"match same value");

        // Match something different
        best = Main.findBestMatch(f6,faces);
        test(4,best,"match different value");

    }

    public static void testWorstMatch() {
        System.out.println("***** TESTING Worst Match");
         
        // Convert the strings from the file into Face objects
        Face[] faces = new Face[5];
        faces[0] = new Face("100,100,1,1,1,1,1");
        faces[1] = new Face("100,100,2,2,2,2,2");
        faces[2] = new Face("100,100,3,3,3,3,3");
        faces[3] = new Face("100,100,4,4,4,4,4");
        faces[4] = new Face("100,100,5,5,5,5,5");
    }
}
