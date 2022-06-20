package pages.newSOMAdmin;

import base.PageTools;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.Constants;
import utils.SelenideTools;

public class NewSOMAdminTenantsPage extends PageTools {
    private By tenantsTab = By.xpath("//nav[contains(@class,'navbar')]/ul[@class='navbar-nav']/li[5]");
    private By tenantsSearchField = By.xpath("//div[@id='DataTables_Table_0_filter']/label/input");
    private By editTenantButton = By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[5]/a[1]");
    private By algorithmAccordion = By.xpath("//div[@id='accordion']");
    private By settingsSliderA1b = By.xpath("//div[@id='accordion']//label[contains(@class,'switch')]/span[contains(@class,'slider')]");
    private By addSettingsButtonA1 = By.xpath("//a[contains(@onclick,'addsettings(1);')]");
    private By addSettingsButtonA2 = By.xpath("//a[contains(@onclick,'addsettings(2);')]");
    private By addSettingsButtonA3 = By.xpath("//a[contains(@onclick,'addsettings(3);')]");
    private By addSettingsButtonA4 = By.xpath("//a[contains(@onclick,'addsettings(4);')]");
    private By addSettingsButtonA5 = By.xpath("//a[contains(@onclick,'addsettings(5);')]");
    private By addSettingsButtonA6 = By.xpath("//a[contains(@onclick,'addsettings(6);')]");

    private By addSettingsButtonA1b = By.xpath("//a[contains(@onclick,'addsettings(9);')]");
    private By addSettingsButtonA2b = By.xpath("//a[contains(@onclick,'addsettings(10);')]");
    private By addSettingsButtonA4b = By.xpath("//a[contains(@onclick,'addsettings(11);')]");
    private By addSettingsButtonA5b = By.xpath("//a[contains(@onclick,'addsettings(12);')]");
    private By addSettingsButtonA6b = By.xpath("//a[contains(@onclick,'addsettings(13);')]");

    private By customerIdInputA1 = By.xpath("//div[@class='algothms_1']//input[@data-label='customerid']");
    private By customerIdInputA2 = By.xpath("//div[@class='algothms_2']//input[@data-label='customerid']");
    private By customerIdInputA3 = By.xpath("//div[@class='algothms_3']//input[@data-label='customerid']");
    private By customerIdInputA4 = By.xpath("//div[@class='algothms_4']//input[@data-label='customerid']");
    private By customerIdInputA5 = By.xpath("//div[@class='algothms_5']//input[@data-label='customerid']");
    private By customerIdInputA6 = By.xpath("//div[@class='algothms_6']//input[@data-label='customerid']");

    private By customerIdInputA1b = By.xpath("//div[@class='algothms_9']//input[@data-label='customerid']");
    private By customerIdInputA2b = By.xpath("//div[@class='algothms_10']//input[@data-label='customerid']");
    private By customerIdInputA4b = By.xpath("//div[@class='algothms_11']//input[@data-label='customerid']");
    private By customerIdInputA5b = By.xpath("//div[@class='algothms_12']//input[@data-label='customerid']");
    private By customerIdInputA6b = By.xpath("//div[@class='algothms_13']//input[@data-label='customerid']");

    private By ndcInputA1b = By.xpath("//div[@class='algothms_9']//input[@data-label='ndc']");
    private By ndcInputA2b = By.xpath("//div[@class='algothms_10']//input[@data-label='ndc']");
    private By ndcInputA3 = By.xpath("//div[@class='algothms_3']//input[@data-label='ndc']");

    private By ndcInputA4b = By.xpath("//div[@class='algothms_11']//input[@data-label='ndc']");
    private By ndcInputA5b = By.xpath("//div[@class='algothms_12']//input[@data-label='ndc']");
    private By ndcInputA6b = By.xpath("//div[@class='algothms_13']//input[@data-label='ndc']");
    private By familyInputA4 = By.xpath("//div[@class='algothms_4']//input[@id='family']");
    private By historyDaysInputA3 = By.xpath("//div[@class='algothms_3']//input[@data-label='historydays']");
    private By ndcFrequencyInputA3 = By.xpath("//div[@class='algothms_3']//input[@data-label='ndcfrequency']");
    private By familyInputA4b = By.xpath("//div[@class='algothms_11']//input[@id='family']");
    private By tradeInputA1 = By.xpath("//div[@class='algothms_1']//input[@data-label='trade']");
    private By tradeInputA2 = By.xpath("//div[@class='algothms_2']//input[@data-label='trade']");
    private By tradeInputA6 = By.xpath("//div[@class='algothms_6']//input[@data-label='trade']");

    private By tradeInputA4b = By.xpath("//div[@class='algothms_11']//input[@data-label='trade']");
    private By tradeInputA5b = By.xpath("//div[@class='algothms_12']//input[@data-label='trade']");
    private By tradeInputA6b = By.xpath("//div[@class='algothms_13']//input[@data-label='trade']");

    private By thresholdInputA1 = By.xpath("//div[@class='algothms_1']//input[@data-label='flagthreshold']");
    private By thresholdInputA2 = By.xpath("//div[@class='algothms_2']//input[@data-label='flagthreshold']");
    private By thresholdInputA4 = By.xpath("//div[@class='algothms_4']//input[@data-label='flagthreshold']");
    private By thresholdInputA5 = By.xpath("//div[@class='algothms_5']//input[@data-label='flagthreshold']");
    private By thresholdInputA6 = By.xpath("//div[@class='algothms_6']//input[@data-label='flagthreshold']");

    private By thresholdInputA1b = By.xpath("//div[@class='algothms_9']//input[@data-label='flagthreshold']");
    private By thresholdInputA2b = By.xpath("//div[@class='algothms_10']//input[@data-label='flagthreshold']");
    private By thresholdInputA4b = By.xpath("//div[@class='algothms_11']//input[@data-label='flagthreshold']");
    private By thresholdInputA5b = By.xpath("//div[@class='algothms_12']//input[@data-label='flagthreshold']");
    private By thresholdInputA6b = By.xpath("//div[@class='algothms_13']//input[@data-label='flagthreshold']");

    private By averagingPeriodSelectA1 = By.xpath("//div[@id='appndsettings_1']//select[1]");
    private By averagingPeriodSelectA2 = By.xpath("//div[@id='appndsettings_2']//select[1]");
    private By averagingPeriodSelectA4 = By.xpath("//div[@id='appndsettings_4']//select[1]");
    private By averagingPeriodSelectA5 = By.xpath("//div[@id='appndsettings_5']//select[1]");
    private By averagingPeriodSelectA6 = By.xpath("//div[@id='appndsettings_6']//select[1]");

    private By averagingPeriodSelectA1b = By.xpath("//div[@id='appndsettings_9']//select[1]");
    private By averagingPeriodSelectA2b = By.xpath("//div[@id='appndsettings_10']//select[1]");
    private By averagingPeriodSelectA4b = By.xpath("//div[@id='appndsettings_11']//select[1]");
    private By averagingPeriodSelectA5b = By.xpath("//div[@id='appndsettings_12']//select[1]");
    private By averagingPeriodSelectA6b = By.xpath("//div[@id='appndsettings_13']//select[1]");

    private By numberOfMonthSelectA1 = By.xpath("//div[@id='appndsettings_1']//label[text()='Number of Months']/following-sibling::select");
    private By numberOfMonthSelectA2 = By.xpath("//div[@id='appndsettings_2']//label[text()='Number of Months']/following-sibling::select");
    private By numberOfMonthSelectA4 = By.xpath("//div[@id='appndsettings_4']//label[text()='Number of Months']/following-sibling::select");
    private By numberOfMonthSelectA5 = By.xpath("//div[@id='appndsettings_5']//label[text()='Number of Months']/following-sibling::select");
    private By numberOfMonthSelectA6 = By.xpath("//div[@id='appndsettings_6']//label[text()='Number of Months']/following-sibling::select");

    private By numberOfMonthSelectA1b = By.xpath("//div[@id='appndsettings_9']//label[text()='Number of Months']/following-sibling::select");
    private By numberOfMonthSelectA2b = By.xpath("//div[@id='appndsettings_10']//label[text()='Number of Months']/following-sibling::select");
    private By numberOfMonthSelectA4b = By.xpath("//div[@id='appndsettings_11']//label[text()='Number of Months']/following-sibling::select");
    private By numberOfMonthSelectA5b = By.xpath("//div[@id='appndsettings_12']//label[text()='Number of Months']/following-sibling::select");
    private By numberOfMonthSelectA6b = By.xpath("//div[@id='appndsettings_13']//label[text()='Number of Months']/following-sibling::select");

    private By removeCustomSettingsA1 = By.xpath("//div[@class='algothms_1']//div[@id='appndsettings_1']//a[contains(@class,'btn-outline-danger')]");
    private By removeCustomSettingsA2 = By.xpath("//div[@class='algothms_2']//div[@id='appndsettings_2']//a[contains(@class,'btn-outline-danger')]");
    private By removeCustomSettingsA3 = By.xpath("//div[@class='algothms_3']//div[@id='appndsettings_3']//a[contains(@class,'btn-outline-danger')]");
    private By removeCustomSettingsA4 = By.xpath("//div[@class='algothms_4']//div[@id='appndsettings_4']//a[contains(@class,'btn-outline-danger')]");
    private By removeCustomSettingsA5 = By.xpath("//div[@class='algothms_5']//div[@id='appndsettings_5']//a[contains(@class,'btn-outline-danger')]");
    private By removeCustomSettingsA6 = By.xpath("//div[@class='algothms_6']//div[@id='appndsettings_6']//a[contains(@class,'btn-outline-danger')]");

    private By removeCustomSettingsA1b = By.xpath("//div[@class='algothms_9']//div[@id='appndsettings_9']//a[contains(@class,'btn-outline-danger')]");
    private By removeCustomSettingsA2b = By.xpath("//div[@class='algothms_10']//div[@id='appndsettings_10']//a[contains(@class,'btn-outline-danger')]");
    private By removeCustomSettingsA4b = By.xpath("//div[@class='algothms_11']//div[@id='appndsettings_11']//a[contains(@class,'btn-outline-danger')]");
    private By removeCustomSettingsA5b = By.xpath("//div[@class='algothms_12']//div[@id='appndsettings_12']//a[contains(@class,'btn-outline-danger')]");
    private By removeCustomSettingsA6b = By.xpath("//div[@class='algothms_13']//div[@id='appndsettings_13']//a[contains(@class,'btn-outline-danger')]");

    private By updateTenantButton = By.xpath("//button[@id='edittenentbutton']");
    private By popUpOkButton = By.xpath("//div[contains(@class,'sweet-alert')]//button[@class='confirm']");
    private By popUpCancelButton = By.xpath("//div[contains(@class,'sweet-alert')]//button[@class='cancel']");

    public void openTenantsTab(){
        waitForElementClickable(tenantsTab);
        click(tenantsTab);
    }

    public void typeInTenantsSearch(String tenant){
        waitForElementVisibility(tenantsSearchField);
        type(tenant, tenantsSearchField);
    }

    public void clickEditTenantButton(){
        waitForElementClickable(editTenantButton);
        click(editTenantButton);
    }

    public void expandAlgorithm(int index){
        waitForElementClickable(algorithmAccordion);
        getElements(algorithmAccordion).get(index).click();
    }

    public void switchSliderA1b(){
        SelenideTools.sleep(2);
        //waitForElementClickable(settingsSliderA1b);
        click(settingsSliderA1b);
    }

    public void clickAddSettingsButtonA1(){
        waitForElementPresent(addSettingsButtonA1);
        scrollToElement(addSettingsButtonA1);
        click(addSettingsButtonA1);
    }

    public void clickAddSettingsButtonA2(){
        waitForElementPresent(addSettingsButtonA2);
        scrollToElement(addSettingsButtonA2);
        click(addSettingsButtonA2);
    }

    public void clickAddSettingsButtonA3(){
        waitForElementPresent(addSettingsButtonA3);
        scrollToElement(addSettingsButtonA3);
        click(addSettingsButtonA3);
    }

    public void clickAddSettingsButtonA4(){
        waitForElementPresent(addSettingsButtonA4);
        scrollToElement(addSettingsButtonA4);
        click(addSettingsButtonA4);
    }

    public void clickAddSettingsButtonA5(){
        waitForElementPresent(addSettingsButtonA5);
        scrollToElement(addSettingsButtonA5);
        click(addSettingsButtonA5);
    }

    public void clickAddSettingsButtonA6(){
        waitForElementPresent(addSettingsButtonA6);
        scrollToElement(addSettingsButtonA6);
        click(addSettingsButtonA6);
    }
    public void clickAddSettingsButtonA1b(){
        waitForElementPresent(addSettingsButtonA1b);
        scrollToElement(addSettingsButtonA1b);
        click(addSettingsButtonA1b);
    }

    public void clickAddSettingsButtonA2b(){
        waitForElementPresent(addSettingsButtonA2b);
        scrollToElement(addSettingsButtonA2b);
        click(addSettingsButtonA2b);
    }

    public void clickAddSettingsButtonA4b(){
        waitForElementPresent(addSettingsButtonA4b);
        scrollToElement(addSettingsButtonA4b);
        click(addSettingsButtonA4b);
    }

    public void clickAddSettingsButtonA5b(){
        waitForElementPresent(addSettingsButtonA5b);
        scrollToElement(addSettingsButtonA5b);
        click(addSettingsButtonA5b);
    }

    public void clickAddSettingsButtonA6b(){
        waitForElementPresent(addSettingsButtonA6b);
        scrollToElement(addSettingsButtonA6b);
        click(addSettingsButtonA6b);
    }

    public void typeCustomerIdA1(String id){
        waitForElementVisibility(customerIdInputA1);
        type(id,customerIdInputA1);
    }

    public void typeCustomerIdA2(String id){
        waitForElementVisibility(customerIdInputA2);
        type(id,customerIdInputA2);
    }

    public void typeCustomerIdA3(String id){
        waitForElementVisibility(customerIdInputA3);
        type(id,customerIdInputA3);
    }

    public void typeCustomerIdA4(String id){
        waitForElementVisibility(customerIdInputA4);
        type(id,customerIdInputA4);
    }

    public void typeCustomerIdA5(String id){
        waitForElementVisibility(customerIdInputA5);
        type(id,customerIdInputA5);
    }

    public void typeCustomerIdA6(String id){
        waitForElementVisibility(customerIdInputA6);
        type(id,customerIdInputA6);
    }

    public void typeCustomerIdA1b(String id){
        waitForElementVisibility(customerIdInputA1b);
        type(id,customerIdInputA1b);
    }

    public void typeCustomerIdA2b(String id){
        waitForElementVisibility(customerIdInputA2b);
        type(id,customerIdInputA2b);
    }

    public void typeCustomerIdA4b(String id){
        waitForElementVisibility(customerIdInputA4b);
        type(id,customerIdInputA4b);
    }

    public void typeCustomerIdA5b(String id){
        waitForElementVisibility(customerIdInputA5b);
        type(id,customerIdInputA5b);
    }

    public void typeCustomerIdA6b(String id){
        waitForElementVisibility(customerIdInputA6b);
        type(id,customerIdInputA6b);
    }

    public void typeNdcA1b(String ndc){
        waitForElementVisibility(ndcInputA1b);
        type(ndc,ndcInputA1b);
    }

    public void typeNdcA2b(String ndc){
        waitForElementVisibility(ndcInputA2b);
        type(ndc,ndcInputA2b);
    }

    public void typeNdcA3(String ndc){
        waitForElementVisibility(ndcInputA3);
        type(ndc,ndcInputA3);
    }

    public void typeNdcA4b(String ndc){
        waitForElementVisibility(ndcInputA4b);
        type(ndc,ndcInputA4b);
    }

    public void typeNdcA5b(String ndc){
        waitForElementVisibility(ndcInputA5b);
        type(ndc,ndcInputA5b);
    }

    public void typeNdcA6b(String ndc){
        waitForElementVisibility(ndcInputA6b);
        type(ndc,ndcInputA6b);
    }

    public void typeFamilyA4(String family){
        waitForElementVisibility(familyInputA4);
        type(family,familyInputA4);
    }

    public void typeHistoryDaysA3(String historyDays){
        waitForElementVisibility(historyDaysInputA3);
        type(historyDays,historyDaysInputA3);
    }

    public void typeNDCFrequencyA3(String frequency){
        waitForElementVisibility(ndcFrequencyInputA3);
        type(frequency,ndcFrequencyInputA3);
    }

    public void typeFamilyA4b(String family){
        waitForElementVisibility(familyInputA4b);
        type(family,familyInputA4b);
    }

    public void typeTradeA1(String trade){
        waitForElementVisibility(tradeInputA1);
        type(trade,tradeInputA1);
    }

    public void typeTradeA2(String trade){
        waitForElementVisibility(tradeInputA2);
        type(trade,tradeInputA2);
    }

    public void typeTradeA6(String trade){
        waitForElementVisibility(tradeInputA6);
        type(trade,tradeInputA6);
    }

    public void typeTradeA4b(String trade){
        waitForElementVisibility(tradeInputA4b);
        type(trade,tradeInputA4b);
    }

    public void typeTradeA5b(String trade){
        waitForElementVisibility(tradeInputA5b);
        type(trade,tradeInputA5b);
    }

    public void typeTradeA6b(String trade){
        waitForElementVisibility(tradeInputA6b);
        type(trade,tradeInputA6b);
    }

    public void typeThresholdA1(String threshold){
        waitForElementVisibility(thresholdInputA1);
        type(threshold,thresholdInputA1);
    }

    public void typeThresholdA2(String threshold){
        waitForElementVisibility(thresholdInputA2);
        type(threshold,thresholdInputA2);
    }

    public void typeThresholdA4(String threshold){
        waitForElementVisibility(thresholdInputA4);
        type(threshold,thresholdInputA4);
    }

    public void typeThresholdA5(String threshold){
        waitForElementVisibility(thresholdInputA5);
        type(threshold,thresholdInputA5);
    }

    public void typeThresholdA6(String threshold){
        waitForElementVisibility(thresholdInputA6);
        type(threshold,thresholdInputA6);
    }
    public void typeThresholdA1b(String threshold){
        waitForElementVisibility(thresholdInputA1b);
        type(threshold,thresholdInputA1b);
    }

    public void typeThresholdA2b(String threshold){
        waitForElementVisibility(thresholdInputA2b);
        type(threshold,thresholdInputA2b);
    }

    public void typeThresholdA4b(String threshold){
        waitForElementVisibility(thresholdInputA4b);
        type(threshold,thresholdInputA4b);
    }

    public void typeThresholdA5b(String threshold){
        waitForElementVisibility(thresholdInputA5b);
        type(threshold,thresholdInputA5b);
    }

    public void typeThresholdA6b(String threshold){
        waitForElementVisibility(thresholdInputA6b);
        type(threshold,thresholdInputA6b);
    }

    public void selectAveragingPeriodA1(String period){
        waitForElementVisibility(averagingPeriodSelectA1);
        selectOption(period,averagingPeriodSelectA1);
    }

    public void selectAveragingPeriodA2(String period){
        waitForElementVisibility(averagingPeriodSelectA2);
        selectOption(period,averagingPeriodSelectA2);
    }

    public void selectAveragingPeriodA4(String period){
        waitForElementVisibility(averagingPeriodSelectA4);
        selectOption(period,averagingPeriodSelectA4);
    }

    public void selectAveragingPeriodA5(String period){
        waitForElementVisibility(averagingPeriodSelectA5);
        selectOption(period,averagingPeriodSelectA5);
    }

    public void selectAveragingPeriodA6(String period){
        waitForElementVisibility(averagingPeriodSelectA6);
        selectOption(period,averagingPeriodSelectA6);
    }
    public void selectAveragingPeriodA1b(String period){
        waitForElementVisibility(averagingPeriodSelectA1b);
        selectOption(period,averagingPeriodSelectA1b);
    }

    public void selectAveragingPeriodA2b(String period){
        waitForElementVisibility(averagingPeriodSelectA2b);
        selectOption(period,averagingPeriodSelectA2b);
    }

    public void selectAveragingPeriodA4b(String period){
        waitForElementVisibility(averagingPeriodSelectA4b);
        selectOption(period,averagingPeriodSelectA4b);
    }

    public void selectAveragingPeriodA5b(String period){
        waitForElementVisibility(averagingPeriodSelectA5b);
        selectOption(period,averagingPeriodSelectA5b);
    }

    public void selectAveragingPeriodA6b(String period){
        waitForElementVisibility(averagingPeriodSelectA6b);
        selectOption(period,averagingPeriodSelectA6b);
    }

    public void selectNumberOfMonthA1(String month){
        waitForElementVisibility(numberOfMonthSelectA1);
        selectOption(month, numberOfMonthSelectA1);
    }

    public void selectNumberOfMonthA2(String month){
        waitForElementVisibility(numberOfMonthSelectA2);
        selectOption(month, numberOfMonthSelectA2);
    }

    public void selectNumberOfMonthA4(String month){
        waitForElementVisibility(numberOfMonthSelectA4);
        selectOption(month, numberOfMonthSelectA4);
    }

    public void selectNumberOfMonthA5(String month){
        waitForElementVisibility(numberOfMonthSelectA5);
        selectOption(month, numberOfMonthSelectA5);
    }

    public void selectNumberOfMonthA6(String month){
        waitForElementVisibility(numberOfMonthSelectA6);
        selectOption(month, numberOfMonthSelectA6);
    }
    public void selectNumberOfMonthA1b(String month){
        waitForElementVisibility(numberOfMonthSelectA1b);
        selectOption(month, numberOfMonthSelectA1b);
    }

    public void selectNumberOfMonthA2b(String month){
        waitForElementVisibility(numberOfMonthSelectA2b);
        selectOption(month, numberOfMonthSelectA2b);
    }

    public void selectNumberOfMonthA4b(String month){
        waitForElementVisibility(numberOfMonthSelectA4b);
        selectOption(month, numberOfMonthSelectA4b);
    }

    public void selectNumberOfMonthA5b(String month){
        waitForElementVisibility(numberOfMonthSelectA5b);
        selectOption(month, numberOfMonthSelectA5b);
    }

    public void selectNumberOfMonthA6b(String month){
        waitForElementVisibility(numberOfMonthSelectA6b);
        selectOption(month, numberOfMonthSelectA6b);
    }

    public void clickRemoveCustomSettingA1Button(){
        waitForElementVisibility(removeCustomSettingsA1);
        click(removeCustomSettingsA1);
    }

    public void clickRemoveCustomSettingA2Button(){
        waitForElementVisibility(removeCustomSettingsA2);
        click(removeCustomSettingsA2);
    }

    public void clickRemoveCustomSettingA3Button(){
        waitForElementVisibility(removeCustomSettingsA3);
        click(removeCustomSettingsA3);
    }

    public void clickRemoveCustomSettingA4Button(){
        waitForElementVisibility(removeCustomSettingsA4);
        click(removeCustomSettingsA4);
    }

    public void clickRemoveCustomSettingA5Button(){
        waitForElementVisibility(removeCustomSettingsA5);
        click(removeCustomSettingsA5);
    }

    public void clickRemoveCustomSettingA6Button(){
        waitForElementVisibility(removeCustomSettingsA6);
        click(removeCustomSettingsA6);
    }

    public void clickRemoveCustomSettingA1bButton(){
        waitForElementVisibility(removeCustomSettingsA1b);
        click(removeCustomSettingsA1b);
    }

    public void clickRemoveCustomSettingA2bButton(){
        waitForElementVisibility(removeCustomSettingsA2b);
        click(removeCustomSettingsA2b);
    }

    public void clickRemoveCustomSettingA4bButton(){
        waitForElementVisibility(removeCustomSettingsA4b);
        click(removeCustomSettingsA4b);
    }

    public void clickRemoveCustomSettingA5bButton(){
        waitForElementVisibility(removeCustomSettingsA5b);
        click(removeCustomSettingsA5b);
    }

    public void clickRemoveCustomSettingA6bButton(){
        waitForElementVisibility(removeCustomSettingsA6b);
        click(removeCustomSettingsA6b);
    }

    public void clickUpdateTenantButton(){
        waitForElementClickable(updateTenantButton);
        click(updateTenantButton);
    }

    public void clickPopUpOkButton(){
        waitForElementClickable(popUpOkButton);
        click(popUpOkButton);
    }

    public void clickPopUpCancelButton(){
        waitForElementClickable(popUpCancelButton);
        click(popUpCancelButton);
    }
}
