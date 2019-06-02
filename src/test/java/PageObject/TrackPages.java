package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TrackPages {
    WebDriver driver;
    public TrackPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.LINK_TEXT,using = "Add new Track")
    private WebElement addNewTrackBtn;

    @FindBy(how= How.ID,using = "j_id123:trackDescriptionDecorate:trackDescription")
    private WebElement addName;

    @FindBy(how= How.ID,using = "j_id123:trackTagDecorate:trackTag")
    private WebElement addTag;

    @FindBy(how= How.ID,using = "j_id123:taskLines:0:taskDescriptionDecorate:taskDescription")
    private WebElement addTask;

    @FindBy(how= How.LINK_TEXT,using = "Save")
    private WebElement saveBtnTrack;

    public void clickaddNewTrack(String TrackName,String TagName,String TaskName) {
        addNewTrackBtn.click();
        addName.sendKeys(TrackName);
        addTag.sendKeys(TagName);
        addTask.sendKeys(TaskName);
        saveBtnTrack.click();
    }
}
