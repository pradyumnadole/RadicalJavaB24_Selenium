package datadriven;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class B23ReadExcell {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("src/datadriven/TestData.xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		
		String data1 = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Value in excell 0 0 = "+data1);
		System.out.println("=================== ");
		
		String value;
		for(int i =0;i<5;i++){
			for(int j = 0; j<2;j++){
				value = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value + " ");
			}
			System.out.println("");
		}

	}

}
