package test;

import com.hut.DataGenerator;
import org.junit.Before;

/**
 * Tests the Data Generation Class
 */
public class DataGeneratorTest extends junit.framework.TestCase {

    private DataGenerator dg;


    @Before
    public void setUp(){
        dg = new DataGenerator();
    }

    public void testRandomNumberGenerator(){
        // Can't really test the numbers as we'd just be testing how random Random is
        int[] arr = dg.generateNumbers(5);
        assertEquals(arr.length, 5);
    }

    public void testRandomNumberGeneratorEmpty(){
        int[] arr = dg.generateNumbers(0);
        assertEquals(arr.length, 0);
    }

}
