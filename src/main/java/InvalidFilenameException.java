import java.text.ParseException;

public class InvalidFilenameException extends ParseException {
    /**
     * Constructs a ParseException with the specified detail message and
     * offset.
     * A detail message is a String that describes this particular exception.
     *
     * @param s           the detail message
     * @param errorOffset the position where the error is found while parsing.
     */
    public InvalidFilenameException(String s, int errorOffset) {
        super(s, errorOffset);
    }

    /**
     * Constructs an invalidFilenameException with a default message and specified errorOffset.
     * @param errorOffset the position where the error is found while parsing.
     */
    public InvalidFilenameException(int errorOffset){
        super("Invalid filename given.",errorOffset);
    }

    /**
     * Constructs an invalidFilenameException with a default message and errorOffset of 0.
     */
    public InvalidFilenameException(){
        super("Invalid filename given.",0);
    }
}
