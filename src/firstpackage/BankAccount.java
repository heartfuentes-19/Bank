package firstpackage;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a bank account with transaction history and validated operations.
 * Deposit and withdraw print the attempted amount, update balance on success,
 * and throw specific exceptions on failure.
 */
public class BankAccount {

    private double balance = 0.0;
    private boolean frozen = false;
    private final List<Transaction> transactionHistory = new ArrayList<>();
    private final String owner;

    /**
     * Constructs a BankAccount with owner set to "N/A".
     */
    public BankAccount() {
        this("N/A");
    }

    /**
     * Constructs a BankAccount with the specified owner.
     *
     * @param owner the account owner's name
     */
    public BankAccount(String owner) {
        this.owner = owner;
        this.balance = 0.0;
        this.frozen = false;
    }

    /**
     * Deposit the specified amount.
     * Prints the attempted amount, validates input and frozen state,
     * updates balance and records a transaction on success.
     *
     * @param amount amount to deposit
     * @throws InvalidAmountException if amount <= 0
     * @throws AccountFrozenException if account is frozen
     */
    public void deposit(double amount) throws InvalidAmountException, AccountFrozenException {
        System.out.printf("Amount deposited: %.2f%n", amount);

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount. Must be greater than 0");
        }
        if (frozen) {
            throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
        }

        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.printf("Current balance: %.2f%n", balance);
    }

    /**
     * Withdraw the specified amount.
     * Prints the attempted amount, validates input and frozen state,
     * updates balance and records a transaction on success.
     *
     * @param amount amount to withdraw
     * @throws InvalidAmountException     if amount <= 0
     * @throws InsufficientFundsException if amount > balance
     * @throws AccountFrozenException     if account is frozen
     */
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException, AccountFrozenException {
        System.out.printf("Amount withdrawn: %.2f%n", amount);

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount. Must be greater than 0");
        }
        if (frozen) {
            throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
        }
        if (amount > balance) {
            // Print current balance for clarity (tests expect balance display)
            System.out.println("Insufficient balance.");
            System.out.printf("Current balance: %.2f%n", balance);
            throw new InsufficientFundsException("Insufficient balance.");
        }

        balance -= amount;
        transactionHistory.add(new Transaction("Withdraw", amount));
        System.out.printf("Current balance: %.2f%n", balance);
    }

    /**
     * Freezes the account, preventing transactions.
     */
    public void freeze() {
        this.frozen = true;
    }

    /**
     * Unfreezes the account, allowing transactions.
     */
    public void unfreeze() {
        this.frozen = false;
    }

    /**
     * Backwards-compatible name used elsewhere.
     */
    public void freezeAccount() {
        freeze();
        System.out.println("Account is FROZEN");
    }

    /**
     * Backwards-compatible name used elsewhere.
     */
    public void unfreezeAccount() {
        unfreeze();
        System.out.println("Account is UNFROZEN");
    }

    /**
     * Returns whether the account is frozen.
     *
     * @return true if frozen, false otherwise
     */
    public boolean isFrozen() {
        return frozen;
    }

    /**
     * Returns current balance.
     *
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the account owner name.
     *
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Returns an unmodifiable copy of transaction history.
     *
     * @return list of transactions
     */
    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(new ArrayList<>(transactionHistory));
    }
}
