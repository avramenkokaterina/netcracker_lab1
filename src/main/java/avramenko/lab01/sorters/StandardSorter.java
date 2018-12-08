package avramenko.lab01.sorters;

import java.util.Arrays;

public class StandardSorter extends AbstractSorter{

    @Override
    public int[] sort(int[] array){
        Arrays.sort(array);
        return array;
    }

}
