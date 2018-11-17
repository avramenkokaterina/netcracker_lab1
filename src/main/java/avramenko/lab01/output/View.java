package avramenko.lab01.output;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class View {

    public int readNumber(int param) {
        if (param == 1) {
            System.out.println("Enter length of arrays");
        } else {
            System.out.println("Enter element X");
        }
        Scanner in = new Scanner(System.in);
        int number;
        do {
            System.out.println();
            while (!in.hasNextInt()) {
                System.out.println("Not a number. Please, enter number.");
                in.next();
            }
            number = in.nextInt();
        } while (number < 0);
        return number;
    }

    public void printResults(TreeMap<String, Long> treeMap) {
        for (Map.Entry<String, Long> item : treeMap.entrySet()) {
            System.out.println("Sort and Array: " + item.getKey());
            System.out.println("Time: " + item.getValue() + " nanoseconds");
            System.out.println();
        }
    }

}
