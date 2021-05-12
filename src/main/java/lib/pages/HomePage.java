package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[text() = 'Sing In']")
    private WebElement signIn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignInPage clickSignInLink() {
        log.debug("clickSignInLink()");
        commands.clickElement(driver, signIn);
        return new SignInPage(driver);
    }
}
