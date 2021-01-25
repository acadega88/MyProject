package lib.utils.wait;

import lib.utils.Logger;
import lib.utils.TimeoutLevel;
import lib.utils.wait.conditions.DocumentReadyStateCondition;
import lib.utils.wait.conditions.JQueryAnimationDoneCondition;
import lib.utils.wait.conditions.JQueryInactiveCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    Logger log = new Logger();

    public WaitUtil() {
    }

    public void waitPageReady(final WebDriver driver) {
        log.debug("waitPageReady()");
        ExpectedCondition<Boolean> jsLoad = new DocumentReadyStateCondition();
        ExpectedCondition<Boolean> jQueryLoad = new JQueryInactiveCondition();
        ExpectedCondition<Boolean> jQueryAnimation = new JQueryAnimationDoneCondition();
        new WebDriverWait(driver, TimeoutLevel.LONG.value()).until(ExpectedConditions.and(jsLoad, jQueryLoad, jQueryAnimation));
    }

    /**
     * Wait for element to be visible
     *
     * @param element element
     */
    public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        log.debug("waitForElementToBeVisible()");
        WebDriverWait wait = new WebDriverWait(driver, TimeoutLevel.NORMAL.value());
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
