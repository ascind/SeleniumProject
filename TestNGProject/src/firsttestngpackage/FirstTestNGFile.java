package firsttestngpackage;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class FirstTestNGFile {
	public String baseurl="https://en.wikipedia.org/wiki/Main_Page";
	public WebDriver driver=new FirefoxDriver();
	
  @Test(priority=2, enabled=true)
  public void verifyhomepagetitle() {
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  String ExpectedTitle="Wikipedia, the free encyclopedia";
	  String ActualTitle=driver.getTitle();
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  driver.quit();
  }
  
  @Test(priority=1)
  public void verifyhomepagefirstlink() {
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  String Expectedlink1="Main page";
	  String Actuallink1=driver.findElement(By.id("n-mainpage-description")).getText();
	  Assert.assertEquals(Actuallink1, Expectedlink1);
	 
  }
  
  private boolean isElementPresent(By id) {
	// TODO Auto-generated method stub
	return true;
}

@Test(priority=0)
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
