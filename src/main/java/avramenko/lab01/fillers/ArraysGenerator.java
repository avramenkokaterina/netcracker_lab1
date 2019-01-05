package avramenko.lab01.fillers;

import java.util.Arrays;
import java.util.Random;

/**
 * <h1>ArraysGenerator</h1>
 * <p>ArraysGenerator class creating 4 different types of array.</p>
 * @author Avramenko Kateryna
 * @version 1.3
 * @see java.lang.annotation.Annotation
 * @see Fillers
 */

public class ArraysGenerator {

    private static Random random;

    /**
     * Generating sorted array by adding to previous element random number.
     * Annotating with (@code Fillers).
     * @param length - length of array.
     * @return sorted array with length length.
     */

    @Fillers (name = "Sorted Array")
    public static int[] generateSortedArray(int length) {
        random = new Random();
        int[] array = new int[length];
        array[0] = 1;
        for (int i = 1; i < length; i++) {
            array[i] = array[i - 1] + random.nextInt(10);
        }
        return array;
    }

    /**
     * Generating sorted array with one more random element.
     * Annotating with (@code Fillers).
     * @param length - length of array.
     * @return sorted array with one more element at the end with length length.
     */

    @Fillers (name = "Sorted array with element X at the end")
    public static int[] generateArrayX(int length) {
        int[] oldArray = generateSortedArray(length);
        int[] array = Arrays.copyOf(oldArray, length + 1);
        array[length] = random.nextInt(50);
        return array;
    }

    /**Generating sorted and reversed array.
     * Annotating with (@code Fillers).
     * @param length - length of array.
     * @return reversed array with length length.
     */

    @Fillers (name = "Reversed Array")
    public static int[] generateReverseSortedArray(int length) {
        int[] array = generateSortedArray(length);
        int i = 0;
        int j = array.length - 1;
        int tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * Generating random array.
     * Annotating with (@code Fillers).
     * @param length - length of array.
     * @return array with random elements.
     */

    @Fillers (name = "Random filled array")
    public static int[] generateRandomArray(int length) {
        random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = random.nextInt(99);
        return array;
    }
}
