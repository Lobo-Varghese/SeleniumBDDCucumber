package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/appFeatures"},
		glue = {"stepdefinitions","appHooks"},
		plugin = {"pretty"}
		)

public class RunnerClass {

}
