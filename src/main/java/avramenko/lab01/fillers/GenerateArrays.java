package avramenko.lab01.fillers;

import java.util.Arrays;
import java.util.Random;

public class GenerateArrays {

    public int[] generateSortedArray(int length){
        int[] array = generateRandomArray(length);
        Arrays.sort(array);
        return array;
    }

    public int[] generateArrayX(int length, int element){
        int[] oldArray = generateSortedArray(length);
        int[] array = Arrays.copyOf(oldArray, length+1);
        array[length]=element;
        return array;
    }

    public int[] generateAnotherSortedArray(int length){
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

    public int[] generateRandomArray(int length){
        Random random = new Random();
        int[] array = new int[length];
        for (int i=0; i<length; i++)
            array[i] = random.nextInt(99);
        return array;
    }
}
