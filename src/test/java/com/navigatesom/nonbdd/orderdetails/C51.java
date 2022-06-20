package com.navigatesom.nonbdd.orderdetails;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;

public class C51 extends BaseTest {

    @Test(description = "C51, Add Notes to order")
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
        Pages.newSomOrderPage().clickAddNoteButton();
        Pages.newSomOrderPage().clickSaveNoteButton();
        Assert.assertEquals("Please enter comment.",Pages.newSomOrderPage().getErrorText());
        Pages.newSomOrderPage().typeNote("Test note");
        Pages.newSomOrderPage().clickSaveNoteButton();
        Assert.assertEquals("Test note",Pages.newSomOrderPage().getAddedNoteMessage());
        Pages.newSomOrderPage().clickAddNoteButton();
        Pages.newSomOrderPage().typeNote("  ");
        Pages.newSomOrderPage().clickSaveNoteButton();
        Assert.assertEquals("Please enter comment.",Pages.newSomOrderPage().getErrorText());
        Pages.newSomOrderPage().clickCancelNoteButton();
        SelenideTools.sleep(2);
        Pages.newSomOrderPage().clickAddNoteButton();
        Pages.newSomOrderPage().typeNoteAndClickEnter("Test note 2");
        Pages.newSomOrderPage().closeOrderWindow();
        SelenideTools.sleep(2);
        Pages.newSomOrdersPage().openOrdersTab();
        Pages.newSomOrdersPage().typeInSearchInput("1111120");
        Pages.newSomOrdersPage().openFirstOrder();
        Assert.assertTrue(Pages.newSomOrderPage().getAddedNotesMessage().contains("Test note"));
        Assert.assertTrue(Pages.newSomOrderPage().getAddedNotesMessage().contains("Test note 2"));
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
