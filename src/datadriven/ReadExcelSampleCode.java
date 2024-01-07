package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelSampleCode {
	
	@Test
	public void readExcel() throws IOException{
		
//		String excelPath=
//				"D:\\IBM\\workspace\\RadicalSelenium1\\src\\datadriven\\loginDemo.xlsx";
//		
//		File srcFile = new File(excelPath);
//		FileInputStream fis = new FileInputStream(srcFile);
		//Read excel file
		XSSFWorkbook wb = new XSSFWorkbook("D:\\IBM\\workspace\\RadicalSelenium1\\src\\datadriven\\loginDemo.xlsx"); //xlsx
		//HSSFWorkbook wb1 = new HSSFWorkbook(fis); //xls
		//get sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		wb.close();
		
		int rowCNT = wb.getSheetAt(0).getLastRowNum();
		int colCNT = 2;
		
		for(int i=0;i<rowCNT;i++ ){
			String cell1 =sheet.getRow(i).getCell(0).getStringCellValue();
			String cell2 =sheet.getRow(i).getCell(1).getStringCellValue();
			
			System.out.println("value 1= "+cell1+ "    value 2="+cell2);
		}
		
	}

}
