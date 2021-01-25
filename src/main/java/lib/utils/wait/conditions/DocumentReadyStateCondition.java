package lib.utils.wait.conditions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class DocumentReadyStateCondition implements ExpectedCondition<Boolean> {

    @Override
    public Boolean apply(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Object result = javascriptExecutor.executeScript("return document.readyState");
        return result.toString().equals("complete");
    }
}
