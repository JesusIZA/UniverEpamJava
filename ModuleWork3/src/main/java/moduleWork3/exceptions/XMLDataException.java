package moduleWork3.exceptions;

/**
 * @author Jesus Raichuk
 */
public class XMLDataException extends Exception {
    public XMLDataException() {
    }

    public XMLDataException(String message) {
        super(message);
    }

    public XMLDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLDataException(Throwable cause) {
        super(cause);
    }

    public XMLDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
