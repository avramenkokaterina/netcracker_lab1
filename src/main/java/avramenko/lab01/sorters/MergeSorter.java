package avramenko.lab01.sorters;

public abstract class MergeSorter extends AbstractSorter {

    public abstract int[] sort(int[] array);

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
