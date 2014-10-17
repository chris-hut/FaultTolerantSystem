package test;

import com.hut.DataGenerator;
import org.junit.Test;

/**
 * Created by chris on 10/17/14.
 */
public class DataGeneratorTest extends junit.framework.TestCase {

    @Test
    public void testDataGeneratorSuccess(){
        DataGenerator dg = new DataGenerator();
        assert dg != null;
    }

}
