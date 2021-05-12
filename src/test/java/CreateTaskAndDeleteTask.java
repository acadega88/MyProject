import lib.SeleniumTest;
import lib.pages.WorkspacePage;
import lib.webDriver.WebDriverFactory;
import org.testng.annotations.Test;

public class CreateTaskAndDeleteTask extends SeleniumTest {

    @Test
    public void testCreateTaskAndDeleteTask() {

        String sNewTaskName = "nekiNoviTask";

        log.info("testCreateTaskAndDeleteTask()");
        driver = WebDriverFactory.getDriver();

        try {
            log.debug("Login to app");
            WorkspacePage workspacePage = loginToApp(driver);

            log.debug("Create new task");
            workspacePage.createNewTask(sNewTaskName);

            log.debug("Mark as done");
            workspacePage.markTaskAsDone();

            log.debug("Delete task");
            workspacePage.deleteTask();

            log.debug("Verify that task is deleted");
            assert workspacePage.isTaskDeleted(sNewTaskName) : "Task " + sNewTaskName + " is not deleted";


        } finally {
            quitDriver(driver);
        }
    }
}
