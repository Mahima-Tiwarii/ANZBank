package MyTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/com/features/BorrowEstimates.feature"},
		glue= {"stepdefinitions", "AppHooks"}
		,monochrome=true
		//,tags="@Sanity"
		,plugin= {"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				,"timeline:test-output-thread/"

				}
		
		)

public class MyTestRunner {
	

}
