package avramenko.lab01.output;

import avramenko.lab01.analyzer.Analyzer;
import avramenko.lab01.fillers.ArraysGenerator;
import avramenko.lab01.fillers.Fillers;
import avramenko.lab01.fillers.LengthGenerator;
import avramenko.lab01.sorters.AbstractSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
import org.reflections.Reflections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static avramenko.lab01.fillers.LengthGenerator.generateLength;

public class ExcelOutput {

    public void reportCreation() {
        List<String> fillersNames = getFillers();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook.createSheet(fillersNames.get(0));
        XSSFSheet sheet2 = workbook.createSheet(fillersNames.get(1));
        XSSFSheet sheet3 = workbook.createSheet(fillersNames.get(2));
        XSSFSheet sheet4 = workbook.createSheet(fillersNames.get(3));
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

            createChart(sheet, data);

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

    private void createChart(XSSFSheet sheet, Object[][] data) {
        XSSFDrawing xlsxDrawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = xlsxDrawing.createAnchor(0, 0, 0, 0, 10, 0, 19, 20);
        XSSFChart lineChart = xlsxDrawing.createChart(anchor);
        XSSFChartLegend legend = lineChart.getOrCreateLegend();
        legend.setPosition(LegendPosition.BOTTOM);
        LineChartData dataChart = lineChart.getChartDataFactory().createLineChartData();
        ChartAxis bottomAxis = lineChart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = lineChart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 13, 0, 0));
        ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 13, 1, 1));
        ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 13, 2, 2));
        ChartDataSource<Number> ys3 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 13, 3, 3));
        ChartDataSource<Number> ys4 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 13, 4, 4));
        ChartDataSource<Number> ys5 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 13, 5, 5));
        ChartDataSource<Number> ys6 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 13, 6, 6));
        ChartDataSource<Number> ys7 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 13, 7, 7));
        ChartDataSource<Number> ys8 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 13, 8, 8));

        LineChartSeries chartSerie1 = dataChart.addSeries(xs, ys1);
        String name = data[0][1].toString();
        chartSerie1.setTitle(name);
        LineChartSeries chartSerie2 = dataChart.addSeries(xs, ys2);
        name = data[0][2].toString();
        chartSerie2.setTitle(name);
        LineChartSeries chartSerie3 = dataChart.addSeries(xs, ys3);
        name = data[0][3].toString();
        chartSerie3.setTitle(name);
        LineChartSeries chartSerie4 = dataChart.addSeries(xs, ys4);
        name = data[0][4].toString();
        chartSerie4.setTitle(name);
        LineChartSeries chartSerie5 = dataChart.addSeries(xs, ys5);
        name = data[0][5].toString();
        chartSerie5.setTitle(name);
        LineChartSeries chartSerie6 = dataChart.addSeries(xs, ys6);
        name = data[0][6].toString();
        chartSerie6.setTitle(name);
        LineChartSeries chartSerie7 = dataChart.addSeries(xs, ys7);
        name = data[0][7].toString();
        chartSerie7.setTitle(name);
        LineChartSeries chartSerie8 = dataChart.addSeries(xs, ys8);
        name = data[0][8].toString();
        chartSerie8.setTitle(name);

        lineChart.plot(dataChart, new ChartAxis[]{bottomAxis, leftAxis});
    }

    private Object[][] createData(String filler) {
        Object[][] time = new Object[14][9];

        List<String> sortersNames = getSorters();
        time[0][0] = "Array length";
        int w = 1;
        for (int i = 0; i < 8; i++) {
            time[0][w] = sortersNames.get(i);
            w++;
        }

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

    private List<String> getFillers() {
        Set<Method> fillersList = new HashSet<>();

        Method[] methods = ArraysGenerator.class.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Fillers.class)) {
                fillersList.add(method);
            }
        }
        List<String> fillersName = new ArrayList<>();
        for (Method filler : fillersList) {
            fillersName.add(filler.getAnnotation(Fillers.class).name());
        }
        Collections.sort(fillersName);
        return fillersName;
    }

    private List<String> getSorters() {
        Reflections reflections = new Reflections("avramenko.lab01.sorters");
        Set<Class<? extends AbstractSorter>> classes = reflections.getSubTypesOf(AbstractSorter.class);

        List<AbstractSorter> sorters = new ArrayList<>();
        for (Class<? extends AbstractSorter> aClass : classes) {
            try {
                AbstractSorter sorter = aClass.newInstance();
                sorters.add(sorter);
            } catch (Exception ex) {
            }
        }
        List<String> sortersName = new ArrayList<>();
        for (AbstractSorter sorter : sorters) {
            sortersName.add(sorter.getClass().getSimpleName());
        }
        Collections.sort(sortersName);
        return sortersName;
    }
}
