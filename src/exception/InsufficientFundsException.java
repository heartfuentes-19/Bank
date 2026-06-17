package exception;

/**
 * Exception thrown when a withdrawal exceeds the available balance.
 */
public class InsufficientFundsException extends Exception {
    private final String message;

    /**
     * Constructs a new InsufficientFundsException with the specified message.
     *
     * @param message the detail message.
     */
    public InsufficientFundsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
