package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

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

    public String getText(By locator) { return driver.findElement(locator).getText(); }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void waitFor(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitUntilClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void dragAndDrop(WebElement locatorFrom, By locatorTo) {
        WebElement to = driver.findElement(locatorTo);
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.dragAndDrop(locatorFrom, to).build();
        dragAndDrop.perform();
//        Action dragAndDrop = builder.clickAndHold(locatorFrom)
//                .moveToElement(to)
//                .release(locatorFrom)
//                .build();
//        dragAndDrop.perform();
//        WebElement to = driver.findElement(locatorTo);
//        final Actions action = new Actions(driver);
//       // action.dragAndDrop(locatorFrom, to).build().perform();
//        int srcX = locatorFrom.getLocation().getX();
//        int srcY = locatorFrom.getLocation().getY();
//        int targetX = to.getLocation().getX() + 40;
//        int targetY = to.getLocation().getY() + 10;
//
//        int offsetX = targetX - srcX;
//        int offsetY = targetY - srcY;
//        int xOffset = to.getLocation().getX() + to.getSize().getWidth() / 2;
//        int yOffset = to.getLocation().getY() + to.getSize().getHeight() / 2;
//        action.dragAndDropBy(locatorFrom, offsetX,offsetY).build().perform();
//        action.clickAndHold(locatorFrom)
//                .moveByOffset(offsetX,offsetY)
//                .pause(5000)
//                .release()
//                .build()
//                .perform();
//        Point coordinates1 = locatorFrom.getLocation();
//        Point coordinates2 = to.getLocation();
//
//        Robot robot = null;
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//
//        robot.mouseMove(coordinates1.getX(), coordinates1.getY());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        action.dragAndDrop(locatorFrom, to).perform();
//        action.moveByOffset(offsetX, offsetY).perform();
//        action.release().perform();
//        action.clickAndHold(locatorFrom).release(to).perform();
    }

}
