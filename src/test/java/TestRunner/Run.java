package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Customers.feature",
		glue="StepDefinitions",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/Cucumber_Reports/reports2.html"}
		)
public class Run {
//this classs will be empty. write anything outside the claass
	
}
