package pages.newSOMAdmin;

import base.PageTools;
import org.openqa.selenium.By;
import utils.Constants;
import utils.SelenideTools;

public class NewSOMAdminGlobalPage extends PageTools {
    private By adminTitle = By.xpath("//title[contains(text(),'NavigateSOM | Admins')]");

    public void openDemoSomAdmin(){
        SelenideTools.openUrl(Constants.demoAdminURL);
    }

    public boolean isAdminPageOpened(){
        SelenideTools.sleep(5);
        return isElementExists(adminTitle);
    }
}
