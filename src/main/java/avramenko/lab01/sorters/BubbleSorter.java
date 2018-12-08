package avramenko.lab01.sorters;

public abstract class BubbleSorter extends AbstractSorter {

    public abstract int[] sort(int[] array);

    void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
