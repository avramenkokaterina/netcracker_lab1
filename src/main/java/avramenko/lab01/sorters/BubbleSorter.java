package avramenko.lab01.sorters;

/**
 * <h1>BubbleSorter</h1>
 * <p>The BubbleSorter class is the abstract class with one abstract method
 * {@link BubbleSorter#sort(int[])} and one additional method {@link BubbleSorter#swap(int[], int, int)}.
 * It's a parent of two classes bubble sorters. It's a child of abstract class {@link AbstractSorter}</p>
 *
 * @author Avramenko Kateryna
 * @version 1.3
 * @see AbstractSorter
 * @see BubbleSorterFromEnd
 * @see BubbleSorterFromBeginning
 */

public abstract class BubbleSorter extends AbstractSorter {

    /**
     * Abstract method (@see sort).
     * @param array is entry array which is have to be sorted.
     * @return sorted array
     */
    public abstract int[] sort(int[] array);


    /**
     * Additional method for bubble sort. It swaps two elements of array.
     * @param array entry array
     * @param x first element, that have to be swapped with next element in array
     * @param y second element, that have o be swapped with previous element in array
     */
    void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
