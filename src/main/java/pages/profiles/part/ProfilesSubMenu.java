package pages.profiles.part;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.profiles.EngagementsPage;
import pages.profiles.SelectionsPage;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class ProfilesSubMenu extends PageBase {

    private static final By SELECTIONS_TAB = get("ProfilesSubMenu.Selections");
    private static final By ENGAGEMENTS_TAB = get("ProfilesSubMenu.Engagements");

    public ProfilesSubMenu(WebDriver driver) {
        super(driver);
    }

    public SelectionsPage clickSelections() {
        actionBot.click(SELECTIONS_TAB);
        return new SelectionsPage(driver);
    }

    public EngagementsPage clickEngagements() {
        actionBot.click(ENGAGEMENTS_TAB);
        return new EngagementsPage(driver);
    }
}
