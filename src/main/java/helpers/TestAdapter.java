package helpers;

import base.InternalPage;
import base.TestBase;
import org.testng.annotations.BeforeMethod;
import pages.test_managment.DashboardPage;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public abstract class TestAdapter <TPage extends InternalPage> extends TestBase {

        private static final String EMAIL_ADDRESS ="relay42test1@gmail.com";
        private static final String PASSWORD = "relay42test";

        protected TPage pageUnderTest;

        private DashboardPage givenImLoggedIn() throws InterruptedException {
            return loginPage.login(EMAIL_ADDRESS, PASSWORD);
        }

        @BeforeMethod
        public void init() throws InterruptedException {
            pageUnderTest = setCurrentPage(givenImLoggedIn());
        }

        protected abstract TPage setCurrentPage(DashboardPage page);

}
