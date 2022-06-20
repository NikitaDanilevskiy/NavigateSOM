package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideTargetLocator;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.io.FileUtils.forceDelete;
public class SelenideTools {
    protected static final Logger LOG = LoggerFactory.getLogger(SelenideTools.class);

    public static WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static SelenideTargetLocator switchTo() {
        return Selenide.switchTo();
    }

    public static ArrayList<String> getTabsList() {
        return new ArrayList<>(getDriver().getWindowHandles());
    }

    public static int getTabsCount() {
        return getDriver().getWindowHandles().size();
    }

    public static void sleep(int sec) {
        Selenide.sleep(sec * 1000);
    }

    public static void setTabSize(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

    @Step("Closing current tab...")
    public static void closeCurrentTab() {
        LOG.info("Closing current tab...");
        Selenide.closeWindow();
    }

    @Step("Opening url - '{url}'")
    public static void openUrl(String url) {
        LOG.info("Opening url '{}'", url);
        Selenide.open(url);
    }

    @Step("Refreshing...")
    public static void refresh() {
        LOG.info("Refreshing...");
        Selenide.refresh();
    }

    @Step("Clearing cookies...")
    public static void clearCookies() {
        LOG.info("Clearing cookies...");
        Selenide.clearBrowserCookies();
    }

    /**
     * Custom methods
     */

    @Step("Switching to frame...")
    public static void switchToFrame(By by) {
        LOG.info("Switching to frame...");
        SelenideTools.switchTo().frame($(by));
    }

    @Step("Switching to default content...")
    public static void switchToDefaultContent() {
        LOG.info("Switching to default content...");
        SelenideTools.switchTo().defaultContent();
    }

    @Step("Switching to last tab...")
    public static void switchToLastTab() {
        LOG.info("Switching to last tab...");
        ArrayList<String> tabs = getTabsList();
        SelenideTools.switchTo().window(tabs.get(tabs.size() - 1));
    }

    @Step("Switching to first tab...")
    public static void switchToFirstTab() {
        LOG.info("Switching to first tab...");
        ArrayList<String> tabs = getTabsList();
        SelenideTools.switchTo().window(tabs.get(0));
    }

    @Step("Switching to previous tab...")
    public static void switchToPreviousTab() {
        LOG.info("Switching to previous tab...");
        ArrayList<String> tabs = getTabsList();
        SelenideTools.switchTo().window(tabs.get(tabs.size() - 2));
    }

    @Step("Open url in new window")
    public static void openUrlInNewWindow(String url) {
        LOG.info("Open url in new window");
        Selenide.executeJavaScript("window.open('" + url + "')");
    }

    public static void closeAllTabsExceptCurrent() {
        String currentWindow = getDriver().getWindowHandle();
        ArrayList<String> tabs = getTabsList();
        for (String tab : tabs) {
            if (!tab.equals(currentWindow)) {
                Selenide.switchTo().window(tab);
                Selenide.closeWindow();
            }
        }
        Selenide.switchTo().window(currentWindow);
    }

    @Step("Get current url")
    public static String getCurrentUrl() {
        LOG.info("Get current url");
        return WebDriverRunner.url();
    }

    @Step("Clean Directory")
    public static void cleanDirectory(File directory) throws IOException {
        String message;
        if (!directory.exists()) {
            message = directory + " does not exist";
            throw new IllegalArgumentException(message);
        } else if (!directory.isDirectory()) {
            message = directory + " is not a directory";
            throw new IllegalArgumentException(message);
        } else {
            File[] files = directory.listFiles();
            if (files == null) {
                throw new IOException("Failed to list contents of " + directory);
            } else {
                IOException exception = null;
                File[] arr$ = files;
                int len$ = files.length;

                for (int i$ = 0; i$ < len$; ++i$) {
                    File file = arr$[i$];

                    try {
                        forceDelete(file);
                    } catch (IOException var8) {
                        exception = var8;
                    }
                }

                if (null != exception) {
                    throw exception;
                }
            }
        }
    }


    @Step("Getting page URL...")
    public static String getPageURL() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    /**
     * Work with Tabs and Frames
     */


    @Step("Switching to the parent frame...")
    public static void switchToParentFrame() {
        Selenide.switchTo().parentFrame();
    }

//    @Step("Switching to the child frame...")
//    public static void switchToChildFrame() {
//        Selenide.switchTo().innerFrame();
//    }

    @Step("Getting number of tabs...")
    public static int getNumberOfTabs() {
        return WebDriverRunner.getWebDriver().getWindowHandles().size();
    }

    @Step("Switching to the tab and closing it...")
    public static void switchToTabAndCloseIt(int tab) {

        if (WebDriverRunner.getWebDriver().getWindowHandles().size() > tab) {
            WebDriverRunner.getWebDriver().switchTo().window(new ArrayList<String>(WebDriverRunner.getWebDriver().getWindowHandles()).get(tab));
            WebDriverRunner.getWebDriver().close();
        }
    }

    /**
     * Work with Alerts
     */

    @Step("Waiting for JS Alert...")
    public static void waitForJSAlert() {
        new WebDriverWait(WebDriverRunner.getWebDriver(), 120).until(ExpectedConditions.alertIsPresent());
    }

    @Step("Getting JS Alert message...")
    public static String getJSAlertMessage() {
        return WebDriverRunner.getWebDriver().switchTo().alert().getText();
    }

    @Step("Dismissing JS alert...")
    public static void dismissJSAlert() {
        WebDriverRunner.getWebDriver().switchTo().alert().dismiss();
    }

    @Step("Accepting JS alert...")
    public static void acceptJSAlert() {
        WebDriverRunner.getWebDriver().switchTo().alert().accept();
    }

    @Step("Sending data to JS alert...")
    public static void sendDataToJSAlert(String data) {
        WebDriverRunner.getWebDriver().switchTo().alert().sendKeys(data);
    }

    @Step("Checking if the file is downloaded...")
    public static boolean isFileDownloaded(String fileName) {
        Boolean found = false;
        File dir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                found = true;
                //dirContents[i].delete();
            }
        }
        return found;
    }

    @Step("Getting file full name...")
    public static String getFullFileName(String fileName) {
        File dir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                return dirContents[i].getName();
                //dirContents[i].delete();
            }
        }
        return null;
    }

    @Step("Deleting file...")
    public static void deleteFile(String fileName) {
        File dir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                dirContents[i].delete();
            }
        }
    }
}
