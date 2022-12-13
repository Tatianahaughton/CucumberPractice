package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ExcelReader {

    static Workbook book;
    static Sheet sheet;

    public static void openExcel(String filePath)  {
        try {
            FileInputStream fis=new FileInputStream(filePath);
            book=new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getSheet(String sheetName){
        sheet=book.getSheet(sheetName);//opening the sheet
    }
//getting row count
    public static int getRowCount(){
        return sheet.getPhysicalNumberOfRows();
    }
//getting column count
    public static int getColsCount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }
//getting cell data in String format
    public static String getCellData(int rowIndex,int colIndex){
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }
//getting List of maps having data from Excel file
    public static List<Map<String,String>>excelListIntoMap(String filePath,String sheetName){
        openExcel(filePath);
        getSheet(sheetName);

        //creating a list of maps for all the rows
        List<Map<String,String>>listData=new ArrayList<>();
        //loop-outer loops takes care off Rows
        //row 0 is all keys and row 1 are values
        for(int row=1; row<getRowCount(); row++){
            //creating a map for every row
            Map<String,String>map=new LinkedHashMap<>();

            //cell 0 first cell but less than amount of cells in a row?..
            for(int col=0; col<getColsCount(row); col++){
                map.put(getCellData(0,col),getCellData(row,col));//getCellData to get the keys
            }
            listData.add(map);
        }
        return listData;
    }
}
