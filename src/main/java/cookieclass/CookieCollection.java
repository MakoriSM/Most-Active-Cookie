package cookieclass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CookieCollection extends ArrayList<Cookie> {
    @Override
    public String toString() {
        DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

        Iterator<Cookie> it = this.iterator();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            Cookie e = it.next();
            sb.append(e.getCookieString());
            sb.append(",");
            sb.append(e.getCookieDateTime().format(inputDateFormat));
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    public CookieCollection get(LocalDate date) throws NoSuchElementException{
        CookieCollection cookieCollection = new CookieCollection();
        for(Cookie cookie: this){
            if(cookie.getCookieDateTime().toLocalDate().equals(date)){
                cookieCollection.add(cookie);
            }
        }

        if(cookieCollection.isEmpty()){
            throw new NoSuchElementException("No cookies found on given date.");
        }

        return cookieCollection;
    }

    public String[] getMostActiveCookies(){
        Map<String, Integer> frequencyOfCookies = new HashMap<>();


        CookieCollection cookieCollection = new CookieCollection();
        for(Cookie cookie: this){
            Integer frequencyVal = frequencyOfCookies.get(cookie.getCookieString());
            //Put the frequency value + 1 at the key for this cookie
            frequencyOfCookies.put(cookie.getCookieString(), frequencyVal == null ? 1 : frequencyVal + 1);
        }

        if(frequencyOfCookies.isEmpty()){
            throw new NoSuchElementException("No cookies found.");
        }

        Map<String, Integer> modeEntries = new HashMap<>();
        int modeValue = 0;
        for (Map.Entry<String, Integer> entry : frequencyOfCookies.entrySet()) {
            if (entry.getValue() > modeValue) {
                modeValue = entry.getValue();
                modeEntries.clear();
                modeEntries.put(entry.getKey(),entry.getValue());
            }
            else if(entry.getValue() == modeValue){
                modeEntries.put(entry.getKey(),entry.getValue());
            }
        }

        String[] entryList = new String[modeEntries.size()];
        int numberOfModeEntries = 0;
        for(Map.Entry<String, Integer> entry : modeEntries.entrySet()){
            entryList[numberOfModeEntries] = entry.getKey();
            numberOfModeEntries++;
        }

        return entryList;
    }
}
