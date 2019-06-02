package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TaskCategoriesPage {

    WebDriver driver;
    public TaskCategoriesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.LINK_TEXT,using = "Add new Category")
    private WebElement addNewCategoryBtn;

    @FindBy(how= How.ID,using = "editCategoryForm:taskCategoryNameDecorate:taskCategoryName")
    private WebElement addNameTask;

    @FindBy(how= How.ID,using = "editCategoryForm:j_id175")
    private WebElement saveBtn;

    public void clickNewCategories(String AddTaskName) throws InterruptedException
    {
        addNewCategoryBtn.click();
        Thread.sleep(2000);
        addNameTask.sendKeys(AddTaskName);
        saveBtn.click();
    }
}
