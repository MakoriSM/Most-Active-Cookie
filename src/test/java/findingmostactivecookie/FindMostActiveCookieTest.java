package findingmostactivecookie;

import cookieclass.Cookie;
import cookieclass.CookieCollection;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class FindMostActiveCookieTest {


    @Test
    public void findMostActiveCookie() {
        LocalDate date = LocalDate.of(2018,12,9);
        CookieCollection cookieCollection = new CookieCollection();
        DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

        cookieCollection.add(new Cookie("AtY0laUfhglK3lC7",OffsetDateTime.parse(
                "2018-12-09T14:19:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("SAZuXPGUrfbcn5UA",OffsetDateTime.parse(
                "2018-12-09T10:13:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("5UAVanZf6UtGyKVS",OffsetDateTime.parse(
                "2018-12-09T07:25:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("AtY0laUfhglK3lC7",OffsetDateTime.parse(
                "2018-12-09T06:19:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("SAZuXPGUrfbcn5UA",OffsetDateTime.parse(
                "2018-12-08T22:03:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("4sMM2LxV07bPJzwf",OffsetDateTime.parse(
                "2018-12-08T21:30:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("fbcn5UAVanZf6UtG",OffsetDateTime.parse(
                "2018-12-08T09:30:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("4sMM2LxV07bPJzwf",OffsetDateTime.parse(
                "2018-12-07T23:30:00+00:00", inputDateFormat)));
        System.out.println(cookieCollection.toString());
        FindMostActiveCookie activeCookieFinder = new FindMostActiveCookie();
        activeCookieFinder.findCookiesFromDay(date,cookieCollection);
        assertEquals(activeCookieFinder.getCookiesFromDay().toString(),"[AtY0laUfhglK3lC7," +
                "2018-12-09T14:19:00+0000, SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+0000, " +
                "5UAVanZf6UtGyKVS,2018-12-09T07:25:00+0000, AtY0laUfhglK3lC7,2018-12-09T06:19:00+0000]");

    }
}