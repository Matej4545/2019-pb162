package cz.muni.fi.pb162.project.exception;

/**
 * Exception if the vertices are missing
 * @author Matej Groman
 */
public class MissingVerticesException extends RuntimeException {

    /**
     * Constructor with message only
     * @param message string with error info
     */
    public MissingVerticesException(String message) {
        super(message);
    }

    /**
     * Constructor with message and cause
     * @param message string with error info
     * @param cause cause of this error
     */
    public MissingVerticesException(String message, Throwable cause) {
        super(message, cause);
    }
}
