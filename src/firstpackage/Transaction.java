
// java
package firstpackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple transaction record used by accounts.
 */
public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime timestamp;
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Constructs a Transaction.
     *
     * @param type   the transaction type (e.g., "Deposit", "Withdraw")
     * @param amount the transaction amount
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction [type=" + type + ", amount=" + amount + ", time_stamp=" + timestamp.format(FORMAT) + "]";
    }
}
