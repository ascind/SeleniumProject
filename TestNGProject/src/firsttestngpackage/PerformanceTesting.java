
package firsttestngpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.browsermob.proxy.ProxyServer;
import org.browsermob.core.har.Har;
public class PerformanceTesting {
  @Test
  public void f() throws Exception {
	  
	
  		
	  		// Start the BrowserMob Proxy
	  		ProxyServer server = new ProxyServer(9090);
	  		server.start();
	  		
	  		// Get the Selenium proxy object
	  		Proxy proxy = server.seleniumProxy();
	  		
	  		// Configure Desired capability for using Proxy Server
	  		DesiredCapabilities capabilities = new DesiredCapabilities();
	  		capabilities.setCapability(CapabilityType.PROXY, proxy);

	  		// Start the Browser up
	  		WebDriver driver = new FirefoxDriver(capabilities);

	  		// Create a new HAR with the label "StockMarketData"
	  		server.newHar("StockMarketData");

	  		// Open the Application
	  		/*driver.get("http://money.rediff.com/");

	  		WebElement searchTextBox = driver.findElement(By.name("srchword"));
	  		searchTextBox.sendKeys("Page Industries Ltd.");
	  		searchTextBox.sendKeys(Keys.ENTER);
	  		
	  		Thread.sleep(5000);*/
  		  driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
  		  driver.manage().window().maximize();
	  	  driver.findElement(By.id("user_login")).click();
	  	  driver.findElement(By.id("user_login")).sendKeys("admin");
	  	  driver.findElement(By.id("user_pass")).sendKeys("demo123");
	  	  driver.findElement(By.id("wp-submit")).click();
	  	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  	  driver.findElement(By.id("menu-media")).click();
	  	  driver.findElement(By.id("menu-pages")).click();
	  	  Reporter.log("Verififcation completed");
	  	  
	  		// Collect the performance data from the BrowserMob proxy server
	  		// Get the HAR data 
	  		Har har = server.getHar();

	  		// Write the HAR Data in a File
	  		File harFile = new File("C:\\tmp\\rediffmoney.har");
	  		har.writeTo(harFile);
	  		
	  			  		
	  		// Stop the BrowserMob Proxy Server
	  		server.stop();
	  		
	  		// Close the browser
	  		driver.quit();
	  				
	  	}
	  }	




