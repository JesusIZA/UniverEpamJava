package moduleWork3.exceptions;

/**
 * @author Jesus Raichuk
 */
public class KlOborException extends Exception {
    public KlOborException() {
    }

    public KlOborException(String message) {
        super(message);
    }

    public KlOborException(String message, Throwable cause) {
        super(message, cause);
    }

    public KlOborException(Throwable cause) {
        super(cause);
    }

    public KlOborException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
