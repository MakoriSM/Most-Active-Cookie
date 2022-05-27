package findingmostactivecookie;

import cookieclass.Cookie;
import cookieclass.CookieCollection;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

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
        FindMostActiveCookie activeCookieFinder = new FindMostActiveCookie();
        activeCookieFinder.findCookiesFromDay(date,cookieCollection);
        assertEquals("AtY0laUfhglK3lC7",activeCookieFinder.findMostActiveCookieValue()[0]);
    }

    @Test
    public void findMostActiveCookies() {
        LocalDate date = LocalDate.of(2018,12,9);
        CookieCollection cookieCollection = new CookieCollection();
        DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

        cookieCollection.add(new Cookie("AtY0laUfhglK3lC7",OffsetDateTime.parse(
                "2018-12-09T14:19:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("SAZuXPGUrfbcn5UA",OffsetDateTime.parse(
                "2018-12-09T10:13:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("SAZuXPGUrfbcn5UA",OffsetDateTime.parse(
                "2018-12-09T07:25:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("AtY0laUfhglK3lC7",OffsetDateTime.parse(
                "2018-12-09T06:19:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("SAZuXPGUrfbcn5UA",OffsetDateTime.parse(
                "2018-12-08T22:03:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("4sMM2LxV07bPJzwf",OffsetDateTime.parse(
                "2018-12-08T21:30:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("fbcn5UAVanZf6UtG",OffsetDateTime.parse(
                "2018-12-09T06:19:00+00:00", inputDateFormat)));
        cookieCollection.add(new Cookie("4sMM2LxV07bPJzwf",OffsetDateTime.parse(
                "2018-12-07T23:30:00+00:00", inputDateFormat)));
        FindMostActiveCookie activeCookieFinder = new FindMostActiveCookie();
        activeCookieFinder.findCookiesFromDay(date,cookieCollection);
        assertEquals("AtY0laUfhglK3lC7",activeCookieFinder.findMostActiveCookieValue()[0]);
        assertEquals("SAZuXPGUrfbcn5UA",activeCookieFinder.findMostActiveCookieValue()[1]);
    }

    @Test
    public void findMostActiveCookieOnNonexistentDay() {
        LocalDate date = LocalDate.of(2012,4,9);
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
        FindMostActiveCookie activeCookieFinder = new FindMostActiveCookie();
        assertEquals(false,activeCookieFinder.findCookiesFromDay(date,cookieCollection));
    }

    @Test
    public void findMostActiveCookieOnNoCookies() {
        FindMostActiveCookie activeCookieFinder = new FindMostActiveCookie();
        assertNull(activeCookieFinder.findMostActiveCookieValue());
    }

}