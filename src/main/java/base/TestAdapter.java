package base;

import constant.Credentials;
import org.testng.annotations.BeforeMethod;
import pages.test_managment.DashboardPage;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public abstract class TestAdapter <TPage extends InternalPage> extends TestBase {

        protected TPage pageUnderTest;

        private DashboardPage givenImLoggedIn() throws InterruptedException {
            return loginPage.login(Credentials.EMAIL, Credentials.PASSWORD);
        }

        @BeforeMethod
        public void init() throws InterruptedException {
            pageUnderTest = setCurrentPage(givenImLoggedIn());
        }

        protected abstract TPage setCurrentPage(DashboardPage page);

}
