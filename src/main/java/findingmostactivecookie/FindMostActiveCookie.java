package findingmostactivecookie;

import cookieclass.CookieCollection;

import java.time.LocalDate;

public class FindMostActiveCookie {

    private CookieCollection m_cookiesFromDay = null;

    public CookieCollection getCookiesFromDay() {
        return m_cookiesFromDay;
    }

    public void setCookiesFromDay(CookieCollection cookiesFromDay) {
        m_cookiesFromDay = cookiesFromDay;
    }

    public void findCookiesFromDay(LocalDate inputDay, CookieCollection cookieCollection){
        setCookiesFromDay(cookieCollection.get(inputDay));
        System.out.println(getCookiesFromDay().toString());
    }

    public void findMostActiveCookie(){
        try{
            getCookiesFromDay().
        }catch (NullPointerException e){
            System.out.println("No cookies found from given date.");
        }
    }
}
