import base.TestAdapter;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;
import pages.profiles.EngagementsPage;
import pages.test_managment.DashboardPage;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class UserIsInSelectionTest extends TestAdapter<EngagementsPage> {

    private static final Log LOG = LogFactory.getLog(UserIsInSelectionTest.class);

    @Override
    protected EngagementsPage setCurrentPage(DashboardPage page) {
        return page.getHeader().clickProfiles().getProfilesSubMenu().clickEngagements();
    }

    @Test
    public void userIsInSelectionTest() throws InterruptedException {

        String engType = RandomStringUtils.randomAlphabetic(6);
        String engDescription = RandomStringUtils.randomAlphabetic(6);
        String selectionName = RandomStringUtils.randomAlphabetic(7);
        String selectionDescription = RandomStringUtils.randomAlphabetic(7);

        pageUnderTest.createNewEngagement(engType, engDescription);
        pageUnderTest.getProfilesSubMenu()
                .clickSelections()
                .createNewSelection(selectionName, selectionDescription, engType);
        Thread.sleep(20000);
        System.out.print("aaaaaaaaaaa");
    }
}
