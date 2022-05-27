package customexceptions;

import java.text.ParseException;

public class InvalidDateException extends ParseException {
    /**
     * Constructs a ParseException with the specified detail message and
     * offset.
     * A detail message is a String that describes this particular exception.
     *
     * @param s           the detail message
     * @param errorOffset the position where the error is found while parsing.
     */
    public InvalidDateException(String s, int errorOffset) {
        super(s, errorOffset);
    }

    /**
     * Constructs an invalidDateException with a default message and specified errorOffset.
     * @param errorOffset the position where the error is found while parsing.
     */
    public InvalidDateException(int errorOffset){
        super("Invalid date given.",errorOffset);
    }

    /**
     * Constructs an invalidDateException with a default message and errorOffset of 0.
     */
    public InvalidDateException(){
        super("Invalid date given.",0);
    }
}
