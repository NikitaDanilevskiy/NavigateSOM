package pages.newSOM;

import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;

public class NewSOMUploadsPage extends PageTools {
    private By uploadsTab = By.xpath("//div[@class='nav-bar']/div/nav/ul/li[5]/a");
    private By uploadButton = By.xpath("//div[@class='pg-hd']//a[@class='upld-btn']");
    private By fileInput = By.xpath("//input[@type='file']");
    private By uploadId = By.xpath("//form[@id='uploadform']//table[@id='DataTables_Table_0']//tr/td[1]");
    private By fileTypeError = By.xpath("//h2[contains(text(),\"You can't upload files of this type\")]");
    private By popUpOkButton = By.xpath("//div[contains(@class,'sweet-alert')]//button[@class='confirm']");
    private By errorUploadRow = By.xpath("//div[contains(@class,'table-list')]/table/tbody/tr");

    public void openUploadsTab(){
        waitForElementVisibility(uploadsTab);
        click(uploadsTab);
    }

    public boolean isUploadsTabOpened(){
        SelenideTools.sleep(2);
        return isElementVisible(uploadButton);
    }

    public void clickUploadButton(){
        waitForElementVisibility(uploadButton);
        click(uploadButton);
    }

    public void uploadFile(String filepath){
        SelenideTools.sleep(5);
        uploadFile(filepath, fileInput);
    }

    public String getUploadId(int index){
        waitForElementVisibility(uploadId);
        return getElements(uploadId).get(index).getText();
    }

    public boolean isFileTypeErrorAppeared(){
        SelenideTools.sleep(5);
        return isElementVisible(fileTypeError);
    }

    public void clickPopUpOkButton(){
        waitForElementVisibility(popUpOkButton);
        click(popUpOkButton);
    }

    public String getErrorUploadMessage(){
        waitForElementVisibility(errorUploadRow);
        return getSelenideElement(errorUploadRow).findElement(By.xpath("./td[10]")).getText();
    }
}
