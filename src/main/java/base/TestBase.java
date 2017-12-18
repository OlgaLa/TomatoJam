package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class TestBase {

    private static final String URL = "https://admin.relay42.com/";
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
        driver.get(URL);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void cleanUp() {
        driver.get(URL);
        loginPage = new LoginPage(driver);
    }

}
