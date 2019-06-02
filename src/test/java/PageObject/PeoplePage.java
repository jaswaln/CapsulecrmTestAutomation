package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PeoplePage {
    WebDriver driver;
    public PeoplePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.XPATH,using = "//a[@href='/party/person/new']")
    private WebElement addPeople;

    public void checkAddPeopleButtonCheck(){
        Assert.assertEquals("Add Person",addPeople.getText());}
    public void clickAddPeople(){ addPeople.click();}

}
