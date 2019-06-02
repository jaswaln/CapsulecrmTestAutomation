package StepDefination;

import FilePageManager.ConnectionEnvironmentManager;
import FilePageManager.FileReaderManager;
import PageObject.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TestCase2 {

   // private ConnectionEnvironmentManager connectionEnvironmentManager;
    private static WebDriver getDriver;
    private DashBoardPage dashBoardPage;
    AccountSettingPage accountSettingPage;
    LoginPage loginPage;
    WebDriverWait wait;
    AppearancePage appearancePage;
    UsersPage userPage;
    OpportunitiesPage opportunitiesPage;
    TrackPages trackPages;
    TaskCategoriesPage taskCategoriesPage;
    TagsPage tagsPage;
    public TestCase2(){

        ConnectionEnvironmentManager connectionEnvironmentManager=new ConnectionEnvironmentManager();
        getDriver=connectionEnvironmentManager.getDriver();
        loginPage=new LoginPage(getDriver);
        dashBoardPage=new DashBoardPage(getDriver);
        accountSettingPage=new AccountSettingPage(getDriver);
        wait=new WebDriverWait(getDriver,80);
        appearancePage=new AppearancePage(getDriver);
        userPage=new UsersPage(getDriver);
        opportunitiesPage=new OpportunitiesPage(getDriver);
        trackPages=new TrackPages(getDriver);
        taskCategoriesPage=new TaskCategoriesPage(getDriver);
        tagsPage=new TagsPage(getDriver);

    }
   @Given("^Navigate to URL1$")
    public void navigate_to_URL() throws Throwable {
        System.out.println(
                "Url Launched successfully"
        );
        getDriver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

    }

    @When("^Login with correct credentials1$")
    public void login_with_correct_credentials() throws Throwable {

        loginPage.enterLoginCredentials();

    }
    @Then("^Click on account settings and verify page headers$")
    public void click_on_account_settings_and_verify_page_headers() throws Throwable {
        dashBoardPage.clickAccountSettings();
        accountSettingPage.testAccountSettingTitle();
    }

    @Then("^Click on all links to the left panel , perform operations and verify page headers$")
    public void click_on_all_links_to_the_left_panel_perform_operations_and_verify_page_headers() throws Throwable {



        List<WebElement> links= wait.until(ExpectedConditions.visibilityOfAllElements(getDriver.findElements(By.xpath("//div[@class='left-fixed']/ul/li/a"))));
        Thread.sleep(2000);
        List<String>  ele=new ArrayList<String>();
        for(WebElement link:links)
        {
            ele.add(link.getText());
        }
        System.out.println(""+ele);
        for(String link:ele)
        {
               getDriver.findElement(By.linkText(link)).click();
            accountSettingPage.checkPageHeader(link);
             Thread.sleep(2000);
        }


    }
    @Then("^Click on Appearance and upload image$")
    public void click_on_Appearance_and_upload_image() throws Throwable {
            accountSettingPage.clickAppearance();
            appearancePage.UploadLogo();
    }

    @Given("^Click on User : Add user and verify the same \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void click_on_User_Add_user_and_verify_the_same(String firstname, String lastname, String email, String username) throws Throwable {
        accountSettingPage.clickUsers();
        userPage.addNewUser(firstname,lastname,email,username);
        List<WebElement> users=wait.until(ExpectedConditions.visibilityOfAllElements(getDriver.findElements(By.xpath("//td[@class='list-column-left']/a"))));
        List<String> userEle=new ArrayList<String>();
        for(WebElement user:users)
        {
            userEle.add(user.getText());
        }
        for(String user:userEle)
        {
            if(user.contains(firstname+" "+lastname)) {
                Assert.assertEquals(user, firstname+" "+lastname);
                System.out.println("***********************************************************");
                System.out.println(" User Verified " + user);
                System.out.println("***********************************************************");
            }
            else
            {
                System.out.println("Other User too "+user);
            }
        }

    }

    @Given("^Click on Opportunities and : Add new Milestone and verify the same \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void click_on_Opportunities_and_Add_new_Milestone_and_verify_the_same(String mileStoneName, String description, String mileStoneProbability, String daysUntilStale) throws Throwable {

        accountSettingPage.clickOpportunities();
        opportunitiesPage.clickAddNewMileStone(mileStoneName,description,mileStoneProbability,daysUntilStale);
        Thread.sleep(3000);
        List<WebElement> mileStones=wait.until(ExpectedConditions.visibilityOfAllElements(getDriver.findElements(By.xpath("//button[@class='hyperlink-button milestone-item-edit']"))));
        List<String> mileEle=new ArrayList<String>();
        for(WebElement mile:mileStones)
        {
            mileEle.add(mile.getText());
        }
        for(String mile:mileEle)
        {
            if(mile.contains(mileStoneName)) {
                Assert.assertEquals(mile, mileStoneName);
                System.out.println("***********************************************************");
                System.out.println(" MileStone Verified " + mile);
                System.out.println("***********************************************************");
            }
            else
            {
                System.out.println("Other MileStone too "+mile);
            }
        }
    }

    @Given("^Click on Tracks : Add new Tracks and verify the same \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void click_on_Tracks_Add_new_Tracks_and_verify_the_same(String trackName, String tagName, String taskName) throws Throwable {

        accountSettingPage.clickTracks();
        trackPages.clickaddNewTrack(trackName,tagName,taskName);
        List<WebElement> tracks=wait.until(ExpectedConditions.visibilityOfAllElements(getDriver.findElements(By.xpath("//td[@class='list-column-left']/a"))));
        List<String> trackEle=new ArrayList<String>();
        for(WebElement track:tracks)
        {
            trackEle.add(track.getText());
        }
        for(String track:trackEle)
        {
            if(track.contains(trackName)) {
                Assert.assertEquals(track, trackName);
                System.out.println("***********************************************************");
                System.out.println(" Tracks Verified " + track);
                System.out.println("***********************************************************");
            }
            else
            {
                System.out.println("Other Tracks too "+track);
            }
        }

    }

    @Given("^Click on Task Categories : Add new Categories and verify the same \"([^\"]*)\"$")
    public void click_on_Task_Categories_Add_new_Categories_and_verify_the_same(String AddTaskName) throws Throwable {
        accountSettingPage.clickTaskCategoriesLink();
        taskCategoriesPage.clickNewCategories(AddTaskName);
        Thread.sleep(2000);
        List<WebElement> categories=wait.until(ExpectedConditions.visibilityOfAllElements(getDriver.findElements(By.xpath("//td[@class=' list-column-left']/a"))));

        List<String> categoryEle=new ArrayList<String>();
        for(WebElement category:categories)
        {
            categoryEle.add(category.getText());
        }
        for(String category:categoryEle)
        {
            if(category.contains(AddTaskName)) {
                Assert.assertEquals(category, AddTaskName);
                System.out.println("***********************************************************");
                System.out.println(" Category Verified " + category);
                System.out.println("***********************************************************");
            }
            else
            {
                System.out.println("Other Tracks too "+category);
            }
        }

    }

    @Given("^Click on Tags : Add new milestones and verify the same \"([^\"]*)\"$")
    public void click_on_Tags_Add_new_milestones_and_verify_the_same(String AddTagName) throws Throwable {
        accountSettingPage.clickTagsLink();
        tagsPage.clickAddNewTag(AddTagName);
        Thread.sleep(2000);
        List<WebElement> tags=wait.until(ExpectedConditions.visibilityOfAllElements(getDriver.findElements(By.xpath("//td[@class='list-column-left']/span/a"))));
        List<String> tagEle=new ArrayList<String>();
        for(WebElement tag:tags)
        {
            tagEle.add(tag.getText());
        }
        for(String tag:tagEle)
        {
            if(tag.contains(AddTagName)) {
                Assert.assertEquals(tag, AddTagName);
                System.out.println("***********************************************************");
                System.out.println(" Tag Verified " + tag);
                System.out.println("***********************************************************");
            }
            else
            {
                System.out.println("Other Tag too "+tag);
            }
        }

    }
    @Then("^Verify total number of configure buttons at Integrations$")
    public void verify_total_number_of_configure_buttons_at_Integrations() throws Throwable {
        accountSettingPage.clickOnIntegration();
        List<WebElement> btnCheck=getDriver.findElements(By.linkText("Configure"));
        accountSettingPage.testConfigureBtn(btnCheck.size());

    }
    @Then("^Close the browser$")
    public void close_the_browser() throws Throwable {
        getDriver.quit();
    }


}
