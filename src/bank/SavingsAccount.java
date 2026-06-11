package bank;

public class SavingsAccount extends BankAccount {

    private String owner;

    public SavingsAccount(String owner) {
        super();
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}