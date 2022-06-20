package com.navigatesom.nonbdd.suspiciousflag;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;

public class C79 extends BaseTest {

    @Test(description = "C79, Algorithm5 - Mark As Suspicious")
    public void checkingThe1bAlgorithm()
    {
        Actions.loginActions().loginToDemoSom(Constants.demoEmail, Constants.demoPassword);
        Pages.newSomUploadsPage().openUploadsTab();
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.algorithm1b4b5b6bFile);
        SelenideTools.sleep(30);
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
        Pages.newSomOrdersPage().openFirstOrder();
        String reasons = Pages.newSomOrderPage().getOrderFlagReasons();
        System.out.println(reasons);
        Assert.assertTrue(reasons.contains("Algorithm 5: Order over customer's monthly cost average"));
        Pages.newSomOrderPage().clickSuspiciousRadioButton();
        Pages.newSomOrderPage().selectClearFlagOrderCheckbox();
        Pages.newSomOrderPage().typeOrderReason("Test reason");
        Pages.newSomOrderPage().clickSubmitButton();
        Assert.assertTrue(Pages.newSomOrderPage().isFlagCleared().contains("Marked As Suspicious"));
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().selectFlagType("Suspicious");
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
        Assert.assertFalse(Pages.newSomOrdersPage().isNoRecordsFoundMessageAppeared());
    }

    @AfterMethod
    public void deleteLastUpload()
    {
        SelenideTools.refresh();
        Pages.newSomRequestDeleterPage().openRequestDeleterTab();
        SelenideTools.sleep(2);
        Pages.newSomRequestDeleterPage().clearDemoData();
        SelenideTools.sleep(2);
        Pages.newSomRequestDeleterPage().clickPopUpOkButton();
        SelenideTools.sleep(5);

    }
}
