package base;

import org.openqa.selenium.WebDriver;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public abstract class PageBase {

    protected WebDriver driver;
    protected ActionBot actionBot;

    public PageBase(WebDriver driver) {
        actionBot = new ActionBot(driver);
        this.driver = driver;
    }

}