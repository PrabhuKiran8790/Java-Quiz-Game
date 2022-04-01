package com.prabhu.quiz_app;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadExcel {
    String path;

    ReadExcel(String path) {
        this.path = path;
    }

    int[] getRowsColumnsCount() {
        path = this.path;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert wb != null;
        Sheet sheet = wb.getSheetAt(0);
        return new int[]{sheet.getLastRowNum(), sheet.getRow(0).getLastCellNum()};
    }

    String readCellData(int vRow, int vColumn) {
        String value;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(this.path);
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert wb != null;
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(vRow);
        Cell cell = row.getCell(vColumn);
        value = cell.toString();
        return cell.toString();
    }

    String[] getQuestions() {
        int rows = getRowsColumnsCount()[0];
        String[] questions = new String[rows];
        for (int i = 1; i < rows+1; i++) {
            questions[i-1] = readCellData(i, 0);
        }
        return questions;
    }

    String[][] getOptions() {
        int rows = getRowsColumnsCount()[0];
        String[][] options = new String[rows][4];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= 4; j++) {
                options[i-1][j-1] = readCellData(i, j);
            }
        }
        return options;
    }

    String[] getCorrectOptions() {
        int rows = getRowsColumnsCount()[0];
        String[] correctOptions = new String[rows];
        for (int i = 1; i < rows+1; i++) {
            correctOptions[i-1] = readCellData(i, 5);
        }
        return correctOptions;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        path = path.concat("\\src\\com\\prabhu\\quiz_app\\data.xlsx");
        ReadExcel sheet = new ReadExcel(path);
        System.out.println(Arrays.toString(sheet.getRowsColumnsCount()));
        System.out.println(Arrays.toString(sheet.getQuestions()));
        System.out.println(Arrays.deepToString(sheet.getOptions()));
        System.out.println(Arrays.toString(sheet.getCorrectOptions()));
    }
}
