import base.TestAdapter;
import constant.ApiUrls;
import constant.Credentials;
import helpers.TestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.profiles.EngagementsPage;
import pages.test_managment.DashboardPage;
import relay42.api.client.ApiClient;
import relay42.api.client.GetSegmentsRequest;
import relay42.api.client.Segment;
import traking.api.client.TrackingApiClient;

import java.util.List;
import java.util.UUID;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class UserIsInSelectionTest extends TestAdapter<EngagementsPage> {

    private static final Log LOG = LogFactory.getLog(UserIsInSelectionTest.class);

    private static final Long SITE_NUMBER = 1233L;
    private static final Long PARTNER_ID = 42L;

    @Override
    protected EngagementsPage setCurrentPage(DashboardPage page) {
        return page.getHeader().clickProfiles().getProfilesSubMenu().clickEngagements();
    }

    private Segment findSegmentByApiIdentifier(List<Segment> segments, String apiIdentifier) {
        for (Segment segment: segments) {
            if (segment.segmentName.contains(apiIdentifier)) {
                return segment;
            }
        }
        return null;
    }

    @Test
    public void userIsInSelectionTest() throws InterruptedException {

        String engType = RandomStringUtils.randomAlphabetic(6);
        String engDescription = RandomStringUtils.randomAlphabetic(6);
        String selectionName = RandomStringUtils.randomAlphabetic(7);
        String selectionDescription = RandomStringUtils.randomAlphabetic(7);

        pageUnderTest.createNewEngagement(engType, engDescription);
        String apiIdentifier = pageUnderTest.getProfilesSubMenu()
                .clickSelections()
                .createNewSelection(selectionName, selectionDescription, engType);
        String selectionNumber = TestUtils.splitString(apiIdentifier);

        TrackingApiClient trackingApiClient = new TrackingApiClient(ApiUrls.TRACKING_BASE_URL);
        UUID eventId = trackingApiClient.submitVisit(engType);

        ApiClient relay42ApiClient = new ApiClient(Credentials.EMAIL, Credentials.PASSWORD, ApiUrls.RELAY42_API_BASE_URL);
        List<Segment> segments = relay42ApiClient.getList(new GetSegmentsRequest(SITE_NUMBER, PARTNER_ID, eventId.toString()));

        Segment segment = findSegmentByApiIdentifier(segments, apiIdentifier);
        Assert.assertNotNull(segment, "Response doesn't contain selection name: " + apiIdentifier);
        Assert.assertEquals(segment.segmentNumber, selectionNumber, "Response doesn't contain selection number: " + selectionNumber);
        Assert.assertEquals(segment.siteNumber, SITE_NUMBER.toString(), "Response doesn't contain site number: " + SITE_NUMBER.toString());

        LOG.info(getClass().getSimpleName() + " passed");
    }


}
