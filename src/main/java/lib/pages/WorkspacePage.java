package lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspacePage extends BasePage{

    @FindBy(id = "newTaskName")
    private WebElement newTaskName;

    @FindBy(xpath = "//button[text() = 'Add Task']")
    private WebElement addTaskBtn;

    @FindBy(xpath = "//button[@title = 'Mark as undone']")
    private WebElement markAsUndone;

    @FindBy(xpath = "//button[@title = 'Delete task']")
    private WebElement deleteTask;

    public WorkspacePage(WebDriver driver) {
        super(driver);
    }

    private void typeNewTaskName(String taskName) {
        log.debug("typeNewTaskName()");
        commands.waitAndType(driver, newTaskName, taskName);
    }

    private void clickAddTaskBtn() {
        log.debug("clickLoginBtn()");
        commands.clickElement(driver, addTaskBtn);
    }

    public WorkspacePage createNewTask(String taskName){
        log.debug("createNewTask()");
        typeNewTaskName(taskName);
        clickAddTaskBtn();
        return this;
    }

    public WorkspacePage markTaskAsDone() {
        log.debug("markTaskAsDone()");
        commands.clickElement(driver, markAsUndone);
        return this;
    }

    public WorkspacePage deleteTask() {
        log.debug("deleteTask()");
        commands.clickElement(driver, deleteTask);
        return this;
    }

    public boolean isTaskDeleted(String taskName) {
        log.debug("isTaskDeleted()");
        try{
            driver.findElement(By.xpath("//td[contains(text(), '" + taskName + "')]"));
            return false;
        } catch (NoSuchElementException e){
            return true;
        }
    }
}
