package firsttestngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class KeyboardOperations {
	
	public String baseurl="https://en.wikipedia.org/wiki/Main_Page";
	public WebDriver driver=new FirefoxDriver();
	
	
  @Test
  public void f() throws InterruptedException {
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  WebElement txtsearch = driver.findElement(By.id("searchInput"));
	  
	  
	  Actions builder=new Actions(driver);
	  Action seriesofaction=builder
			  .moveToElement(txtsearch)
			  .click()
			  .keyDown(txtsearch,Keys.SHIFT)
			  .sendKeys("india")
			  .keyUp(txtsearch,Keys.SHIFT)
			  .sendKeys("india")
			  .build();
	  
	  seriesofaction.perform();
	  builder.sendKeys(Keys.TAB).perform();
	  driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	  builder.sendKeys(Keys.TAB).perform();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  builder.sendKeys(Keys.TAB).perform();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  builder.sendKeys(Keys.ENTER).perform();
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  
	  WebElement txtMOver = driver.findElement(By.linkText("its name"));
	  Action mouseOverHome = builder
              .moveToElement(txtMOver)
              .build();
	  mouseOverHome.perform();
	  
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
  }
 
  @AfterTest
  public void postcondn() {
	  driver.quit();
  }
}
