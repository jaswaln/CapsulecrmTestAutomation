package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CasesPage {

    WebDriver driver;

    public CasesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.XPATH,using = "//a[@href='/case/add']")
    private WebElement addCases;

    public void checkAddButton(){
        Assert.assertEquals("Add Case",addCases.getText());
    }
    public void clickAddCase(){ addCases.click();
    }
}
