package avramenko.lab01.sorters;

public class QuickSorter extends AbstractSorter {


    @Override
    public int[] sort(int[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException();
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private int[] quickSort(int[] array, int startIndex, int endIndex){
        if (startIndex<endIndex){
            int partitioningIndex = partition(array, startIndex, endIndex);
            quickSort(array, startIndex, partitioningIndex-1);
            quickSort(array, partitioningIndex+1, endIndex);
        }
        return array;
    }

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
