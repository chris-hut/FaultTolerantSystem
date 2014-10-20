package test;

import com.hut.DataGenerator;

/**
 * Tests the Data Generation Class
 */
public class DataGeneratorTest extends junit.framework.TestCase {

    public void testRandomNumberGenerator(){
        // Can't really test the numbers as we'd just be testing how random Random is
        int[] arr = DataGenerator.generateNumbers(5);
        assertEquals(arr.length, 5);
    }

    public void testRandomNumberGeneratorEmpty(){
        int[] arr = DataGenerator.generateNumbers(0);
        assertEquals(arr.length, 0);
    }

}
