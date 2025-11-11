package exceptions;

/**
 * Exception class for handling Page Object related issues in the framework.
 * <p>
 * This exception is typically thrown when a page action fails,
 * a web element is not found, or a page-specific operation cannot be completed.
 */
public class PageException extends FrameworkException {

    /**
     * Creates a new PageException with a detailed message.
     *
     * @param message the detailed error message
     */
    public PageException(String message) {
        super(message);
    }

    /**
     * Creates a new PageException with a detailed message and cause.
     *
     * @param message the detailed error message
     * @param cause   the original exception that caused this error
     */
    public PageException(String message, Throwable cause) {
        super(message, cause);
    }
}
