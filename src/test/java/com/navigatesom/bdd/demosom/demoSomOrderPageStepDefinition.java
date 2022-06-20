package com.navigatesom.bdd.demosom;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Pages;

import java.util.ArrayList;

public class demoSomOrderPageStepDefinition {


    @Then("Check the order for {string} flag reason on Demo env")
    public void checkTheOrderForFlagReasonOnDemoEnv(String reason){
        ArrayList<String> reasons = Pages.newSomOrderPage().getNdcFlagReasons();
        System.out.println(reasons.toString());
        Assert.assertTrue(reasons.contains(reason));
    }

    @Then("Close the order window on Demo env")
    public void closeTheOrderWindowOnDemoEnv() {
        Pages.newSomOrderPage().closeOrderWindow();
    }
}
