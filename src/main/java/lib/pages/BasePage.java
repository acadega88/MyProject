package lib.pages;

import lib.utils.DriverCommands;
import lib.utils.Logger;
import lib.utils.Sleep;
import lib.utils.TimeoutLevel;
import lib.utils.wait.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    protected WebDriver driver;

    Logger log = new Logger();
    Sleep sleep = new Sleep();

    protected WaitUtil waitUtil = new WaitUtil();
    DriverCommands commands = new DriverCommands();


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtil.waitPageReady(driver);
    }

}