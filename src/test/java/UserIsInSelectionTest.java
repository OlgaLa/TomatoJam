import helpers.TestAdapter;
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

        pageUnderTest.createNewEngagement(RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(6));
        // add check that the engag is created.
        //Thread.sleep(5000);
        pageUnderTest.getProfilesSubMenu().clickSelections();
               // .createNewSelection(RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(6));
        Thread.sleep(5000);
        System.out.print("aaaaaaaaaaa");
    }
}
