package base;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static com.sun.xml.internal.ws.client.ContentNegotiation.none;

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

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void waitFor(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void dragAndDrop(WebElement from, By locatorTo) {
//        So, here is the deal:
//        It seems to be a known bug with java selenium webdriver https://bugs.chromium.org/p/chromedriver/issues/detail?id=841.
//        It's getting fixed over and over again since 2014, oh.
//        I tried all the possible combinations of known workarounds but didn't manage to make it work.
//        Anyway, I think it doesn't make any sense to keep trying anymore.
        WebElement to = driver.findElement(locatorTo);
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.dragAndDrop(from, to).build();
        dragAndDrop.perform();
    }

}
