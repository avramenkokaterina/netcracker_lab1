package avramenko.lab01.sorters;

public class BubbleSort {

    public int[] bubbleSortFromBeginning(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public int[] bubbleSortFromEnd(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1])
                    swap(array, j, j - 1);
            }
        }
        return array;
    }

    public int[] swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
        return array;
    }
}
