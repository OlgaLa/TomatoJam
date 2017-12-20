package relay42.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga Lapanovich on 19.12.2017.
 */
public class ApiClient {
    private final String login;
    private final String password;
    private final String baseUrl;

    public ApiClient(String login, String password, String baseUrl){

        this.login = login;
        this.password = password;
        this.baseUrl = baseUrl;
    }

    public List<Segment> getList(GetSegmentsRequest request){
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials(this.login, this.password);
        provider.setCredentials(AuthScope.ANY, credentials);

        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();

        try {

            CloseableHttpResponse response = client.execute(request.build(this.baseUrl));
            try {
                System.out.println("----------------------------------------");

                String responseContent = EntityUtils.toString(response.getEntity());
                return jsonArrayToObjectList(responseContent);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Segment> jsonArrayToObjectList(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Segment.class);
        List<Segment> ts = mapper.readValue(response, listType);
        return ts;
    }
}
