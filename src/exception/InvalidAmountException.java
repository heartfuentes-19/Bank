package exception;

/**
 * Exception thrown when an invalid amount (negative or zero) is deposited or withdrawn.
 */
public class InvalidAmountException extends Exception {
    private final String message;

    /**
     * Constructs a new InvalidAmountException with the specified message.
     *
     * @param message the detail message.
     */
    public InvalidAmountException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
