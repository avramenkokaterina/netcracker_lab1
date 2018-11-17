package avramenko.lab01.sorters;

import java.util.Arrays;

public class MergeSort {

    public int[] merge(int[] tempArray1, int[] tempArray2, int startIndex, int length) {
        int[] array = new int[length];
        int i = 0;
        int j = 0;
        int k = startIndex;
        while (i < tempArray1.length && j < tempArray2.length) {
            if (tempArray1[i] <= tempArray2[j]) {
                array[k] = tempArray1[i];
                i++;
                k++;
            } else {
                array[k] = tempArray2[j];
                j++;
                k++;
            }
        }
        while (i < tempArray1.length) {
            array[k] = tempArray1[i];
            i++;
            k++;
        }
        while (j < tempArray2.length) {
            array[k] = tempArray2[j];
            j++;
            k++;
        }
        return array;
    }


    public int[] mergeSortFromBeginning(int[] array, int startIndex, int endIndex) {
        BubbleSort bubbleSort = new BubbleSort();
        if (startIndex < endIndex) {
            int mergeIndex = startIndex + (endIndex - startIndex) / 2;
            int[] tempArray1 = Arrays.copyOfRange(array, startIndex, mergeIndex + 1);
            tempArray1 = bubbleSort.bubbleSortFromBeginning(tempArray1);
            int[] tempArray2 = Arrays.copyOfRange(array, mergeIndex + 1, endIndex + 1);
            tempArray2 = bubbleSort.bubbleSortFromBeginning(tempArray2);
            array = merge(tempArray1, tempArray2, startIndex, array.length);
        }
        return array;
    }

    public int[] mergeSortFromEnd(int[] array, int startIndex, int endIndex) {
        BubbleSort bubbleSort = new BubbleSort();
        if (startIndex < endIndex) {
            int mergeIndex = startIndex + (endIndex - startIndex) / 2;
            int[] tempArray1 = Arrays.copyOfRange(array, startIndex, mergeIndex + 1);
            tempArray1 = bubbleSort.bubbleSortFromEnd(tempArray1);
            int[] tempArray2 = Arrays.copyOfRange(array, mergeIndex + 1, endIndex + 1);
            tempArray2 = bubbleSort.bubbleSortFromEnd(tempArray2);
            array = merge(tempArray1, tempArray2, startIndex, array.length);
        }
        return array;
    }

    public int[] mergeSortQuickSort(int[] array, int startIndex, int endIndex) {
        QuickSort quickSortObj = new QuickSort();
        if (startIndex < endIndex) {
            int mergeIndex = startIndex + (endIndex - startIndex) / 2;
            int[] tempArray1 = Arrays.copyOfRange(array, startIndex, mergeIndex + 1);
            tempArray1 = quickSortObj.quickSort(tempArray1, 0, tempArray1.length - 1);
            int[] tempArray2 = Arrays.copyOfRange(array, mergeIndex + 1, endIndex + 1);
            tempArray2 = quickSortObj.quickSort(tempArray2, 0, tempArray2.length - 1);
            array = merge(tempArray1, tempArray2, startIndex, array.length);
        }
        return array;
    }

    public int[] mergeSortStandardSort(int[] array, int startIndex, int endIndex) {
        StandardSort standardSortObj = new StandardSort();
        if (startIndex < endIndex) {
            int mergeIndex = startIndex + (endIndex - startIndex) / 2;
            int[] tempArray1 = Arrays.copyOfRange(array, startIndex, mergeIndex + 1);
            tempArray1 = standardSortObj.standardSort(tempArray1);
            int[] tempArray2 = Arrays.copyOfRange(array, mergeIndex + 1, endIndex + 1);
            tempArray2 = standardSortObj.standardSort(tempArray2);
            array = merge(tempArray1, tempArray2, startIndex, array.length);
        }
        return array;
    }
}
