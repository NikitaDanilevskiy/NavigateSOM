package pages.newSOM;

import java.util.List;
import entities.Order;
import base.PageTools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.SelenideTools;

import java.util.ArrayList;

public class NewSOMOrdersPage extends PageTools {
    private By ordersTab = By.xpath("//div[@class='nav-bar']/div/nav/ul/li[2]/a");
    private By ordersAmount = By.xpath("//div[@id='DataTables_Table_0_info']");
    private By ordersRow = By.xpath("//table[@id='DataTables_Table_0']/tbody/tr");
    private By orderOpenButton = By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]//a");
    private By orders = By.xpath("//table[@id='DataTables_Table_0']/tbody/tr");
    private By searchInput = By.xpath("//div[@id='DataTables_Table_0_filter']/label/input");
    private By flagType = By.xpath("//select[@id='flagtype']");
    private By noRecordsMessage = By.xpath("//td[@class='dataTables_empty']");


    public void openOrdersTab(){
        waitForElementClickable(ordersTab);
        click(ordersTab);
    }

    public String getOrdersAmount(){
        waitForElementVisibility(ordersAmount);
        return getSelenideElement(ordersAmount).getText();
    }

    public void typeInSearchInput(String search){
        waitForElementVisibility(searchInput);
        type(search,searchInput);
        getSelenideElement(searchInput).sendKeys(Keys.ENTER);
    }

    public void openFirstOrder(){
        waitForElementVisibility(orderOpenButton);
        getSelenideElement(orderOpenButton).click();
    }

    public void openOrder(int id){
        waitForElementVisibility(orderOpenButton);
        getElements(orderOpenButton).get(id).click();
    }

    public void selectFlagType(String flag){
        waitForElementVisibility(flagType);
        selectOption(flag,flagType);
    }

    public boolean isNoRecordsFoundMessageAppeared(){
        SelenideTools.sleep(5);
        return isElementVisible(noRecordsMessage);
    }

    public List<Order> getOrdersData(){
        List<Order> data = new ArrayList<>();
        Order order;
        for(int i = 0; i < getElements(orders).size();i++){
            order = new Order();
            order.setId(getElements(orders).get(i).findElement(By.xpath("./td[2]")).getText());
            order.setCustomerId(getElements(orders).get(i).findElement(By.xpath("./td[3]")).getText());
            order.setCustomerName(getElements(orders).get(i).findElement(By.xpath("./td[4]")).getText());
            order.setTrade(getElements(orders).get(i).findElement(By.xpath("./td[5]")).getText());
            order.setQuantity(Integer.parseInt(getElements(orders).get(i).findElement(By.xpath("./td[6]")).getText()));
            order.setLineTotal(Float.parseFloat(getElements(orders).get(i).findElement(By.xpath("./td[7]")).getText()));
            order.setOrderDate(getElements(orders).get(i).findElement(By.xpath("./td[9]")).getText());
            data.add(order);
        }
        return data;
    }
}
