package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    WebDriver driver;
    public DashBoardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.XPATH,using = "//a[@href='/parties']")
    private WebElement peopleOrganization;


    @FindBy(how= How.XPATH,using = "//a[@href='/cases']")
    private WebElement cases;

    @FindBy(how=How.XPATH,using = "//span[@class='nav-bar-username']")
    private WebElement usernameDashBoard;

    @FindBy(how=How.XPATH,using = "//span[@class='nav-bar-account-name']")
    private WebElement accountName;

    @FindBy(how=How.XPATH,using = "//a[@href='/settings']")
    private WebElement accountSetting;


    public void checkUsernameDashBoard()
    {
        Assert.assertEquals("Neeraj Jaswal",usernameDashBoard.getText());
    }
    public void checkAccountName()
    {
        Assert.assertEquals("NeerajTestAutomation",accountName.getText());
    }
    public void clickPeopleOrganization()
    {
        peopleOrganization.click();
    }
    public void clickCases()
    {
        cases.click();
    }
    public void clickAccountSettings(){
        accountName.click();
        accountSetting.click();
    }

}
