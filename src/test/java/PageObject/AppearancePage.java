package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class AppearancePage {

    WebDriver driver;
    public AppearancePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.ID,using = "appearance:uploadDecorate:logoImage")
    private WebElement logoBtn;

    @FindBy(how= How.PARTIAL_LINK_TEXT,using = "Save")
    private WebElement saveAppearance;

    public void UploadLogo()
    {
        File file = new File("/CapsulecrmTestAutomation/src/main/resources/Photo/images.jpg");
       logoBtn.sendKeys(file.getAbsolutePath());
        saveAppearance.click();
    }
}
