package avramenko.lab01;

import avramenko.lab01.analyzer.Analysis;

import avramenko.lab01.output.View;

import java.util.TreeMap;

import static avramenko.lab01.fillers.GenerateLength.generateLength;

public class Controller {

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        View view = new View();
        int[] lengths = generateLength();
        for (int i = 0; i < lengths.length; i++) {
            TreeMap<String, Long> treeMap = analysis.startAnalysis(lengths[i]);
            view.printResults(treeMap);
        }
    }
}
