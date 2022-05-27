package findingmostactivecookie;

import cookieclass.CookieCollection;
import logger.ProgramLogger;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class FindMostActiveCookie {

    private CookieCollection m_cookiesFromDay = null;

    public CookieCollection getCookiesFromDay() {
        return m_cookiesFromDay;
    }

    public void setCookiesFromDay(CookieCollection cookiesFromDay) {
        m_cookiesFromDay = cookiesFromDay;
    }

    public Boolean findAllCookiesFromDay(LocalDate inputDay, CookieCollection cookieCollection){
        try {
            setCookiesFromDay(cookieCollection.get(inputDay));
            Logger logger = ProgramLogger.getLogger();
            logger.info(getCookiesFromDay().toString());
            return true;
        }catch (NoSuchElementException e){
            System.out.println(e);
            return false;
        }

    }

    public String[] findMostActiveCookies(){
        try{
            CookieCollection cookiesFromDay = getCookiesFromDay();
            if(cookiesFromDay == null){
                throw new NoSuchElementException("No cookies given to look through");
            }
            String[] mostActiveCookie = cookiesFromDay.getMostActiveCookies();
            return mostActiveCookie;
        }catch (NoSuchElementException e){
            System.out.println(e);
            return null;
        }
    }
}
