package firsttestngpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class ReadWriteExcelFile {
  @Test
  public void writeExcel() throws IOException, InvalidFormatException{
	  
	  String excelFileName = "D:\\Selenium\\TestData\\TestOutputs.xls";//name of excel file
	  try {
			FileOutputStream fileOut = new FileOutputStream(excelFileName);
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("Sheet1");
			
			/*******************************Create 4 Headers in the excel file***************************	
			index from 0,0... cell A1 is cell(0,0) 
			Header1: UserNames
			Header2: Passwords
			Header3: Status
			Header4: Date
			********************************************************************************************/
			
			HSSFRow row1 = worksheet.createRow((short) 0); 

			HSSFCell cellA1 = row1.createCell(0);
			cellA1.setCellValue("UserNames");
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.BLUE.index);
			cellStyle.setFillPattern(HSSFCellStyle.BORDER_THICK);
			cellStyle.setFillPattern(HSSFCellStyle.ALIGN_CENTER);
			cellA1.setCellStyle(cellStyle);

			HSSFCell cellB1 = row1.createCell((short) 1);
			cellB1.setCellValue("Passwords");
			cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			cellStyle.setFillPattern(HSSFCellStyle.BORDER_THICK);
			cellStyle.setFillPattern(HSSFCellStyle.ALIGN_CENTER);
			cellB1.setCellStyle(cellStyle);

			HSSFCell cellC1 = row1.createCell((short) 2);
			cellC1.setCellValue("Status");
			cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.BROWN.index);
			cellStyle.setFillPattern(HSSFCellStyle.BORDER_THICK);
			cellStyle.setFillPattern(HSSFCellStyle.ALIGN_CENTER);
			cellC1.setCellStyle(cellStyle);

			HSSFCell cellD1 = row1.createCell((short) 3);
			cellD1.setCellValue("Date");
			cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
			cellStyle.setFillPattern(HSSFCellStyle.BORDER_THICK);
			cellStyle.setFillPattern(HSSFCellStyle.ALIGN_CENTER);
			cellD1.setCellStyle(cellStyle);
			
			
			/*******************************Enter values in respective columns***************************	
			
			Header1 is filled up with UserNames array values
			Header2 is filled up with Password array values
			Header3 is filled up with Status array values
			Header4 is filled up with today's Date and time values
			*/
			
			// Stored Usernames in an arrary
	        String[] UserNames={"User1","User2","User3","User4","User5","User6"};
	        String[] Passwords={"Password1","Password2","Password3","Password4","Password5","Password6"};
	        String[] Status={"Passed","Failed","Passed","Failed","Passed","Failed"};
	        
	        for(int intcounter=1;intcounter<UserNames.length;intcounter++){
	        	HSSFRow row = worksheet.createRow((short) intcounter);
	        	
				HSSFCell cell = row.createCell((short) 0);
				cell.setCellValue(UserNames[intcounter-1]);
				
				HSSFCell cell1 = row.createCell((short) 1);
				cell1.setCellValue(Passwords[intcounter-1]);
				
				HSSFCell cell2 = row.createCell((short) 2);
				cell2.setCellValue(Status[intcounter-1]);
				cellStyle = workbook.createCellStyle();
				cell2.setCellStyle(cellStyle);
				
				HSSFCell cell3 = row.createCell((short) 3);
				cell3.setCellValue(new Date());
				cellStyle = workbook.createCellStyle();
				cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
				cell3.setCellStyle(cellStyle);
	        }
			
							
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			
			
			/*******************************Read from the excel file***************************	
			
			Values stored in the excel file are read and displayed in the Console window
		
			*/
			FileInputStream fileInputStream = new FileInputStream(excelFileName);
			HSSFWorkbook workbooks = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheets = workbook.getSheet("Sheet1");
			
			int totalrows=worksheets.getLastRowNum();
			for(int rowcount=1;rowcount<totalrows;rowcount++){
				
				HSSFRow rows = worksheet.getRow(rowcount);
				
				HSSFCell Acells = rows.getCell(0);
				String AVal = Acells.getStringCellValue();
				System.out.println("A"+rowcount+":"+ AVal);
				
				HSSFCell Bcells = rows.getCell((short) 1);
				String BVal = Bcells.getStringCellValue();
				System.out.println("B"+rowcount+":"+BVal);
				
				HSSFCell Ccells = rows.getCell((short) 2);
				String CVal = Ccells.getStringCellValue();
				System.out.println("C"+rowcount+":"+CVal);
				
				HSSFCell Dcells = rows.getCell((short) 3);
				Date DVal = Dcells.getDateCellValue();
				SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
				String strDate = sm.format(DVal);
				System.out.println("D"+rowcount+":"+strDate);
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}


