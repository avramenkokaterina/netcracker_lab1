package avramenko.lab01.sorters;

/**
 * <h1>MergeSorter</h1>
 * <p>The MergeSorter class is the abstract class with one abstract method
 * {@link MergeSorter#sort(int[])} and one additional method {@link MergeSorter#merge(int[], int[], int, int)}.
 * It's a parent of four classes merge sorters. It's a child of abstract class {@link AbstractSorter}</p>
 *
 * @author Avramenko Kateryna
 * @version 1.3
 * @see AbstractSorter
 * @see MergeSorterBubbleFromBeginning
 * @see MergeSorterBubbleFromEnd
 * @see MergeSorterQuick
 * @see MergeSorterQuick
 * @see MergeSorterStandard
 */

public abstract class MergeSorter extends AbstractSorter {

    /**
     * Abstract method (@see sort).
     * @param array is entry array which is have to be sorted.
     * @return sorted array
     */
    public abstract int[] sort(int[] array);

    /**
     * Additional method for merge two arrays.
     * @param tempArray1 first array which is have to be merged
     * @param tempArray2 second array which is have to be merged
     * @param startIndex index from method start to merge arrays
     * @param length length of merged array
     * @return one array, which consists two merged arrays.
     */
    int[] merge(int[] tempArray1, int[] tempArray2, int startIndex, int length) {
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
}
