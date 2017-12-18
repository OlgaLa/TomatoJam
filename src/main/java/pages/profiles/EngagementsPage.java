package pages.profiles;

import base.InternalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.profiles.part.ProfilesSubMenu;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class EngagementsPage extends InternalPage{

    private ProfilesSubMenu profilesSubMenu;

    private static final By NEW_ENGAGEMENT_BUTTON = get("EngagementsPage.NewEngagementButton");
    private static final By TYPE_FIELD = get("EngagementsPage.TypeField");
    private static final By DESCRIPTION_FIELD = get("EngagementsPage.DescriptionField");
    private static final By SUBMIT_BUTTON = get("EngagementsPage.SubmitButton");

    public EngagementsPage(WebDriver driver) {
        super(driver);
        profilesSubMenu = new ProfilesSubMenu(driver);
    }

    public ProfilesSubMenu getProfilesSubMenu() { return profilesSubMenu; }

    private void clickNewEngagementButton() {
        actionBot.click(NEW_ENGAGEMENT_BUTTON);
    }

    private void enterEngagementType(String type) {
        actionBot.sendKeys(TYPE_FIELD, type);
    }

    private void enterEngagementDescription(String description) {
        actionBot.sendKeys(DESCRIPTION_FIELD, description);
    }

    private void clickSubmitButton() {
        actionBot.click(SUBMIT_BUTTON);
    }

    public void createNewEngagement(String type, String description) {
        clickNewEngagementButton();
        enterEngagementType(type);
        enterEngagementDescription(description);
        clickSubmitButton();
    }
}