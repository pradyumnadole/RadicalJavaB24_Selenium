package basic;

import java.io.IOException;

public class B24MyReadExcelNew {

	public static void main(String[] args) throws IOException {
		B24MyReadUtility excelUtility = new B24MyReadUtility ("D:\\RadicalSelenium\\Test.xlsx",0);

		int totalRows = excelUtility.getLastRowNum();
		int totalCols = excelUtility.getLastColNum();
		String celldata = null;
		
		for(int i =0;i<totalRows;i++) {
			for (int j =0;j<totalCols;j++) {
				celldata = excelUtility.getcellvalue(0, i, j);
				System.out.println("Data is " + celldata);
			}
			
			
		}
		
		
		
	}

}
