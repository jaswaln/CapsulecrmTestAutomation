package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how=How.ID,using = "loginBranding")
    private WebElement loginBranding;

    @FindBy(how= How.ID,using="login:usernameDecorate:username")
    private WebElement username;

    @FindBy(how=How.ID,using = "login:passwordDecorate:password")
    private WebElement password;

    @FindBy(how=How.ID,using = "login:login")
    private WebElement button;

    public void enterLoginCredentials()
    {
        username.sendKeys("NeerajJ");
        password.sendKeys("jassi@110");
        button.click();
    }
}
