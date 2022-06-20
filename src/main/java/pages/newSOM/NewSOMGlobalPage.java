package pages.newSOM;

import base.PageTools;
import org.openqa.selenium.By;
import utils.Constants;
import utils.SelenideTools;

public class NewSOMGlobalPage extends PageTools {
    private By header = By.xpath("//header/nav/div/span");

    public void openSomDemo(){
        SelenideTools.openUrl(Constants.demoURL);
    }
    public boolean isPageOpened()
    {
        SelenideTools.sleep(5);
        return isElementVisible(header);
    }
}
