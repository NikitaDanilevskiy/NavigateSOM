package pages.newSOM;

import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;

public class NewSOMLoginPage extends PageTools {
    private By emailInput = By.xpath("//div[@class='login-body']//input[@id='email']");
    private By passwordInput = By.xpath("//div[@class='login-body']//input[@id='password']");
    private By continueButton = By.xpath("//div[@class='login-body']//a[contains(@class,'confirm-btn')]");
    private By submitButton = By.xpath("//div[@class='login-body']//a[contains(@class,'submit-btn')]");


    public boolean isLoginPageOpened(){
        SelenideTools.sleep(5);
        return isElementVisible(emailInput);
    }

    public void typeEmail(String email){
        waitForElementVisibility(emailInput);
        type(email,emailInput);
    }

    public void typePassword(String password){
        waitForElementVisibility(passwordInput);
        type(password,passwordInput);
    }

    public void clickContinueButton(){
        waitForElementVisibility(continueButton);
        click(continueButton);
    }

    public void clickSubmitButton(){
        waitForElementVisibility(submitButton);
        click(submitButton);
    }
}
