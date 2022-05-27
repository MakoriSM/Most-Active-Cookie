import cookieclass.CookieCollection;
import filereading.CookieFileReader;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Collections;

import static org.junit.Assert.*;

public class CookieFileReaderTest {

    @Test
    public void readExistingCookieFile() throws IOException {
        CookieFileReader cfr = new CookieFileReader();

        String expectedString = "[AtY0laUfhglK3lC7,2018-12-09T14:19:00+0000, SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+0000, " +
                "5UAVanZf6UtGyKVS,2018-12-09T07:25:00+0000, AtY0laUfhglK3lC7,2018-12-09T06:19:00+0000, SAZuXPGUrfbcn5UA," +
                "2018-12-08T22:03:00+0000, 4sMM2LxV07bPJzwf,2018-12-08T21:30:00+0000, " +
                "fbcn5UAVanZf6UtG,2018-12-08T09:30:00+0000, 4sMM2LxV07bPJzwf,2018-12-07T23:30:00+0000]";
        String filename = "cookie_log.csv";
        URL url = this.getClass().getResource(filename);
        CookieCollection cookieCollection = cfr.readCookieFile(filename);
        Collections.sort(cookieCollection,Collections.reverseOrder());
        assertEquals(expectedString,cookieCollection.toString());
        System.out.println(cookieCollection.toString());
    }

    @Test
    public void readNonExistingCookieFile() {
        CookieFileReader cfr = new CookieFileReader();
        assertThrows(NullPointerException.class,() -> cfr.readCookieFile("null.csv"));
        System.out.println("File not found");
    }


}