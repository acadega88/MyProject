package lib;

import lib.pages.HomePage;
import lib.pages.LoginPage;
import lib.utils.Logger;
import lib.utils.UserProperties;
import org.openqa.selenium.WebDriver;

public class SeleniumTest {

    public Logger log = new Logger();
    public WebDriver driver;
    public String sEmail = UserProperties.getEmail();
    public String sPassword = UserProperties.getPassword();


    public void loginToApp(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(sEmail, sPassword);

    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
    }

}
