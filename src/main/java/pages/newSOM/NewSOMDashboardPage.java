package pages.newSOM;

import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;

import java.util.ArrayList;

public class NewSOMDashboardPage extends PageTools {
    private By dashboardTab = By.xpath("//div[@class='nav-bar']/div/nav/ul/li[1]/a");
    private By daysFilterbox = By.xpath("//select[@id='filterby']");
    private By algorithmInfo = By.xpath("//table[contains(@class,'table-borderless')]/tbody/tr[contains(@class,'table-visited ')]");

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

        elements.add(getElements(algorithmInfo).get(index).findElement(By.xpath("./td[2]/p")).getText());
        elements.add(getElements(algorithmInfo).get(index).findElement(By.xpath("./td[3]/p")).getText());
        elements.add(getElements(algorithmInfo).get(index).findElement(By.xpath("./td[4]/p")).getText());

        return elements;
    }
}
