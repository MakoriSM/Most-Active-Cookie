package cookieclass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

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

    public CookieCollection get(LocalDate date){
        CookieCollection cookieCollection = new CookieCollection();
        for(Cookie cookie: this){
            if(cookie.getCookieDateTime().toLocalDate().equals(date)){
                cookieCollection.add(cookie);
            }
        }

        return cookieCollection;

    }
}
