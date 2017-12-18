package base;

import org.openqa.selenium.WebDriver;
import pages.header.Header;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class InternalPage extends PageBase {

    public InternalPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return new Header(driver);
    }
}
