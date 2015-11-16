package firsttestngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserCompatibility {
	public String baseurl="https://en.wikipedia.org/wiki/Main_Page";
 
  @Test(description="Verify Application Links")
  public void verifyhomepagetitle() {
	  
	  
	  //FireFox driver settings
	   WebDriver driver=new FirefoxDriver();
	  
	  //Chrome Driver Settings
	   System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Jars\\MyAssociatedJars\\chromedriver.exe");
	  //ChromeDriver driver=new ChromeDriver();
	  
	  //IE Driver Settings
	   System.setProperty("webdriver.ie.driver","D:\\Selenium\\Jars\\MyAssociatedJars\\IEDriverServer_64bits.exe");
	   
	  
	   DesiredCapabilities capabilities=new DesiredCapabilities();
	   capabilities.setBrowserName("internet explorer");
       capabilities.setCapability("javascript.enabled", true);
	   capabilities.setCapability("nativeEvents",false);
	   //WebDriver driver=new InternetExplorerDriver(capabilities);
	   
	  
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

  

