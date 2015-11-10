package firsttestngpackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CaptureScreenshots {
	
	WebDriver driver = new FirefoxDriver();
	
  @Test(priority=0)
  public void myfunction1() throws IOException {
	  driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
	  CaptureScreenshot("Loginpage");
  }
  
  @Test(priority=1)
  public void myfunction2() throws IOException {
	 	  
	  driver.findElement(By.id("user_login")).click();
	  driver.findElement(By.id("user_login")).sendKeys("admin");
	  driver.findElement(By.id("user_pass")).sendKeys("demo123");
	  driver.findElement(By.id("wp-submit")).click();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  CaptureScreenshot("HomePage");
	  	  
  }
  
  //This function call captures the screenshot with the Filename provided as function argument and stores in the specified location
  public void CaptureScreenshot(String FileName) throws IOException {
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  System.out.println(scrFile.getAbsolutePath());
	  Date date = new Date();
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss");
	  String dtDate = sdf.format(date);
	  FileUtils.copyFile(scrFile, new File("D:\\Selenium\\Results\\"+FileName+"_"+dtDate+".png"));
	 
  }
  
  @AfterTest
  public void postcondition() {
	  driver.quit();
  }
  
}
