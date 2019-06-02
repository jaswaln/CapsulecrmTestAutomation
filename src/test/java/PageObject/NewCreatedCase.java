package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCreatedCase {

    WebDriver driver;
    public NewCreatedCase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH,using = "(//div[@class='recent-item ember-view']//a)[1]")
    private WebElement recentCase;

    @FindBy(how= How.XPATH,using = "//span[@class='kase-summary-status-open']")
    private WebElement openStatus;

    @FindBy(how= How.XPATH,using = "//a[@class='ember-view']")
    private WebElement assigendFor;

    @FindBy(how= How.XPATH,using = "//div[@class='entity-details-owner']")
    private WebElement assigendTo;
    public void checkCaseRecent( String CaseName)
    {
        Assert.assertEquals(CaseName,recentCase.getText());
    }
    public void checkFor(String NameFor)
    {
        Assert.assertEquals(NameFor,assigendFor.getText());
    }
    public void checkAssignedTo()
    {
        //Assert.assertEquals("Neeraj Jaswal",assigendTo.getText());
    }
    public void checkOpenStatus()
    {
        Assert.assertEquals("Open",openStatus.getText());
    }
    public void clickCase()
    {
        recentCase.click();
    }
}
