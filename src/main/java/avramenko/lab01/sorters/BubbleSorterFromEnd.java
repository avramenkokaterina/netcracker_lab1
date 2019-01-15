package avramenko.lab01.sorters;

/**
 * <h1>BubbleSorterFromEnd</h1>
 * <p>The BubbleSorterFromEnd is a child of abstract class {@link BubbleSorter}.
 * This class implements abstract method {@link BubbleSorter#sort(int[])} by using bubble sort from
 * last element. </p>
 *
 * @author Avramenko Kateryna
 * @version 1.3
 * @see AbstractSorter
 * @see BubbleSorterFromEnd
 * @see BubbleSorterFromBeginning
 */

public class BubbleSorterFromEnd extends BubbleSorter {

    /**
     * This method implements bubble sort from end algorithm. It gets array and then in 2 cycles it checks
     * does current element less, that next. If so, they stay in the same order. If not, they swapping.
     * @param array is entry array which is have to be sorted.
     * @return sorted array
     */
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
