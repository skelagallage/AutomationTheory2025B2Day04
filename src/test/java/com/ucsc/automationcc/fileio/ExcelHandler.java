package com.ucsc.automationcc.fileio;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ExcelHandler {

    private static Map<Integer, Object[]> studentDetails = new HashMap<>();

    static {
        studentDetails.put(1, new Object[]{"Sanath", 37});
        studentDetails.put(2, new Object[]{"Shama", 22});
        studentDetails.put(3, new Object[]{"Ishini", 26});
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

    public static void main(String[] args) throws IOException {
        ExcelHandler.writeExcel();
    }
}
