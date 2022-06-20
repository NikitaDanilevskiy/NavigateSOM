package com.navigatesom.nonbdd.suspiciousflag;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;

import java.util.ArrayList;

public class C43 extends BaseTest {

    @Test(description = "C43, Algorithm3 - Mark As Suspicious")
    public void checkingThe1bAlgorithm()
    {
        Actions.loginActions().loginToDemoSom(Constants.demoEmail, Constants.demoPassword);
        Pages.newSomUploadsPage().openUploadsTab();
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.algorithm3);
        SelenideTools.sleep(30);
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
        Pages.newSomOrdersPage().openFirstOrder();
        ArrayList<String> reasons = Pages.newSomOrderPage().getNdcFlagReasons();
        System.out.println(reasons.toString());
        Assert.assertTrue(reasons.contains("Algorithm 3: NDC frequency over tolerance level"));
        Pages.newSomOrderPage().clickSuspiciousRadioButton();
        Pages.newSomOrderPage().selectClearFlagNdcCheckbox();
        Pages.newSomOrderPage().typeNdcReason("Test reason");
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
