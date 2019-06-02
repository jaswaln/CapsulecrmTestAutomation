package StepDefination;

import FilePageManager.ConnectionEnvironmentManager;
import FilePageManager.FileReaderManager;
import PageObject.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestCase1 {
    // ConnectionEnvironmentManager connectionEnvironmentManager;
    private static WebDriver getDriver;
     LoginPage loginPage;
     DashBoardPage dashBoardPage;
     PeoplePage peoplePage;
     AddNewPeoplePage addNewPeoplePage;
     CasesPage casesPage;
     AddNewCasePage addNewCasePage;
     NewCreatedCase newCreatedCase;
    WebDriverWait wait;
    static String AddCasePerson;
    public TestCase1(){
        ConnectionEnvironmentManager connectionEnvironmentManager=new ConnectionEnvironmentManager();
        getDriver=connectionEnvironmentManager.getDriver();
        dashBoardPage=new DashBoardPage(getDriver);
        peoplePage=new PeoplePage(getDriver);
        addNewPeoplePage=new AddNewPeoplePage(getDriver);
        casesPage =new CasesPage(getDriver);
        addNewCasePage=new AddNewCasePage(getDriver);
        newCreatedCase=new NewCreatedCase(getDriver);
        wait=new WebDriverWait(getDriver,800);
        loginPage=new LoginPage(getDriver);
    }
    @Given("^Navigate to URL$")
    public void navigate_to_URL() throws Throwable {
        System.out.println(
                "Url Launched successfully"
        );
        getDriver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

    }

    @When("^Login with correct credentials$")
    public void login_with_correct_credentials() throws Throwable {

        loginPage.enterLoginCredentials();

    }

    @Then("^Click on person icon and add a person \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void click_on_person_icon_and_add_a_person(String title, String firstname, String lastname, String JobTitle, String Tag) throws Throwable {


        dashBoardPage.checkAccountName();
        dashBoardPage.checkUsernameDashBoard();
        dashBoardPage.clickPeopleOrganization();

        peoplePage.checkAddPeopleButtonCheck();
        peoplePage.clickAddPeople();

        addNewPeoplePage.checkNewPersonTagName();
        addNewPeoplePage.addPeopleDetails(title,firstname,lastname,JobTitle,Tag);

        JavascriptExecutor jse = (JavascriptExecutor)getDriver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(2000);
        addNewPeoplePage.scrollToSave();
        Thread.sleep(2000);
    }

    @Then("^Click on cases icon$")
    public void click_on_cases_icon() throws Throwable {
        dashBoardPage.clickCases();

        casesPage.checkAddButton();

    }

    @Then("^Click on add case button$")
    public void click_on_add_case_button() throws Throwable {
        casesPage.clickAddCase(); }

    @Then("^Create a new case with the added person \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void create_a_new_case_with_the_added_person(String AddCasePerson, String CaseName, String CaseDescription) throws Throwable {
        addNewCasePage.checkNewCaseTitle();
        addNewCasePage.addCaseRelatedTo(AddCasePerson);
        Thread.sleep(3000);
        List<WebElement> cases=wait.until(ExpectedConditions.visibilityOfAllElements(getDriver.findElements(By.xpath("(//div[@class='searchresult']//ul/li)[1]"))));
        for(WebElement Case:cases)
        {
            if(Case.getText().contains(AddCasePerson))
            {
                Case.click();
                Thread.sleep(2000);
            }
        }
        addNewCasePage.addNewCase(CaseName,CaseDescription);

    }

    @Then("^Verify the correct case got created for the same person \"([^\"]*)\" \"([^\"]*)\"$")
    public void verify_the_correct_case_got_created_for_the_same_person(String AddCasePerson, String CaseName ) throws Throwable {

        newCreatedCase.clickCase();
        newCreatedCase.checkCaseRecent(CaseName);
        System.out.println("***********************************************************");
        System.out.println("Case Name Verified");
        System.out.println("***********************************************************");
        //newCreatedCase.checkAssignedTo();
        newCreatedCase.checkFor(AddCasePerson);
        System.out.println("***********************************************************");
        System.out.println("Person for Verified");
        System.out.println("***********************************************************");


    }

    @Then("^verify the case status Open$")
    public void verify_the_case_status_Open() throws Throwable {
        newCreatedCase.checkOpenStatus();

    }

    @Then("^close the browser$")
    public void close_the_browser() throws Throwable {
        getDriver.close();

    }






}
