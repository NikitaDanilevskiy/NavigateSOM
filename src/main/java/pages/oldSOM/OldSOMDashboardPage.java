package pages.oldSOM;

import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;

import java.util.ArrayList;

public class OldSOMDashboardPage extends PageTools {
    private By dashboardTab = By.xpath("//div[contains(@class,'MuiListItem-root')]/div/span[text()='Dashboard']");
    private By daysFilterbox = By.xpath("//section/div[@class='filterbox']/select");
    private By algorithmInfo = By.xpath("//table[contains(@class,'MuiTable-root')]/tbody/tr");

    public void openDashboardTab(){
        waitForElementClickable(dashboardTab);
        click(dashboardTab);
    }

    public void selectDaysFilterOption(String option){
        waitForElementVisibility(daysFilterbox);
        selectOption(option,daysFilterbox);
        SelenideTools.sleep(5);
    }

    public ArrayList<String> getAlgorithmInfo(int index){
        ArrayList<String> elements = new ArrayList<>();

        elements.add(getElements(algorithmInfo).get(index).findElement(By.xpath("./td[2]")).getText());
        elements.add(getElements(algorithmInfo).get(index).findElement(By.xpath("./td[3]")).getText());
        elements.add(getElements(algorithmInfo).get(index).findElement(By.xpath("./td[4]")).getText());

        return elements;
    }
}
