package exception;

/**
 * Exception thrown when operations are performed on a frozen account.
 */
public class AccountFrozenException extends Exception {
    private final String message;

    /**
     * Constructs a new AccountFrozenException with the specified message.
     *
     * @param message the detail message.
     */
    public AccountFrozenException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}