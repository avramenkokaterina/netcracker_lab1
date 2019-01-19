package avramenko.lab01.analyzer;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

public class AnalyzerTest {

    @Test(timeout = 60000)
    public void startAnalysisTimeTest() {
        int length = 1000;
        Analyzer analyzer = new Analyzer();
        analyzer.startAnalysis(length);
    }

    @Test(expected = NullPointerException.class)
    public void startAnalysisExceptionTest(){
        TreeMap<String, Long> treeMap = new TreeMap<>();
        int length = 1000;
        Analyzer analyzer = new Analyzer();
        treeMap = analyzer.startAnalysis(length);
        boolean isNull = false;
        if (treeMap == null) {
            isNull = true;
            Assert.assertTrue("Oh no..." ,isNull);
        }
    }
}