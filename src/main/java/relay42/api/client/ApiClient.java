package relay42.api.client;

/**
 * Created by Olga Lapanovich on 18.12.2017.
 */
public class ApiClient {

    private String login;
    private String password;

    public ApiClient(String login, String password) {

        this.login = login;
        this.password = password;
    }

    public String get() {
        return "";
    }
}
