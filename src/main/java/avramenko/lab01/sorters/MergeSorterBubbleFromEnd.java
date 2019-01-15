package avramenko.lab01.sorters;

import java.util.Arrays;

/**
 * <h1>MergeSorterBubbleFromEnd</h1>
 * <p>The MergeSorterBubbleFromEnd is a child of abstract class {@link MergeSorter}.
 *  * This class implements abstract method {@link MergeSorter#sort(int[])} by using bubble sort from
 *  * last element. </p>
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
public class MergeSorterBubbleFromEnd extends MergeSorter {

    /**
     * This method divides entry array on two arrays. Then this two arrays are sorted by
     * {@link BubbleSorterFromEnd#sort(int[])} and then {@link MergeSorter#merge(int[], int[], int, int)}
     * method merge two arrays in one.
     * @param array is entry array which is have to be sorted.
     * @return sorted array
     */
    @Override
    public int[] sort(int[] array) {
        BubbleSorterFromEnd bubbleSorterFromEnd = new BubbleSorterFromEnd();

        int startIndex = 0;
        int endIndex = array.length - 1;
        int mergeIndex = array.length / 2 - 1;

        int[] tempArray1 = Arrays.copyOfRange(array, startIndex, mergeIndex + 1);
        int[] tempArray2 = Arrays.copyOfRange(array, mergeIndex + 1, endIndex + 1);

        tempArray1 = bubbleSorterFromEnd.sort(tempArray1);
        tempArray2 = bubbleSorterFromEnd.sort(tempArray2);

        array = merge(tempArray1, tempArray2, startIndex, array.length);

        return array;
    }
}