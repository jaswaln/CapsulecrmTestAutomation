package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCasePage {
    WebDriver driver;
    public AddNewCasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH,using = "//*[contains(text(),'New Case')]")
    private WebElement newCaseTitle;

    @FindBy(how= How.ID,using = "partySearch")
    private WebElement caseRelates;

    @FindBy(how= How.ID,using = "caseNameDecorate:name")
    private WebElement caseName;

    @FindBy(how= How.ID,using = "caseDescriptionDecorate:description")
    private WebElement caseDescription;

    @FindBy(how= How.ID,using = "save")
    private WebElement save;

    public void checkNewCaseTitle()
    {

        Assert.assertEquals("New Case",newCaseTitle.getText());
    }
    public void addCaseRelatedTo(String addPerson)
    {
        caseRelates.sendKeys(addPerson);
    }
    public void addNewCase(String CaseName,String CaseDescription)
    {

       // caseRelates.sendKeys("Neeraj Jaswal");

        caseName.sendKeys(CaseName);
        caseDescription.sendKeys(CaseDescription);
        save.click();
    }
}
