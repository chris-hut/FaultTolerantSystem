package test;

import com.hut.AcceptanceTest;
import junit.framework.TestCase;

public class AcceptanceTestTest extends TestCase {

    public static void testSimple(){
        int a[] = {1, 2, 3, 4, 5};
        assertTrue(AcceptanceTest.isSorted(a));
    }

    public static void testOneElements(){
        int a[] = {0};
        assertTrue(AcceptanceTest.isSorted(a));
    }

    public static void testAllSameNumber(){
        int a[] = {1,1,1,1,1,1,1,1,1,1};
        assertTrue(AcceptanceTest.isSorted(a));
    }

    public static void testNotSorted(){
        int a[] = {108, 4, 8, 15, 16, 23, 42};
        assertTrue(!AcceptanceTest.isSorted(a));
    }

    public static void testFirstPartSorted(){
        int a[] = {4, 8, 15, 16, 23, 42, 4, 8, 15, 16, 23, 42};
        assertTrue(!AcceptanceTest.isSorted(a));
    }
}
