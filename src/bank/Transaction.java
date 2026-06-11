package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime timeStamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }

    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return timeStamp.format(formatter);
    }

    public String toString() {
        return "Transaction type=" + type +
                ", amount=" + amount +
                ", time_stamp=" + getFormattedTime();
    }
}