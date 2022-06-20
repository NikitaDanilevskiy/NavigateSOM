package com.navigatesom.nonbdd.orderdetails;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;

public class C47 extends BaseTest {

    @Test(description = "C47, Print order details data")
    public void checkingThe1bAlgorithm()
    {
        Actions.loginActions().loginToDemoSom(Constants.demoEmail, Constants.demoPassword);
        Pages.newSomUploadsPage().openUploadsTab();
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.algorithm1b4b5b6bFile);
        SelenideTools.sleep(30);
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().typeInSearchInput("1111122");
        Pages.newSomOrdersPage().openFirstOrder();
        Pages.newSomOrderPage().clickSuspiciousRadioButton();
        SelenideTools.sleep(2);
        Pages.newSomOrderPage().selectClearFlagNdcCheckbox();
        Pages.newSomOrderPage().clickSubmitButton();
        Assert.assertEquals("Please enter reason.",Pages.newSomOrderPage().getErrorText());
        Pages.newSomOrderPage().typeNdcReason("Test reason");
        Pages.newSomOrderPage().clickSubmitButton();
        Assert.assertTrue(Pages.newSomOrderPage().isFlagCleared().contains("Marked As Suspicious"));
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().selectFlagType("Suspicious");
        Pages.newSomOrdersPage().typeInSearchInput("1111122");
        Assert.assertFalse(Pages.newSomOrdersPage().isNoRecordsFoundMessageAppeared());

        Pages.newSomOrdersPage().selectFlagType("ALL");
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
        Pages.newSomOrdersPage().openFirstOrder();
        Pages.newSomOrderPage().selectClearFlagNdcCheckbox();
        Pages.newSomOrderPage().clickSubmitButton();
        Assert.assertEquals("Please enter reason.",Pages.newSomOrderPage().getErrorText());
        Pages.newSomOrderPage().typeNdcReason("Test reason");
        Pages.newSomOrderPage().clickSubmitButton();
        Assert.assertTrue(Pages.newSomOrderPage().isFlagCleared().contains("Flag Cleared"));
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().selectFlagType("Flagged");
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
        Assert.assertTrue(Pages.newSomOrdersPage().isNoRecordsFoundMessageAppeared());
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
