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

public class C49 extends BaseTest {

    @Test(description = "C49, Algorithms 1b, 2b, 3, 4b, 5b, 6b - Mark As Suspicious")
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
        Assert.assertTrue(reasons.contains("Algorithm 1b: NDC over quantity average"));
        Assert.assertTrue(reasons.contains("Algorithm2b: NDC over cost average"));
        Assert.assertTrue(reasons.contains("Algorithm 3: NDC frequency over tolerance level"));
        Assert.assertTrue(reasons.contains("Algorithm 4b: NDC over customer's family average"));
        Assert.assertTrue(reasons.contains("Algorithm 5b: NDC over customer's quantity average"));
        Assert.assertTrue(reasons.contains("Algorithm 6b: NDC over customer's monthly trade average"));
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
