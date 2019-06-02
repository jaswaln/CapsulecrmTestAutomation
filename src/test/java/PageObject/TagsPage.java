package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TagsPage {
    WebDriver driver;
    public TagsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.LINK_TEXT,using = "Add new Tag")
    private WebElement addNewTagBtn;

    @FindBy(how= How.ID,using = "j_id177:tagNameDecorate:tagName")
    private WebElement addName;

    @FindBy(how= How.ID,using = "j_id177:j_id210")
    private WebElement savBtn;

    public void clickAddNewTag(String AddTagName) throws InterruptedException{
        addNewTagBtn.click();
        Thread.sleep(3000);

        addName.sendKeys(AddTagName);
        savBtn.click();
    }
}
