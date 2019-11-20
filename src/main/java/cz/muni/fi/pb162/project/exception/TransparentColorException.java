package cz.muni.fi.pb162.project.exception;

/**
 * Exeption if color is not set
 * @author Matej Groman
 */
public class TransparentColorException extends RuntimeException {
    /**
     * Constructor with message only
     * @param message string with error info
     */
    public TransparentColorException(String message) {
        super(message);
    }

    /**
     * Constructor with message and cause
     * @param message string with error info
     * @param cause cause of this error
     */
    public TransparentColorException(String message, Throwable cause) {
        super(message, cause);
    }
}
