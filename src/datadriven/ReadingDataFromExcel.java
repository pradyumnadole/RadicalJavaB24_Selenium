package datadriven;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingDataFromExcel {
	
	XSSFSheet sheet = null;
	@Test
	public void readExcel() throws IOException{
		
		//xlsx
		XSSFWorkbook wb = new XSSFWorkbook("src/datadriven/loginDemo.xlsx");
		
		//xls
		//HSSFWorkbook wb = new HSSFWorkbook(s)
		sheet = wb.getSheetAt(0);
		
		String cellValue = sheet.getRow(0).getCell(0).getStringCellValue();
		String cellValue1 = sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Value1  = "+cellValue + "   value 2 ="+cellValue1);
		Object[][] data = new Object[3][2];
		
		for(int i = 0; i< 10; i++ ){
			for(int j =0; j<2;j++){
				String cell1 = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print("   Value1  = "+cell1 );
				data[3][2] = cell1;
			}
			System.out.println(" ");
		}
		wb.close();
		
	}
	
	String getCellValue(XSSFSheet sheet){
		String cell1 = null;
		try{
			cell1 = sheet.getRow(2).getCell(1).getStringCellValue();
		}catch(NullPointerException e){
			cell1="";
		}
		return cell1;
	}

}
