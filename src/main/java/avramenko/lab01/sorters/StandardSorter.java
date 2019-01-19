package avramenko.lab01.sorters;

import java.util.Arrays;
/**
 * <h1>StandardSorter</h1>
 * <p>The StandardSorter class is the class that implements method
 * {@link StandardSorter#sort(int[])}.
 * It's a child of abstract class {@link AbstractSorter}</p>
 *
 * @author Avramenko Kateryna
 * @version 1.3
 * @see AbstractSorter
 */

public class StandardSorter extends AbstractSorter {

    /**
     * This method implements java sort algorithm.
     * @param array is entry array which is have to be sorted.
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }

}
