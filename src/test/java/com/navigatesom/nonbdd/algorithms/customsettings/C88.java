package com.navigatesom.nonbdd.algorithms.customsettings;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;

import java.util.ArrayList;

public class C88 extends BaseTest {

    @Test(description = "C88, Algorithm6b - Valid Include Custom settings with Averaging Period " +
            "'From Last Day of Previous Month' with the same Averaging Period in Global settings")
    public void checkingThe1bAlgorithm()
    {
        Actions.loginActions().loginToDemoAdminSom(Constants.demoAdminEmail,Constants.demoAdminPassword);
        Pages.newSomAdminTenantsPage().openTenantsTab();
        Pages.newSomAdminTenantsPage().typeInTenantsSearch("nikita");
        Pages.newSomAdminTenantsPage().clickEditTenantButton();
        SelenideTools.sleep(4);
        Pages.newSomAdminTenantsPage().expandAlgorithm(11);
        Pages.newSomAdminTenantsPage().clickAddSettingsButtonA6b();
        Pages.newSomAdminTenantsPage().switchSliderA1b();
        Pages.newSomAdminTenantsPage().typeCustomerIdA6b("FF0000244");
        Pages.newSomAdminTenantsPage().typeNdcA6b("10702002501");
        Pages.newSomAdminTenantsPage().typeThresholdA6b("1");
        Pages.newSomAdminTenantsPage().selectAveragingPeriodA6b("From Last Day of Previous Month");
        Pages.newSomAdminTenantsPage().selectNumberOfMonthA6b("12 Month (s)");
        Pages.newSomAdminTenantsPage().clickUpdateTenantButton();
        SelenideTools.sleep(30);
        Actions.loginActions().loginToDemoSom(Constants.demoEmail,Constants.demoPassword);
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
        Assert.assertTrue(reasons.contains("Algorithm 6b: NDC over customer's monthly trade average"));
        Pages.newSomOrderPage().closeOrderWindow();
    }

    @AfterMethod
    public void deleteLastUploadAndCustomSetting()
    {
        Pages.newSomAdminGlobalPage().openDemoSomAdmin();
        Pages.newSomAdminTenantsPage().openTenantsTab();
        Pages.newSomAdminTenantsPage().typeInTenantsSearch("nikita");
        Pages.newSomAdminTenantsPage().clickEditTenantButton();
        SelenideTools.sleep(4);
        Pages.newSomAdminTenantsPage().expandAlgorithm(11);
        SelenideTools.sleep(2);
        Pages.newSomAdminTenantsPage().clickRemoveCustomSettingA6bButton();
        SelenideTools.sleep(2);
        Pages.newSomAdminTenantsPage().clickPopUpOkButton();
        SelenideTools.sleep(5);
        Pages.newSomAdminTenantsPage().clickUpdateTenantButton();
        SelenideTools.sleep(10);
        Pages.newSomGlobalPage().openSomDemo();
        if(Pages.newSomLoginPage().isLoginPageOpened())
        {
            Pages.newSomLoginPage().typeEmail(Constants.demoEmail);
            Pages.newSomLoginPage().clickContinueButton();
            Pages.newSomLoginPage().typePassword(Constants.demoPassword);
            Pages.newSomLoginPage().clickSubmitButton();
            Assert.assertTrue(Pages.newSomGlobalPage().isPageOpened());
        }
        Pages.newSomRequestDeleterPage().openRequestDeleterTab();
        SelenideTools.sleep(2);
        Pages.newSomRequestDeleterPage().clearDemoData();
        SelenideTools.sleep(2);
        Pages.newSomRequestDeleterPage().clickPopUpOkButton();
        SelenideTools.sleep(5);
    }
}
