package avramenko.lab01;

import avramenko.lab01.analyzer.Analyzer;
import avramenko.lab01.output.ExcelOutput;
import avramenko.lab01.output.View;

import java.util.TreeMap;

import static avramenko.lab01.fillers.LengthGenerator.generateLength;

public class Controller {

    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer();
        View view = new View();
        int[] lengths = generateLength();
        for (int i = 0; i < lengths.length; i++) {
            TreeMap<String, Long> treeMap = analyzer.startAnalysis(lengths[i]);
            //view.printResults(treeMap);

        }
        ExcelOutput excelOutput = new ExcelOutput();
        excelOutput.reportCreation();
    }
}
