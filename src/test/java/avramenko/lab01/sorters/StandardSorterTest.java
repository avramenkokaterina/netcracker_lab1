package avramenko.lab01.sorters;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StandardSorterTest {

    private int[] createArray(){
        int[] testArray = new int[50];
        Random random = new Random();
        for (int i = 0; i<testArray.length; i++) {
            testArray[i] = random.nextInt();
        }
        StandardSorter standardSorter = new StandardSorter();
        int[] result = standardSorter.sort(testArray);
        return result;
    }

    @Test
    public void sortTest() {
        int[] testArray = createArray();
        boolean isSorted = true;
        for (int i = 0; i<testArray.length - 1; i++) {
            if (testArray[i] > testArray[i+1]) {
                isSorted = false;
            }
        }
        Assert.assertTrue("Oh no..." ,isSorted);
    }

    @Test(timeout = 10000)
    public void sortTimeTest(){
        int[] testArray = createArray();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void sortExceptionTest(){
        int[] testArray = createArray();
        int element = testArray[51];
    }
}