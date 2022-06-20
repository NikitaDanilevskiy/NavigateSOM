package com.navigatesom.bdd.demosom;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Pages;

public class demoSomOrdersPageStepDefinition {

    @When("Open the [Orders] tab on Demo env")
    public void openTheOrdersTabOnDemoEnv() {
        Pages.newSomOrdersPage().openOrdersTab();
    }

    @When("Find the {string} order on Demo env")
    public void findTheOrderOnDemoEnv(String order) {
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
    }

    @Then("Open the first order on Demo env")
    public void openTheFirstOrderOnDemoEnv() {
        Pages.newSomOrdersPage().openFirstOrder();
    }
}
