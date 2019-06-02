package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

    WebDriver driver;
    public OpportunitiesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.XPATH,using = "//button[@class='btn-primary']")
    private WebElement addNewMileStone;

    @FindBy(how= How.XPATH,using = "//input[@class='form-input-text milestone-modal-name']")
    private WebElement mileStoneName;

    @FindBy(how= How.XPATH,using = "//textarea[@class='form-input-text milestone-modal-description']")
    private WebElement description;

    @FindBy(how= How.XPATH,using = "//input[@class='form-input-text milestone-modal-probability']")
    private WebElement mileStoneProbability;

    @FindBy(how= How.XPATH,using = "//input[@class='form-input-text milestone-modal-days-until-stale']")
    private WebElement daysUntilStale;

    @FindBy(how= How.XPATH,using = "//button[@class='async-button ember-view btn-primary']")
    private WebElement btnSave;

    public void clickAddNewMileStone(String MileStoneName,String Description,String MileStoneProbability,String DaysUntilStale)
    {
        addNewMileStone.click();

        mileStoneName.sendKeys(MileStoneName);
        description.sendKeys(Description);
        mileStoneProbability.sendKeys(MileStoneProbability);
        daysUntilStale.sendKeys(DaysUntilStale);
        btnSave.click();
    }

}
