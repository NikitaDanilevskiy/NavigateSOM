package com.navigatesom.nonbdd;

import actions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.Constants;
import utils.SelenideTools;

import pages.Pages;

import java.util.ArrayList;

public class C10 {

    @Test(description = "com.navigatesom.nonbdd.C10, Checking the algorithm's work on NavigateSOM demo environment")
    public void checkingTheAlgorithmsWorkOnDemo()
    {
        Actions.loginActions().loginToProdSom(Constants.prodLogin, Constants.prodPassword);
        Pages.somUploadsPage().openUploadsTab();
        Pages.somUploadsPage().clickUploadButton();
        Pages.somUploadsPage().uploadFile(Constants.oneOrderFile);
        Pages.somUploadsPage().clickUploadFileButton();
        SelenideTools.sleep(15);
        Pages.somDashboardPage().openDashboardTab();
        Pages.somDashboardPage().selectDaysFilterOption("ALL");
        SelenideTools.sleep(5);
        ArrayList<String> algorithm1b = Pages.somDashboardPage().getAlgorithmInfo(0);
        ArrayList<String> algorithm2b = Pages.somDashboardPage().getAlgorithmInfo(1);
        ArrayList<String> algorithm3 = Pages.somDashboardPage().getAlgorithmInfo(2);
        ArrayList<String> algorithm4b = Pages.somDashboardPage().getAlgorithmInfo(3);
        ArrayList<String> algorithm5b = Pages.somDashboardPage().getAlgorithmInfo(4);
        ArrayList<String> algorithm6b = Pages.somDashboardPage().getAlgorithmInfo(5);

        System.out.println(algorithm1b.toString());
        System.out.println(algorithm2b.toString());
        System.out.println(algorithm3.toString());
        System.out.println(algorithm4b.toString());
        System.out.println(algorithm5b.toString());
        System.out.println(algorithm6b.toString());

        Pages.somOrdersPage().openOrdersTab();
        String oldOrders = Pages.somOrdersPage().getOrdersAmount();

        Actions.loginActions().loginToDemoSom(Constants.demoEmail, Constants.demoPassword);
        Pages.newSomUploadsPage().openUploadsTab();
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.oneOrderFile);

        SelenideTools.sleep(10);
        SelenideTools.refresh();

        Pages.newSomDashboardPage().openDashboardTab();
        Pages.newSomDashboardPage().selectDaysFilterOption("ALL");
        SelenideTools.sleep(5);

        ArrayList<String> newAlgorithm3 = Pages.newSomDashboardPage().getAlgorithmInfo(0);
        ArrayList<String> newAlgorithm1b = Pages.newSomDashboardPage().getAlgorithmInfo(1);
        ArrayList<String> newAlgorithm2b = Pages.newSomDashboardPage().getAlgorithmInfo(2);
        ArrayList<String> newAlgorithm4b = Pages.newSomDashboardPage().getAlgorithmInfo(3);
        ArrayList<String> newAlgorithm5b = Pages.newSomDashboardPage().getAlgorithmInfo(4);
        ArrayList<String> newAlgorithm6b = Pages.newSomDashboardPage().getAlgorithmInfo(5);

        System.out.println(newAlgorithm3.toString());
        System.out.println(newAlgorithm1b.toString());
        System.out.println(newAlgorithm2b.toString());
        System.out.println(newAlgorithm4b.toString());
        System.out.println(newAlgorithm5b.toString());
        System.out.println(newAlgorithm6b.toString());

        Pages.newSomOrdersPage().openOrdersTab();
        String newOrders = Pages.newSomOrdersPage().getOrdersAmount();
        System.out.println(newOrders);
        System.out.println(oldOrders);

    }

    @AfterMethod
    public void deleteOrdersOnProdAndDemo()
    {
        SelenideTools.refresh();
        Pages.newSomRequestDeleterPage().openRequestDeleterTab();
        SelenideTools.sleep(2);
        Pages.newSomRequestDeleterPage().clearProdData();
        SelenideTools.sleep(2);
        Pages.newSomRequestDeleterPage().clickPopUpOkButton();
        SelenideTools.sleep(2);
        Pages.newSomRequestDeleterPage().clickPopUpOkButton();
        Pages.newSomRequestDeleterPage().clearDemoData();
        SelenideTools.sleep(2);
        Pages.newSomRequestDeleterPage().clickPopUpOkButton();
        SelenideTools.sleep(5);
    }
}