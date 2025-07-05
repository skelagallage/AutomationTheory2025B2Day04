package com.ucsc.automationcc.fileio;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ExcelHandler {

    private static Map<Integer, Object[]> studentDetails = new HashMap<>();

    static {
        studentDetails.put(1, new Object[]{"Name", "Age"});
        studentDetails.put(2, new Object[]{"Sanath", 37});
        studentDetails.put(3, new Object[]{"Shama", 22});
        studentDetails.put(4, new Object[]{"Ishini", 26});
    }

    public static void writeExcel() throws IOException {
        OutputStream outputStream = new FileOutputStream("studentDetails.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("sheet01");

        IntStream.range(0, studentDetails.size()).forEach(index -> {
            XSSFRow xssfRow = xssfSheet.createRow(index);
            Object[] objArr = studentDetails.get(index+1);
            for(int c = 0; c<objArr.length; c++){
                XSSFCell xssfCell = null;
                if(objArr[c] instanceof Integer){
                    xssfCell = xssfRow.createCell(c, CellType.NUMERIC);
                    xssfCell.setCellValue(Integer.parseInt(objArr[c].toString()));
                }else{
                    xssfCell = xssfRow.createCell(c, CellType.STRING);
                    xssfCell.setCellValue(objArr[c].toString());
                }

            }
        });

        xssfWorkbook.write(outputStream);
    }

    public static List<Map<String, String>> readExcel(String excelFilePath,
                                                      String sheetName)
            throws IOException {
        List<Map<String, String>> returnList = new ArrayList<>();
        InputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
        List<String> heading = new ArrayList<>();
        for(int i=0; i<=xssfSheet.getLastRowNum(); i++){
            Map<String, String> rowDictionary = new HashMap<>();
            XSSFRow xssfRow = xssfSheet.getRow(i);
            for (int c=0; c<xssfRow.getLastCellNum(); c++){
                if(i==0){
                    heading.add(xssfRow.getCell(c).getStringCellValue());
                }else{
                    if(xssfRow.getCell(c).getCellType() == CellType.NUMERIC){
                        rowDictionary.put(heading.get(c), String.valueOf(xssfRow.getCell(c).
                                getNumericCellValue()));
                    }else{
                        rowDictionary.put(heading.get(c), xssfRow.getCell(c).getStringCellValue());
                    }

                }
            }
            if(i != 0)
                returnList.add(rowDictionary);
        }
        return returnList;
    }

    public static void main(String[] args) throws IOException {
        ExcelHandler.writeExcel();
    }

}
