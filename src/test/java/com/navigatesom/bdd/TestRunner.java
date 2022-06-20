package com.navigatesom.bdd;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import utils.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(  monochrome = true,
        tags = "@tags",
        features = "src/test/resources/features",glue = {"com.navigatesom.bdd"},
        plugin = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" }
        )

public class TestRunner extends AbstractTestNGCucumberTests {
}