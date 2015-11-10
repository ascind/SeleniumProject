package firsttestngpackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SeleniumRemoteControl {
  @Test
  public void f() {
	  
	  DesiredCapabilities capabilities=new DesiredCapabilities();
	  capabilities.setBrowserName("internet explorer");
	  RemoteWebDriver remoteWD=null;
	  
	  //This 3 lines of code is for IE browser only
	  capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
	  capabilities.setCapability("javascript.enabled", true);
	  capabilities.setCapability("nativeEvents",false);

	  	 
	  try {
		  remoteWD=new RemoteWebDriver(new URL("http://172.16.1.189:4444/wd/hub"),capabilities);
	  }
	  catch(MalformedURLException e) {
		  e.printStackTrace();
	  }
	 
	  remoteWD.get("http://www.google.com");
	  remoteWD.findElement(By.name("q")).sendKeys("Hi Ranjan!!! How are you?");
  
	  

  }
  
  
}
