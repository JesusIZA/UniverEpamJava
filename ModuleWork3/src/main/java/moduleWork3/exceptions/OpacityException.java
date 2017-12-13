package moduleWork3.exceptions;

/**
 * @author Jesus Raichuk
 */
public class OpacityException extends Exception{
    public OpacityException() {
    }

    public OpacityException(String message) {
        super(message);
    }

    public OpacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpacityException(Throwable cause) {
        super(cause);
    }

    public OpacityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
