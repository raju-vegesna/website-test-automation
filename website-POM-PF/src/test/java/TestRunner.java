import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( 
			format = { "pretty:", "html:target/html/" }, // configure test run report output as html 
			features = "src/test/resources/features/", 	// location of feature files to read
			tags = {})									// will be used to run tagged scenarios in feature file (eg: smoke, sanity, regression)

public class TestRunner {

}
