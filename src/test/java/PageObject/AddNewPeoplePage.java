package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewPeoplePage {
    WebDriver driver;
    public AddNewPeoplePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.NAME,using = "party:j_id108:j_id116")
    private WebElement title;

    @FindBy(how= How.ID,using = "party:fnDecorate:fn")
    private WebElement firstName;

    @FindBy(how= How.XPATH,using = "//input[@id='party:lnDecorate:ln']")
    private WebElement lastName;

    @FindBy(how= How.ID,using = "party:roleDecorate:jobTitle")
    private WebElement jobTitle;

    @FindBy(how= How.ID,using = "party:tagsDecorate:tagComboBox")
    private WebElement tag;

    @FindBy(how= How.ID,using = "party:save")
    private WebElement save;

    @FindBy(how= How.ID,using = "party:tagsDecorate:j_id187")
    private WebElement addTag;

    @FindBy(how= How.XPATH,using = "//*[contains(text(),'New Person')]")
    private WebElement checkNewPersonTag;

    public void checkNewPersonTagName(){
        Assert.assertEquals("New Person", checkNewPersonTag.getText());}

    public void addPeopleDetails(String Title,String FirstName,String LastName,String JobTitle,String Tag)
    {
        Select se=new Select(title);
        se.selectByValue(Title);

        firstName.sendKeys(FirstName);
        lastName.sendKeys(LastName);
        jobTitle.sendKeys(JobTitle);
        tag.sendKeys(Tag);
        addTag.click();



    }

  public void scrollToSave()
  {
      save.click();
  }
}
