package com.navigatesom.nonbdd.datadisplaying;

import actions.Actions;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.util.List;
import entities.Order;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Pages;
import utils.BaseTest;
import utils.Constants;
import utils.SelenideTools;


import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class C29 extends BaseTest {

    @Test(description = "C29, Upload file and compare the data in the file with the data on the SOM page")
    public void checkingThe1bAlgorithm() throws IOException, CsvException
    {
        List<String[]> r;
        String fileName = "src/main/resources/algorithm1b4b5b6b.csv";
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        }
        Actions.loginActions().loginToDemoSom(Constants.demoEmail, Constants.demoPassword);
        Pages.newSomUploadsPage().openUploadsTab();
        Pages.newSomUploadsPage().clickUploadButton();
        Pages.newSomUploadsPage().uploadFile(Constants.algorithm1b4b5b6bFile);
        SelenideTools.sleep(30);
        SelenideTools.refresh();
        Pages.newSomOrdersPage().openOrdersTab();
        List<Order> ordersInfoFromOrdersPage = Pages.newSomOrdersPage().getOrdersData();
        for (Order order : ordersInfoFromOrdersPage){
            System.out.println(order.toString());
            Assert.assertTrue(r.contains(order.toString()));
        }
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
