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
public class MergeSorterBubbleFromEnd extends MergeSorter implements Runnable {
    private int[] array;
    private int recursiveLevel;
    private int[] result;

    public MergeSorterBubbleFromEnd() {
    }

    public MergeSorterBubbleFromEnd(int[] array, int recursiveLevel, int[] result) {
        this.array = array;
        this.recursiveLevel = recursiveLevel;
        this.result = result;
    }

    /**
     * This method divides entry array on two arrays. Then this two arrays are sorted by
     * {@link BubbleSorterFromEnd#sort(int[])} and then {@link MergeSorter#merge(int[], int[], int, int)}
     * method merge two arrays in one.
     *
     * @param array is entry array which is have to be sorted.
     * @return sorted array
     */

    @Override
    public int[] sort(int[] array) {
        this.result = new int[array.length];
        try {
            mergeSort(array, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = this.result[i];
        }
        return array;
    }

    @Override
    public void run() {
        try {
            mergeSort(array, recursiveLevel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mergeSort(int[] array, int recursiveLevel) throws InterruptedException {
        long threadCount = Math.round(-(1 - Math.pow(2, recursiveLevel)));
        if (Runtime.getRuntime().availableProcessors() > threadCount) {
            recursiveLevel++;

            int startIndex = 0;
            int endIndex = array.length;
            int mergeIndex = array.length / 2;

            int[] tempArray1 = Arrays.copyOfRange(array, startIndex, mergeIndex);
            int[] tempArray2 = Arrays.copyOfRange(array, mergeIndex, endIndex);

            int[] result1 = new int[mergeIndex];
            int[] result2 = new int[endIndex - mergeIndex];
            Runnable runnable1 = new MergeSorterBubbleFromEnd(tempArray1, recursiveLevel, result1);
            Runnable runnable2 = new MergeSorterBubbleFromEnd(tempArray2, recursiveLevel, result2);
            Thread thread1 = new Thread(runnable1);
            Thread thread2 = new Thread(runnable2);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            int[] tempResult = merge(result1, result2, startIndex, array.length);
            for (int i = 0; i < tempResult.length; i++){
                this.result[i] = tempResult[i];
            }
        } else {
            BubbleSorterFromEnd bubbleSorterFromEnd = new BubbleSorterFromEnd();
            int[] tempResult = bubbleSorterFromEnd.sort(array);
            for (int i = 0; i < tempResult.length; i++){
                this.result[i] = tempResult[i];
            }
        }
    }
}