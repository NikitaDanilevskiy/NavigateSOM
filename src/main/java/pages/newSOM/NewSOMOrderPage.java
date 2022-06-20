package pages.newSOM;

import org.openqa.selenium.Keys;
import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;
import java.util.ArrayList;


public class NewSOMOrderPage extends PageTools {
    private By orderForm = By.xpath("//form[@id='ordersforms']");
    private By ndcFlagReasons = By.xpath("//form[@id='ordersforms']/table/tbody/tr/td[6]/p/strong");
    private By ndcClearedFlag = By.xpath("//form[@id='ordersforms']/table[1]/tbody/tr/td/p/b/span");

    private By orderFlagReasons = By.xpath("//form[@id='ordersforms']/table[2]/tbody/tr/td/p");
    private By orderClearedFlag = By.xpath("//form[@id='ordersforms']/table[2]/tbody/tr/td/b/span");
    private By orderWindowCloseButton = By.xpath("//div[@id='notes']//a[contains(@class,'closebtn')]");
    private By clearFlagNdcCheckbox = By.xpath("//form[@id='ordersforms']//input[contains(@class,'clearflagcls')]/following-sibling::label");
    private By clearFlagNdcReasonInput = By.xpath("//form[@id='ordersforms']//input[contains(@class,'clearflagreason')]");
    private By clearFlagOrderCheckbox = By.xpath("//form[@id='ordersforms']//input[@id='orderclearflag_checkbox']/following-sibling::label");
    private By clearFlagOrderReasonInput = By.xpath("//form[@id='ordersforms']//input[@id='orderclearflag']");
    private By submitButton = By.xpath("//form[@id='ordersforms']//button[@id='submitform']");
    private By submitDocumentButton = By.xpath("//div[contains(@class,'dcumnt-sec')]//input[@name='btnSubmit']");
    private By flagCleared = By.xpath("//form[@id='ordersforms']//span[contains(@class,'issuspiciousclr')]");
    private By suspiciousRadioButton = By.xpath("//label[contains(@for,'customRadioInline2')]");
    private By printButton = By.xpath("//a[contains(@class,'prnt-btn')]");
    private By reasonError = By.xpath("//label[@class='error']");
    private By addNoteButton = By.xpath("//a[@onclick='addNote();']");
    private By noteInput = By.xpath("//input[@name='note']");
    private By saveNotesButton = By.xpath("//button[@onclick='saveNotes();']");
    private By cancelNotesButton = By.xpath("//button[@onclick='cancelNotes()']");
    private By addedNoteMessages = By.xpath("//div[@id='noteslist']//table/tbody/tr/td[4]");
    private By addDocumentButton = By.xpath("//a[@onclick='adddoc()']");
    private By chooseFileInput = By.xpath("//input[@id='uploaddocfile']");
    private By addedDocumentName = By.xpath("//div[@id='addDocumentlist']//table/tbody/tr/td[3]");
    private By cancelAddedDocument = By.xpath("//button[@onclick='cancelDocument()']");


    public boolean isOrderOpened(){
        SelenideTools.sleep(2);
        return isElementVisible(orderForm);
    }

    public void closeOrderWindow(){
        waitForElementVisibility(orderWindowCloseButton);
        click(orderWindowCloseButton);
    }

    public ArrayList<String> getNdcFlagReasons(){
        waitForElementVisibility(ndcFlagReasons);
        ArrayList<String> reasons = new ArrayList<>();
        for(int i = 0; i < getElements(ndcFlagReasons).size(); i++){
            reasons.add(getElements(ndcFlagReasons).get(i).getText());
        }
        return reasons;
    }

    public String getOrderFlagReasons(){
        waitForElementVisibility(orderFlagReasons);
        return getSelenideElement(orderFlagReasons).getText();
    }

    public boolean isOrderFlagCleared(){
        SelenideTools.sleep(2);
        return isElementVisible(orderClearedFlag);
    }

    public boolean isNdcFlagCleared(){
        SelenideTools.sleep(2);
        return isElementVisible(ndcClearedFlag);
    }

    public void selectClearFlagNdcCheckbox(){
        waitForElementPresent(clearFlagNdcCheckbox);
        click(clearFlagNdcCheckbox);
    }

    public void typeNdcReason(String reason){
        waitForElementVisibility(clearFlagNdcReasonInput);
        type(reason, clearFlagNdcReasonInput);
    }

    public void selectClearFlagOrderCheckbox(){
        waitForElementPresent(clearFlagOrderCheckbox);
        click(clearFlagOrderCheckbox);
    }

    public void typeOrderReason(String reason){
        waitForElementVisibility(clearFlagOrderReasonInput);
        type(reason, clearFlagOrderReasonInput);
    }

    public void clickSubmitButton(){
        waitForElementVisibility(submitButton);
        click(submitButton);
    }

    public void clickSubmitDocumentButton(){
        waitForElementVisibility(submitDocumentButton);
        click(submitDocumentButton);
    }

    public String isFlagCleared(){
        SelenideTools.sleep(2);
        return getSelenideElement(flagCleared).getText();
    }

    public void clickSuspiciousRadioButton(){
        SelenideTools.sleep(2);
        click(suspiciousRadioButton);
    }

    public void clickPrintButton(){
        waitForElementVisibility(printButton);
        click(printButton);
    }

    public String getErrorText(){
        waitForElementVisibility(reasonError);
        return getSelenideElement(reasonError).getText();
    }



    public void clickAddNoteButton(){
        waitForElementVisibility(addNoteButton);
        click(addNoteButton);
    }

    public void typeNote(String note){
        waitForElementVisibility(noteInput);
        type(note,noteInput);
    }

    public void typeNoteAndClickEnter(String note){
        waitForElementVisibility(noteInput);
        type(note,noteInput);
        SelenideTools.sleep(2);
        getSelenideElement(noteInput).sendKeys(Keys.ENTER);
    }

    public void clickSaveNoteButton(){
        waitForElementVisibility(saveNotesButton);
        click(saveNotesButton);
    }

    public void clickCancelNoteButton(){
        waitForElementVisibility(cancelNotesButton);
        click(cancelNotesButton);
    }

    public String getAddedNoteMessage(){
        waitForElementClickable(addedNoteMessages);
        return getSelenideElement(addedNoteMessages).getText();
    }

    public ArrayList<String> getAddedNotesMessage(){
        waitForElementPresent(addedNoteMessages);
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < getElements(addedNoteMessages).size();i++){
            list.add(getElements(addedNoteMessages).get(i).getText());
        }
        return list;
    }

    public String getAddedDocumentName(){
        waitForElementClickable(addedDocumentName);
        return getSelenideElement(addedDocumentName).getText();
    }

    public ArrayList<String> getAddedDocumentsNames(){
        waitForElementPresent(addedDocumentName);
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < getElements(addedDocumentName).size();i++){
            list.add(getElements(addedDocumentName).get(i).getText());
        }
        return list;
    }

    public void clickAddDocumentButton(){
        waitForElementVisibility(addDocumentButton);
        click(addDocumentButton);
    }

    public void uploadDocument(String filepath){
        SelenideTools.sleep(5);
        uploadFile(filepath, chooseFileInput);
    }

    public void clickCancelAddedDocumentButton(){
        waitForElementVisibility(cancelAddedDocument);
        click(cancelAddedDocument);
    }
}
