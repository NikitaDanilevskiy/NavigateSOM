package com.navigatesom.bdd;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.Pages;
import utils.AllureLogger;
import utils.SelenideConfig;
import utils.SelenideTools;

public class Hooks extends AllureLogger {

    @Before
    public void setUpBrowser(){
        logInfo("Creating web driver configuration...");
        SelenideConfig.createBrowserConfig(System.getProperty("selenide.browser", "chrome"));
        logInfo("Open browser...");
    }

    @After(value = "@Algorithms", order = 1)
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
