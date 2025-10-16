package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",      // path to feature files
        glue = {"stepDefinitions", "hooks"},                    // package containing step definitions
        plugin = { "html:target/cucumber-reports.html"} // reports
        //monochrome = true                              // cleaner console output
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
