package com.qa.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doClick(By locator) {
		getElement(locator).click();

	}

	public String doGetElementText(By locator) {
		return getElement(locator).getText();
	}

	public static By getBy(String locatorType, String locatorValue) {

		By locator = null;

		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;

		case "linkText":
			locator = By.linkText(locatorValue);
			break;
		case "partialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;

		case "tagName":
			locator = By.tagName(locatorValue);
			break;
		default:
			System.out.println("please pass the right locator....");
			break;
		}

		return locator;

	}

	public String doGetAttributeValue(By locator, String attributeValue) {
		return getElement(locator).getAttribute(attributeValue);
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();

	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void clickOnElementFromSection(By locator, String value) {
		List<WebElement> eleList = getElements(locator);

		System.out.println(eleList.size());
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);

			if (text.contains(value)) {
				e.click();
				System.out.println("clicked");
				break;
			}
		}
	}

	public int getElementsListCount(By locator) {
		return getElements(locator).size();

	}

	public List<String> getAllElementsTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			eleTextList.add(text);

		}
		return eleTextList;

	}

	public void getAllElementsText(By locator) {

		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
		}

	}

	
	
	//=====================================Waits=======================================================
	
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public String waitForTitleIs(String titleValue, int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleIs(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}
	
	
	public String waitForUrlToBe(String urlValue, int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		}
		return null;
	}

}
