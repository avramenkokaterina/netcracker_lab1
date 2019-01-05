package avramenko.lab01.output;

import avramenko.lab01.analyzer.Analyzer;
import avramenko.lab01.fillers.LengthGenerator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static avramenko.lab01.fillers.LengthGenerator.generateLength;

public class ExcelOutput {

    public void reportCreation() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook.createSheet("Random filled array");
        XSSFSheet sheet2 = workbook.createSheet("Reversed Array");
        XSSFSheet sheet3 = workbook.createSheet("Sorted Array");
        XSSFSheet sheet4 = workbook.createSheet("Sorted array with element X at the end");
        XSSFSheet[] sheets = {sheet1, sheet2, sheet3, sheet4};


        int rowNum = 0;

        for (XSSFSheet sheet : sheets) {
            Object[][] data = createData(sheet.getSheetName());
            for (Object[] record : data) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (Object field : record) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else {
                        if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        } else if (field instanceof Long) {
                            cell.setCellValue((Long) field);
                        }
                    }
                }
            }
            rowNum = 0;
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(new File("D:\\Programming\\NetCracker\\labs\\AnalysisReport.xlsx"));
            workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object[][] createData(String filler) {
        Object[][] time = new Object[14][9];
        time[0][0] = "Array length";
        time[0][1] = "Bubble From Beginning";
        time[0][2] = "Bubble From End";
        time[0][3] = "Merge Bubble From Beginning";
        time[0][4] = "Merge Bubble From End";
        time[0][5] = "Merge Quick";
        time[0][6] = "Merge Java";
        time[0][7] = "Quick Sorter";
        time[0][8] = "Java Sorter";

        LengthGenerator lengthGenerator = new LengthGenerator();
        int[] lengths = lengthGenerator.generateLength();
        long[] times = getDataForCurrentFiller(filler);

        int k = 0;
        int m = 0;

        for (int i = 1; i < lengths.length + 1; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0) {
                    time[i][j] = lengths[m];
                    m++;
                } else {
                    time[i][j] = times[k];
                    k++;
                }
            }
        }
        return time;
    }


    private long[] getDataForCurrentFiller(String filler) {
        long[] currentFillerResult = new long[104];
        TreeMap<String, Long> treeMap;
        Analyzer analyzer = new Analyzer();
        int[] lengths = generateLength();
        int k = 0;
        for (int i = 0; i < lengths.length; i++) {
            treeMap = analyzer.startAnalysis(lengths[i]);
            for (Map.Entry<String, Long> item : treeMap.entrySet()) {
                Pattern pattern = Pattern.compile(filler);
                Matcher matcher = pattern.matcher(item.getKey());
                if (matcher.find()) {
                    currentFillerResult[k] = item.getValue();
                    k++;
                }
            }
        }
        return currentFillerResult;
    }
}
