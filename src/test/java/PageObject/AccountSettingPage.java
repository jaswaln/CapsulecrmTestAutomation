package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingPage {

    WebDriver driver;
    public AccountSettingPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH,using = "//span[@class='settings-content-menu-title']")
    private WebElement accountSettingTitle;

    @FindBy(how= How.XPATH,using = "//h1[@class='settings-page-header']")
    private WebElement linkHeader;

    @FindBy(how= How.XPATH,using = "//a[@href='/settings/account']")
    private WebElement accountLink;

    @FindBy(how= How.XPATH,using = "//a[@href='/settings/account/invoices']")
    private WebElement invoicesLink;

    @FindBy(how= How.XPATH,using = "//a[@href='/settings/account/export']")
    private WebElement ExportLink;

    @FindBy(how= How.XPATH,using = "//a[@href='/settings/account/appearance']")
    private WebElement appearanceLink;

    @FindBy(how= How.XPATH,using = "//h1[@class='settings-page-header']")
    private WebElement accountHeader;

    @FindBy(how= How.XPATH,using = "//header[@class='page-box-header']")
    private WebElement invoiceHeader;

    @FindBy(how= How.XPATH,using = "//h1[@class='settings-page-header']")
    private WebElement exportHeader;

    @FindBy(how= How.XPATH,using = "//h1[@class='settings-page-header']")
    private WebElement appearanceHeader;

    @FindBy(how= How.XPATH,using = "//h2[@class='settings-page-header']")
    private WebElement mailDropBoxHeader;

    @FindBy(how= How.XPATH,using = "//h2[@class='settings-page-header']")
    private WebElement usersHeader;

    @FindBy(how= How.XPATH,using = "//header[@class='page-box-header']")
    private WebElement opportunitiesHeader;

    @FindBy(how= How.XPATH,using = "//h2[@class='settings-page-header']")
    private WebElement tracksHeader;

    @FindBy(how= How.XPATH,using = "//h2[@class='settings-page-header']")
    private WebElement taskCategoriesHeader;

    @FindBy(how= How.XPATH,using = "//h2[@class='settings-page-header']")
    private WebElement customesHeader;

    @FindBy(how= How.XPATH,using = "//h2[@class='settings-page-header']")
    private WebElement tagsHeader;

    @FindBy(how= How.XPATH,using = "//h2[@class='settings-page-header']")
    private WebElement integrationsHeader;

    @FindBy(how= How.XPATH,using = "//h2[@class='settings-page-header']")
    private WebElement TrashHeader;

    @FindBy(how= How.PARTIAL_LINK_TEXT,using = "Integrations")
    private WebElement integrationLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT,using = "Configure")
    private WebElement configurebtn;

    @FindBy(how= How.PARTIAL_LINK_TEXT,using = "Appearance")
    private WebElement AppearanceLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT,using = "Users")
    private WebElement UserLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT,using = "Opportunities")
    private WebElement OpportunitiesLink;

    @FindBy(how= How.XPATH,using = "//a[@href='/settings/tracks/opportunities']")
    private WebElement TracksLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT,using = "Task Categories")
    private WebElement TaskCategoriesLink;

    @FindBy(how= How.PARTIAL_LINK_TEXT,using = "Tags")
    private WebElement TagsLink;

    public void testAccountSettingTitle(){
        Assert.assertEquals("Account Settings",accountSettingTitle.getText());
    }
    public void clickAccount(){
        accountLink.click();
    }
    public void testLinkHeader(String header)
    {

        Assert.assertEquals(header,linkHeader.getText());
    }
    public void checkPageHeader(String link)
    {
        if(link.equalsIgnoreCase("Account"))
        {
            Assert.assertEquals(link,accountHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Invoices"))
        {
            Assert.assertEquals(link,invoiceHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Export"))
        {
            Assert.assertEquals(link,exportHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Appearance"))
        {
            Assert.assertEquals(link,appearanceHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Mail Drop Box"))
        {
            Assert.assertEquals(link,mailDropBoxHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Users"))
        {
            Assert.assertEquals(link,usersHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Opportunities"))
        {
            Assert.assertEquals(link,opportunitiesHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Tracks"))
        {
            Assert.assertEquals(link,tracksHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Task Categories"))
        {
            Assert.assertEquals(link,taskCategoriesHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Custom Fields"))
        {
            Assert.assertEquals(link,customesHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Tags"))
        {
            Assert.assertEquals("Tags and DataTags",tagsHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Integrations"))
        {
            Assert.assertEquals(link,integrationsHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
        else if(link.equalsIgnoreCase("Trash"))
        {
            Assert.assertEquals(link,TrashHeader.getText());
            System.out.println("Page Header Verifired "+link);
        }
    }
    public void clickOnIntegration(){
        integrationLink.click();
    }
    public void testConfigureBtn(int btncheck)
    {

        Assert.assertEquals(10,btncheck);
        System.out.println("Configure Button 10 verified");
    }
    public void clickAppearance()
    {
        appearanceLink.click();
    }
    public void clickUsers()
    {
        UserLink.click();
    }
    public void clickOpportunities()
    {
        OpportunitiesLink.click();
    }
    public void clickTracks()
    {
        TracksLink.click();
    }
    public void clickTaskCategoriesLink()
    {
        TaskCategoriesLink.click();
    }
    public void clickTagsLink()
    {
        TagsLink.click();
    }

}
