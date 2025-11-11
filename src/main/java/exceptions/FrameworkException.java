package exceptions;

/**
 * Abstract base class for all custom exceptions in the automation framework.
 * <p>
 * This provides a consistent structure for all framework-related exceptions.
 * Specific exception types like {@code PageException}, {@code DriverException},
 * etc., should extend this class.
 */
public abstract class FrameworkException extends RuntimeException {

    /**
     * Creates a new FrameworkException with a detailed message.
     *
     * @param message the detailed error message
     */
    public FrameworkException(String message) {
        super(message);
    }

    /**
     * Creates a new FrameworkException with a detailed message and cause.
     *
     * @param message the detailed error message
     * @param cause   the original cause of this exception
     */
    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
