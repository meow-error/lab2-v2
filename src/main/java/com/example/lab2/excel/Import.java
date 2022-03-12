package com.example.lab2.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Import {

    private double[][] arr;

    public void arr(File file) throws IOException, InvalidFormatException {

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        int variant = 7; // Номер варианта
        XSSFSheet sheet = workbook.getSheetAt(variant - 1);

        int numLastCol = sheet.getRow(1).getLastCellNum();

        arr = new double[numLastCol][sheet.getLastRowNum()];
        for (int i = 0; i < numLastCol; i++) {
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                arr[i][j - 1] = sheet.getRow(j).getCell(i).getNumericCellValue();
            }
        }
        workbook.close();
    }

    public double[][] getArr() {
        return arr;
    }
}
