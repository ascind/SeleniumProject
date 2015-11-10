package firsttestngpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UsageofPropertiesFile {
	InputStream inputStream;
@Test
  public void usetestproperties() throws IOException {
	    
	    Properties prop = new Properties();
		String propFileName = "config.properties";
		inputStream = getClass().getResourceAsStream(propFileName);
		prop.load(inputStream);
		String user = prop.getProperty("user");
		Reporter.log(user);
		String Company=prop.getProperty("company1");
		Reporter.log(Company);
  }
}
