package cz.muni.fi.pb162.project.exception;

/**
 * Exception if the drawable is empty
 * @author Matej Groman
 */
public class EmptyDrawableException extends RuntimeException {

    /**
     * Constructor with message only
     * @param message string with error info
     */
    public EmptyDrawableException(String message) {
        super(message);
    }
    /**
     * Constructor with message and cause
     * @param message string with error info
     * @param cause cause of this error
     */
    public EmptyDrawableException(String message, Throwable cause) {
        super(message, cause);
    }
}
