package avramenko.lab01.sorters;

public class BubbleSorterFromEnd extends BubbleSorter {

    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1])
                    swap(array, j, j - 1);
            }
        }
        return array;
    }
}
