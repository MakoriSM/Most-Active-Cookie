import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class InputHandlerTest {
    @Test
    public void testValidArgs(){
        String[] args = {"cookie_log.csv","2018-12-09"};

        InputHandler inputHandler = new InputHandler(args);
        DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Assert.assertEquals("cookie_log.csv",inputHandler.getFilename());
        Assert.assertEquals("2018-12-09",inputDateFormat.format(inputHandler.getInputDay()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooManyArgs(){
        String[] args = {"cookie_log.csv","2018-12-09","extra"};
        new InputHandler(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooFewArgs(){
        String[] args = {"cookie_log.csv"};
        new InputHandler(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooManySectionsInFile(){
        String[] args = {"cookie_log.csv.csv","2018-12-09"};
        new InputHandler(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoFileExtension(){
        String[] args = {"cookie_log","2018-12-09"};
        new InputHandler(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongFileExtension(){
        String[] args = {"cookie_log.png","2018-12-09"};
        new InputHandler(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBlankFilenameInput(){
        String[] args = {"   ","2018-12-09"};
        new InputHandler(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateFormatInput(){
        String[] args = {"cookie_log.csv","12-09-2018"};
        new InputHandler(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBlankDateInput(){
        String[] args = {"cookie_log.csv","  "};
        new InputHandler(args);
    }
}