package actions;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import pages.Pages;
import utils.Constants;
import utils.SelenideTools;

public class LoginActions {
    public void loginToProdSom(String login, String password){
        Pages.somGlobalPage().openSomProd();
        Assert.assertTrue(Pages.somLoginPage().isLoginPageOpened());
        Pages.somLoginPage().enterLogin(login);
        Pages.somLoginPage().enterPassword(password);
        Pages.somLoginPage().clickLoginButton();
        SelenideTools.sleep(5);
        Assert.assertTrue(Pages.somGlobalPage().isPageOpened());
    }

    public void loginToDemoSom(String email, String password){
        Pages.newSomGlobalPage().openSomDemo();
        Assert.assertTrue(Pages.newSomLoginPage().isLoginPageOpened());
        Pages.newSomLoginPage().typeEmail(email);
        Pages.newSomLoginPage().clickContinueButton();
        Pages.newSomLoginPage().typePassword(password);
        Pages.newSomLoginPage().clickSubmitButton();

        Assert.assertTrue(Pages.newSomGlobalPage().isPageOpened());
    }

    public void loginToDemoAdminSom(String email, String password){
        Pages.newSomAdminGlobalPage().openDemoSomAdmin();
        Assert.assertTrue(Pages.newSomAdminLoginPage().isLoginPageOpened());
        Pages.newSomAdminLoginPage().typeEmail(email);
        Pages.newSomAdminLoginPage().typePassword(password);
        Pages.newSomAdminLoginPage().clickSubmitButton();

        Assert.assertTrue(Pages.newSomAdminGlobalPage().isAdminPageOpened());
        SelenideTools.sleep(5);
    }
}
