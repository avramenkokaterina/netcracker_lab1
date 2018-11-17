package avramenko.lab01;

import avramenko.lab01.analyzer.Analysis;
import avramenko.lab01.output.View;


public class Controller {

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        View view = new View();
        int length = view.readNumber(1);
        int elementX = view.readNumber(2);
        analysis.startAnalysis(length, elementX);
        view.printResults(length, elementX, analysis);
    }
}
