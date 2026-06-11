package firstpackage;

public class BankAccount {

    private double balance;
    private boolean frozen;

    public BankAccount() {
        balance = 0.0;
        frozen = false;
    }

    public void deposit(double amount) {

        System.out.printf("Amount deposited: %.2f%n", amount);

        if (frozen) {
            System.out.println("Account is FROZEN");
            System.out.println("Unable to transact");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0");
            return;
        }

        balance += amount;
        System.out.printf("Current balance: %.2f%n", balance);
    }

    public void withdraw(double amount) {

        System.out.printf("Amount withdrawn: %.2f%n", amount);

        if (frozen) {
            System.out.println("Account is FROZEN");
            System.out.println("Unable to transact");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            System.out.printf("Current balance: %.2f%n", balance);
            return;
        }

        balance -= amount;
        System.out.printf("Current balance: %.2f%n", balance);
    }

    public double getBalance() {
        return balance;
    }

    public void freezeAccount() {
        frozen = true;
        System.out.println("Account is FROZEN");
    }

    public void unfreezeAccount() {
        frozen = false;
        System.out.println("Account is UNFROZEN");
    }

	public void freeze() {
		// TODO Auto-generated method stub
		
	}

	public void unfreeze() {
		// TODO Auto-generated method stub
		
	}

}