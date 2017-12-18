package pages.profiles;

import base.InternalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.profiles.part.ProfilesSubMenu;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class SelectionsPage extends InternalPage {

    private ProfilesSubMenu profilesSubMenu;

    private static final By NEW_SELECTION_BUTTON = get("SelectionsPage.NewSelectionButton");
    private static final By NAME_FIELD = get("SelectionsPage.SelectionNameField");
    private static final By DESCRIPTION_FIELD = get("SelectionsPage.DescriptionField");
    private static final By NEXT_BUTTON = get("SelectionsPage.NextButton");

    public SelectionsPage(WebDriver driver) {
        super(driver);
        profilesSubMenu = new ProfilesSubMenu(driver);
    }

    public ProfilesSubMenu getProfilesSubMenu() { return profilesSubMenu; }

    private void clickNewSelectionButton() {
        actionBot.click(NEW_SELECTION_BUTTON);
    }

    private void enterSelectionName(String name) {
        actionBot.sendKeys(NAME_FIELD, name);
    }

    private void enterSelectionDescription(String description) {
        actionBot.sendKeys(DESCRIPTION_FIELD, description);
    }

    private void clickNextButton() {
        actionBot.click(NEXT_BUTTON);
    }

    public void createNewSelection(String name, String description) {
        clickNewSelectionButton();
        enterSelectionName(name);
        enterSelectionDescription(description);
        clickNextButton();
    }
}
