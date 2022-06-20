package com.navigatesom.nonbdd.algorithms.customsettings;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;

public class C89 extends BaseTest {

    @Test(description = "C89, Algorithm1 - Valid Include Custom settings with Averaging Period " +
            "'From Last Day of Previous Month' with the same Averaging Period in Global settings")
    public void checkingThe1bAlgorithm()
    {
        Actions.loginActions().loginToDemoAdminSom(Constants.demoAdminEmail,Constants.demoAdminPassword);
        Pages.newSomAdminTenantsPage().openTenantsTab();
        Pages.newSomAdminTenantsPage().typeInTenantsSearch("nikita");
        Pages.newSomAdminTenantsPage().clickEditTenantButton();
        SelenideTools.sleep(4);
        Pages.newSomAdminTenantsPage().expandAlgorithm(0);
        Pages.newSomAdminTenantsPage().clickAddSettingsButtonA1();
        Pages.newSomAdminTenantsPage().switchSliderA1b();
        Pages.newSomAdminTenantsPage().typeCustomerIdA1("FF0000244");
        //Pages.newSomAdminTenantsPage().typeTradeA1("Trade");
        Pages.newSomAdminTenantsPage().typeThresholdA1("1");
        Pages.newSomAdminTenantsPage().selectAveragingPeriodA1("From Last Day of Previous Month");
        Pages.newSomAdminTenantsPage().selectNumberOfMonthA1("12 Month (s)");
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
        String reasons = Pages.newSomOrderPage().getOrderFlagReasons();
        System.out.println(reasons);
        Assert.assertTrue(reasons.contains("Algorithm 1 : Order over quantity average"));
        Pages.newSomOrderPage().closeOrderWindow();;
    }

    @AfterMethod
    public void deleteLastUploadAndCustomSetting()
    {
        Pages.newSomAdminGlobalPage().openDemoSomAdmin();
        Pages.newSomAdminTenantsPage().openTenantsTab();
        Pages.newSomAdminTenantsPage().typeInTenantsSearch("nikita");
        Pages.newSomAdminTenantsPage().clickEditTenantButton();
        SelenideTools.sleep(4);
        Pages.newSomAdminTenantsPage().expandAlgorithm(0);
        SelenideTools.sleep(2);
        Pages.newSomAdminTenantsPage().clickRemoveCustomSettingA1Button();
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
