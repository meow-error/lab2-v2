package com.example.lab2.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Import {

    private double[][] arr;
    private String[] arrNames;

    public void arr(File file) throws IOException, InvalidFormatException {

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet;

        int variant = 7; // Номер варианта

        if (workbook.getNumberOfSheets() > 7) {
            sheet = workbook.getSheetAt(variant - 1);
        } else {
            sheet = workbook.getSheetAt(0);
        }

        int numLastCol = sheet.getRow(0).getLastCellNum();

        arrNames = new String[numLastCol];
        arr = new double[numLastCol][sheet.getLastRowNum()];

        for (int i = 0; i < numLastCol; i++) {
            for (int j = 0; j <= sheet.getLastRowNum(); j++) {
                if (sheet.getRow(j).getCell(i) != null) {

                    if (sheet.getRow(j).getCell(i).getCellType() == CellType.STRING) {
                        arrNames[i] = sheet.getRow(j).getCell(i).getStringCellValue();
                    } else if (sheet.getRow(j).getCell(i).getCellType() == CellType.NUMERIC) {
                        arr[i][j - 1] = sheet.getRow(j).getCell(i).getNumericCellValue();
                    }
                }
            }
        }

        workbook.close();
    }

    public double[][] getArr() {
        return arr;
    }

    public String[] getArrNames() {
        return arrNames;
    }
}
