package avramenko.lab01.fillers;

import java.util.Arrays;
import java.util.Random;

public class GenerateArrays {

    private static Random random;

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

    @Fillers (name = "Sorted array with element X at the end")
    public static int[] generateArrayX(int length) {
        int[] oldArray = generateSortedArray(length);
        int[] array = Arrays.copyOf(oldArray, length + 1);
        array[length] = random.nextInt(50);
        return array;
    }

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

    @Fillers (name = "Random filled array")
    public static int[] generateRandomArray(int length) {
        random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = random.nextInt(99);
        return array;
    }
}
