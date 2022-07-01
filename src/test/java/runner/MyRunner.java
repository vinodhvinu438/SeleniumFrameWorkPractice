package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
				glue="stepdefinitions",tags="@OmayoLogin",plugin= {
                         "html:target/cucumberresult.html"}
				)
public class MyRunner extends AbstractTestNGCucumberTests {

}
