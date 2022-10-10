package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.util.Constants;
import com.qa.util.ElementUtil;


public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By appTypeSingle= By.xpath("//li[@class='selected']/label[@for='application_type_single']");
	private By dependentsNum= By.xpath("//select[@title='Number of dependants']");
	private By borrowTypeHome= By.xpath("//li[@class='selected']/label[@for='borrow_type_home']");
	private By annualIncome=By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q1']");
	private By annualOtherIncome= By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q2q2']");
	private By monthlyExpenses= By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q1']");
	private By homeLoanRepay = By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q2']");
	private By otherLoanRepay = By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q3']");
	private By otherMonthlyComm = By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q4']");
	private By totalCredLimit = By.xpath("//div[@class='input__wrapper']/input[@aria-labelledby='q3q5']");
	
	
	private By borrowResultAmount= By.xpath("//span[@id='borrowResultTextAmount']");
	private By borrowErrorMsg=By.xpath("//div[@class='borrow__error__text']");
	
	
	By howMuchIcanBorrowBtn = By.id("btnBorrowCalculater");
	By startOverBtn=By.xpath("//div[@class='result__restart']/button[@aria-label='Start over']");
	
	private By header= By.xpath("//div[@class='hero__contentRow hero__contentRow--textBanner']/h1[text()='How much could I borrow?']");
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}
	
	public String getHomePageUrl() {
		String url = eleUtil.waitForUrlToBe(Constants.PAGE_URL, 10);
		System.out.println("Page url is: "+url);
		return url;
	}
	
	public String getHomePageTitle() {
		String title = eleUtil.waitForTitleIs(Constants.PAGE_TITLE, 10);
		System.out.println("Page title is: "+title);
		return title;
	}
	
	public boolean headerExist() {
		return eleUtil.doIsDisplayed(header);
	}
	
	public void getUserDetails(String appType, String dependents, String propertyType,String annualIncomeAmt, String otherIncome, String monthlyExpensesAmt, 
			String homeloanRepayAmt, String otherloanAmt, String otherCommAmt, String creditlimitAmt){

		
		eleUtil.waitForElementVisible(appTypeSingle, 10).click();
		WebElement dependentNum_ele=eleUtil.waitForElementVisible(dependentsNum, 10);
		Select select=new Select(dependentNum_ele);
		select.selectByIndex(0);
		
		eleUtil.getElement(borrowTypeHome).click();
		eleUtil.waitForElementVisible(annualIncome, 8).sendKeys(annualIncomeAmt);
		eleUtil.waitForElementVisible(annualOtherIncome, 8).sendKeys(otherIncome);
		eleUtil.doSendKeys(monthlyExpenses,monthlyExpensesAmt);
		eleUtil.doSendKeys(homeLoanRepay,homeloanRepayAmt);

		eleUtil.doSendKeys(otherLoanRepay,otherloanAmt);

		eleUtil.doSendKeys(otherMonthlyComm,otherCommAmt);

		eleUtil.doSendKeys(totalCredLimit,creditlimitAmt);

		eleUtil.doClick(howMuchIcanBorrowBtn);

		}
	
	public String getBorrowResult() {
		
		String borrowResultText= eleUtil.waitForElementVisible(borrowResultAmount, 10).getText();
		return borrowResultText;
	}
	
	public String getBorrowError() {
		
		String borrowErrorText= eleUtil.waitForElementVisible(borrowErrorMsg, 10).getText();
		return borrowErrorText;
	}
	
	

}
