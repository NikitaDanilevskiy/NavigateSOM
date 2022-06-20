package pages.oldSOM;

import base.PageTools;
import org.openqa.selenium.By;
import utils.SelenideTools;

public class OldSOMLoginPage extends PageTools {
    private By loginInput = By.xpath("//form/div/div/input[@type='text']");
    private By passwordInput = By.xpath("//form/div/div/input[@type='password']");
    private By loginButton = By.xpath("//form/button[@type='submit']/span[text()='Login']");

    public boolean isLoginPageOpened()
    {
        SelenideTools.sleep(4);
        return isElementVisible(loginButton);
    }

    public void enterLogin(String login)
    {
        waitForElementVisibility(loginInput);
        type(login, loginInput);
    }

    public void enterPassword(String password)
    {
        waitForElementVisibility(passwordInput);
        type(password,passwordInput);
    }

    public void clickLoginButton()
    {
        waitForElementClickable(loginButton);
        click(loginButton);
    }
}
