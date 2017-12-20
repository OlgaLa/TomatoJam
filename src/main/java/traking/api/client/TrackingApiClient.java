package traking.api.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Olga Lapanovich on 20.12.2017.
 */
public class TrackingApiClient {
    private String baseUri;

    public TrackingApiClient(String baseUri) {

        this.baseUri = baseUri;
    }

    public UUID submitVisit(String selectionName) {
        long currentTimeMillis = System.currentTimeMillis();
        UUID eventId = UUID.randomUUID();
        String url = String.format("%st-1233?i=%s&e=true&et=%s&cb=%d", this.baseUri, eventId.toString(), selectionName, currentTimeMillis);

        CloseableHttpClient client = HttpClientBuilder.create()
                .build();

        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eventId;
    }
}
