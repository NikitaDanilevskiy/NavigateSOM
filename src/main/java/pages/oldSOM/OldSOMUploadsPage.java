package pages.oldSOM;

import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;

public class OldSOMUploadsPage extends PageTools {
    private By uploadsTab = By.xpath("//div[contains(@class,'MuiListItem-root')]/div/span[text()='Uploads']");
    private By uploadButton = By.xpath("//section/section/section/div/div/button[2]");
    private By fileInput = By.xpath("//input[@type='file']");
    private By uploadFileButton = By.xpath("//div[contains(@class,'MuiDialogActions-spacing')]/div/button/span[text()='Upload']");
    public void openUploadsTab(){
        waitForElementClickable(uploadsTab);
        click(uploadsTab);
    }

    public void clickUploadButton(){
        waitForElementVisibility(uploadButton);
        click(uploadButton);
    }

    public void uploadFile(String filepath){
        SelenideTools.sleep(5);
        uploadFile(filepath, fileInput);
    }

    public void clickUploadFileButton(){
        waitForElementVisibility(uploadFileButton);
        click(uploadFileButton);
    }
}
