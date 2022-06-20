package com.navigatesom.nonbdd.datatransfer;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.Constants;
import utils.SelenideTools;

import java.util.ArrayList;

public class C60 {

    @Test(description = "C60, Verify the total number of orders")
    public void checkingTheAlgorithmsWorkOnDemo()
    {
        Actions.loginActions().loginToProdSom("nikita.danilevskiy@pharma.solutions", "Shlyapa2");
//        Pages.somUploadsPage().openUploadsTab();
//        Pages.somUploadsPage().clickUploadButton();
//        Pages.somUploadsPage().uploadFile(Constants.januaryOrders);
//        Pages.somUploadsPage().clickUploadFileButton();
//        SelenideTools.sleep(60);
//        Pages.somUploadsPage().clickUploadButton();
//        Pages.somUploadsPage().uploadFile(Constants.januaryOrders);
//        Pages.somUploadsPage().clickUploadFileButton();
//        SelenideTools.sleep(60);
        Pages.somDashboardPage().openDashboardTab();
        SelenideTools.sleep(10);
        Pages.somDashboardPage().selectDaysFilterOption("ALL");
        SelenideTools.sleep(5);
        ArrayList<String> algorithm1 = Pages.somDashboardPage().getAlgorithmInfo(0);
        ArrayList<String> algorithm2 = Pages.somDashboardPage().getAlgorithmInfo(1);
        ArrayList<String> algorithm1b = Pages.somDashboardPage().getAlgorithmInfo(2);
        ArrayList<String> algorithm2b = Pages.somDashboardPage().getAlgorithmInfo(3);
        ArrayList<String> algorithm3 = Pages.somDashboardPage().getAlgorithmInfo(4);
        ArrayList<String> algorithm4 = Pages.somDashboardPage().getAlgorithmInfo(5);
        ArrayList<String> algorithm4b = Pages.somDashboardPage().getAlgorithmInfo(6);
        ArrayList<String> algorithm5 = Pages.somDashboardPage().getAlgorithmInfo(7);
        ArrayList<String> algorithm5b = Pages.somDashboardPage().getAlgorithmInfo(8);
        ArrayList<String> algorithm6 = Pages.somDashboardPage().getAlgorithmInfo(9);
        ArrayList<String> algorithm6b = Pages.somDashboardPage().getAlgorithmInfo(10);
        ArrayList<String> algorithm8 = Pages.somDashboardPage().getAlgorithmInfo(11);
        ArrayList<String> algorithm9 = Pages.somDashboardPage().getAlgorithmInfo(12);

        Pages.somOrdersPage().openOrdersTab();
        String oldOrders = Pages.somOrdersPage().getOrdersAmount();

        Actions.loginActions().loginToDemoSom(Constants.demoEmail, Constants.demoPassword);
        Pages.newSomUploadsPage().openUploadsTab();
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.januaryOrders);
        SelenideTools.sleep(60);
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.februaryOrders);
        SelenideTools.sleep(60);
        SelenideTools.refresh();
        Pages.newSomDashboardPage().openDashboardTab();
        Pages.newSomDashboardPage().selectDaysFilterOption("ALL");
        SelenideTools.sleep(5);

        ArrayList<String> newAlgorithm1 = Pages.newSomDashboardPage().getAlgorithmInfo(0);
        ArrayList<String> newAlgorithm2 = Pages.newSomDashboardPage().getAlgorithmInfo(1);
        ArrayList<String> newAlgorithm3 = Pages.newSomDashboardPage().getAlgorithmInfo(2);
        ArrayList<String> newAlgorithm4 = Pages.newSomDashboardPage().getAlgorithmInfo(3);
        ArrayList<String> newAlgorithm5 = Pages.newSomDashboardPage().getAlgorithmInfo(4);
        ArrayList<String> newAlgorithm6 = Pages.newSomDashboardPage().getAlgorithmInfo(5);
        ArrayList<String> newAlgorithm8 = Pages.newSomDashboardPage().getAlgorithmInfo(6);
        ArrayList<String> newAlgorithm1b = Pages.newSomDashboardPage().getAlgorithmInfo(7);
        ArrayList<String> newAlgorithm2b = Pages.newSomDashboardPage().getAlgorithmInfo(8);
        ArrayList<String> newAlgorithm4b = Pages.newSomDashboardPage().getAlgorithmInfo(9);
        ArrayList<String> newAlgorithm5b = Pages.newSomDashboardPage().getAlgorithmInfo(10);
        ArrayList<String> newAlgorithm6b = Pages.newSomDashboardPage().getAlgorithmInfo(11);
        ArrayList<String> newAlgorithm9 = Pages.newSomDashboardPage().getAlgorithmInfo(12);

        Pages.newSomOrdersPage().openOrdersTab();
        String newOrders = Pages.newSomOrdersPage().getOrdersAmount();
        System.out.println(newOrders);
        System.out.println(oldOrders);

        Assert.assertEquals(algorithm1.get(1),newAlgorithm1.get(1));
        Assert.assertEquals(algorithm2.get(1),newAlgorithm2.get(1));
        Assert.assertEquals(algorithm3.get(1),newAlgorithm3.get(1));
        Assert.assertEquals(algorithm4.get(1),newAlgorithm4.get(1));
        Assert.assertEquals(algorithm5.get(1),newAlgorithm5.get(1));
        Assert.assertEquals(algorithm6.get(1),newAlgorithm6.get(1));
        Assert.assertEquals(algorithm8.get(1),newAlgorithm8.get(1));
        Assert.assertEquals(algorithm9.get(1),newAlgorithm9.get(1));

        Assert.assertEquals(algorithm1b.get(1),newAlgorithm1b.get(1));
        Assert.assertEquals(algorithm2b.get(1),newAlgorithm2b.get(1));
        Assert.assertEquals(algorithm4b.get(1),newAlgorithm4b.get(1));
        Assert.assertEquals(algorithm5b.get(1),newAlgorithm5b.get(1));
        Assert.assertEquals(algorithm6b.get(1),newAlgorithm6b.get(1));
    }

    @AfterMethod
    public void deleteOrdersOnProdAndDemo()
    {
        SelenideTools.refresh();
        Pages.newSomRequestDeleterPage().openRequestDeleterTab();
        SelenideTools.sleep(2);
        //Pages.newSomRequestDeleterPage().clearProdData();
        //SelenideTools.sleep(2);
        //Pages.newSomRequestDeleterPage().clickPopUpOkButton();
        //SelenideTools.sleep(2);
        //Pages.newSomRequestDeleterPage().clickPopUpOkButton();
        Pages.newSomRequestDeleterPage().clearDemoData();
        SelenideTools.sleep(2);
        Pages.newSomRequestDeleterPage().clickPopUpOkButton();
        SelenideTools.sleep(5);
    }
}