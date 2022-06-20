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

public class C84 extends BaseTest {

    @Test(description = "C84, Algorithm9 - Clear flag")
    public void checkingThe1bAlgorithm()
    {
        int id = 1;
        Actions.loginActions().loginToDemoSom(Constants.demoEmail, Constants.demoPassword);
        Pages.newSomUploadsPage().openUploadsTab();
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.algorithm1b4b5b6bFile);
        SelenideTools.sleep(30);
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.algorithm1b4b5b6bFile);
        SelenideTools.sleep(30);
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
        Pages.newSomOrdersPage().openOrder(id);
        ArrayList<String> reasons = Pages.newSomOrderPage().getNdcFlagReasons();
        System.out.println(reasons.toString());
        if(!reasons.contains("Algorithm 9: Algorithm to flag line items with already existing suspicious or NDC flags")){
            id--;
            Pages.newSomOrdersPage().openOrdersTab();
            Pages.newSomOrdersPage().typeInSearchInput("1111120");
            Pages.newSomOrdersPage().openOrder(id);
        }
        Pages.newSomOrderPage().selectClearFlagNdcCheckbox();
        Pages.newSomOrderPage().typeNdcReason("Test reason");
        Pages.newSomOrderPage().clickSubmitButton();
        Assert.assertTrue(Pages.newSomOrderPage().isFlagCleared().contains("Flag Cleared"));
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
        Pages.newSomOrdersPage().openOrder(id);
        ArrayList<String> reasons2 = Pages.newSomOrderPage().getNdcFlagReasons();
        SelenideTools.sleep(2);
        Assert.assertTrue(Pages.newSomOrderPage().isNdcFlagCleared());
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
