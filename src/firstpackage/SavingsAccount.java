package firstpackage;

public class SavingsAccount extends BankAccount {
    private final String owner;

    public SavingsAccount(String owner) {
        this.owner = owner;
    }

    public String getOwner() { return owner; }

    // use superclass accessors instead of direct field access
    protected void doDeposit(double amount) {
        setBalance(getBalance() + amount);
    }

    protected void doWithdraw(double amount) {
        if (amount > getBalance()) throw new IllegalArgumentException("Insufficient funds");
        setBalance(getBalance() - amount);
    }

    private void setBalance(double d) {
        // TODO Auto-generated method stub
        
    }
}
