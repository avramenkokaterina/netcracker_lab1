package avramenko.lab01.sorters;

/**
 * <h1>BubbleSorterFromBeginning</h1>
 * <p>The BubbleSorterFromBeginning is a child of abstract class {@link BubbleSorter}.
 * This class implements abstract method {@link BubbleSorter#sort(int[])} by using bubble sort from
 * first element. </p>
 *
 * @author Avramenko Kateryna
 * @version 1.3
 * @see AbstractSorter
 * @see BubbleSorterFromEnd
 * @see BubbleSorterFromBeginning
 */

public class BubbleSorterFromBeginning extends BubbleSorter {

   /**
     * This method implements bubble sort from beginning algorithm. It gets array and then in 2 cycles it checks
     * does current element less, that next. If so, they stay in the same order. If not, they swapping.
     * @param array is entry array which is have to be sorted.
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }
}
