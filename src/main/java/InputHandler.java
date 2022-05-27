import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

public class InputHandler {
    private String m_filename = null;
    private LocalDate  inputDay = null;



    public InputHandler(String[] args) throws IllegalArgumentException{
        try{
            final int MAXARGS = 2;
            if (args.length > MAXARGS){
                throw new IllegalArgumentException("More than " + MAXARGS + " arguments given.");
            }

            if (args.length < MAXARGS){
                throw new IllegalArgumentException("Less than " + MAXARGS + " arguments given.");
            }

            String filename = args[0];
            String[] filenameSections = filename.split("\\.");

            if(filenameSections.length != 2){ //If filename is not a file and extension (ie file.csv.something)
                throw new InvalidFilenameException("File must be a valid .csv file",filename.length());
            }

            if(!filenameSections[1].equals("csv")){ //If filename is not a csv file
                throw new InvalidFilenameException("File must have a .csv extension",filenameSections[0].length());
            }

            DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate inputDay = LocalDate.parse(args[1],inputDateFormat);

            setInputDay(inputDay);
            setFilename(filename);

            Logger logger = ProgramLogger.getLogger();
            logger.info("Filename: " + filename);
            logger.info("Input day: " + inputDay);

        }
        catch (InvalidFilenameException e) {
            System.out.println("Invalid filename given: " + e);
            throw new IllegalArgumentException();
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid date given: " + e);
            throw new IllegalArgumentException();
        }
    }

    public String getFilename() {
        return m_filename;
    }

    public void setFilename(String filename) {
        m_filename = filename;
    }

    public LocalDate getInputDay() {
        return inputDay;
    }

    public void setInputDay(LocalDate inputDay) {
        this.inputDay = inputDay;
    }
}
