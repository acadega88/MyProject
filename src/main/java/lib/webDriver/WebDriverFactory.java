package lib.webDriver;

import lib.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    public static WebDriver getDriver() {

        WebDriver driver = null;
        String browser = ConfigProperties.getBrowser();
        String device = ConfigProperties.getDevice();
        String downloadFilepath = "C:\\src\\main\\java\\resources\\download";

        String chromeBrowser = "chrome";
        String firefoxBrowser = "firefox";
        String edgeBrowser = "edge";

        if (browser.equalsIgnoreCase(chromeBrowser)) {
            //WebDriverManager.chromedriver().driverVersion("86").setup();
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("download.default_directory", downloadFilepath);
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-gpu");
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            options.setCapability(ChromeOptions.CAPABILITY, options);
            if (device.equals("pcBrowser") && ConfigProperties.getHeadless()) {
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--headless");
            } else if (device.equals("pcBrowser") && !ConfigProperties.getHeadless()) {
                options.addArguments("--start-maximized");
            } else if (device.equals("mobile") && ConfigProperties.getHeadless()) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Galaxy S5");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
                options.addArguments("--headless");
            } else if (device.equals("mobile") && !ConfigProperties.getHeadless()) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Galaxy S5");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
            } else if (device.equals("tablet") && ConfigProperties.getHeadless()) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Nexus 10");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
                options.addArguments("--headless");
            } else if (device.equals("tablet") && !ConfigProperties.getHeadless()) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Nexus 10");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
            } else if (device.equals("iPhone") && ConfigProperties.getHeadless()) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "iPhone X");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
                options.addArguments("--headless");
            } else if (device.equals("iPhone") && !ConfigProperties.getHeadless()) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "iPhone X");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
            } else if (device.equals("iPad") && ConfigProperties.getHeadless()) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "iPad");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
                options.addArguments("--headless");
            } else if (device.equals("iPad") && !ConfigProperties.getHeadless()) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "iPad");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
            }
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase(firefoxBrowser)) {
            //WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase(edgeBrowser)) {
            //WebDriverManager.edgedriver().setup();
            System.setProperty("webdriver.edge.driver", "./src/main/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Error");
        }
        assert driver != null;
        driver.manage().deleteAllCookies();
        switch (ConfigProperties.getEnv()) {
            case "dev":
                driver.get(ConfigProperties.getURLDev());
                break;
            case "qa":
                driver.get(ConfigProperties.getURLQa());
                break;
            case "prod":
                driver.get(ConfigProperties.getURLProd());
                break;
        }
        return driver;
    }
}