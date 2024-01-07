package basic;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class B24MyReadExcel {

	@Test
	public void testcase1() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("D:\\RadicalSelenium\\Test.xlsx");
		XSSFSheet sh = wb.getSheetAt(0);

		String cellval = sh.getRow(0).getCell(0).toString();
		System.out.println("Value is = " + cellval);

		int rowcount = sh.getPhysicalNumberOfRows();
		System.out.println("rowcount = " + rowcount);
		int colcount = sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println("colcount= " + colcount);
		for (int i = 0; i < rowcount; i++) {

			for (int j = 0; j < colcount; j++) {

				String val1 = sh.getRow(i).getCell(j).toString();
				System.out.println("Values from excel cell  : " + val1);

			}

		}

	}

}
