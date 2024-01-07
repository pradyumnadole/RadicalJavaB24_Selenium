package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelSheet {
	
	
	XSSFWorkbook wb;
	//HSSFWorkbook wb1;
	XSSFSheet sheet ;
	
	public ReadExcelSheet(String excelPath) throws InvalidFormatException, IOException{
		
		File srcFile = new File(excelPath);
		FileInputStream fis = new FileInputStream(srcFile);
		//Read excel file
		wb = new XSSFWorkbook(fis); //xlsx
		//wb1 = new HSSFWorkbook(fis); //xls
		//get sheet
		sheet = wb.getSheetAt(0);
		wb.close();
	}
	
	public String getCellData(int sheetNumber, int row, int column){
		//sheet =wb.getSheetAt(sheetNumber);
		String data0;
		try{
			data0 = sheet.getRow(row).getCell(column).getStringCellValue();
		}catch(Exception e){
			data0 = "";
		}
		return data0;
	}
	
//	public String putCellData(int sheetNumber, int row, int column){
//		//sheet =wb.getSheetAt(sheetNumber);
//		String data0;
//		try{
//			data0 = sheetgetRow(row).getCell(column).getStringCellValue();
//		}catch(Exception e){
//			data0 = "";
//		}
//		return data0;
//	}
	
	public int getRowCount(int sheetNumber){
		int rowCNT = wb.getSheetAt(sheetNumber).getLastRowNum();
		return rowCNT;
	}
	
	
	

}
