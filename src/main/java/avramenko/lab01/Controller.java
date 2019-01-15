package avramenko.lab01;

import avramenko.lab01.fillers.Fillers;
import avramenko.lab01.output.ExcelOutput;
import avramenko.lab01.sorters.AbstractSorter;

/**
 * The Controller class consists launch method {@link Controller#main(String[])}.
 * @author Avramenko Kateryna
 * @version 1.3
 * @see AbstractSorter
 * @see avramenko.lab01.analyzer.Analyzer
 * @see Fillers
 */

public class Controller {

    /**
     * This method calls {@link ExcelOutput#reportCreation()} method.
     * @param args
     */
    public static void main(String[] args) {
        ExcelOutput excelOutput = new ExcelOutput();
        excelOutput.reportCreation();
    }
}
