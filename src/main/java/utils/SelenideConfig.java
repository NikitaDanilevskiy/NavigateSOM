package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.codeborne.selenide.FileDownloadMode.PROXY;

public class SelenideConfig {
    private static final String VIDEO_NAME_PATTERN = "HH:mm:ss:SSS";

    /*For Selenoid*/
    private static DesiredCapabilities getBrowserCapabilities() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        //chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\src\\main\\resources\\downloads");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.setAcceptInsecureCerts(true);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (Constants.REMOTE_URL != null) {
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            capabilities.setBrowserName(System.getProperty("browserName", "chrome"));
            capabilities.setVersion(System.getProperty("browserVersion", "94.0"));
            capabilities.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVnc", "true")));
            capabilities.setCapability("enableVideo", Boolean.parseBoolean(System.getProperty("enableVideo", "true")));
            //capabilities.setCapability("videoName", String.format("video_%s.mp4", DateTime.getLocalDateTimeByPattern(VIDEO_NAME_PATTERN)));
            capabilities.setCapability("sessionTimeout", "5m");
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "94.0");


        }
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return capabilities;
    }

    public static void createBrowserConfig(String browser) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.ALL);

        Configuration.browser = browser;

        if (Constants.REMOTE_URL != null) {
            Configuration.driverManagerEnabled = true;
            Configuration.remote = Constants.REMOTE_URL;
        }

        Configuration.browserCapabilities = getBrowserCapabilities();

        Configuration.holdBrowserOpen = true;
        //Configuration.startMaximized = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities = getBrowserCapabilities();
        Configuration.fastSetValue = false;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.pollingInterval = 10000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 100000;
        Configuration.reportsFolder = "screenshots/";
        //Configuration.proxyEnabled = true;\
        Configuration.proxyEnabled = false;
        //Configuration.fileDownload = PROXY;

    }
}