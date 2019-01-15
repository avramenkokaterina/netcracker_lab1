package avramenko.lab01.sorters;

/**
 * <h1>AbstractSorter</h1>
 * <p>The AbstractSorter class is the abstract class with one abstract method
 * {@link AbstractSorter#sort(int[])}. It's a parent of other classes-sorters.</p>
 *
 * @author Avramenko Kateryna
 * @version 1.3
 * @see BubbleSorter
 * @see BubbleSorterFromBeginning
 * @see BubbleSorterFromEnd
 * @see MergeSorter
 * @see MergeSorterBubbleFromBeginning
 * @see MergeSorterBubbleFromEnd
 * @see MergeSorterStandard
 * @see MergeSorterQuick
 * @see QuickSorter
 * @see StandardSorter
 */

public abstract class AbstractSorter {

    /**
     * Abstract method (@see sort).
     * @param array is entry array which is have to be sorted.
     * @return sorted array
     */
    public abstract int[] sort(int[] array);

}
