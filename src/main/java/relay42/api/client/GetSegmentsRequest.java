package relay42.api.client;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * Created by Olga Lapanovich on 19.12.2017.
 */
public class GetSegmentsRequest {

    private final Long siteNumber;
    private final Long partnerType;
    private final String partnerId;

    public GetSegmentsRequest(Long siteNumber, Long partnerType, String partnerId) {
        this.siteNumber = siteNumber;
        this.partnerType = partnerType;
        this.partnerId = partnerId;
    }

    public HttpUriRequest build(String baseUrl) {
        String url = String.format("%ssite-%d/profiles/%d/segments?partnerId=%s", baseUrl, this.siteNumber, this.partnerType, this.partnerId);
        return new HttpGet(url);
    }
}
