import java.io.*;
import java.net.URL;

public class CookieFileReader {

    public void readCookieFile(String filename) throws NullPointerException {

        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

    }
}
