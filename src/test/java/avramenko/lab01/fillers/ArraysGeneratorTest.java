package avramenko.lab01.fillers;

import org.junit.Assert;
import org.junit.Test;

import static avramenko.lab01.fillers.ArraysGenerator.*;
import static org.junit.Assert.*;

public class ArraysGeneratorTest {

    private int length = 100;

    @Test(timeout = 10000)
    public void generateSortedArrayTimeTest() {
        generateSortedArray(length);
    }

    @Test(expected = NullPointerException.class)
    public void generateSortedArrayExceptionTest(){
        boolean isNull = false;
        if (generateSortedArray(length) == null){
            isNull = true;
            Assert.assertTrue("Oh no..." ,isNull);
        }
    }

    @Test(timeout = 10000)
    public void generateArrayXTimeTest() {
        generateArrayX(length);
    }

    @Test(expected = NullPointerException.class)
    public void generateArrayXExceptionTest(){
        boolean isNull = false;
        if (generateArrayX(length) == null){
            isNull = true;
            Assert.assertTrue("Oh no..." ,isNull);
        }
    }

    @Test(timeout = 10000)
    public void generateReverseSortedArrayTimeTest() {
        generateReverseSortedArray(length);
    }

    @Test(expected = NullPointerException.class)
    public void generateReverseSortedArrayExceptionTest(){
        boolean isNull = false;
        if (generateReverseSortedArray(length) == null){
            isNull = true;
            Assert.assertTrue("Oh no..." ,isNull);
        }
    }

    @Test(timeout = 10000)
    public void generateRandomArrayTimeTest() {
        generateRandomArray(length);
    }

    @Test(expected = NullPointerException.class)
    public void generateRandomArrayExceptionTest(){
        boolean isNull = false;
        if (generateRandomArray(length) == null){
            isNull = true;
            Assert.assertTrue("Oh no..." ,isNull);
        }
    }
}