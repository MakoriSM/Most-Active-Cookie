import cookieclass.CookieCollection;
import filereading.CookieFileReader;
import findingmostactivecookie.FindMostActiveCookie;
import inputhandling.InputHandler;
import logger.ProgramLogger;

import java.io.IOException;


public class MostActiveCookie {
    final private static String INPUTFORMAT = "java -jar most_active_cookie.jar cookie_log.csv 2018-12-09";


    public static void main(String[] args) {
        ProgramLogger.setProgramLogger();
        InputHandler inputHandler;

        try {
            inputHandler = new InputHandler(args);
        }
        catch (IllegalArgumentException e){
            System.out.println("Please run program with the format:");
            System.out.println(INPUTFORMAT);
            return;
        }

        CookieCollection fileCookies;
        try {
            CookieFileReader cookieFileReader = new CookieFileReader();
            fileCookies = cookieFileReader.readCookieFile(inputHandler.getFilename());
        }catch (IOException e) {
            System.out.println("Could not read data from file: " + inputHandler.getFilename());
            return;
        } catch (NullPointerException e){
            System.out.println("File " + inputHandler.getFilename() + " not found.");
            return;
        }


        FindMostActiveCookie mostActiveCookieFinder = new FindMostActiveCookie();
        if(mostActiveCookieFinder.findAllCookiesFromDay(inputHandler.getInputDay(),fileCookies)) {
            String[] mostActiveCookies = mostActiveCookieFinder.findMostActiveCookies();
            for(String cookie: mostActiveCookies){
                System.out.println(cookie);
            }
            return;
        }
        System.out.println("No cookies found from given day.");
    }
}
