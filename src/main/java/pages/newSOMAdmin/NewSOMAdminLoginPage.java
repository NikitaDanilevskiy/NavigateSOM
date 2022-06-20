package pages.newSOMAdmin;

import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;

public class NewSOMAdminLoginPage extends PageTools {
    private By loginForm = By.xpath("//form[@id='loginform']");
    private By emailInput = By.xpath("//form[@id='loginform']//input[@id='username']");
    private By passwordInput = By.xpath("//form[@id='loginform']//input[@id='password']");
    private By submitButton = By.xpath("//form[@id='loginform']//button[@type='submit']");

    public boolean isLoginPageOpened(){
        SelenideTools.sleep(5);
        return isElementVisible(loginForm);
    }

    public void typeEmail(String email){
        waitForElementVisibility(emailInput);
        type(email,emailInput);
    }

    public void typePassword(String password){
        waitForElementVisibility(passwordInput);
        type(password,passwordInput);
    }

    public void clickSubmitButton(){
        waitForElementVisibility(submitButton);
        click(submitButton);
    }
}
