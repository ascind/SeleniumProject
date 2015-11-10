//This Script is a Suite containing multiple test scripts with @BeforeSuite and @AfeterSuite

package firsttestngpackage;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class SingleScriptMultipleTestCases extends LibraryFile{
	public String baseurl="http://demo.opensourcecms.com/wordpress/wp-login.php";
	public WebDriver driver=new FirefoxDriver();

	public long starttime;
	public long Endtime;
	public String[] arrreportdescription=new String[10];
	public String[] arrreportstatus=new String[10];
	
	 LibraryFile LF=new LibraryFile();

	
@BeforeSuite
  public void preconditions(){
  
  starttime = System.currentTimeMillis( );
	
}
@AfterSuite
public void postconditions() throws IOException{
		
	driver.manage().deleteAllCookies();
	driver.quit();
	
	//Generate  HTML Report 
	Endtime = System.currentTimeMillis( );
	long Executiontime=(Endtime-starttime);
	LF.GenerateHTMLReport(Executiontime, arrreportdescription, arrreportstatus);
}

  @Test(priority=0,description="TestCaseI")
  public void verifyloginpage() {
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  String ExpectedTitle="WordPress Demo Install › Log In";
	  String ActualTitle=driver.getTitle();
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  Assert.assertTrue((driver.findElement(By.id("user_login")).isDisplayed() && driver.findElement(By.id("user_pass")).isDisplayed()),"UserID and Password fields are displayed");
	  Assert.assertTrue(driver.findElement(By.id("wp-submit")).isDisplayed(),"Signin button is displayed");
	  Reporter.log("Verififcation of login page is completed");
	  arrreportdescription[0]="Verififcation of login page is completed";
	  arrreportstatus[0]="Passed";
  }
  
  @Test(priority=1,description="TestCaseII")
  public void enterlogincredentials() {
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  driver.findElement(By.id("user_login")).click();
	  driver.findElement(By.id("user_login")).sendKeys("admin");
	  driver.findElement(By.id("user_pass")).sendKeys("demo123");
	  driver.findElement(By.id("wp-submit")).click();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  if(driver.findElement(By.tagName("h3")).isDisplayed())  {
		  Reporter.log("Login Successful: Welcome to your new WordPress site! message displayed");
		  arrreportdescription[1]="Login Successful: Welcome to your new WordPress site! message displayed";
		  arrreportstatus[1]="Failed";
	  }
	  else
	  {
		  Reporter.log("Login Unsuccessful: Welcome to your new WordPress site! message is not displayed");
		  arrreportdescription[1]="Login Unsuccessful: Welcome to your new WordPress site! message is not displayed";
		  arrreportstatus[1]="Failed";
	  }
  }
  
  @Test(priority=2,enabled=false,description="TestCaseIII")
  public void verifyhomepagesecondlink() {
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.linkText("Arts")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  String Expectedlink1="Portal:Arts";
	  String Actuallink1=driver.findElement(By.id("firstHeading")).getText();
	  Assert.assertEquals(Actuallink1, Expectedlink1);
	  
  }
   
    
}
