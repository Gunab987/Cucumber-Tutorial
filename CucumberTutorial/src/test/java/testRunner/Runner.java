package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions
		(features = { "src/test/java/features/addToCart.feature" }, 
		dryRun = !true, 
		glue = { "stepDefinition","Hooks" }, 
		snippets = SnippetType.CAMELCASE, 
		monochrome = true, 
		plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty",
				"html:C:\\Users\\gunab\\eclipse-workspace\\CucumberTutorial\\Reports\\Reports.html",
				"json:C:\\Users\\gunab\\eclipse-workspace\\CucumberTutorial\\Reports\\Reportsresult.json",
				"junit:C:\\Users\\gunab\\eclipse-workspace\\CucumberTutorial\\Reports\\result.xml" }

// tags = "@smoke or @reg"
// tags = "not @smoke"
// tags = "@gun"

				)

public class Runner extends AbstractTestNGCucumberTests {

}
