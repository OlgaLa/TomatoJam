package helpers;

/**
 * Created by Olga Lapanovich on 20.12.2017.
 */
public class TestUtils {

    public static String splitString(String string) {
        String[] str = string.split("_");
        String selNumber = null;
        if (str.length == 2) {
            selNumber = str[1];
        }
        return selNumber;
    }

}
