package firstpackage;

import java.util.HashMap;
import java.util.Map;

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
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public void listAccounts() {

        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            System.out.println("Account ID: " + entry.getKey());
        //    System.out.println("Account name: " + ((SavingsAccount) entry.getValue()).getOwner());
            System.out.println("Balance: " + entry.getValue().getBalance());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("BankAccountManager is running successfully.");
    }
}