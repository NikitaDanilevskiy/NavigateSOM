package com.navigatesom.nonbdd.clearflag;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;

import java.util.ArrayList;

public class C26 extends BaseTest {

    @Test(description = "C26, Algorithm4b - Clear flag")
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
        ArrayList<String> reasons = Pages.newSomOrderPage().getNdcFlagReasons();
        System.out.println(reasons.toString());
        Assert.assertTrue(reasons.contains("Algorithm 4b: NDC over customer's family average"));
        Pages.newSomOrderPage().selectClearFlagNdcCheckbox();
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
