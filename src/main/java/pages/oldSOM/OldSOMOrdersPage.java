package pages.oldSOM;

import base.PageTools;
import org.openqa.selenium.By;

public class OldSOMOrdersPage extends PageTools {
    private By ordersTab = By.xpath("//div[contains(@class,'MuiListItem-root')]/div/span[text()='Orders']");
    private By ordersAmount = By.xpath("//table/tfoot[@class='MuiTableFooter-root']/tr/td/div/p[2]");

    public void openOrdersTab(){
        waitForElementClickable(ordersTab);
        click(ordersTab);
    }

    public String getOrdersAmount(){
        waitForElementVisibility(ordersAmount);
        return getSelenideElement(ordersAmount).getText();
    }

}
