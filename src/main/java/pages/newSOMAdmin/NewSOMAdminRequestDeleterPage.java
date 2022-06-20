package pages.newSOMAdmin;

import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;

public class NewSOMAdminRequestDeleterPage extends PageTools {
    private By requestDeleterTab = By.xpath("//nav[contains(@class,'navbar')]/ul[@class='navbar-nav']/li[7]");
    private By requestIdInput = By.xpath("//input[@id='request_id']");
    private By submitButton = By.xpath("//form[@id='requestdeleteform']//button[@type='submit']");
    private By deletedSuccessfullyMessage = By.xpath("//div[@id='timeoutmsg']/p[text()='Deleted successfully!']");

    public void openRequestDeleterTab(){
        waitForElementVisibility(requestDeleterTab);
        click(requestDeleterTab);
    }

    public void typeRequestId(String id){
        waitForElementVisibility(requestIdInput);
        type(id,requestIdInput);
    }

    public void clickSubmitButton(){
        waitForElementClickable(submitButton);
        click(submitButton);
    }

    public boolean isDeletedSuccessfullyMessageShown(){
        SelenideTools.sleep(5);
        return isElementExists(deletedSuccessfullyMessage);
    }
}
