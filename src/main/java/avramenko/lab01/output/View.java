package avramenko.lab01.output;

import java.util.Map;
import java.util.TreeMap;

public class View {

    public void printResults(TreeMap<String, Long> treeMap) {
        for (Map.Entry<String, Long> item : treeMap.entrySet()) {
            System.out.println("Sort and Array: " + item.getKey());
            System.out.println("Time: " + item.getValue() + " nanoseconds");
            System.out.println();
        }
    }

}
