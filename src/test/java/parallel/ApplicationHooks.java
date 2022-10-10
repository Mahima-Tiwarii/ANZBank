package parallel;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		configReader= new ConfigReader();
		prop= configReader.init_prop();
		
	}
	@Before(order=1)
	public void launchBrowser() {
		String browserName= prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browserName);
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown() {
		
		System.out.println("connection closed");
	}

}
