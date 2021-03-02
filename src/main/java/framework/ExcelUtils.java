package framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils extends WaitUtils{
	public static Object getCellData(String fileName,String sheetName,int rowNumber,int columnNumber) {
		try {
			FileInputStream fis=new FileInputStream(fileName);
			XSSFWorkbook wbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=wbook.getSheet(sheetName);
			XSSFRow row=sheet.getRow(rowNumber);
			XSSFCell cell=row.getCell(columnNumber);
			CellType cellType=cell.getCellType();
			Object celldata1;
			if(cellType.equals(CellType.STRING)) {
				celldata1=cell.getStringCellValue();
			}
			else if(cellType.equals(CellType.BOOLEAN))
				celldata1=cell.getBooleanCellValue();
			else if(cellType.equals(CellType.NUMERIC))
				celldata1=cell.getNumericCellValue();
			else{
				celldata1 = null;
			}
			return celldata1;
		}
		catch (Exception e) {
			return null;
		}
	}
	public static void writeCellData(String fileName,String sheetName,int rowNumber,int columnNumber,String cellData) {
		try {
			FileInputStream fis=new FileInputStream(fileName);
			XSSFWorkbook wbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=wbook.getSheet(sheetName);
			XSSFRow row;
			try {
				row=sheet.getRow(rowNumber);
			}
			catch (Exception e) {
				 row=sheet.createRow(rowNumber);
			}		
			XSSFCell cell=row.createCell(columnNumber);
			cell.setCellValue(cellData);
			FileOutputStream fos=new FileOutputStream(fileName);
			wbook.write(fos);
		}
		catch (Exception e) {
			System.out.println("Unable to write data into Excel Sheet");
		}
	}
	public static Map<String,Object> getRowData(String fileName,String sheetName,String scenarioName,int scenarioNameColumnNumber){
		try {
			FileInputStream fis=new FileInputStream(fileName);//Reading file path
			XSSFWorkbook wbook=new XSSFWorkbook(fis);//reading Workbook data 
			XSSFSheet sheet=wbook.getSheet(sheetName);//reading sheet data
			Iterator<Row> rowIterartor=sheet.rowIterator();//Creating rowIterator
			Map<String,Object> rowData=new HashMap<>();//Creating a map to save key value pairs
			while(rowIterartor.hasNext()) {//Checking next row has data
				Row row=rowIterartor.next();//Navigating to next row
				
				if(row.getCell(scenarioNameColumnNumber).getStringCellValue().equals(scenarioName))//getting scenario Name and commparing the same with required scenario Name
				{
					int columnNumber=0;//To get cellNumber
					Iterator<Cell> cellIterator=row.cellIterator();//Creating a cell iterator
					while(cellIterator.hasNext()) {//checking cell as next value
						Cell cell=cellIterator.next();//Navigating to next cell
						CellType cellType=cell.getCellType();//getting cell data type
						Object celldata1=null;
						if(cellType.equals(CellType.STRING)) {
							celldata1=cell.getStringCellValue();
						}
						else if(cellType.equals(CellType.BOOLEAN))
							celldata1=cell.getBooleanCellValue();
						else if(cellType.equals(CellType.NUMERIC))
							celldata1=cell.getNumericCellValue();
						String columnHeader=sheet.getRow(0).getCell(columnNumber).getStringCellValue();
						rowData.put(columnHeader, celldata1);
						columnNumber++;
					}
					break;
				}
			}
			return rowData;
		}
		catch (Exception e) {
			return null;
		}
	}
	public static Object[][] getSheetData(String fileName,String sheetName){
		try{
			FileInputStream fis=new FileInputStream(fileName);
			XSSFWorkbook wbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=wbook.getSheet(sheetName);
			int numberofRows=sheet.getLastRowNum();
			int numberOFColumns=sheet.getRow(0).getLastCellNum();
			Object[][] sheetData=new Object[numberofRows][numberOFColumns];
			int rowNumber=0;
			int columnNumber=0;
			Iterator<Row> rowIterator=sheet.rowIterator();
			rowIterator.next();
			while(rowIterator.hasNext()) {
				Row rowData=rowIterator.next();
				Iterator<Cell> cellIterator=rowData.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell=cellIterator.next();
					CellType cellType=cell.getCellType();//getting cell data type
					Object celldata1=null;
					if(cellType.equals(CellType.STRING)) {
						celldata1=cell.getStringCellValue();
					}
					else if(cellType.equals(CellType.BOOLEAN))
						celldata1=cell.getBooleanCellValue();
					else if(cellType.equals(CellType.NUMERIC))
						celldata1=cell.getNumericCellValue();
					sheetData[rowNumber][columnNumber]=celldata1;
					columnNumber++;
				}
				rowNumber++;
				columnNumber=0;
			}
			return sheetData;
		}
		catch (Exception e) {
			return null;
		}
	}
}
