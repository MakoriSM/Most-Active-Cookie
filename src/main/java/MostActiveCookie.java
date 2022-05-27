import inputhandling.InputHandler;
import logger.ProgramLogger;


public class MostActiveCookie {
    final private static String INPUTFORMAT = "java -jar most_active_cookie cookie_log.csv 2018-12-09";


    public static void main(String[] args) {
        new ProgramLogger();
        try {
            new InputHandler(args);
        }
        catch (IllegalArgumentException e){
            System.out.println("Please run program with the format:");
            System.out.println(INPUTFORMAT);
        }



    }
}
