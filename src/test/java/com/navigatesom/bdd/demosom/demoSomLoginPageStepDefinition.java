package com.navigatesom.bdd.demosom;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Pages;
import utils.Constants;
import utils.SelenideTools;

public class demoSomLoginPageStepDefinition {


    @Then("Enter login {string} on Demo login page")
    public void enterLoginOnDemoLoginPage(String login) {
        Pages.newSomLoginPage().typeEmail(login);
        Pages.newSomLoginPage().clickContinueButton();
    }

    @Then("Enter password {string} on Demo login page")
    public void enterPasswordOnDemoLoginPage(String password){
        Pages.newSomLoginPage().typePassword(password);
        Pages.newSomLoginPage().clickSubmitButton();
        Assert.assertTrue(Pages.newSomGlobalPage().isPageOpened());
    }

    @When("Open the [Uploads] tab on Demo env")
    public void openTheUploadsTab(){
        Pages.newSomUploadsPage().openUploadsTab();
        Assert.assertTrue(Pages.newSomUploadsPage().isUploadsTabOpened());
    }

    @Then("Upload the file {string} on Demo env")
    public void uploadTheFile(String filepath){
        Pages.newSomUploadsPage().uploadFile(filepath);
        SelenideTools.sleep(30);
        SelenideTools.refresh();
    }


    @When("Open NavigateSOM Demo")
    public void openNavigateSOMDemo() {
        Pages.newSomGlobalPage().openSomDemo();
        Assert.assertTrue(Pages.newSomLoginPage().isLoginPageOpened());
    }
}
