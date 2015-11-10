package firsttestngpackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;

public class LibraryFile {
  @Test
  public void GenerateHTMLReport(long Executiontime, String[] arrinputreportdescription,String[] arrinputreportstatus) throws IOException {
	  /******************************************************************************************
	  @Function Name: GenerateReport
	  @Function Description:
	       This function generates report in html format in the path specified
	  @Arguments:
	       1. arrinputreportdescription: First array stores the value of first message to be shown in the report under Verification Points
	       2. arrinputreportstatus: First array stores the value of second message to be shown in the report (Status(Pass/Fail/Warning)under Verification Points
	       3. Filename: Name of the report file to be created for the test scenario
	       4. DateforReport: The date and time which should be displayed in the Execution Summary
	       5. Executiontime: Total time taken to execute the scenario in Seconds under Execution Summary
	       6. TestScenarioName: Contains the class name which gets displayed in the Execution Summary
	  @Return:
	       NA
	  @Author: Shiba Tripathy    
	  ***************************************************************************************** */
	  String TestScenarioName="Scenario1";
	  Calendar cal = new GregorianCalendar();
      SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy hh_mm");
      String DateofReport=sdf.format(cal.getTime());
      File f = new File("D:\\Selenium\\Results\\SummaryReport_"+DateofReport+""+".htm");
      BufferedWriter bw=new BufferedWriter(new FileWriter(f)); 
      bw.write("<html>");
      bw.write("<title>GSM Automation Report</title>");
      bw.write("<head></head>");
      bw.write("<body>");
      bw.write("<font face='Tahoma'size='2'>");
      bw.write("<h2 align='center'>Selenium Automation Summary</h2>");
      bw.write("</table>");
      //For Execution Summary
      bw.write("<hr>");
      bw.write("<table border='2' BORDERCOLOR='#000000' width='100%'>");
      bw.write("<tr><td width='100%' align='center' colspan='2' bgcolor='#996600'><b><font face='Tahoma' size='2' color='#FFFFFF'>Execution Summary</font></b></td></tr>");
      bw.write("<tr><td width='50%' bgcolor='#CCCCFF'><b><font face='Tahoma' size='2'>Date & Time</font></b></td><td width='50%' font color='#009900' bgcolor='#FFFFDC'><b><font color='#009900' face='Tahoma' size='2'>"+DateofReport+"</font></b></td></tr>");
      bw.write("<tr><td width='50%' bgcolor='#CCCCFF'><b><font face='Tahoma' size='2'>Test Scenario Name</font></b></td><td width='50%' font color='#009900' bgcolor='#FFFFDC'><b><font color='#009900' face='Tahoma' size='2'>"+TestScenarioName+"</font></b></td></tr>");
      bw.write("<tr><td width='50%' bgcolor='#CCCCFF'><b><font face='Tahoma' size='2'>Execution Time</font></b></td><td width='50%' font color='#009900' bgcolor='#FFFFDC'><b><font color='#009900' face='Tahoma' size='2'>"+Executiontime+"</font></b></td></tr>");
      bw.write("</hr>");
      
      //For Verification Points            
      bw.write("<hr>");
      bw.write("<table border='2' BORDERCOLOR='#000000' width='100%'>");
      bw.write("<tr><td width='100%' align='center' colspan='2' bgcolor='#996600'><b><font face='Tahoma' size='2' color='#FFFFFF'>Verification Points</font></b></td></tr>");
      
      for(int i=0;i<arrinputreportdescription.length;i++)
      {
           if(arrinputreportdescription[i]==null)break;
           else 
                if(arrinputreportstatus[i].equalsIgnoreCase("Passed"))
                {
                      bw.write("<tr><td width='50%' bgcolor='#CCCCFF'><font face='Tahoma' size='2'>"+arrinputreportdescription[i]+"</font></td><td width='50%' font color='#009900' bgcolor='#FFFFDC'><b><font color='#009900' face='Tahoma' size='2'>"+arrinputreportstatus[i]+"</font></b></td></tr>");
                }
                else if(arrinputreportstatus[i].equalsIgnoreCase("Failed"))
                {
                      bw.write("<tr><td width='50%' bgcolor='#CCCCFF'><b><font face='Tahoma' size='2'>"+arrinputreportdescription[i]+"</font></b></td><td width='50%' font color='#009900' bgcolor='#FFFFDC'><b><font color='#e60000' face='Tahoma' size='2'>"+arrinputreportstatus[i]+"</font></b></td></tr>");
                }
                else
                {
                      bw.write("<tr><td width='50%' bgcolor='#CCCCFF'><font face='Tahoma' size='2'>"+arrinputreportdescription[i]+"</font></td><td width='50%' font color='#009900' bgcolor='#FFFFDC'><b><font color='#01DF74' face='Tahoma' size='2'>"+arrinputreportstatus[i]+"</font></b></td></tr>");
                }
                      
      }
      
      bw.write("</table>");
      bw.write("</font>");
      bw.write("</body>");
     bw.write("</html>");
      
      bw.close();
  }
}



