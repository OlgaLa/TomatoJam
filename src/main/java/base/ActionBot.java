package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class ActionBot {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ActionBot(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void waitFor(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void dragAndDrop(WebElement locatorFrom, By locatorTo) {
//        WebElement to = driver.findElement(locatorTo);
//        Actions builder = new Actions(driver);
//        Action dragAndDrop = builder.clickAndHold(locatorFrom)
//                .moveToElement(to)
//                .release(to)
//                .build();
//        dragAndDrop.perform();
        WebElement to = driver.findElement(locatorTo);
        final Actions action = new Actions(driver);
        //action.dragAndDrop(locatorFrom, to).build().perform();
//        int xOffset = to.getLocation().getX() + to.getSize().getWidth() / 2;
//        int yOffset = to.getLocation().getY() + to.getSize().getHeight() / 2;
        action.clickAndHold(locatorFrom)
                .moveToElement(to)
                .release(locatorFrom)
                .build()
                .perform();
    }

}
