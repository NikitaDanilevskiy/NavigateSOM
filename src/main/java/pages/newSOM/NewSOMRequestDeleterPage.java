package pages.newSOM;

import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;

public class NewSOMRequestDeleterPage extends PageTools {
    private By requestDeleterTab = By.xpath("//nav[contains(@class,'navbar')]/ul[@class='navbar-nav']/li[8]");
    private By clearDemoDataButton = By.xpath("//button[@onclick='removeDemoData()']");
    private By clearProdDataButton = By.xpath("//button[@onclick='removeProdData()']");
    private By alertPopUp = By.xpath("//div[contains(@class,'sweet-alert')]");
    private By alertPopUpOkButton = By.xpath("//div[contains(@class,'sweet-alert')]//button[@class='confirm']");
    private By alertPopUpCancelButton = By.xpath("//div[contains(@class,'sweet-alert')]//button[@class='cancel']");

    private By deletedSuccessfullyMessage = By.xpath("//div[@id='timeoutmsg']/p[text()='Deleted successfully!']");

    public void openRequestDeleterTab(){
        waitForElementVisibility(requestDeleterTab);
        click(requestDeleterTab);
    }

    public void clearProdData(){
        waitForElementVisibility(clearProdDataButton);
        click(clearProdDataButton);
    }

    public void clearDemoData(){
        waitForElementVisibility(clearDemoDataButton);
        click(clearDemoDataButton);
    }

    public boolean isDeletedSuccessfullyMessageShown(){
        SelenideTools.sleep(5);
        return isElementExists(deletedSuccessfullyMessage);
    }

    public void clickPopUpOkButton(){
        waitForElementVisibility(alertPopUp);
        click(alertPopUpOkButton);
    }

    public void clickPopUpCancelButton(){
        waitForElementVisibility(alertPopUp);
        click(alertPopUpCancelButton);
    }
}
