package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.test_managment.DashboardPage;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class LoginPage extends PageBase {

    private static final By EMAIL_ADDRESS_FIELD = get("LoginPage.EmailAddressField");
    private static final By PASSWORD_FIELD = get("LoginPage.PasswordField");
    private static final By SIGNIN_BUTTON = get("LoginPage.SignInButton");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void enterEmailAddress(String emailAddress) {
        actionBot.waitFor(EMAIL_ADDRESS_FIELD);
        actionBot.sendKeys(EMAIL_ADDRESS_FIELD, emailAddress);
    }

    private void enterPassword(String password) {
        actionBot.waitFor(PASSWORD_FIELD);
        actionBot.sendKeys(PASSWORD_FIELD, password);
    }

    private void clickSignInButton() {
        actionBot.click(SIGNIN_BUTTON);
    }

    public DashboardPage login(String emailAddress, String password) throws InterruptedException {
        enterEmailAddress(emailAddress);
        enterPassword(password);
        clickSignInButton();
        return new DashboardPage(driver);
    }

}
