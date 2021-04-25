package stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
    @CucumberOptions(features="src/test/resources",plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"},
            glue= {"stepDefinition"}, strict = true,tags="@RunOnly")
    public class TestRunner {
    }
