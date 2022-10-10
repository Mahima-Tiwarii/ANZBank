package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	public WebDriver init_driver(String browser){
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else {
			System.out.println("Please enter valid browser...");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
		
	}
	
//public static void openUrl() {
//	getDriver().get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
//	System.out.println("open url method");
//}

}
