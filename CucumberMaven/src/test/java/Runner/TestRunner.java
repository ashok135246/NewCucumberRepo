package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features= {"src\\test\\resources\\Login\\Login.feature"},
glue= {"StepDefinition"},//This is to run step files
monochrome=true, //to make console output in a better format
dryRun=false,//to check all methods have been implemented properly
strict=true, //to check if i missed any steps in step definition
plugin= {"html:testoutput/testoutput.html","junit:testoutput/cucumber.xml","json:testoutput/cucumber.json"})
public class TestRunner {

}