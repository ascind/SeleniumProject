package firsttestngpackage;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class writeexcel {
  @Test
  public void writeExcel() throws IOException{
	  
	  String excelFileName = "D:\\Selenium\\TestData\\TestOutputs.xls";//name of excel file

		String sheetName1 = "Sheet2";//name of sheet
				
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName1) ;
			
		//Enter Column Headers
		for (int row=0;row<2;row++ )
		{
			HSSFRow rows = sheet.createRow(row);
				
			for (int col=0;col < 5; col++ )
			{
				HSSFCell cells = rows.createCell(col);
								
				cells.setCellValue("Header"+col);
	
			}
		}
		
		//Enter column values
		for (int r=1;r < 50; r++ )
		{
			HSSFRow row = sheet.createRow(r);
				
			//iterating c number of columns
			for (int c=0;c < 5; c++ )
			{
				HSSFCell cell = row.createCell(c);
								
				cell.setCellValue("Written out"+r+" "+c);
	
			}
		}
		
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
 
	  
  }
}
