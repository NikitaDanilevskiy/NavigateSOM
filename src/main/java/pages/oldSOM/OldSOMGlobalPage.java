package pages.oldSOM;

import base.PageTools;
import org.openqa.selenium.By;
import utils.Constants;
import utils.SelenideTools;

public class OldSOMGlobalPage extends PageTools {
    private By header = By.xpath("//header[contains(@class,'MuiAppBar-root')]/div/h6[text()='NavigateSOM']");

    public void openSomProd()
    {
        SelenideTools.openUrl(Constants.prodURL);
    }
    public boolean isPageOpened(){
        SelenideTools.sleep(5);
        return isElementVisible(header);
    }
}
