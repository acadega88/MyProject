package lib.utils;

import lib.utils.wait.WaitUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class DriverCommands {


    WaitUtil waitUtil = new WaitUtil();
    String browser = ConfigProperties.getBrowser();
    Logger log = new Logger();
    Sleep sleep = new Sleep();


    public DriverCommands() {
    }

    /**
     * Mouse over element
     *
     * @param driver  driver
     * @param element element
     */
    public void mouseOver(WebDriver driver, WebElement element) {
        if (!browser.equalsIgnoreCase("chrome")) {
            mouseOverJs(driver, element);
        } else {
            new Actions(driver).moveToElement(element).perform();
        }
        sleep.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }

    /**
     * Pass element on which mouse hover to be performed
     *
     * @param driver  driver
     * @param element element
     */
    public void mouseOverJs(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj);", element);
    }

    /**
     * Is element present
     *
     * @param element element
     * @return boolean
     */
    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    /**
     * Scroll to up or down in pixels (Negative number is up, positive number is
     * down)
     *
     * @param yPixels yPixels
     */
    public void scrollHorizontally(WebDriver driver, int yPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + yPixels + ")");
    }

    /**
     * Scroll to left or right in pixels (Negative number is left, positive number
     * is right)
     *
     * @param xPixels xPixels
     */
    public void scrollVertically(WebDriver driver, int xPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + xPixels + ", 0)");
    }

    /**
     * Scroll horizontally and vertically
     *
     * @param xPixels xPixels
     * @param yPixels yPixels
     */
    public void scrollHorizontallyAndVertically(WebDriver driver, int xPixels, int yPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + xPixels + "," + yPixels + ")");
    }

    /**
     * Scroll to element
     *
     * @param element element
     */
    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        scrollHorizontally(driver, -100);
    }

    /**
     * Click on element with JavaScript and wait for given milliseconds
     *
     * @param element element
     */
    public void clickElementJS(WebDriver driver, WebElement element) {
        log.debug("Click on element with js");
        waitUtil.waitForElementToBeVisible(driver, element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        scrollToElement(driver, element);
        js.executeScript("arguments[0].click();", element);
        sleep.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }


    /**
     * Click on element and wait for given milliseconds
     *
     * @param element element
     */
    public void clickElement(WebDriver driver, WebElement element) {
        log.debug("Click on element");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        element.click();
        sleep.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }

    /**
     * Type text into element
     *
     * @param element element
     * @param text    text
     */
    public void waitAndType(WebDriver driver, WebElement element, String text) {
        log.debug("waitAndType()");
        waitUtil.waitForElementToBeVisible(driver, element);
        type(element, text);
        sleep.sleepForMilliseconds(TimeoutLevel.MS_SHORTEST.value());
    }

    private void type(WebElement element, String text) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        element.sendKeys(text);
    }

    /**
     * Get text from element
     *
     * @param element element
     * @return text
     */
    public String getText(WebDriver driver, WebElement element) {
        log.debug("getText()");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        sleep.sleepForSeconds(TimeoutLevel.SHORTER.value());
        return element.getText();
    }
}
