package com.navigatesom.nonbdd.algorithms;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;

import java.util.ArrayList;

public class C83 extends BaseTest {

    @Test(description = "C83, Algorithm9 - Add order for flagging")
    public void checkingThe1bAlgorithm()
    {
        int id=1;
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
        System.out.println(reasons);
        if(!reasons.contains("Algorithm 9: Algorithm to flag line items with already existing suspicious or NDC flags")){
            id--;
            Pages.newSomOrdersPage().openOrdersTab();
            Pages.newSomOrdersPage().typeInSearchInput("1111120");
            Pages.newSomOrdersPage().openOrder(id);
        }
        Assert.assertTrue(reasons.contains("Algorithm 9: Algorithm to flag line items with already existing suspicious or NDC flags"));
        Pages.newSomOrderPage().closeOrderWindow();
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
