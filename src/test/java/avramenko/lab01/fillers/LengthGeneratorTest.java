package avramenko.lab01.fillers;

import org.junit.Assert;
import org.junit.Test;

import static avramenko.lab01.fillers.LengthGenerator.generateLength;

public class LengthGeneratorTest {

    @Test(timeout = 5000)
    public void generateLengthTimeTest() {
        generateLength();
    }

    @Test
    public void generateLengthExceptionTest(){
        boolean isNull = false;
        if (generateLength() == null){
            isNull = true;
            Assert.assertTrue("Oh no..." ,isNull);
        }
    }

    @Test
    public void generateLengthTest(){
        int[] lengths = generateLength();
        boolean isSorted = true;
        for (int i = 0; i<lengths.length - 1; i++) {
            if (lengths[i] > lengths[i+1]) {
                isSorted = false;
            }
        }
        Assert.assertTrue("Oh no..." ,isSorted);
    }
}