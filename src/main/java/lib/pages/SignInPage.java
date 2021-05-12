package lib.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement loginBtn;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private void typeEmail(String email) {
        log.debug("typeEmail()");
        commands.waitAndType(driver,emailInput, email);
    }

    private void typePassword(String password) {
        log.debug("typePassword()");
        commands.waitAndType(driver,passwordInput, password);
    }

    private void clickLoginBtn() {
        log.debug("clickLoginBtn()");
        commands.clickElement(driver, loginBtn);
    }

    public WorkspacePage signIn(String email, String password) {
        log.debug("signIn(");
        typeEmail(email);
        typePassword(password);
        clickLoginBtn();
        return new WorkspacePage(driver);
    }
}
