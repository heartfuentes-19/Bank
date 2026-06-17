package firstpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class BankAccountManager implements Bank {

    private Map<Integer, BankAccount> accounts;
    private int id;

    public BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
    }

    @Override
    public void addAccount(BankAccount account) {

        if (id >= 100) {
            System.out.println("Maximum account limit reached");
            return;
        }

        accounts.put(id, account);
        System.out.println("Account added successfully with ID: " + id);
        id++;
    }

    @Override
    public Optional<BankAccount> getAccount(int id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public void listAccounts() {

        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            System.out.println("Account ID: " + entry.getKey());
            if (entry.getValue() instanceof SavingsAccount) {
                System.out.println("Account name: " + ((SavingsAccount) entry.getValue()).getOwner());
            }
            System.out.println("Balance: " + entry.getValue().getBalance());
            System.out.println("Frozen: " + entry.getValue().isFrozen());
            System.out.println();
        }
    }

    /**
     * Deposit amount into account with given id.
     * @return true on success, false on failure
     */
    public boolean deposit(int accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            System.err.println("Deposit failed: account not found: " + accountId);
            return false;
        }
        try {
            account.deposit(amount);
            return true;
        } catch (Exception e) {
            System.err.println("Deposit failed for account " + accountId + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Withdraw amount from account with given id.
     * @return true on success, false on failure
     */
    public boolean withdraw(int accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            System.err.println("Withdraw failed: account not found: " + accountId);
            return false;
        }
        try {
            account.withdraw(amount);
            return true;
        } catch (Exception e) {
            System.err.println("Withdraw failed for account " + accountId + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Transfer amount from one account to another. Attempts to keep operation atomic.
     * @return true on success, false on failure
     */
    public boolean transfer(int fromId, int toId, double amount) {
        BankAccount from = accounts.get(fromId);
        BankAccount to = accounts.get(toId);

        if (from == null || to == null) {
            System.err.println("Transfer failed: invalid account id(s). from=" + fromId + " to=" + toId);
            return false;
        }

        // simple atomic behavior: withdraw then deposit, refund if deposit fails
        try {
            from.withdraw(amount);
        } catch (Exception e) {
            System.err.println("Transfer failed during withdraw from " + fromId + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }

        try {
            to.deposit(amount);
            return true;
        } catch (Exception e) {
            System.err.println("Transfer failed during deposit to " + toId + ": " + e.getMessage());
            e.printStackTrace();
            // attempt refund
            try {
                from.deposit(amount);
            } catch (Exception ex) {
                System.err.println("Critical: refund failed for account " + fromId + ": " + ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    public void freezeAccount(int accountId) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            System.err.println("Freeze failed: account not found: " + accountId);
            return;
        }
        account.freeze();
    }

    public void unfreezeAccount(int accountId) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            System.err.println("Unfreeze failed: account not found: " + accountId);
            return;
        }
        account.unfreeze();
    }

    /**
     * Main method to test the BankAccountManager functionality
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("BankAccountManager is running successfully.");

        BankAccountManager manager = new BankAccountManager();
        SavingsAccount a1 = new SavingsAccount("Alice");
        SavingsAccount a2 = new SavingsAccount("Bob");

        manager.addAccount(a1); // id 0
        manager.addAccount(a2); // id 1

        manager.deposit(0, 200.0);
        manager.withdraw(0, 50.0);
        manager.transfer(0, 1, 100.0);

        manager.listAccounts();
    }
}
