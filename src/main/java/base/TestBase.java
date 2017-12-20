package base;

import constants.ApiUrls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class TestBase {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {

        String browser = System.getProperty("browser") != null ? System.getProperty("browser").toLowerCase() : "chrome";

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ApiUrls.APP_URL);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
