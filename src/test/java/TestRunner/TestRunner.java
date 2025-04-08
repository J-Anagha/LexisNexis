package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"StepDefinitions", "Hooks"}, 
				plugin = {
				        "json:target/cucumber-reports/Cucumber.json",  // Ensure this line is here
				        "pretty",
				        "html:target/cucumber-reports/html-report.html"
				    },		
		//plugin = {"pretty",
		//		  "junit:target/cucumber-reports/Cucumber.xml",
		//		  "json:target/cucumber-reports/Cucumber.json",
		//		  "html:target/cucumber-reports/html-report.html"
		//		 },		
		monochrome = true)

public class TestRunner {
	
}