import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class CookieFileReaderTest {

    @Test
    public void readExistingCookieFile() throws FileNotFoundException {
        CookieFileReader cfr = new CookieFileReader();
        cfr.readCookieFile("cookie_log.csv");
    }

    @Test
    public void readNonExistingCookieFile() {
        CookieFileReader cfr = new CookieFileReader();
        assertThrows(NullPointerException.class,() -> cfr.readCookieFile("null.csv"));
        System.out.println("File not found");
    }
}