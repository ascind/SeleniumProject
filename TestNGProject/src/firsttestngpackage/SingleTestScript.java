package firsttestngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTestScript {
	public String baseurl="https://en.wikipedia.org/wiki/Main_Page";
	public WebDriver driver=new FirefoxDriver();
	
  
  @Test(description="Verify Application Links")
  public void verifyhomepagetitle() {
	  
	  
	  
	  
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  String ExpectedTitle="Wikipedia, the free encyclopedia";
	  String ActualTitle=driver.getTitle();
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  String Expectedlink1="Main page";
	  String Actuallink1=driver.findElement(By.id("n-mainpage-description")).getText();
	  Assert.assertEquals(Actuallink1, Expectedlink1);
	  driver.findElement(By.linkText("Arts")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  String Expectedlink2="Portal:Arts";
	  String Actuallink2=driver.findElement(By.id("firstHeading")).getText();
	  Assert.assertEquals(Actuallink2, Expectedlink2);
	  driver.quit();
	  
	  
  }
}

  

