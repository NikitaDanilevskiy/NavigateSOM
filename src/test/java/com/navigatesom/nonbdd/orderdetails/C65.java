package com.navigatesom.nonbdd.orderdetails;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;

public class C65 extends BaseTest {

    @Test(description = "C65, Add Document to order")
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
        SelenideTools.sleep(5);
        Pages.newSomOrderPage().clickAddDocumentButton();
        SelenideTools.sleep(5);
        Pages.newSomOrderPage().uploadDocument(Constants.pdfFile);
        SelenideTools.sleep(5);
        Pages.newSomOrderPage().clickSubmitDocumentButton();
        SelenideTools.sleep(5);
        Assert.assertEquals("sample.pdf",Pages.newSomOrderPage().getAddedDocumentName());
        SelenideTools.sleep(5);
        Pages.newSomOrderPage().clickAddDocumentButton();
        SelenideTools.sleep(5);
        Pages.newSomOrderPage().clickCancelAddedDocumentButton();

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
