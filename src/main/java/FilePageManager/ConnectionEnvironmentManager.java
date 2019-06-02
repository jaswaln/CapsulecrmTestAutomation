package FilePageManager;


import cucumber.api.java.Before;
import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Neeraj on 27-05-2019.
 */
public class ConnectionEnvironmentManager {
    private WebDriver driver;
    private static EnvironmentType environmentType;
    private static DriverType driverType;
    private static final String CHROME_DRIVER_PROPERTY="webdriver.chrome.driver";

    public ConnectionEnvironmentManager()
    {
        driverType=FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType= FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    @Before
   public WebDriver getDriver(){
        if(driver==null)driver=createConnection();
        return driver;
    }
    private WebDriver createConnection()
    {
        switch (environmentType)
        {
            case QA_CVA: driver=createQAConnection();
               break;
            case PREPROD:driver=createPREConnection();
                break;
        }
        return driver;

    }
    private WebDriver createPREConnection()
    {
        return driver;
    }
    private WebDriver createQAConnection()
    {
        try {
            switch (driverType) {
                case FIREFOX : driver = new FirefoxDriver();
                    break;
                case CHROME :
                    System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
                    driver = new ChromeDriver();
                    break;
                case INTERNETEXPLORER : driver = new InternetExplorerDriver();
                    break;
            }

            if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
            return driver;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
            return  driver;
    }
}
