package pages.profiles;

import base.InternalPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.profiles.part.ProfilesSubMenu;

import java.util.List;

import static helpers.Locators.get;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class SelectionsPage extends InternalPage {

    private static final Log LOG = LogFactory.getLog(SelectionsPage.class);
    private ProfilesSubMenu profilesSubMenu;

    private static final By NEW_SELECTION_BUTTON = get("SelectionsPage.NewSelectionButton");
    private static final By NAME_FIELD = get("SelectionsPage.SelectionNameField");
    private static final By DESCRIPTION_FIELD = get("SelectionsPage.DescriptionField");
    private static final By NEXT_BUTTON = get("SelectionsPage.NextButton");
    private static final By ENGAGEMENTS = get("SelectionsPage.Engagements");
    private static final By DRAG_AND_DROP_AREA = get("SelectionPage.DragAndDropArea");
    private static final By CONFIRM_BUTTON = get("SelectionPage.ConfirmButton");
    private static final By SELECTION_INFO_BOX = get("SelectionPage.SelectionInfoBox");

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

    private void clickConfirmButton() {
        actionBot.click(CONFIRM_BUTTON);
    }

    private void waitSelectionNameIsVisible() {
        actionBot.waitFor(SELECTION_INFO_BOX);
    }

    public void createNewSelection(String name, String description, String engagementType) throws InterruptedException {
        clickNewSelectionButton();
        enterSelectionName(name);
        enterSelectionDescription(description);
        Thread.sleep(2000);
        dradAndDropEngagement(engagementType);
//        clickNextButton();
//        clickNextButton();
//        clickConfirmButton();
//        waitSelectionNameIsVisible();
        LOG.info("\nSelection name " + name + " and description " + description + "\n");
    }

    public void dradAndDropEngagement(String engagementType) {
        List<WebElement> engagements = driver.findElements(ENGAGEMENTS);

        System.out.println(engagements.size());
        for (WebElement engagement: engagements) {
            if(engagement.getText().contains(engagementType)){
                System.out.println("QQQQQ " + engagement.getText());
                actionBot.dragAndDrop(engagement, DRAG_AND_DROP_AREA);
                LOG.info("\nFind engagement type " + engagementType + "\n");
                break;
            }
            else {
                LOG.info("Selection: " + engagement.getText());
            }
        }
    }
}
