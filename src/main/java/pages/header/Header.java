package pages.header;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.profiles.SelectionsPage;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class Header extends PageBase {

    private static final By PROFILES_TAB = get("Header.ProfilesTab");

    public Header(WebDriver driver) {
        super(driver);
    }

    public SelectionsPage clickProfiles() {
        actionBot.waitFor(PROFILES_TAB);
        actionBot.click(PROFILES_TAB);
        return new SelectionsPage(driver);
    }
}
