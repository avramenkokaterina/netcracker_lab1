package avramenko.lab01.sorters;

/**
 * <h1>QuickSorter</h1>
 * <p>The QuickSorter class is the class that implements method
 * {@link QuickSorter#sort(int[])} and two additional methods: {@link QuickSorter#quickSort(int[], int, int)} and
 * {@link QuickSorter#partition(int[], int, int)}.
 * It's a child of abstract class {@link AbstractSorter}</p>
 *
 * @author Avramenko Kateryna
 * @version 1.3
 * @see AbstractSorter
 */
public class QuickSorter extends AbstractSorter {

    /**
     * This method implements quick sort algorithm. It gets array and then if length of array not 0, it send
     * array to method (@code quickSort(int[] array, int startIndex, int endIndex)).
     * @param array is entry array which is have to be sorted.
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException();
        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * This method choose partition index in array and divide entry array into two arrays,
     * based on partition index. {@link QuickSorter#partition(int[], int, int)} method determines partition index.
     * @param array entry array
     * @param startIndex first index of array
     * @param endIndex last index of array
     * @return sorted array
     */
    private int[] quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitioningIndex = partition(array, startIndex, endIndex);
            quickSort(array, startIndex, partitioningIndex - 1);
            quickSort(array, partitioningIndex + 1, endIndex);
        }
        return array;
    }

    /**
     * This method determines partition index.
     * @param array entry array
     * @param startIndex first index of array
     * @param endIndex last index of array
     * @return partition index
     */
    private int partition(int[] array, int startIndex, int endIndex) {
        int x = array[endIndex];
        int i = startIndex - 1;
        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] <= x) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[endIndex];
        array[endIndex] = temp;
        return i + 1;
    }
}
