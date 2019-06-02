package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

    WebDriver driver;
    public UsersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.LINK_TEXT,using = "Add new User")
    private WebElement addNewUserBtn;

    @FindBy(how= How.ID,using = "register:firstnameDecorate:firstName")
    private WebElement FirstName;

    @FindBy(how= How.ID,using = "register:lastNameDecorate:lastName")
    private WebElement LastName;

    @FindBy(how= How.ID,using = "register:emailDecorate:email")
    private WebElement email;

    @FindBy(how= How.ID,using = "register:usernameDecorate:username")
    private WebElement username;

    @FindBy(how= How.ID,using = "register:save")
    private WebElement inviteUser;

    @FindBy(how= How.ID,using = "(//td[@class='list-column-left']/a)[2]")
    private WebElement verifyUser;

    public void addNewUser(String firstname,String lastname,String Email,String Username)
    {
      addNewUserBtn.click();
      FirstName.sendKeys(firstname);
      LastName.sendKeys(lastname);
      email.sendKeys(Email);
      username.sendKeys(Username);
      inviteUser.click();
    }

}
