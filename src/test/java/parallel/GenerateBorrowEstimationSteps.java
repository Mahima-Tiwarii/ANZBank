package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;

import io.cucumber.core.cli.Main;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GenerateBorrowEstimationSteps {
	private String title;
	private String url;
	private String borrowResultText;
	private String getBorrowErrorMsg;
	
	private HomePage homePage;
	private ElementUtil eleUtil;
	
	@Given("User opens application url")
	public void User_opens_application_url() {
		eleUtil=new ElementUtil(DriverFactory.getDriver());
		homePage= new HomePage(DriverFactory.getDriver());
		url=homePage.getHomePageUrl();
		System.out.println("Application url is: "+url);
		
		}

	@When("User gets application url as {string}")
	public void user_gets_application_url_as(String expectedUrl) {
		Assert.assertEquals(url,expectedUrl);
	
	}



	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) throws InterruptedException {
		Thread.sleep(5000);
		title=homePage.getHomePageTitle();
		Assert.assertTrue(title.contains(expectedTitle));
	
	}
	
	@Then("{string} header should be displayed")
	public void header_should_be_displayed(String expectedHeader) {
		Assert.assertTrue(homePage.headerExist());
		
	}

	@When("User select {string}, dependents {string}, property type {string} and User enters annual income {string}, other income {string}, monthly expense {string}, homeloanRepay {string}, otherloan {string}, otherCommitement {string} and creditlimit {string} and User clicks Work out how much I could borrow button")	
	public void getUserDetails(String appType, String dependents, String propertyType,String annualIncomeAmt, String otherIncome, String monthlyExpensesAmt, 
			String homeloanRepayAmt, String otherloanAmt, String otherCommAmt, String creditlimitAmt) throws InterruptedException {
			  
		homePage.getUserDetails(appType,dependents, propertyType,annualIncomeAmt, otherIncome, monthlyExpensesAmt, homeloanRepayAmt, otherloanAmt, otherCommAmt, creditlimitAmt);
		Thread.sleep(3000);
		borrowResultText = homePage.getBorrowResult();
		
		}

	@Then("User gets estimates results {string}")
	public void user_gets_estimates_results(String expectedResult) {
		System.out.println("Your borrow result: "+borrowResultText);
		Assert.assertTrue(borrowResultText.contains(expectedResult));
	  
	}
	
	
	@When("User provides details")
	public void user_select(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> detailsList= dataTable.asMaps();
		String applicationType = detailsList.get(0).get("Application Type");
		String numOfDependents = detailsList.get(0).get("Number of dependents");
		String propertyType = detailsList.get(0).get("Property type");
		
		String annualIncome = detailsList.get(0).get("Annual income");
		String otherIncome = detailsList.get(0).get("Other income");
		String livingExpenses = detailsList.get(0).get("Living expenses");
		String monthlyHomeLoan = detailsList.get(0).get("Monthly home loan");
		String otherLoans = detailsList.get(0).get("Other loans");
		String otherCommitments = detailsList.get(0).get("Other monthly commitments");
		String creditLimits = detailsList.get(0).get("Credit limits");
		
		homePage.getUserDetails(applicationType,numOfDependents,propertyType,annualIncome, otherIncome, livingExpenses, monthlyHomeLoan, otherLoans, otherCommitments, creditLimits);
		Thread.sleep(3000);
		getBorrowErrorMsg = homePage.getBorrowError();
	}
	
	
	@Then("User gets estimates error {string}")
	public void user_gets_estimates_error(String expectedError) {
		System.out.println("Your borrow result: "+getBorrowErrorMsg);
		Assert.assertTrue(getBorrowErrorMsg.contains(expectedError));

	}
	
	@When("User is on home page")
	public void user_gets_application_url_as() {
		Assert.assertEquals(url,"dfdfd");
	
	}


}
