import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CookieFileReader {

    private final int COOKIE_LENGTH = 16;
    private final String HEADER_STRING = "cookie,timestamp";

    public void readCookieFile(String filename) throws NullPointerException, IOException {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(filename);
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while((line = reader.readLine()) != null){

            if(line.equals(HEADER_STRING)){
                continue;
            }

            try {
                    String[] lineContents = line.split(","); //split up line contents

                    if (lineContents.length != 2) { //Skip line if incorrect number of values found.
                        throw new IllegalArgumentException("Incorrect number of values found on line.");
                    }

                    DateTimeFormatter inputDateFormat = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
                    OffsetDateTime lineDate = OffsetDateTime.parse(lineContents[1], inputDateFormat);

                    if (lineContents[0].length() != COOKIE_LENGTH) {
                        //Skip line if cookie string is of incorrect length.
                        throw new IllegalArgumentException("Cookie string should be " + COOKIE_LENGTH +
                                " characters long.");
                    }

                    //Check for special characters
                    Pattern cookiePattern = Pattern.compile("[^A-Za-z0-9]");
                    Matcher cookieMatcher = cookiePattern.matcher(lineContents[0]);

                    if (cookieMatcher.find()) { //Skip line if special characters found in cookie string.
                        throw new IllegalArgumentException("Special characters are not valid in cookie string.");
                    }

            }
            catch (IllegalArgumentException e){
                //Just print the illegal argument exception for that line.
                System.out.println(e);
            }
            catch (DateTimeParseException e) {
                System.out.println("Invalid date given: " + e);
            }
        }
    }
}
