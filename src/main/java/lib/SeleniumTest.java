package lib;

import lib.pages.HomePage;
import lib.pages.WorkspacePage;
import lib.utils.Logger;
import lib.utils.UserProperties;
import org.openqa.selenium.WebDriver;

public class SeleniumTest {

    public Logger log = new Logger();
    public WebDriver driver;
    public String sEmail = UserProperties.getEmail();
    public String sPassword = UserProperties.getPassword();


    public WorkspacePage loginToApp(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        WorkspacePage workspacePage = homePage.clickSignInLink()
                .signIn(sEmail, sPassword);
        return new WorkspacePage(driver);

    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
    }

}
