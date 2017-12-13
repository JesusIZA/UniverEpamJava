package moduleWork3.exceptions;

/**
 * @author Jesus Raichuk
 */
public class VException extends Exception {
    public VException() {
    }

    public VException(String message) {
        super(message);
    }

    public VException(String message, Throwable cause) {
        super(message, cause);
    }

    public VException(Throwable cause) {
        super(cause);
    }

    public VException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
