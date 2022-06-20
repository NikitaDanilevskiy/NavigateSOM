package base;

import com.codeborne.selenide.*;
import utils.LocatorParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AllureLogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageTools extends AllureLogger {

    private static String getPreviousMethodNameAsText() {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String replacedMethodName = methodName.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
        return replacedMethodName.substring(0, 1).toUpperCase() + replacedMethodName.substring(1).toLowerCase();
    }

    private By byLocator(By by, Object... args) {
        return LocatorParser.parseLocator(by, args);
    }

    protected SelenideElement getSelenideElement(By by, Object... args) {
        return $(byLocator(by, args));
    }

    protected Actions getActions() {
        return Selenide.actions();
    }

    /**
     * Should be
     */

    protected ElementsCollection shouldBe(CollectionCondition condition, By by, Object... args) {
        return $$(byLocator(by, args)).shouldBe(condition);
    }

    protected SelenideElement shouldBe(Condition condition, By by, Object... args) {
        return $(byLocator(by, args)).shouldBe(condition);
    }

//    protected SelenideElement shouldMatchText(String pattern, By by, Object... args) {
//        return $(byLocator(by, args)).should(Condition.matchesText(pattern));
//    }

    protected void shouldNotBeEmpty(By by, Object... args) {
        $(byLocator(by, args)).shouldNotBe(Condition.empty);
    }

    protected void shouldNotHaveClass(String className, By by, Object... args) {
        $(byLocator(by, args)).shouldNotHave(Condition.cssClass(className));
    }

    protected void shouldHaveClass(String className, By by, Object... args) {
        $(byLocator(by, args)).shouldHave(Condition.cssClass(className));
    }

    /**
     * Main Actions
     */

    protected void click(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        shouldBe(Condition.exist, by, args).click();
    }

    protected void clickIfExist(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        shouldBe(Condition.exist, by, args).click();
    }

    protected void jsClick(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        waitForElementClickable(by, args);
        Selenide.executeJavaScript("arguments[0].click();", shouldBe(Condition.exist, by, args));
    }

    protected void clickElementCoordinates(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args);
        getActions().moveToElement(getSelenideElement(by), (Integer) args[0], (Integer) args[1]).click().perform();
    }

    protected boolean isImageLoaded(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        String script = "return arguments[0].complete && "
                + "typeof arguments[0].naturalWidth != \"undefined\" && "
                + "arguments[0].naturalWidth > 0";
        return Selenide.executeJavaScript(script, shouldBe(Condition.exist, by, args));
    }

    protected void actionClick(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        Actions builder = getActions();
        builder.moveToElement(getWebElement(byLocator(by, args))).click();
        builder.perform();
    }

    protected void type(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + text);
        wipeText(by, args);
        shouldBe(Condition.visible, by, args).append(text);
    }

    protected void jsType(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + text);
        waitForElementClickable(by, args);
        Selenide.executeJavaScript("arguments[0].value = '" + text + "';", shouldBe(Condition.exist, by, args));
    }

    protected void jsSetValue(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + text);
        Selenide.executeJavaScript("arguments[0].setAttribute('value', '" + text + "');", shouldBe(Condition.exist, by, args));
    }

    protected void jsUpdateElementText(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + text);
        Selenide.executeJavaScript("arguments[0].innerHTML='" + text + "';", shouldBe(Condition.exist, by, args));
    }

    protected void jsRiseOnchange(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        Selenide.executeJavaScript("arguments[0].dispatchEvent(new Event('change', { 'bubbles': true }))", shouldBe(Condition.exist, by, args));
    }

    protected void typeWithActions(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        WebElement target = getWebElement(by, args);
        getActions().moveToElement(target).sendKeys(target, text).build().perform();
    }

    protected void typeWithActions(String text) {
        getActions().sendKeys(text).build().perform();
    }

    protected void typeWithoutLogs(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText());
        wipeText(by, args);
        shouldBe(Condition.visible, by, args).append(text);
    }

    protected void uploadFile(String filePath, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + filePath + "', element --> " + byLocator(by, args));
        //wipeText(by, args);
        shouldBe(Condition.enabled, by, args).uploadFile(new File(filePath));
    }

    protected void uploadFileWithoutFile(String filePath, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + filePath + "', element --> " + byLocator(by, args));
        shouldBe(Condition.enabled, by, args).uploadFile(new File(filePath));
    }

    protected void typeWithoutWipe(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + text + "', element --> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).append(text);
    }

    protected void wipeText(By by, Object... args) {
        int stringSize = shouldBe(Condition.enabled, by, args).getWrappedElement().getAttribute("value").length();
        for (int i = 0; i < stringSize; i++) {
            shouldBe(Condition.enabled, by, args).sendKeys(Keys.BACK_SPACE);
        }
    }

    protected void typeIntoFrame(String text, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " '" + text + "', element --> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).clear();
        shouldBe(Condition.visible, by, args).sendKeys(text);
    }

    protected void selectOption(String option, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + " --> " + option + ", element --> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).selectOption(option);
    }

    protected void mouseHover(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        shouldBe(Condition.visible, by, args).hover();
    }

    protected void clickEnterButton() {
        getActions().sendKeys(Keys.ENTER).perform();

    }

    protected void clickDownButton() {
        getActions().sendKeys(Keys.DOWN).perform();
    }

    protected void clickUpButton() {
        getActions().sendKeys(Keys.UP).perform();
    }

    protected void clickTabButton() {
        getActions().sendKeys(Keys.TAB).perform();

    }

    protected void waitForElementVisibility(By by, Object... args) {
        shouldBe(Condition.visible, by, args);
    }

    protected void waitForElementPresent(By by, Object... args) {
        shouldBe(Condition.exist, by, args);
    }

    protected void waitForElementInvisibility(By by, Object... args) {
        shouldBe(Condition.hidden, by, args);
    }

    protected void waitForElementClickable(By by, Object... args) {
        shouldBe(Condition.visible, by, args);
        shouldBe(Condition.enabled, by, args);
    }

    /**
     * Is condition
     */

    /*Working without wait*/
    protected boolean isCondition(Condition condition, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", condition --> " + condition.getName() + ", element --> " + byLocator(by, args));
        return getSelenideElement(by, args).is(condition);
    }

    /*Working with wait*/
    protected boolean isElementVisible(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return isCondition(Condition.visible, by, args);
    }

    protected boolean isElementClickable(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return isCondition(Condition.enabled, by, args);
    }

    protected boolean isElementExists(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return isCondition(Condition.exist, by, args);
    }

    /**
     * Getters
     */

    protected String getElementText(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return shouldBe(Condition.enabled, by, args).text();
    }

    protected String getElementAttributeValue(String attr, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return shouldBe(Condition.exist, by, args).attr(attr);
    }

    protected String getHiddenElementAttributeValue(String attr, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return shouldBe(Condition.hidden, by, args).attr(attr);
    }

    protected String getDisabledElementAttributeValue(String attr, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", element --> " + byLocator(by, args));
        return shouldBe(Condition.disabled, by, args).attr(attr);
    }

    protected List<SelenideElement> getElements(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        return shouldBe(sizeGreaterThan(0), by, args);
    }

    protected List<SelenideElement> getElementsWithZeroOption(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        return shouldBe(sizeGreaterThanOrEqual(0), by, args);
    }

    protected List<SelenideElement> getElementsWithZeroOptionWithWait(int waitTimeout, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        Selenide.sleep(waitTimeout * 1000);
        return shouldBe(sizeGreaterThanOrEqual(0), by, args);
    }

    protected List<String> getElementsText(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        return shouldBe(sizeGreaterThan(0), by, args).texts();
    }

    protected List<String> getElementsTextWithWait(int waitTimeout, By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        Selenide.sleep(waitTimeout * 1000);
        return shouldBe(sizeGreaterThanOrEqual(0), by, args).texts();
    }

    protected void scrollToElement(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        waitForElementVisibility(by);
        Selenide.executeJavaScript("arguments[0].scrollIntoView();", getWebElement(byLocator(by, args)));
    }

    protected void scrollToPlaceElementInCenter(By by, Object... args) {
        logInfo(getPreviousMethodNameAsText() + ", elements --> " + byLocator(by, args));
        waitForElementVisibility(by);
        Selenide.executeJavaScript("arguments[0].scrollIntoView({block: \"center\"});", getWebElement(byLocator(by, args)));
    }

    protected WebElement getWebElement(By by, Object... args) {
        return WebDriverRunner.getWebDriver().findElement(byLocator(by, args));
    }

    /**
     * Custom
     */

    protected File downloadFile(By by, Object... args) {
        try {
            return getSelenideElement(by, args).download();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}