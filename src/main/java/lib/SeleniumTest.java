package lib;

import lib.utils.Logger;
import lib.utils.UserProperties;
import org.openqa.selenium.WebDriver;

public class SeleniumTest {

    public Logger log = new Logger();
    public WebDriver driver;
    public String sEmail = UserProperties.getEmail();
    public String sPassword = UserProperties.getPassword();


    public void loginToApp(WebDriver driver) {
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
    }

}
