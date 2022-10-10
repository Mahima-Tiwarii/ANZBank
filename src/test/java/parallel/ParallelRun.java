package parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/parallel"},
		glue= {"parallel"}
		//,monochrome=true
		//,tags="@Sanity"
		,plugin= {"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				,"timeline:test-output-thread/"
				,"rerun:target/failedrerun.txt"

				}
		
		)

public class ParallelRun extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
