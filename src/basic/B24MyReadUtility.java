package basic;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class B24MyReadUtility {
	
	XSSFWorkbook wb = null;
	XSSFSheet sheet = null;
	String xlspath = null;
	int sheetNum1;

	public B24MyReadUtility(String xlspath , int sheetNum ) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook(xlspath);
		sheet = wb.getSheetAt(sheetNum);
		sheetNum1 = sheetNum;
	}
	
	public String getcellvalue(int sheetNumber, int rowNum, int colNum) {
		String cellval  = null;
		try {
			cellval = sheet.getRow(rowNum).getCell(colNum).toString();	
		}catch (Exception e) {
			cellval = "";
		}
		//System.out.println("value is " +cellval);
		return cellval;		
	}
	
	public int getLastRowNum() {		
		return sheet.getPhysicalNumberOfRows();	
	
	}
	
	public int getLastColNum() {	
		return sheet.getRow(sheetNum1).getLastCellNum();			
	}

}
