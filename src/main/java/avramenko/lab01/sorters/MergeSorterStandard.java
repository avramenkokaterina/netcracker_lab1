package avramenko.lab01.sorters;

import java.util.Arrays;

public class MergeSorterStandard extends MergeSorter {

    @Override
    public int[] sort(int[] array) {
        StandardSorter standardSorter = new StandardSorter();

        int startIndex = 0;
        int endIndex = array.length - 1;
        int mergeIndex = array.length / 2 - 1;

        int[] tempArray1 = Arrays.copyOfRange(array, startIndex, mergeIndex + 1);
        int[] tempArray2 = Arrays.copyOfRange(array, mergeIndex + 1, endIndex + 1);

        tempArray1 = standardSorter.sort(tempArray1);
        tempArray2 = standardSorter.sort(tempArray2);

        array = merge(tempArray1, tempArray2, startIndex, array.length);

        return array;
    }
}
