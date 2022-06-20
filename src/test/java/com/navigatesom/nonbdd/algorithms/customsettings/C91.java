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

public class C91 extends BaseTest {

    @Test(description = "C90, Algorithm3 - Valid Include Custom settings with Averaging Period " +
            "'From Last Day of Previous Month' with the same Averaging Period in Global settings")
    public void checkingThe1bAlgorithm()
    {
        Actions.loginActions().loginToDemoAdminSom(Constants.demoAdminEmail,Constants.demoAdminPassword);
        Pages.newSomAdminTenantsPage().openTenantsTab();
        Pages.newSomAdminTenantsPage().typeInTenantsSearch("nikita");
        Pages.newSomAdminTenantsPage().clickEditTenantButton();
        SelenideTools.sleep(4);
        Pages.newSomAdminTenantsPage().expandAlgorithm(2);
        Pages.newSomAdminTenantsPage().clickAddSettingsButtonA3();
        Pages.newSomAdminTenantsPage().switchSliderA1b();
        Pages.newSomAdminTenantsPage().typeCustomerIdA3("FF0000244");
        Pages.newSomAdminTenantsPage().typeNdcA3("10702002501");
        Pages.newSomAdminTenantsPage().typeHistoryDaysA3("7");
        Pages.newSomAdminTenantsPage().typeNDCFrequencyA3("1");
        Pages.newSomAdminTenantsPage().clickUpdateTenantButton();
        SelenideTools.sleep(30);
        Actions.loginActions().loginToDemoSom(Constants.demoEmail,Constants.demoPassword);
        Pages.newSomUploadsPage().openUploadsTab();
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.algorithm3);
        SelenideTools.sleep(30);
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
        Pages.newSomOrdersPage().openFirstOrder();
        ArrayList<String> reasons = Pages.newSomOrderPage().getNdcFlagReasons();
        System.out.println(reasons);
        Assert.assertTrue(reasons.contains("Algorithm 3: NDC frequency over tolerance level"));
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
        Pages.newSomAdminTenantsPage().expandAlgorithm(2);
        SelenideTools.sleep(2);
        Pages.newSomAdminTenantsPage().clickRemoveCustomSettingA3Button();
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
